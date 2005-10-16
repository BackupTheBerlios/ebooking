package ebooking.util;

import java.util.Map;
import java.util.Iterator;
import java.util.HashMap;

/**
 * <p/>
 * User: rro
 * Date: 04.05.2005
 * Time: 22:37:46
 *
 * @author Roman R&auml;dle
 * @version $Id: MapUtils.java,v 1.1 2005/10/16 18:27:17 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public class MapUtils {
    public static Map getPlainStringMap(Map map) {

        Map returnMap = new HashMap();

        String key = null;
        Object obj = null;
        for (Iterator i = map.keySet().iterator(); i.hasNext();) {
            key = (String) i.next();
            obj = map.get(key);

            if (obj instanceof String[]) {
                returnMap.put(key, ((String[]) obj)[0]);
            } else {
                returnMap.put(key, obj.toString());
            }
        }

        return returnMap;
    }
}
