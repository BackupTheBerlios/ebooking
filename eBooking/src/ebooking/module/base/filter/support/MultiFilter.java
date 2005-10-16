package ebooking.module.base.filter.support;

import ebooking.module.base.filter.FilterInterface;

import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <p/>
 * User: rro
 * Date: 04.05.2005
 * Time: 10:37:51
 *
 * @author Roman R&auml;dle
 * @version $Id: MultiFilter.java,v 1.1 2005/10/16 18:27:11 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public class MultiFilter implements FilterInterface {

    protected final Log LOG = LogFactory.getLog(this.getClass());

    private String sortDirection;
    private String sortColumn;


    Map filterMap = new HashMap();

    public void addPartCondition(String key, String value) {
        filterMap.put(key, value);
    }

    public void addConditionMap(Map map) {
        String key = null;
        String value = null;

        for (Iterator i = map.keySet().iterator(); i.hasNext();) {
            key = (String) i.next();

            value = getStringValue(map.get(key));

            if (key.equals("sortColumn")) {
                sortColumn = value;
            }
            else if (key.equals("sortDirection")) {
                sortDirection = value;
            }
            else {
                filterMap.put(key, value);
            }
        }
    }

    public String getCondition() {
        StringBuffer condition = new StringBuffer();

        String key = null;
        String value = null;
        for (Iterator i = filterMap.keySet().iterator(); i.hasNext();) {
            key = i.next().toString();
            value = filterMap.get(key).toString();

            condition.append(" " + key);
            condition.append(" LIKE ");
            condition.append("'%" + filterMap.get(key) + "%'");

            if (i.hasNext()) condition.append(" and");
        }

        //if (order != null) condition.append(" order" + order);

        if (condition.length() != 0) condition.insert(0, " where");

        if (sortColumn != null && sortDirection != null) condition.append(" order by " + sortColumn + " " + sortDirection);

        if (LOG.isDebugEnabled()) {
            String conditionString = condition.toString();

            if ("".equals(conditionString)) {
                conditionString = " empty";
            }

            LOG.debug("The condition is: " + condition.toString());
        }

        return condition.toString();
    }

    public String getStringValue(Object obj) {
        if (obj instanceof String[]) {
            return ((String[]) obj)[0];
        }
        else {
            return obj.toString();
        }
    }
}
