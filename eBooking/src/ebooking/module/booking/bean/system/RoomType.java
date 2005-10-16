package ebooking.module.booking.bean.system;

import ebooking.module.base.bean.system.SystemLocale;

import java.util.Set;

/**
 * <p/>
 * User: rro
 * Date: 27.05.2005
 * Time: 12:21:17
 *
 * @author Roman R&auml;dle
 * @version $Id: RoomType.java,v 1.1 2005/10/16 18:27:15 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public class RoomType {

    private Long id;
    private String key;
    private Set rooms;
    private SystemLocale systemLocale;

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

    public Set getRooms() {
        return rooms;
    }

    public void setRooms(Set rooms) {
        this.rooms = rooms;
    }

    public SystemLocale getSystemLocale() {
        return systemLocale;
    }

    public void setSystemLocale(SystemLocale systemLocale) {
        this.systemLocale = systemLocale;
    }
}
