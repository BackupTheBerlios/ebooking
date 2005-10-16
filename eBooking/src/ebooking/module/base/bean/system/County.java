package ebooking.module.base.bean.system;

import ebooking.core.hibernate.sort.NameComparable;
import ebooking.module.base.bean.system.Country;
import ebooking.core.hibernate.sort.NameComparable;

import java.util.Set;

/**
 * County bean.
 * <p/>
 * User: rro
 * Date: 08.04.2005
 * Time: 14:58:59
 *
 * @author Roman R&auml;dle
 * @version $Id: County.java,v 1.1 2005/10/16 18:27:03 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public class County implements NameComparable {
    /**
     * Country id identifies the name of the county.
     */
    private Long id;

    private String key;

    /**
     * The name of the county with the specific id.
     */
    private String name;

    private Country country;

    /**
     * Returns the id of the county.
     *
     * @return County id.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id of the county.
     *
     * @param id County id.
     */
    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Returns the name of the county.
     *
     * @return Name of the county.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the county.
     *
     * @param name Name of the county.
     */
    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
