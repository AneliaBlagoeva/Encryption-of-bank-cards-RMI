/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad1;


import geometryObjectsPackage.Line;
import geometryObjectsPackage.Point;
import geometryObjectsPackage.RectangleObj;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
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
        int width=(int)scene.getWidth();
        int height=(int)scene.getHeight();
        
        Point sPoint=new Point(new int[]{width/3,height/3});
        Point ePoint=new Point(new int[]{width* 2 /3, height*2 /3});      
         
        RectangleObj rectangle=new RectangleObj(new Point[]{sPoint,ePoint});
        rectangle.draw(root);
        
        Line diagonal1=new Line(sPoint,ePoint);
        diagonal1.draw(root);
        
        primaryStage.setTitle("Drawing lines and rectangles!");
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
