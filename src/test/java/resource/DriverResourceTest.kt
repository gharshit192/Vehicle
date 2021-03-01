package resource

import com.fasterxml.jackson.databind.ObjectMapper
import di.component.DaggerVehicleAppTestComponent
import helper.TestData
import org.glassfish.jersey.server.ResourceConfig
import org.glassfish.jersey.test.JerseyTest
import org.junit.Test
import org.junit.Assert.*
import org.mockito.Mockito.mock
import service.DriverService
import javax.ws.rs.client.Entity
import javax.ws.rs.core.Application
import javax.ws.rs.core.MediaType

class DriverResourceTest : JerseyTest() {
    private var uuid = "1a1c5fe5-3ee0-453d-8425-5fec44961029"
    private val objectMapper = ObjectMapper()
    private var driverService : DriverService = mock(DriverService::class.java)

    override fun configure(): Application {
        val testComponent = DaggerVehicleAppTestComponent.builder().build()
        return ResourceConfig().register(DriverResource(testComponent.mapper(),testComponent.driverService())).application
    }

    @Test
    fun create_driver_return_200(){
        val request = TestData.getCreateDriver()
        val response = target("driver/d1/driver")
            .request().post(Entity.entity(request, MediaType.APPLICATION_JSON_TYPE))
        println(response.status)
        assertTrue(response.status == 200)
    }

}