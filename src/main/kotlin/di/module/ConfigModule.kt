package di.module

import dagger.Module
import dagger.Provides
import model.Driver
import model.Vehicle
import org.apache.kafka.clients.consumer.Consumer
import org.apache.kafka.clients.consumer.KafkaConsumer
import java.util.*
import javax.inject.Named
import javax.inject.Singleton

@Module
class ConfigModule {

    @Provides
    @Named(AppConstants.KEY_SERVER_HOST)
    fun provideHost() : String{
        return AppConstants.SERVER_HOST_NAME
    }
    @Provides
    @Named(AppConstants.KEY_SERVER_PORT)
    fun providePort() : Int{
        return AppConstants.SERVER_PORT
    }


}