package isThisUsed;

public class Noun {
    // properties
    public String value = null;
    // constructors
    public Noun(String noun){
        this.value = noun;
    }
    // methods
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
