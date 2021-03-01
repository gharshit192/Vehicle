package di.module

import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class ConsumerModule {

    @Provides
    @Named("vehicleCollectionName")
    fun vehicleCollectionName(): String {
        return AppConstants.DB_COLLECTION_NAME
    }
    @Provides
    @Named("driverCollectionName")
    fun driverCollectionName(): String {
        return AppConstants.DB_COLLECTION_DRIVER_NAME
    }

    @Provides
    @Named(AppConstants.V_TOPIC_NAME)
    fun vehicleTopicName(): String {
        return AppConstants.V_TOPIC_NAME
    }
    @Provides
    @Named(AppConstants.D_TOPIC_NAME)
    fun driverTopicName(): String {
        return AppConstants.D_TOPIC_NAME
    }
    @Provides
    @Named(AppConstants.KEY_SCHEMA_REGISTRY_URL)
    fun schemaRegistry(): String {
        return AppConstants.KEY_SCHEMA_REGISTRY_URL
    }
}