package ebooking.util;

import ebooking.core.hibernate.sort.NameComparator;
import ebooking.module.base.bean.system.Country;
import ebooking.module.base.bean.system.Country;

import java.util.*;

/**
 * <p/>
 * User: rro
 * Date: 11.05.2005
 * Time: 14:02:14
 *
 * @author Roman R&auml;dle
 * @version $Id: ListUtils.java,v 1.1 2005/10/16 18:27:17 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public class ListUtils {

    public static List sortList(List list) {
        for (Iterator i = list.iterator(); i.hasNext();) {
            System.out.println("ELEMENT: " + ((Country) i.next()).getName());
        }

        Collections.sort(list, new NameComparator());

        for (Iterator i = list.iterator(); i.hasNext();) {
            System.out.println("ELEMENT: " + ((Country) i.next()).getName());
        }

        return list;
    }
}
