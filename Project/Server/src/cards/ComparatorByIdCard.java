/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards;

import java.util.Comparator;

/**
 *
 * @author Anelia
 */
public class ComparatorByIdCard implements Comparator<Card>{

    @Override
    public int compare(Card o1, Card o2) {
        return o1.cardId.compareTo(o2.cardId);
    }
    
}
