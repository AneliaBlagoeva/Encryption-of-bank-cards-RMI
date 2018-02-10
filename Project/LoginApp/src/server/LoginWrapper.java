///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package server;
//
//import java.rmi.RemoteException;
//import java.rmi.server.UnicastRemoteObject;
//
///**
// *
// * @author Anelia
// */
//public class LoginWrapper extends UnicastRemoteObject{
//    ILoginable callbackFtn;
//    boolean flag;
//   
//
//    public LoginWrapper(ILoginable callbackFtn)throws RemoteException {
//        this.callbackFtn = callbackFtn;
//        this.flag = false;
//    }
//    
//    public LoginWrapper()throws RemoteException {
//    }
//    
//    
//    public boolean checkCredentials() throws RemoteException{
//         try{
//         flag=callbackFtn.checkCredentials();
//         }catch(RemoteException e){
//             System.out.println("Error in callback function.");
//         }
//         
//         return flag;
//     }
//    
//}
