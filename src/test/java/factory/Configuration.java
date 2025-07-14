package factory;

public class Configuration
{
    public static String browserName = System.getProperty("browser", "CHROME");
    public static String executionMode = System.getProperty("mode", "GIT");
}
