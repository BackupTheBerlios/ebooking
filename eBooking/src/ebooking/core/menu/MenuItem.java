package ebooking.core.menu;

import ebooking.core.hibernate.sort.IndexComparable;

import java.util.Set;

/**
 * MenuItem.
 * <p/>
 * User: rro
 * Date: 04.07.2005
 * Time: 13:42:12
 *
 * @author Roman R&auml;dle
 * @version $Id: MenuItem.java,v 1.1 2005/10/16 18:41:08 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public class MenuItem implements IndexComparable {

    private Long id;
    private Integer index;
    private String key;
    private String imagePath;
    private String link;
    private String target;
    private String tooltip;
    private MenuItem parent;
    private Set menuItems;
    private Set menuItemAuthorizations;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getTooltip() {
        return tooltip;
    }

    public void setTooltip(String tooltip) {
        this.tooltip = tooltip;
    }

    public MenuItem getParent() {
        return parent;
    }

    public void setParent(MenuItem parent) {
        this.parent = parent;
    }

    public Set getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(Set menuItems) {
        this.menuItems = menuItems;
    }

    public Set getMenuItemAuthorizations() {
        return menuItemAuthorizations;
    }

    public void setMenuItemAuthorizations(Set menuItemAuthorizations) {
        System.out.println("MENU_ITEM_AUTHORIZATION: " + menuItemAuthorizations);
        this.menuItemAuthorizations = menuItemAuthorizations;
    }

    public boolean isAuthorized(String userRole) {
        return (this.menuItemAuthorizations.contains(new MenuItemAuthorization(userRole)));
    }

    public String toString() {
        return "MenuItem name: " + this.getKey() + System.getProperty("line.separator") + "auth: " + menuItemAuthorizations;
    }
}