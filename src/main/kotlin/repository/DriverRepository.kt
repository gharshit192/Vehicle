package repository

import com.fasterxml.jackson.databind.ObjectMapper
import com.mongodb.BasicDBObject
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import com.mongodb.client.model.Filters
import com.mongodb.client.model.FindOneAndUpdateOptions
import com.mongodb.client.model.ReturnDocument
import com.mongodb.util.JSON
import model.Driver
import model.Vehicle
import org.bson.Document
import org.bson.conversions.Bson
import service.VehicleService
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Named

class DriverRepository @Inject constructor(
    private val database: MongoDatabase,
    private val objectMapper: ObjectMapper,
    @Named("driverCollectionName") private val driverCollectionName: String,
    private val vehicleRepository: VehicleRepository
) {
    private val collection: MongoCollection<Document> = database.getCollection(driverCollectionName)

    fun addDriver(driver: Driver): Driver {
        val document = Document.parse(driver.toString())
        document["_id"] = driver.getUuid()
        val existingDriverWithDrivingLicense =
            collection.find(Filters.eq("drivingLicence", driver.getDrivingLicence())).limit(1).iterator()
        return if (existingDriverWithDrivingLicense.hasNext()) {
            println(
                "Already in DB with Registration Number and Chassis Type " +
                        "${driver.getDrivingLicence()} "
            )
            throw Exception("Driver already entered with same data")
        } else {
            collection.insertOne(document)
            document.remove("_id")
            driver
        }
    }

    fun getDriver(id: String): Driver? {
        val query = BasicDBObject()
        query["_id"] = id
        collection.find(query).iterator().use { c ->
            if (c.hasNext()) {
                val doc = c.next()
                doc.remove("_id")
                val json = JSON.serialize(doc)
                return objectMapper.readValue(json, Driver::class.java)
            }
        }
        return null

    }


    fun updateDriver(id : String ,driver: Driver): Driver {
        val query = BasicDBObject()
        query["_id"] = id
        val doc = Document.parse(driver.toString())
        doc.remove("_id")
        val update: Bson = Document("\$set", doc)
        val upDoc = collection.findOneAndUpdate(query, update, FindOneAndUpdateOptions().returnDocument(ReturnDocument.AFTER))
        val json = JSON.serialize(upDoc)
        return objectMapper.readValue(json, Driver::class.java)

    }
    fun updateAssociatedVehicleId(request : Driver?):Driver? {


    }
    fun deleteDriver(id: String): Driver {
        val query = BasicDBObject()
        query["_id"] = id
        val doc = collection.findOneAndDelete(Filters.eq("_id", id))
        return if (doc != null) {
            doc.remove("_id")
            val json = JSON.serialize(doc)
            val deletedDriver = objectMapper.readValue(json, Driver::class.java)
            deletedDriver
        } else {
            throw Exception("No Vehicle With $id")
        }
    }




}
