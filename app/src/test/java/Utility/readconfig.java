package Utility;
import java.io.FileInputStream;
import java.util.Properties;

public class readconfig {

    private static Properties properties;
    //String path = "D:\\GradleDemo\\app\\src\\test\\resources\\Configration.properties";
    String path = "C:\\Users\\navee\\Downloads\\Gradle-Demo_Project-master\\Gradle-Demo_Project-master\\app\\src\\test\\resources\\Configration.properties";

    public readconfig()
    {
        try{
            properties = new Properties();

            FileInputStream fis = new FileInputStream(path);
            properties.load(fis);
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public String getUrl(){
        String value = properties.getProperty("url");
        if(value!=null) {
            return value;
        }
            else
            {
                throw new RuntimeException("Not able to get  baseurl from config");
            }
        }
    public String getBrowser()
    {
        String value = properties.getProperty("browser");
        if(value!= null)
            return value;
        else
            throw new RuntimeException("Not able to get browser");
    }
    }


