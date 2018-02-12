package cards;

import java.util.Comparator;

/**
 *
 * @author Anelia
 */
/**
 * comparator for cards by card id
 * @author Anelia
 */
public class ComparatorByIdCard implements Comparator<Card>{

    @Override
    public int compare(Card o1, Card o2) {
        return o1.cardId.compareTo(o2.cardId);
    }
    
}
