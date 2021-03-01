package repository

import com.fasterxml.jackson.databind.ObjectMapper
import com.mongodb.MongoClient
import com.mongodb.client.MongoDatabase
import helper.EmbeddedMongoDb
import helper.TestData
import model.Driver
import org.junit.Assert.*
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.util.*

class DriverRepositoryTest {

    private val uuid: String = "1a1c5fe5-3ee0-453d-8425-5fec44961029"
    private lateinit var embeddedMongoDb: EmbeddedMongoDb
    private lateinit var database: MongoDatabase
    private val objectMapper = ObjectMapper()
    private val driverCollectionName = "driver"
    private lateinit var driverRepository: DriverRepository

    @Before
    fun configure() {

        startMongoDb()
        val mongoClient = MongoClient("localhost", embeddedMongoDb.port)
        database = mongoClient.getDatabase("driver")

        driverRepository = DriverRepository(database, ObjectMapper(),driverCollectionName)
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
    fun create_driver(){
        val request = TestData.getCreateDriver()
        val driver = objectMapper.readValue(request, Driver::class.java)
        val driverCreated = driverRepository.addDriver(driver)
        assertNotNull(driverCreated)
        assertNotNull(driverCreated.getDrivingLicence())
        println(driverCreated)
    }

}