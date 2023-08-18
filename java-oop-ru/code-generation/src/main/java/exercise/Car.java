package exercise;

import com.fasterxml.jackson.databind.util.ISO8601Utils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

// BEGIN
@Getter
@AllArgsConstructor
@Value
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN

    public static Car unserialize(String json) {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> mapCar;
        Car car = null;
        try {
            mapCar = mapper.readValue(json, Map.class);
           Map<String, Object> mapUser = new LinkedHashMap<>();
           mapUser = (Map<String, Object>) mapCar.get("owner");
           User user = new User((Integer) mapUser.get("id"),
                   (String) mapUser.get("firstName"),
                   (String) mapUser.get("lastName"),
                   (Integer) mapUser.get("age"));
            car = new Car((Integer) mapCar.get("id"),
                    (String) mapCar.get("brand"),
                    (String) mapCar.get("model"),
                    (String) mapCar.get("color"),
                    user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return car;
    }

    public String serialize() {
        Map<String, Object> data;

        data = Map.of("id", id,
                "brand", brand,
                "model", model,
                "color", color,
                "owner", owner);

        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        try {
            json = mapper.writeValueAsString(data);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return json;
    }
    // END
}
