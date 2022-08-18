package ec.edu.espe.serviciosescolastico.enums;

public enum paraleloEnum {

    A("A", "A"),
    B("B","B"),
    C("C","C");
    private final String value;
    private final String text;

    paraleloEnum(String value, String text) {
        this.value = value;
        this.text = text;
    }
    public String getText() {
        return this.text;
    }

    public String getValue() {
        return this.value;
    }


}
