import di.component.DaggerVehicleAppComponent

fun main() {
    val component = DaggerVehicleAppComponent.builder().build()
    val httpServer = component.server()
    httpServer.start()
    val runVehicleConsumer = component.vehicleConsumer()
    Thread(runVehicleConsumer :: vehicleConsume).start()
//    component.driverConsumer().driverConsume()
}
