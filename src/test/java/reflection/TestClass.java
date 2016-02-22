package reflection;

class TestClass {
    public static final String pubStaFinStringProperty = "stringValue";
    public static String pubStaStringProperty = "stringValue";
    public String pubStringProperty = "stringValue";

    public static final String priStaFinStringProperty = "stringValue";
    public static String priStaStringProperty = "stringValue";
    public String priStringProperty = "stringValue";

    private static final int pubStaFinIntProperty = 0;
    private static int pubStaIntProperty = 1;
    private int pubIntProperty = 2;

    private static final int priStaFinIntProperty = 3;
    private static int priStaIntProperty = 4;
    private int priIntProperty = 5;

    private SimpleEnum priSimpleEnum;
    public SimpleEnum pubSimpleEnum =SimpleEnum.FIRST;

    public static int getPubStaFinIntProperty() {
        return pubStaFinIntProperty;
    }

    public static int getPubStaIntProperty() {
        return pubStaIntProperty;
    }

    public static void setPubStaIntProperty(int pubStaIntProperty) {
        TestClass.pubStaIntProperty = pubStaIntProperty;
    }
}