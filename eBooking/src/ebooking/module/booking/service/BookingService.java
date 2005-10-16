package ebooking.module.booking.service;

import ebooking.module.base.filter.FilterInterface;
import ebooking.module.booking.dao.BookingDao;

import java.util.List;

/**
 * <p/>
 * User: rro
 * Date: 20.05.2005
 * Time: 00:45:43
 *
 * @author Roman R&auml;dle
 * @version $Id: BookingService.java,v 1.1 2005/10/16 18:27:16 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public interface BookingService {
    public void setBookingDao(BookingDao bookingDao);
    public BookingDao getBookingDao();

    public List getBookingDtoList(FilterInterface filter);
}
