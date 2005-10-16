package ebooking.module.booking.dao.support;

import ebooking.module.booking.dao.BookingDao;
import ebooking.module.booking.bean.Booking;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.BeansException;

import java.util.List;

/**
 * <p/>
 * User: rro
 * Date: 20.05.2005
 * Time: 00:36:04
 *
 * @author Roman R&auml;dle
 * @version $Id: BookingDaoSupport.java,v 1.1 2005/10/16 18:27:15 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public class BookingDaoSupport extends HibernateDaoSupport implements BookingDao, ApplicationContextAware {

    private ApplicationContext applicationContext;

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public void saveOrUpdate(Object entity) {
        getHibernateTemplate().saveOrUpdate(entity);
    }

    public List find(String query) {
        return getHibernateTemplate().find(query);
    }

    public Booking getBookingByBookingId(Long id) {
        return (Booking) getHibernateTemplate().get(Booking.class, id);
    }
}
