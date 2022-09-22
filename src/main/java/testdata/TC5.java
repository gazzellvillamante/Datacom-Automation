package testdata;

public enum TC5 {
    FROM_ACCOUNT("everyday"),
    PAYEE_ACCOUNT_NUM("bills"),
    PAY_OR_TRANSFER_DETAIL("500");

    private String name;

    public String getName() {
        return name;
    }

    TC5(String name) {
        this.name = name;
    }
}
