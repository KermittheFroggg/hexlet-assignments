package exercise;

// BEGIN
public class LabelTag implements TagInterface {
    private TagInterface tagInterface;
    private String strTag;

    public LabelTag (String strTag, TagInterface tagInterface) {
        this.tagInterface = tagInterface;
        this.strTag = strTag;
    }

    @Override
    public String render() {
        String result = String.format("<label>%s%s</label>", strTag, tagInterface.render());
        return result;
    }
}
// END
