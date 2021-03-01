package service

import kafka.KafkaService
import model.Vehicle
import repository.VehicleRepository
import java.lang.Exception
import java.util.*
import javax.inject.Inject

class VehicleService @Inject constructor(
    private val vehicleRepository: VehicleRepository,
    private val kafkaService: KafkaService,
    private val driverService: DriverService

){

    fun addVehicle(vehicle: Vehicle): Vehicle {
        when {
            vehicle.getRegistrationNumber().isNullOrEmpty() -> throw Exception(" Registration No is Null ")
            vehicle.getChassisType().isNullOrEmpty() -> throw Exception(" Chassis Type is Null ")
            else -> vehicle.setUuid(UUID.randomUUID().toString())
        }
        vehicle.setEventType(AppConstants.VEHICLE_EVENT_CREATED)
        kafkaService.produceVehicle(vehicle.getUuid(),vehicle)
        return vehicleRepository.addVehicle(vehicle)
    }

    fun getVehicle(id: String): Vehicle? {
        val getVehicle = vehicleRepository.getVehicle(id)
        if (getVehicle != null){
            kafkaService.produceVehicle(id , getVehicle)
        }
        return getVehicle
    }

    fun updateVehicle(id: String,vehicle: Vehicle): Vehicle {
        val updatedVehicle =  vehicleRepository.updateVehicle(id,vehicle)
            vehicle.setEventType(AppConstants.VEHICLE_EVENT_UPDATED)
            kafkaService.produceVehicle(id,vehicle)
            return updatedVehicle
        }

    fun updateAssociatedDriverId(id: String, request : Vehicle): Vehicle {
        val updatedVehicle =  vehicleRepository.updateAssociatedDriverId(id, request)
        // TODO: 26/02/21 check in driver repository that with this driver id driver exist or not
        return if(driverService.getDriver(request.getAssociatedDriverUUID()) == null || updatedVehicle ==null){
            throw  Exception("Driver Not Exist with ${request.getAssociatedDriverUUID()} OR " +
                    "Driver Id is NULL or BLANK")
        }else{
            request.setEventType("Associate Driver Id in ${AppConstants.VEHICLE_EVENT_UPDATED}")
            kafkaService.produceVehicle(id,request)
            updatedVehicle
        }
    }

    fun deleteVehicle(id: String): Vehicle {
        return vehicleRepository.deleteVehicle(id)
    }
}