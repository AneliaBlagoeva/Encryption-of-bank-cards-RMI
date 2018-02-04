/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deserialization;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

/**
 *
 * @author Anelia
 */
public class DeserealizationWarpper {

    public static Users deserealization() {
        XStream xs = new XStream(new StaxDriver());
        Users u=new Users();
        try {
            File file = new File("user.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
            Document xmlDom = docBuilder.parse(file);
            String xmlString = xmlDom.toString();
            xs.alias("users", Users.class);
            xs.alias("user", User.class);

            xs.addImplicitCollection(Users.class, "users");
            u = (Users) xs.fromXML(xmlString);
            

        } catch (Exception e) {
            System.out.println("Cannot read teh xml file!");
        }
        
        return u;

    }

//    public static void main(String[] args) {
//        deserealization();
//    }

}
