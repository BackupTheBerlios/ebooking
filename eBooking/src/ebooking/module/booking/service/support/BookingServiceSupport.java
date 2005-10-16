package ebooking.module.booking.service.support;

import ebooking.module.booking.service.BookingService;
import ebooking.module.booking.dao.BookingDao;
import ebooking.module.booking.bean.Booking;
import ebooking.module.base.filter.FilterInterface;

import java.util.List;

/**
 * <p/>
 * User: rro
 * Date: 20.05.2005
 * Time: 00:45:52
 *
 * @author Roman R&auml;dle
 * @version $Id: BookingServiceSupport.java,v 1.1 2005/10/16 18:27:17 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public class BookingServiceSupport implements BookingService {

    private BookingDao bookingDao;

    public void setBookingDao(BookingDao bookingDao) {
        this.bookingDao = bookingDao;
    }

    public BookingDao getBookingDao() {
        return bookingDao;
    }

    public List getBookingDtoList(FilterInterface filter) {
        StringBuffer condition = new StringBuffer();
        condition.append("select new ebooking.module.booking.dto.BookingDto(booking.id, person.firstname, person.lastname, booking.bookingItems) from ");
        condition.append(Booking.class.getName() + " as booking join booking.person as person");

        condition.append(filter.getCondition());

        System.out.println("condi: " + condition);

        return bookingDao.find(condition.toString());
    }
}
