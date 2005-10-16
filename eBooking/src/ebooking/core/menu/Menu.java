package ebooking.core.menu;

import java.util.Set;
import java.util.HashSet;

/**
 * Menu.
 * <p/>
 * User: rro
 * Date: 04.07.2005
 * Time: 13:40:14
 *
 * @author Roman R&auml;dle
 * @version $Id: Menu.java,v 1.1 2005/10/16 18:41:08 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public class Menu {

    private Long id;
    private String key;
    private Set menuItems = new HashSet();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Set getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(Set menuItems) {
        this.menuItems = menuItems;
    }
}