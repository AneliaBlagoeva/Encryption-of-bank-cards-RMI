/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestHelloWorld;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Anelia
 */
@WebService(serviceName = "SayHallo")
public class SayHallo {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "SayName")
    public String SayName(@WebParam(name = "name") String name) {
        //TODO write your implementation code here:
        return "Your name is " + name;
    }
}
