/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deserialization;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;

/**
 *
 * @author Anelia
 */
public class DeserealizationWarpper {

    public static Users deserealization() {
        XStream xs = new XStream(new StaxDriver());
        Users u = new Users();
        try {
            File xmlFile = new File("C:\\Users\\Anelia\\Documents\\NetBeansProjects\\First-steps-in-JAVA\\Project\\LoginApp\\src\\deserialization\\user.xml");


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

        } catch (Exception e) {
            System.out.println("Cannot read the xml file!");
        }

        return u;

    }

//    public static void main(String[] args) {
//            deserealization();
//    }
}
