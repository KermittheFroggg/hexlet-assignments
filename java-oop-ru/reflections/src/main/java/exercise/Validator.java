package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class Validator {

    public static List<String> validate(Address address) {
        Class<?> aClass = address.getClass();
        List<String> result = new ArrayList<>();
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                if (field.isAnnotationPresent(NotNull.class) && field.get(address) == null) {
                    result.add(field.getName());
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static Map<String, List<String>> advancedValidate(Address address) {
        Class<?> aClass = address.getClass();
        Map<String, List<String>> result = new HashMap<>();
        Field[] fields = aClass.getDeclaredFields();
        List<String> value = new ArrayList<>();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                if (field.isAnnotationPresent(NotNull.class) && field.get(address) == null) {
                    value = List.of("can not be null");
                    result.put(field.getName(), value);
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            if (field.isAnnotationPresent(MinLength.class)) {
                MinLength minLengthInfo = field.getAnnotation(MinLength.class);
                try {
                    if(field.get(address).toString().length() < minLengthInfo.minLength()) {
                        value = List.of("length less than " + String.valueOf(minLengthInfo.minLength()));
                        result.put(field.getName(), value);
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return result;
    }
}
// END
