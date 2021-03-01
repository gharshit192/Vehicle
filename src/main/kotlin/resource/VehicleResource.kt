package resource

import com.fasterxml.jackson.databind.ObjectMapper
import jdk.nashorn.internal.objects.annotations.Getter
import model.Vehicle
import service.VehicleService
import java.lang.Exception
import javax.inject.Inject
import javax.json.Json
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("vehicle/v1")
class VehicleResource @Inject constructor(
    private val vehicleService: VehicleService,
    private val objectMapper: ObjectMapper
) {

    @POST
    @Path("vehicle")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun addVehicle(request : String) : Response{
        val vehicle = vehicleService.addVehicle(objectMapper.readValue(request, Vehicle::class.java))
        return Response.ok(vehicle.toString()).build()
    }

    @GET
    @Path("vehicle")
    @Produces(MediaType.APPLICATION_JSON)
    fun getVehicle(id : String) : Response{
        val vehicle = vehicleService.getVehicle(id)
        return Response.ok().build()
    }
    @PUT
    @Path("vehicle")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun updateVehicle(@PathParam("id")id : String,request: String) : Response{
        val vehicle = vehicleService.updateVehicle(id,objectMapper.readValue(request ,Vehicle::class.java))
        return Response.ok(vehicle.toString()).build()
    }
    @PUT
    @Path("vehicle_driver_id")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun updateAssociatedDriverId(@PathParam("id")id : String,request: String) : Response{

        val vehicle = vehicleService.updateAssociatedDriverId(id,objectMapper.readValue(request , Vehicle::class.java))
        return Response.ok(vehicle.toString()).build()
    }

    @DELETE
    @Path("vehicle")
    @Produces(MediaType.APPLICATION_JSON)
    fun deleteVehicle(@PathParam("id") id : String) : Response{
        val vehicle = vehicleService.deleteVehicle(id)
        return Response.ok(vehicle.toString()).build()
    }
}