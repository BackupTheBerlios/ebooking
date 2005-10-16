package ebooking.module.booking.bean;

import ebooking.module.base.bean.person.Person;

import java.util.Set;

/**
 * <p/>
 * User: rro
 * Date: 19.05.2005
 * Time: 13:55:46
 *
 * @author Roman R&auml;dle
 * @version $Id: Booking.java,v 1.1 2005/10/16 18:27:15 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public class Booking {

    private Long id;
    private Person person;
    private Set bookingItems;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Set getBookingItems() {
        return bookingItems;
    }

    public void setBookingItems(Set bookingItems) {
        this.bookingItems = bookingItems;
    }
}
