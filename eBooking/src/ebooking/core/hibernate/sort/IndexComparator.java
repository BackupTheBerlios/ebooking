package ebooking.core.hibernate.sort;

import java.util.Comparator;
import java.text.Collator;

/**
 * IndexComparator.
 * <p/>
 * User: rro
 * Date: 04.07.2005
 * Time: 14:40:59
 *
 * @author Roman R&auml;dle
 * @version $Id: IndexComparator.java,v 1.1 2005/10/16 18:41:08 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public class IndexComparator implements Comparator {

    public int compare(Object o1, Object o2) {

        if (o1 instanceof IndexComparable && o2 instanceof IndexComparable) {
            Integer o1Name = ((IndexComparable) o1).getIndex();
            Integer o2Name = ((IndexComparable) o2).getIndex();

            return o1Name.compareTo(o2Name);
        }

        return 0;
    }
}