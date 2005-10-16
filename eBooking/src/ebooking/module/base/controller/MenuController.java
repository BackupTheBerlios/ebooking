package ebooking.module.base.controller;

import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.context.ApplicationContextAware;
import ebooking.module.base.service.BaseService;
import ebooking.core.menu.Menu;
import ebooking.core.menu.MenuItem;
import ebooking.core.menu.MenuItemAuthorization;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * <p/>
 * User: rro
 * Date: 14.05.2005
 * Time: 10:17:37
 *
 * @author Roman R&auml;dle
 * @version $Id: MenuController.java,v 1.1 2005/10/16 18:27:06 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public class MenuController extends SimpleFormController {

    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    private String userRole = "system_admin";

    private BaseService baseService;

    public BaseService getBaseService() {
        return baseService;
    }

    public void setBaseService(BaseService baseService) {
        this.baseService = baseService;
    }

    protected Map referenceData(HttpServletRequest request) throws Exception {

        Map referenceData = new HashMap();

        //@todo implement user roles.
        Menu menu = baseService.getMenuByAuthorization(userRole);

        referenceData.put("menu", createMenu(menu));

        return referenceData;
    }

    public String createMenu(Menu menu) {

        StringBuffer js = new StringBuffer();

        js.append("    var myMenu =                                                         " + LINE_SEPARATOR);
        js.append("    [                                                                    " + LINE_SEPARATOR);

        for (Iterator i = menu.getMenuItems().iterator(); i.hasNext();) {
            MenuItem menuItem = (MenuItem) i.next();

            //if (menuItem.getUserRoles().contains(userRole)) {
                js.append("    " + createMenuItemEntry(menuItem, !i.hasNext())                                    );
            //}
        }

        js.append("    ];                                                                   " + LINE_SEPARATOR);
        js.append("cmDraw ('myMenuID', myMenu, 'hbr', cmThemeOffice, 'ThemeOffice');        " + LINE_SEPARATOR);

        return js.toString();
    }

    private String createMenuItemEntry(MenuItem menuItem, boolean lastItem) {

        StringBuffer itemEntry = new StringBuffer();

        if (!"_cmSplit".equals(menuItem.getKey())) {
            itemEntry.append("[");

            /*
             * Add image path to menu item entry.
             */
            if (menuItem.getImagePath() != null)
                itemEntry.append("'<img src=\"" + menuItem.getImagePath() + "\" />',");
            else
                itemEntry.append("null,");

            String itemName = getApplicationContext().getMessage(menuItem.getKey(), null, menuItem.getKey(), Locale.GERMAN);
            itemEntry.append("'" + itemName + "',");

            if (menuItem.getLink() != null) itemEntry.append("'" + menuItem.getLink() + "',");
            else itemEntry.append("null,");

            if (menuItem.getTarget() != null)
                itemEntry.append("'" + menuItem.getTarget() + "',");
            else
                itemEntry.append("null,");

            if (menuItem.getTooltip() != null) {
                String itemTooltip = getApplicationContext().getMessage(menuItem.getTooltip(), null, menuItem.getTooltip(), Locale.GERMAN);
                itemEntry.append("'" + itemTooltip + "'");
            }
            else
                itemEntry.append("null");

            Set menuItems = menuItem.getMenuItems();
            if (menuItems.size() != 0) itemEntry.append("," + LINE_SEPARATOR);
            for (Iterator i = menuItems.iterator(); i.hasNext();) {

                MenuItem childMenuItem = (MenuItem) i.next();

                System.out.println("MENU_ITEM: " + childMenuItem);

                System.out.println("CONTAINS: " + childMenuItem.isAuthorized(userRole));

                if (childMenuItem.isAuthorized(userRole)) {
                    itemEntry.append(createMenuItemEntry(childMenuItem, !i.hasNext()));
                }
            }

            itemEntry.append("]");
            if (!lastItem) {
                itemEntry.append(",");
            }
        }
        else {
            itemEntry.append("_cmSplit");
            if (!lastItem) {
                itemEntry.append(",");
            }
        }
        itemEntry.append(LINE_SEPARATOR);

        return itemEntry.toString();
    }
}
