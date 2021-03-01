package kafka

import model.Driver
import model.Vehicle
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import javax.inject.Inject
import javax.inject.Named

class KafkaServiceImpl(
    @Named(AppConstants.V_TOPIC_NAME) private val vehicleTopic: String,
    private val vehicleProducer: KafkaProducer<String, Vehicle>,
    @Named(AppConstants.D_TOPIC_NAME) private val driverTopic: String,
    private val driverProducer: KafkaProducer<String,Driver>
) : KafkaService{

    override fun produceVehicle(key: String, vehicle: Vehicle) {
        try {
           val record = vehicleProducer.send(ProducerRecord(AppConstants.V_TOPIC_NAME, key, vehicle)).get()
            println("Produced with Key $key and value $vehicle")
           println("record produced ${record.offset()}")
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun produceDriver(key: String, driver: Driver) {
        try {
            val record = driverProducer.send(ProducerRecord(AppConstants.D_TOPIC_NAME, key, driver)).get()
            println("record produced ${record.offset()}")
        }catch (e: Exception) {
            e.printStackTrace()
        }
    }
}