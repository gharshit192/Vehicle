package kafka

import model.Driver
import model.Vehicle

interface KafkaService {

    fun produceVehicle(key : String, vehicle: Vehicle)
    fun produceDriver(key : String, driver: Driver)
}