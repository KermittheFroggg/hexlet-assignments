package exercise.daytime;
import jakarta.annotation.PostConstruct;

public class Night implements Daytime {
    private String name;

    public String getName() {
        return name;
    }

    // BEGIN
    @PostConstruct
    public void init() {
        name = "night";
    }
    // END
}
