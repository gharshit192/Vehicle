package di.module

import dagger.Module
import dagger.Provides
import io.confluent.kafka.serializers.KafkaAvroDeserializer
import io.confluent.kafka.serializers.KafkaAvroSerializer
import model.Driver
import model.Vehicle
import org.apache.kafka.clients.consumer.Consumer
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerConfig
import java.util.*
import javax.inject.Named
import javax.inject.Singleton

@Module
class KafkaModule {

    @Provides
    fun provideVehicleProducer(
        @Named(AppConstants.KEY_SCHEMA_REGISTRY_URL) schemaRegistryURL: String
        ) : KafkaProducer<String, Vehicle>
    {
        val props = Properties()
        props[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = AppConstants.SERVER
        props[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = AppConstants.KAFKA_SERIALIZER
        props[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = KafkaAvroSerializer::class.java
        props[ProducerConfig.ACKS_CONFIG] = "all"
        props["schema.registry.url"] = schemaRegistryURL
        return KafkaProducer(props)
    }

    @Provides
    @Named("${AppConstants.VEHICLE_CONSUMER}-config")
    fun provideVehicleConsumerConfig(
        @Named(AppConstants.KEY_SCHEMA_REGISTRY_URL) schemaRegistryURL: String
    ):Properties
    {
        val props = Properties()
        props[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = AppConstants.SERVER
        props[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = AppConstants.KAFKA_DESERIALIZER
        props[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = KafkaAvroDeserializer::class.java
        props[ConsumerConfig.GROUP_ID_CONFIG] = AppConstants.VEHICLE_GROUP
        props[ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG] = "false"
        props[ConsumerConfig.AUTO_OFFSET_RESET_CONFIG] = "earliest"
        props["schema.registry.url"] = schemaRegistryURL
        return props
    }
    @Provides
    fun provideVehicleConsumer(
        @Named("${AppConstants.VEHICLE_CONSUMER}-config")properties: Properties
    ): Consumer<String, Vehicle> {
        return KafkaConsumer(properties)
    }

    @Provides
    fun provideDriverProducer(
        @Named(AppConstants.KEY_SCHEMA_REGISTRY_URL) schemaRegistryURL: String,

        ) : KafkaProducer<String,Driver>
    {
        val props = Properties()
        props[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = AppConstants.SERVER
        props[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = AppConstants.KAFKA_SERIALIZER
        props[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = KafkaAvroSerializer::class.java
        props[ProducerConfig.ACKS_CONFIG] = "all"
        props["schema.registry.url"] = schemaRegistryURL
        return KafkaProducer(props)
    }

    @Provides
    @Named("${AppConstants.DRIVER_CONSUMER}-config")
    fun provideDriverConsumerConfig(
        @Named(AppConstants.KEY_SCHEMA_REGISTRY_URL) schemaRegistryURL: String
        ): Properties
    {
        val props = Properties()
        props[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = AppConstants.SERVER
        props[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = AppConstants.KAFKA_DESERIALIZER
        props[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = KafkaAvroDeserializer::class.java
        props[ConsumerConfig.GROUP_ID_CONFIG] = AppConstants.DRIVER_GROUP
        props[ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG] = "false"
        props[ConsumerConfig.AUTO_OFFSET_RESET_CONFIG] = "earliest"
        props["schema.registry.url"] = schemaRegistryURL
        return props
    }

    @Provides
    fun provideDriverConsumer(
        @Named("${AppConstants.DRIVER_CONSUMER}-config")properties: Properties
    ): Consumer<String, Driver> {
        return KafkaConsumer(properties)
    }
}