package factory;

public class Configuration
{
    public static String browserName = System.getProperty("browser", "chrome");
    public static String executionMode = System.getProperty("mode", "local");
}
