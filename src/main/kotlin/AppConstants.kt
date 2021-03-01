
object AppConstants {

    const val UUID = "uuid"
    const val ID = "id"
    const val KEY_SERVER_HOST = "host.url"
    const val KEY_SERVER_PORT = "host.port"
    const val SERVER_HOST_NAME = "http://0.0.0.0"
    const val SERVER_PORT = 8080

    const val BASE_URL = "vehicle/v1"
    const val VEHICLE = "vehicle"

    const val DB_COLLECTION_NAME = "vehicle"
    const val DB_COLLECTION_DRIVER_NAME = "driver"

    const val DB_NAME = "vehicle"
    const val DB_HOST = "localhost"
    const val DB_PORT = 27017

    // Event - Type
    const val VEHICLE_EVENT_CREATED = "Vehicle Created"
    const val VEHICLE_EVENT_UPDATED = "Vehicle Updated"
    const val VEHICLE_EVENT_DELETED = "Vehicle Deleted"
    const val DRIVER_EVENT_CREATED = "Driver Created"
    const val DRIVER_EVENT_UPDATED = "Driver Updated"
    const val DRIVER_EVENT_DELETED = "Driver Deleted"

    // KAFKA
    const val SERVER = "http://192.168.1.179:9092"
    const val KAFKA_DESERIALIZER = "org.apache.kafka.common.serialization.StringDeserializer"
    const val KAFKA_SERIALIZER = "org.apache.kafka.common.serialization.StringSerializer"
    const val VEHICLE_GROUP = "V-Group"
    const val DRIVER_GROUP = "D-Group"
    const val V_TOPIC_NAME = "V_Topic-1-A"
    const val D_TOPIC_NAME = "D_Topic-1-A"
    const val KEY_SCHEMA_REGISTRY_URL = "http://192.168.1.179:8081"
    const val VEHICLE_CONSUMER = "vehicle.consumer"
    const val DRIVER_CONSUMER = "driver.consumer"


}






