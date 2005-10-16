package ebooking.core.menu;

/**
 * MenuItemAuthorization.
 * <p/>
 * User: rro
 * Date: 04.07.2005
 * Time: 18:04:45
 *
 * @author Roman R&auml;dle
 * @version $Id: MenuItemAuthorization.java,v 1.1 2005/10/16 18:41:08 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public class MenuItemAuthorization {

    private Long id;
    private String userRole;

    public MenuItemAuthorization() {
    }

    public MenuItemAuthorization(String userRole) {
        this.userRole = userRole;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MenuItemAuthorization)) return false;

        final MenuItemAuthorization menuItemAuthorization = (MenuItemAuthorization) o;

        if (userRole != null ? !userRole.equals(menuItemAuthorization.userRole) : menuItemAuthorization.userRole != null) return false;

        return true;
    }

    public int hashCode() {
        return (userRole != null ? userRole.hashCode() : 0);
    }

    public String toString() {
        return "userRole: " + userRole;
    }
}