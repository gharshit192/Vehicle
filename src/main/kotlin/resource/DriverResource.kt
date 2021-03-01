package resource

import com.fasterxml.jackson.databind.ObjectMapper
import model.Driver
import model.Vehicle
import service.DriverService
import java.awt.PageAttributes
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("driver/d1")
class DriverResource @Inject constructor(
    private val objectMapper: ObjectMapper,
    private val driverService: DriverService

){

    @POST
    @Path("driver")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun addDriver(request : String) : Response{
        val driver = driverService.addDriver(objectMapper.readValue(request, Driver::class.java))
        return Response.ok(driver).build()
    }

    @GET
    @Path("driver")
    @Produces(MediaType.APPLICATION_JSON)
    fun getDriver(id: String) : Response{
        val driver = driverService.getDriver(id)
        return Response.ok(driver.toString()).build()
    }
    @PUT
    @Path("driver")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun updateVehicle(@PathParam("id")id : String, request : String) : Response{
        val driver = driverService.updateDriver(id,objectMapper.readValue(request, Driver::class.java))
        return Response.ok(driver.toString()).build()
    }

    @PUT
    @Path("driver_vehicle_id")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun updateAssociatedVehicleId(request: String) : Response{
        val driver = driverService.updateAssociatedVehicleId(objectMapper.readValue(request , Driver::class.java))
        return Response.ok(driver.toString()).build()
    }

    @DELETE
    @Path("driver")
    @Produces(MediaType.APPLICATION_JSON)
    fun deleteDriver(@PathParam("id") id : String) : Response{
        val driver = driverService.deleteDriver(id)
        return Response.ok(driver.toString()).build()
    }


}