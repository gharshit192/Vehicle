package helper

import com.fasterxml.jackson.databind.ObjectMapper
import model.Driver
import model.Vehicle

object TestData {
    private var objectMapper = ObjectMapper()

    fun getCreateVehicle(): String {
        return "{\n" +
                "\"uuid\":\"1a1c5fe5-3ee0-453d-8425-5fec44961029\",\n" +
                "\"registrationNumber\":\"11\",\n" +
                "\"modelNo\":\"M1\",\n" +
                "\"chassisType\":\"CH-1\",\n" +
                "\"associatedDriverUUID\":\"null\"\n" +
                "}"
    }
    fun updatedVehicle() : String{
        return "{\n" +
                "\"uuid\":\"1a1c5fe5-3ee0-453d-8425-5fec44961029\",\n" +
                "\"registrationNumber\":\"11\",\n" +
                "\"modelNo\":\"M1\",\n" +
                "\"chassisType\":\"CH-1\",\n" +
                "\"associatedDriverUUID\":\"null\"\n" +
                "}"  }
    fun getCreateDriver(): String {
        return "{\n" +
                "\"uuid\":\"1a1c5fe5-3ee0-453d-8425-5fec44961029\",\n" +
                "\"drivingLicence\":\"11\",\n" +
                "\"driverName\":\"M1\",\n" +
                "\"associatedVehicleUUID\":\"null\"\n" +
                "}"
    }
    fun updatedDriver() : String{
        return "{\n" +
                "\"uuid\":\"1a1c5fe5-3ee0-453d-8425-5fec44961029\",\n" +
                "\"drivingLicence\":\"11\",\n" +
                "\"driverName\":\"M1\",\n" +
                "\"associatedVehicleUUID\":\"null\"\n" +
                "}"
    }


}