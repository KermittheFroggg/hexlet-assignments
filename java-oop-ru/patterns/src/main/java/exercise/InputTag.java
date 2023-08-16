package exercise;

import java.text.Format;

// BEGIN
public class InputTag implements TagInterface {
    private String type;
    private String value;

    public InputTag(String type, String value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public String render() {
        String result = String.format("<input type=\"%s\" value=\"%s\">", this.getType(), this.getValue());
        return result;
    }

    private String getValue() {
        return value;
    }

    public String getType() {
        return type;
    }
}
// END
