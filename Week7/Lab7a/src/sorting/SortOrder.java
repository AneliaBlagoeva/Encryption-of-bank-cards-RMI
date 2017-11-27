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
public class SortOrder {

    private class Upward implements Sortable {

        @Override
        public boolean greater(int a, int b) {
            return a < b;
        }

    }

    public Sortable getUpwardSort() {
        return new Upward();
    }

    public Sortable getUpwardSortAnonymos() {
        return new Sortable() {
            @Override
            public boolean greater(int a, int b) {
                return a < b;
            }
        };
    }

    private class Downward implements Sortable {

        @Override
        public boolean greater(int a, int b) {
            return a > b;
        }
    }

    public Sortable getDownwardSort() {
        return new Downward();
    }

    public Sortable getDownwardSortAnonymos() {
        return new Sortable() {
            @Override
            public boolean greater(int a, int b) {
                return a > b;
            }
        };
    }
}
