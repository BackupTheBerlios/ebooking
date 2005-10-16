
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;
import ebooking.module.base.controller.MenuController;
import ebooking.module.base.service.BaseService;
import ebooking.core.menu.Menu;

/**
 * TestController.
 * <p/>
 * User: rro
 * Date: 04.07.2005
 * Time: 15:35:09
 *
 * @author Roman R&auml;dle
 * @version $Id: TestController.java,v 1.1 2005/10/16 18:27:01 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public class TestController extends TestCase {

    private ApplicationContext baseServlet = null;

    private BaseService baseService = null;

    protected void setUp() throws Exception {

        /**
         * Get the application context of this application.
         */
        ApplicationContext ac = new FileSystemXmlApplicationContext("WEB-INF/applicationContext.xml");

        baseServlet = new FileSystemXmlApplicationContext("WEB-INF/base-servlet.xml");

        baseService = (BaseService) baseServlet.getBean("baseService");
    }

    public void testMenuController() {

        MenuController menuController = (MenuController) baseServlet.getBean("menuController");

        String js = menuController.createMenu(baseService.getMenuByAuthorization("system_admin"));

        System.out.println(js);
    }
}