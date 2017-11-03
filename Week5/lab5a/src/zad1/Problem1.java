/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad1;


import geometryObjectsPackage.LineObj;
import geometryObjectsPackage.PointObj;
import geometryObjectsPackage.RectangleObj;
import java.util.Random;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author grade
 */
public class Problem1 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Group root=new Group();
        Scene scene=new Scene(root,300,250);
        Random random=new Random();
        int width=(int)scene.getWidth();
        int height=(int)scene.getHeight();
        
        PointObj sPoint=new PointObj(new int[]{random.nextInt(width),random.nextInt(height)});
        PointObj ePoint=new PointObj(new int[]{random.nextInt(width),random.nextInt(height)});       
         
        RectangleObj rectangle=new RectangleObj(new PointObj[]{sPoint,ePoint});
        rectangle.draw(root);
        
        LineObj diagonal1=new LineObj(sPoint,ePoint);
        diagonal1.draw(root);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
