package reflection;

public enum SimpleEnum {
    FIRST(1), SECOND(2);
    private int value;

    SimpleEnum(int i) {

    }

    public int getValue() {
        return value;
    }
}
