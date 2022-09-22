package testdata;

public enum TC3 {
    PAYEE_NAME("Test 3"),
    PAYEE_ACCOUNT_NUM("9876543211234001"),
    FOR_YOU_PARTICULAR(""),
    FOR_YOU_CODE(""),
    FOR_YOU_REFERENCE(""),
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

    TC3(String name) {
        this.name = name;
    }

}