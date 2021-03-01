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
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Named
import javax.validation.constraints.Null

class VehicleRepository @Inject constructor(
    private val database: MongoDatabase,
    private val objectMapper: ObjectMapper,
    @Named("vehicleCollectionName")private val vehicleCollectionName: String
) {
    private val collection: MongoCollection<Document> = database.getCollection(vehicleCollectionName)

    fun addVehicle(vehicle: Vehicle): Vehicle {
        val document = Document.parse(vehicle.toString())
        document["_id"] = vehicle.getUuid()
        val existingVehiclesWithRegistrationNo =
            collection.find(Filters.eq("registrationNumber", vehicle.getRegistrationNumber())).limit(1).iterator()
        val existingVehiclesWithChassisType =
            collection.find(Filters.eq("chassisType", vehicle.getChassisType())).limit(1).iterator()
        return if (existingVehiclesWithRegistrationNo.hasNext() || existingVehiclesWithChassisType.hasNext()) {
            println(
                "Already in DB with Registration Number and Chassis Type " +
                        "${vehicle.getRegistrationNumber()} AND ${vehicle.getChassisType()}"
            )
            throw Exception("Vehicle already entered with same data")
        } else {
            collection.insertOne(document)
            document.remove("_id")
            vehicle
        }
    }

    fun getVehicle(id: String): Vehicle? {
        val query = BasicDBObject()
        query["_id"] = id
        collection.find(query).iterator().use { c ->
            if (c.hasNext()) {
                val doc = c.next()
                doc.remove("_id")
                val json = JSON.serialize(doc)
                return objectMapper.readValue(json, Vehicle::class.java)
            }
        }
        return null

    }
    fun updateVehicle(id : String ,vehicle: Vehicle) : Vehicle {
        val query = BasicDBObject()
        query["_id"] = id
        val doc = Document.parse(vehicle.toString())
        doc.remove("_id")
        val update: Bson = Document("\$set", doc)
        val upDoc = collection.findOneAndUpdate(query, update, FindOneAndUpdateOptions().returnDocument(ReturnDocument.AFTER))
        val json = JSON.serialize(upDoc)
        return objectMapper.readValue(json, Vehicle::class.java)
    }
    fun updateAssociatedDriverId(id: String, request : Vehicle?): Vehicle? {
        val vehicle = getVehicle(id)
        val newDriverId = request?.getAssociatedDriverUUID()
        return if (newDriverId.isNullOrEmpty() || newDriverId.isNullOrBlank()) {
            null
        } else{
            vehicle?.setAssociatedDriverUUID(newDriverId)
            vehicle
        }
    }
    fun deleteVehicle(id: String): Vehicle {
        val query = BasicDBObject()
        query["_id"] = id
        val doc = collection.findOneAndDelete(Filters.eq("_id", id))
        return if (doc != null) {
            doc.remove("_id")
            val json = JSON.serialize(doc)
            val deletedVehicle = objectMapper.readValue(json, Vehicle::class.java)
            deletedVehicle
        } else {
            throw Exception("No Vehicle With $id")
        }
    }




}