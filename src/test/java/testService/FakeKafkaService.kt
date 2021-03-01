package testService

import kafka.KafkaService
import model.Driver
import model.Vehicle

class FakeKafkaService: KafkaService {
    override fun produceVehicle(key: String, vehicle: Vehicle) {
    }

    override fun produceDriver(key: String, driver: Driver) {
    }
}