package ebooking.core.hibernate.sort;

import java.util.Comparator;
import java.text.Collator;

/**
 * <p/>
 * User: rro
 * Date: 11.05.2005
 * Time: 12:31:45
 *
 * @author Roman R&auml;dle
 * @version $Id: NameComparator.java,v 1.1 2005/10/16 18:41:08 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public class NameComparator implements Comparator {

    private Collator collator = Collator.getInstance();

    public int compare(Object o1, Object o2) {
        if (o1 instanceof NameComparable && o2 instanceof NameComparable) {
            String o1Name = ((NameComparable) o1).getName();
            String o2Name = ((NameComparable) o2).getName();

            return collator.compare(o1Name, o2Name);
        }

        return 0;
    }
}
