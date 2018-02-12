package clients;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * class for deserealization of xml file containing users, their passwords and
 * information for them. This class uses XStream for deserealization.
 */
/**
 *
 * @author Anelia
 */
public class DeserealizationWarpper {

    /**
     * method for deserealization of users and information for them.
     * First read the whole file into string and then
     * deserialize the string.
     *
     * @return
     */
    public static Users deserealization() {
        XStream xs = new XStream(new StaxDriver());
        Users u = new Users();
        try {
            File xmlFile = new File("C:\\Users\\Anelia\\Documents\\NetBeansProjects\\First-steps-in-JAVA\\Project\\Server\\src\\clients\\user.xml");

            Reader fileReader = new FileReader(xmlFile);
            BufferedReader bufReader = new BufferedReader(fileReader);
            StringBuilder sb = new StringBuilder();
            String line = bufReader.readLine();
            while (line != null) {
                sb.append(line).append("\n");
                line = bufReader.readLine();
            }
            String xmlString = sb.toString();

            xs.alias("users", Users.class);
            xs.alias("user", User.class);

            xs.addImplicitCollection(Users.class, "users");
            u = (Users) xs.fromXML(xmlString);

        } catch (IOException e) {
            System.out.println("Cannot read the xml file!");
        }

        return u;

    }

}
