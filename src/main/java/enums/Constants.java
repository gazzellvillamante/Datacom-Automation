package enums;

public enum Constants {

    URL("https://www.demo.bnz.co.nz/client/"),
    CHROME_DRIVER_PATH(System.getProperty("user.dir")+"\\drivers\\Chrome\\chromedriver.exe"),
    FIREFOX_DRIVER_PATH(System.getProperty("user.dir")+"\\drivers\\Firefox\\geckodriver.exe");

    private String name;

    public String getName() {
        return name;
    }

    Constants(String name) {
        this.name = name;
    }
}
