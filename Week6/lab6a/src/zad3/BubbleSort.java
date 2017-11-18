/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad3;

/**
 *
 * @author user
 */
public class BubbleSort {
   public void sortArray(Comparable[] arr){
     int j;
     boolean flag = true; 
     Comparable temp;

     while ( flag )
     {
            flag= false;
            for( j=0;  j < arr.length -1;  j++ )
            {
                   if ( arr[ j ].greater(arr[j+1]) )
                   {
                           temp = arr[ j ];           
                           arr[ j ] = arr[ j+1 ];
                           arr[ j+1 ] = temp;
                          flag = true; 
                  } 
            } 
      } 
   } 
}
