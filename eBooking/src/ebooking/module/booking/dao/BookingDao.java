package ebooking.module.booking.dao;

import ebooking.module.booking.bean.Booking;

import java.util.List;

/**
 * <p/>
 * User: rro
 * Date: 20.05.2005
 * Time: 00:35:49
 *
 * @author Roman R&auml;dle
 * @version $Id: BookingDao.java,v 1.1 2005/10/16 18:27:15 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public interface BookingDao {
    public void saveOrUpdate(Object entity);
    public List find(String query);

    public Booking getBookingByBookingId(Long id);
}
