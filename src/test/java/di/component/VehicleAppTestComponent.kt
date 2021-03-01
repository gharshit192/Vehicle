package di.component

import com.fasterxml.jackson.databind.ObjectMapper
import dagger.Component
import di.module.*
import service.DriverService
import service.VehicleService

@Component(modules =
[
    ConfigModule::class,
    HttpModule::class,
    MapperModule::class,
    DatabaseModule::class,
    KafkaModule::class,
    KafkaServiceTestModule::class,
    ConsumerModule::class
])
interface VehicleAppTestComponent {
    fun service() : VehicleService
    fun driverService() : DriverService
    fun mapper() : ObjectMapper

}