package kafka.consumers

import model.Driver
import model.Vehicle
import org.apache.kafka.clients.consumer.Consumer
import org.apache.kafka.clients.consumer.ConsumerRecords
import org.apache.kafka.clients.consumer.KafkaConsumer
import java.lang.Exception
import java.time.Duration
import javax.inject.Inject
import javax.inject.Named

class   DriverConsumer @Inject constructor (
    private val consumer : Consumer<String, Driver>,
    @Named(AppConstants.D_TOPIC_NAME)private val driverTopic : String
) {
    fun driverConsume(){
        println("--------Starting Driver Consumer--------")
        consumer.subscribe(listOf(driverTopic))
        try {
            while (true) {
                val records: ConsumerRecords<String?, Driver?> = consumer.poll(100)
                for (record in records) {
                    val key = record.key()
                    val value = record.value()
                    System.out.printf("consumed --> key = %s, value = %s%n\"", key, value)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}