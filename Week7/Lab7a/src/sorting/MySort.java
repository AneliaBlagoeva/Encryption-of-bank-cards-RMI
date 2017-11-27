/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

/**
 *
 * @author grade
 */
public class MySort {

    private Sortable callback;

    public MySort(Sortable callback) {
        this.callback = callback;
    }

    /**
     * Get the value of callback
     *
     * @return the value of callback
     */
    public Sortable getCallback() {
        return callback;
    }

    /**
     * Set the value of callback
     *
     * @param callback new value of callback
     */
    public void setCallback(Sortable callback) {
        this.callback = callback;
    }

    public void sort(int[] unsorted) {
        int index;

        for (int i = 0; i < unsorted.length - 1; i++) {
            index = i;
            for (int j = i + 1; j < unsorted.length; j++) {
                //upward a < b
                if (!callback.greater(unsorted[index], unsorted[j])) {
                    index = j;
                }
            }
//unsorted[index] is the min when callback.getClass==Upward
//unsorted[index] is the max when callback.getClass==Downward

            int temp = unsorted[i];
            unsorted[i] = unsorted[index];
            unsorted[index] = temp;
        }
    }
    
    
    
    
    //STATIC
        public static void sortStatic(int[] unsorted,Sortable order) {
        int index;

        for (int i = 0; i < unsorted.length - 1; i++) {
            index = i;
            for (int j = i + 1; j < unsorted.length; j++) {
                //upward a < b
                if (!order.greater(unsorted[index], unsorted[j])) {
                    index = j;
                }
            }
//unsorted[index] is the min when callback.getClass==Upward
//unsorted[index] is the max when callback.getClass==Downward

            int temp = unsorted[i];
            unsorted[i] = unsorted[index];
            unsorted[index] = temp;
        }
    }
}
