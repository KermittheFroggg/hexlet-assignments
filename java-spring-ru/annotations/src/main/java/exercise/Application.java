package exercise;

import exercise.model.Address;
import exercise.annotation.Inspect;
import java.lang.reflect.Method;

public class Application {
    public static void main(String[] args) {
        var address = new Address("London", 12345678);

        // BEGIN
        for (Method method : Address.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Inspect.class)) {
                try {
                    method.invoke(address);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String methodType = String.valueOf(method.getReturnType());
                String lastPart = methodType.split("\\.")[methodType.split("\\.").length - 1];

                System.out.println("Method " + method.getName() + " returns a value of type " + lastPart);
            }
        }
        // END
    }
}
