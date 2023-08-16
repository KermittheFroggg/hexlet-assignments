package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    String tag;
    List<Tag> childrens;

    public PairedTag(String name, Map<String, String> atributes, String tag, List<Tag> childrens) {
        super(name, atributes);
        this.tag = tag;
        this.childrens = childrens;
    }

    public String toString() {
        String begin = super.toString();
        StringBuilder stringbuilder = new StringBuilder(begin);
        stringbuilder.append(tag);
        for (Tag child : childrens) {
            stringbuilder.append(child.toString());
        }
        stringbuilder.append(String.format("</%s>", name));
        return String.valueOf(stringbuilder);
    }
}
// END
