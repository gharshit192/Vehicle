package resource

import com.fasterxml.jackson.databind.ObjectMapper
import di.component.DaggerVehicleAppTestComponent
import helper.TestData
import org.glassfish.jersey.server.ResourceConfig
import org.glassfish.jersey.test.JerseyTest
import org.json.JSONObject
import org.junit.Assert.*
import org.junit.Test
import org.mockito.Mockito.mock
import service.VehicleService
import javax.ws.rs.client.Entity
import javax.ws.rs.core.Application
import javax.ws.rs.core.MediaType

class VehicleResourceTest : JerseyTest() {
    private val baseUrl = "vehicle/v1"
    private var uuid = "1a1c5fe5-3ee0-453d-8425-5fec44961029"
    private val objectMapper = ObjectMapper()
    private var vehicleService: VehicleService = mock(VehicleService::class.java)


    override fun configure(): Application {
        val testComponent = DaggerVehicleAppTestComponent.builder().build()
        return ResourceConfig().register(VehicleResource(testComponent.service(),testComponent.mapper())).application
    }

    @Test
    fun return_200_create_vehicle() {
        val request = TestData.getCreateVehicle()
        val response = target("vehicle/v1/vehicle")
            .request().post(Entity.entity(request, MediaType.APPLICATION_JSON))
        println("Response Status : ${response.status}")
        assertTrue("Response Status : ", response.status == 200)
        val responseJson = JSONObject(response.readEntity(String::class.java))
        uuid = responseJson.get("uuid").toString()
        assertNotNull(responseJson.get("uuid"))
    }

    @Test
    fun return_200_update_vehicle() {
        val updatedRequest = TestData.updatedVehicle()
        val response = target("$baseUrl/vehicle")
            .request().put(Entity.entity(updatedRequest,MediaType.APPLICATION_JSON))
        println(response.status)
        assertTrue("Response Status : " ,response.status == 200)

    }

}