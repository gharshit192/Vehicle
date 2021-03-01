package service

import kafka.KafkaService
import model.Driver
import model.Vehicle
import repository.DriverRepository
import java.lang.Exception
import javax.inject.Inject

class DriverService @Inject constructor(
    private val driverRepository: DriverRepository,
    private val kafkaService: KafkaService,
) {
    fun addDriver(driver: Driver): Driver {
        if (driver.getDrivingLicence().isNullOrEmpty()){
            throw Exception("Driving Licence is Null or Empty")
        }else
            driver.setEventType(AppConstants.DRIVER_EVENT_CREATED)
            kafkaService.produceDriver(driver.getUuid(),driver)
            return driverRepository.addDriver(driver)

    }
    fun getDriver(id: String): Driver? {
        val getDriver = driverRepository.getDriver(id)
        if (getDriver != null) {
            kafkaService.produceDriver(id , getDriver)
        }
        return getDriver
    }
    fun updateDriver(id: String ,driver: Driver): Driver {
        return driverRepository.updateDriver(id ,driver)
    }
    fun updateAssociatedVehicleId(request : Driver): Driver? {
        val updatedDriver =  driverRepository.updateAssociatedVehicleId(id, request)
        // TODO: 26/02/21 check in vehicle repository that with this vehicle id vehicle exist or not
        kafkaService.produceDriver(request)
        return updatedDriver
    }
    fun deleteDriver(id: String): Driver {
        return driverRepository.deleteDriver(id)

    }


}