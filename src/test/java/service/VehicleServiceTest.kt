package service

import com.fasterxml.jackson.databind.ObjectMapper
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import helper.TestData
import kafka.KafkaService
import model.Vehicle
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito
import repository.VehicleRepository

class VehicleServiceTest {
    private val kafkaService: KafkaService = mock()
    private val mapper = ObjectMapper()
    private val vehicleRepository: VehicleRepository = Mockito.mock(VehicleRepository::class.java)
    private var vehicleService = VehicleService(vehicleRepository,kafkaService)
    private lateinit var uuid: String


    @Test
    fun create_vehicle() {
        val request = TestData.getCreateVehicle()
        val vehicle = mapper.readValue(request, Vehicle::class.java)
        whenever(vehicleService.addVehicle(vehicle)).thenReturn(vehicle)
        val createdVehicle = vehicleService.addVehicle(vehicle)
        println(createdVehicle.toString())
        Assert.assertNotNull(createdVehicle)
        Assert.assertNotNull(createdVehicle.getRegistrationNumber())
        Assert.assertNotNull(createdVehicle.getChassisType())
    }
}