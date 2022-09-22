package testdata;

public enum TC2 {
    PAYEE_NAME("Test 2"),
    PAYEE_ACCOUNT_NUM("1234569876543001"),
    FOR_YOU_PARTICULAR("Test"),
    FOR_YOU_CODE("Data"),
    FOR_YOU_REFERENCE("Comm"),
    FOR_PAYEE_PARTICULAR("Assessment"),
    FOR_PAYEE_CODE("Activity"),
    FOR_PAYEE_REFERENCE("Sept"),
    IDENTIFIER("wert"),
    RELATIONSHIP("AIR FARES"),
    PAYER_NAME("John Doe");

    private String name;

    public String getName() {
        return name;
    }

    TC2(String name) {
        this.name = name;
    }
}
