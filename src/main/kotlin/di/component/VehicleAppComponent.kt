package di.component

import dagger.Component
import di.module.*
import kafka.consumers.DriverConsumer
import kafka.consumers.VehicleConsumer
import org.glassfish.grizzly.http.server.HttpServer

@Component(modules =
    [
        ConfigModule::class,
        HttpModule::class,
        MapperModule::class,
        DatabaseModule::class,
        KafkaModule::class,
        ServiceModule::class,
        ConsumerModule::class
    ]
)
interface VehicleAppComponent {
    fun server() : HttpServer
    fun vehicleConsumer() : VehicleConsumer
    fun driverConsumer() : DriverConsumer
}