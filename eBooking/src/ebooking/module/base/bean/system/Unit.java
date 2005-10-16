package ebooking.module.base.bean.system;

import ebooking.core.hibernate.sort.NameComparable;

import java.util.Set;

/**
 * <p/>
 * User: rro
 * Date: 19.05.2005
 * Time: 19:34:52
 *
 * @author Roman R&auml;dle
 * @version $Id: Unit.java,v 1.1 2005/10/16 18:27:04 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public class Unit implements NameComparable {

    private Long id;
    private String key;
    private String name;
    private SystemLocale systemLocale;
    private Set bookingItems;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SystemLocale getSystemLocale() {
        return systemLocale;
    }

    public void setSystemLocale(SystemLocale systemLocale) {
        this.systemLocale = systemLocale;
    }

    public Set getBookingItems() {
        return bookingItems;
    }

    public void setBookingItems(Set bookingItems) {
        this.bookingItems = bookingItems;
    }
}
