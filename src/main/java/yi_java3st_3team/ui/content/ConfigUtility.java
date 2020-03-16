package yi_java3st_3team.ui.content;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import yi_java3st_3team.dto.Email;
 
/**
 * A utility class that reads/saves SMTP settings from/to a properties file.
 * @author www.codejava.net
 *
 */
public class ConfigUtility {
    private File configFile = new File("smtp.properties");
    private Properties configProps;
     
    public Properties loadProperties(Email email) throws IOException {
    	Properties defaultProps = new Properties();
        // sets default properties
        defaultProps.setProperty("mail.smtp.host", email.getHostName());
        defaultProps.setProperty("mail.smtp.port", email.getPortNum());
        defaultProps.setProperty("mail.user", email.getUserId());
        defaultProps.setProperty("mail.password", email.getUserPass());
        defaultProps.setProperty("mail.smtp.auth", "true");
         
        configProps = new Properties(defaultProps);
         
        // loads properties from file
        if (configFile.exists()) {
            InputStream inputStream = new FileInputStream(configFile);
            configProps.load(inputStream);
            inputStream.close();
        }
         
        return configProps;
    }
     
    public void saveProperties(String host, String port, String user, String pass) throws IOException {
        configProps.setProperty("mail.smtp.host", host);
        configProps.setProperty("mail.smtp.port", port);
        configProps.setProperty("mail.user", user);
        configProps.setProperty("mail.password", pass);
        configProps.setProperty("mail.smtp.starttls.enable", "true");
        configProps.setProperty("mail.smtp.auth", "true");
         
        OutputStream outputStream = new FileOutputStream(configFile);
        configProps.store(outputStream, "host setttings");
        outputStream.close();
    }  
}
