package testdata;

public enum TC4 {
    PAYEE_NAME("Test 4"),
    PAYEE_ACCOUNT_NUM("9876543211234001"),
    FOR_YOU_PARTICULAR("Test Particular"),
    FOR_YOU_CODE("113"),
    FOR_YOU_REFERENCE("Test Reference"),
    FOR_PAYEE_PARTICULAR(""),
    FOR_PAYEE_CODE(""),
    FOR_PAYEE_REFERENCE(""),
    IDENTIFIER(""),
    RELATIONSHIP(""),
    PAYER_NAME("");

    private String name;

    public String getName() {
        return name;
    }

    TC4(String name) {
        this.name = name;
    }

}