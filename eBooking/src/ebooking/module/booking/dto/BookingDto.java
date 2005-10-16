package ebooking.module.booking.dto;

import ebooking.module.base.dto.DataTransferObject;

import java.util.Set;

/**
 * <p/>
 * User: rro
 * Date: 20.05.2005
 * Time: 00:48:22
 *
 * @author Roman R&auml;dle
 * @version $Id: BookingDto.java,v 1.1 2005/10/16 18:27:16 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public class BookingDto extends DataTransferObject {

    private String firstname;
    private String lastname;
    private Set bookingItems;

    public BookingDto(Long persistentId, String firstname, String lastname, Set bookingItems) {
        setPersistentId(persistentId);
        this.firstname = firstname;
        this.lastname = lastname;
        //this.bookingItems = bookingItems;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Set getBookingItems() {
        return bookingItems;
    }

    public void setBookingItems(Set bookingItems) {
        this.bookingItems = bookingItems;
    }
}
