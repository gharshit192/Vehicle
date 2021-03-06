package repository

import com.fasterxml.jackson.databind.ObjectMapper
import com.mongodb.MongoClient
import com.mongodb.client.MongoDatabase
import di.component.DaggerVehicleAppTestComponent
import helper.EmbeddedMongoDb
import helper.TestData
import model.Vehicle
import org.junit.Assert.*
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.util.*

class VehicleRepositoryTest {

    private val uuid: String = "1a1c5fe5-3ee0-453d-8425-5fec44961029"
    private lateinit var embeddedMongoDb: EmbeddedMongoDb
    private lateinit var database: MongoDatabase
    private val objectMapper = ObjectMapper()
    private val vehicleCollectionName = "vehicle"
    private lateinit var  vehicleRepository: VehicleRepository

    @Before
    fun configure() {

        startMongoDb()
        val mongoClient = MongoClient("localhost", embeddedMongoDb.port)
        database = mongoClient.getDatabase("vehicle")
        vehicleRepository = VehicleRepository(database, ObjectMapper(),vehicleCollectionName)
    }

    @After
    fun closeConnections() {
        embeddedMongoDb.stop()
    }

    private fun startMongoDb() {
        val rand = Random()
        val n = rand.nextInt(99) + 9900
        embeddedMongoDb = EmbeddedMongoDb(n)
        embeddedMongoDb.start()
    }

    @Test
    fun create_vehicle(){
        val request = TestData.getCreateVehicle()
        val vehicle = objectMapper.readValue(request, Vehicle::class.java)
        val vehicleCreated = vehicleRepository.addVehicle(vehicle)
        println(vehicleCreated)
        assertNotNull(vehicleCreated)
    }
}