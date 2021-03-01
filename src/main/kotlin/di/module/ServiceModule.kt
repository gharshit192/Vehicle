package di.module

import dagger.Module
import dagger.Provides
import kafka.KafkaService
import kafka.KafkaServiceImpl
import model.Driver
import model.Vehicle
import org.apache.kafka.clients.producer.KafkaProducer
import javax.inject.Named

@Module
class ServiceModule {

    @Provides
    fun provideKafkaService(
        @Named(AppConstants.V_TOPIC_NAME)vehicleTopic : String,
        vehicleProducer: KafkaProducer<String, Vehicle>,
        @Named(AppConstants.D_TOPIC_NAME)driverTopic : String,
        driverProducer: KafkaProducer<String, Driver>
    ) : KafkaService{
        return KafkaServiceImpl(
            vehicleTopic = vehicleTopic,
            vehicleProducer = vehicleProducer,
            driverTopic = driverTopic,
            driverProducer = driverProducer
        )
    }
}