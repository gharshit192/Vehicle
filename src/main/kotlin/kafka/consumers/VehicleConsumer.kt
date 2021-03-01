package kafka.consumers

import model.Vehicle
import org.apache.kafka.clients.consumer.Consumer
import org.apache.kafka.clients.consumer.ConsumerRecords
import org.apache.kafka.clients.consumer.KafkaConsumer
import service.DriverService
import java.lang.Exception
import java.time.Duration
import javax.inject.Inject

import javax.inject.Named
import javax.inject.Singleton

class VehicleConsumer @Inject constructor(
    private val consumer : Consumer<String, Vehicle>,
    @Named(AppConstants.V_TOPIC_NAME)private val vehicleTopic : String,
    private val driverService: DriverService
) {
    fun vehicleConsume() {
        println("-------Starting vehicle consumer-----")
        try {

            consumer.subscribe(listOf(vehicleTopic))
            while (true) {
                val records: ConsumerRecords<String?, Vehicle?> = consumer.poll(100)
                for (record in records) {
                    val key = record.key()
                    val value = record.value()
                    if (value != null){
                        if (value.getEventType() == AppConstants.VEHICLE_EVENT_CREATED){
                            return
                        }else if (value.getEventType() == AppConstants.VEHICLE_EVENT_UPDATED){
                            return
                        }else if (value.getEventType() == "Associate Driver Id in ${AppConstants.VEHICLE_EVENT_UPDATED}"){
                            return driverService.updateAssociatedVehicleId(value)
                        }
                    }
                    System.out.printf("consumed --> key = %s, value = %s%n\"", key, value)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
}