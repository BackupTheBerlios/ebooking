
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.io.Serializable;

import ebooking.module.booking.bean.Booking;
import ebooking.module.booking.bean.BookingItem;
import ebooking.module.booking.bean.system.Room;
import ebooking.module.base.bean.system.Article;
import ebooking.module.base.bean.system.Country;
import ebooking.module.base.bean.system.SystemLocale;
import ebooking.module.base.bean.system.User;
import ebooking.module.base.service.BaseService;
import ebooking.module.base.service.support.BaseServiceSupport;
import ebooking.module.base.dao.BaseDao;
import ebooking.module.base.dto.CustomerDto;
import ebooking.module.base.controller.command.customer.CustomerCommand;
import ebooking.module.base.controller.command.system.*;
import ebooking.module.base.filter.FilterInterface;
import ebooking.core.util.Encrypter;
import ebooking.core.menu.Menu;
import ebooking.core.menu.MenuItem;
import junit.framework.TestCase;
import junit.framework.Assert;

/**
 * <p/>
 * User: rro
 * Date: 19.05.2005
 * Time: 09:06:50
 *
 * @author Roman R&auml;dle
 * @version $Id: TestPersistence.java,v 1.1 2005/10/16 18:27:02 raedler Exp $
 */
public class TestPersistence extends TestCase {

    private HibernateTemplate hibernateTemplate;

    protected void setUp() throws Exception {

        /**
         * Get the application context of this application.
         */
        ApplicationContext ac = new FileSystemXmlApplicationContext("WEB-INF/applicationContext.xml");

        /**
         * Get the hibernate template that is defined in the application context.
         */
        hibernateTemplate = (HibernateTemplate) ac.getBean("hibernateTemplate");
    }

    public void testGetUser() {

        /**
         * Get users with loginId = ADMIN.
         */
        List userList = hibernateTemplate.find("from " + User.class.getName() + " where loginId = ?", new Object[]{"ADMIN"});

        /**
         * This <code>List</code> should contain only contain one <code>User</code>.
         */
        Assert.assertTrue(userList.size() == 1);

        /**
         * The user.
         */
        User user = (User) userList.get(0);

        /**
         * The eBooking <code>Encrypter</code>.
         */
        Encrypter encrypter = new Encrypter();

        /**
         * The user password should match with the known password.
         */
        Assert.assertTrue(encrypter.matches(user.getPassword(), "x2kub2"));
    }

    public void testGetArticle() {

        /**
         * Get Articles with the key single_room and the ArticleDescription with locale key de.
         */
        List articleList = hibernateTemplate.find("select new ebooking.module.base.bean.system.Article(article.id, article.key, article.price, article.vatIncluded, singularUnit, pluralUnit, descr) from " + Article.class.getName() + " as article join article.singularUnits as singularUnit join article.pluralUnits as pluralUnit join article.descriptions as descr where article.key = ? and singularUnit.systemLocale.key = ? and pluralUnit.systemLocale.key = ? and descr.systemLocale.key = ?", new Object[]{"single_room", "de", "de", "de"});

        /**
         * This <code>List</code> should contain only contain one <code>Article</code> with one <code>ArticleDescription</code>.
         */
        Assert.assertTrue(articleList.size() == 1);

        /**
         * The article.
         */
        Article article = (Article) articleList.get(0);

        /**
         * The article should contain a singular unit.
         */
        Assert.assertNotNull(article.getSingularUnit());

        /**
         * The article should contain a plural unit.
         */
        Assert.assertNotNull(article.getPluralUnit());

        /**
         * The article should contain an article description.
         */
        Assert.assertNotNull(article.getDescription());

        System.out.println("DARSTELLUNG");
        System.out.println("Artikel: " + article.getDescription().getDescription());
        System.out.println("Preis: " + article.getPrice());
        System.out.println("Einheit (singular): " + article.getSingularUnit().getName());
        System.out.println("Einheit (plural): " + article.getPluralUnit().getName());
    }

    public void testGetAllArticles() {

        /**
         * Get Articles with the key single_room and the ArticleDescription with locale key de.
         */
        List articleList = hibernateTemplate.find("select new ebooking.module.base.bean.system.Article(article.id, article.key, article.price, article.vatIncluded, singularUnit, pluralUnit, descr) from " + Article.class.getName() + " as article join article.singularUnits as singularUnit join article.pluralUnits as pluralUnit join article.descriptions as descr where singularUnit.systemLocale.key = ? and pluralUnit.systemLocale.key = ? and descr.systemLocale.key = ?", new Object[]{"de", "de", "de"});

        for (int i = 0; i < articleList.size(); i++) {

            /**
             * Get the article at position i in the list.
             */
            Article article = (Article) articleList.get(i);

            /**
             * The article should contain a singular unit.
             */
            Assert.assertNotNull(article.getSingularUnit());

            /**
             * The article should contain a plural unit.
             */
            Assert.assertNotNull(article.getPluralUnit());

            /**
             * The article should contain an article description.
             */
            Assert.assertNotNull(article.getDescription());

            System.out.println("DARSTELLUNG " + i);
            System.out.println("Artikel: " + article.getDescription().getDescription());
            System.out.println("Preis: " + article.getPrice());
            System.out.println("Einheit (singular): " + article.getSingularUnit().getName());
            System.out.println("Einheit (plural): " + article.getPluralUnit().getName() + "\n");
        }
    }

    public void testMenu() {

        List menuList = hibernateTemplate.find("from " + Menu.class.getName() + " as menu where menu.key = ?", new Object[]{"system_admin"});

        Assert.assertTrue(menuList.size() == 1);

        Menu menu = (Menu) menuList.get(0);

        for (Iterator i = menu.getMenuItems().iterator(); i.hasNext(); ) {
            MenuItem menuItem = (MenuItem) i.next();

            System.out.println("PARENT_NAME: " + menuItem.getKey());
            System.out.println("PARENT: " + menuItem.getParent());

            for (Iterator j = menuItem.getMenuItems().iterator(); j.hasNext(); ) {
                MenuItem menuItem2 = (MenuItem) j.next();

                System.out.println("CHILD_NAME: " + menuItem2);
                System.out.println("CHILDS_PARENT: " + menuItem2.getParent());
            }
        }
    }
}
