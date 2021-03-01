package service

import com.fasterxml.jackson.databind.ObjectMapper
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import helper.TestData
import kafka.KafkaService
import model.Driver
import org.junit.Test
import org.junit.Assert.*
import org.mockito.Mockito
import repository.DriverRepository

class DriverServiceTest {
    private val kafkaService: KafkaService = mock()
    private val objectMapper = ObjectMapper()
    private val  driverRepository : DriverRepository = Mockito.mock(DriverRepository::class.java)
    private val driverService = DriverService(driverRepository,kafkaService)

    @Test
    fun create_driver(){
        val request = TestData.getCreateDriver()
        val driver = objectMapper.readValue(request, Driver::class.java)
        whenever(driverRepository.addDriver(driver)).thenReturn(driver)
        val createdDriver = driverService.addDriver(driver)
        println(createdDriver)
        assertNotNull(createdDriver)
        assertNotNull(createdDriver.getDrivingLicence())
    }
}