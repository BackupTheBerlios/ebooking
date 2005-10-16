package ebooking.module.base.bean.system;

import ebooking.core.hibernate.sort.NameComparable;
import ebooking.module.base.bean.system.SystemLocale;
import ebooking.core.hibernate.sort.NameComparable;

import java.util.Set;
import java.util.LinkedHashSet;

/**
 * Country bean.
 * <p/>
 * User: rro
 * Date: 08.04.2005
 * Time: 14:58:59
 *
 * @author Roman R&auml;dle
 * @version $Id: Country.java,v 1.1 2005/10/16 18:27:03 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public class Country implements NameComparable {
    /**
     * Country id identifies the name of the country.
     */
    private Long id;

    private String key;

    /**
     * The name of the country with the specific id.
     */
    private String name;

    private SystemLocale systemLocale;

    /**
     * The counties in this country.
     */
    private Set counties;

    /**
     * Returns the id of the country.
     *
     * @return Country id.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id of the country.
     *
     * @param id Country id.
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
     * Returns the name of the country.
     *
     * @return Name of the country.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the country.
     *
     * @param name Name of the country.
     */
    public void setName(String name) {
        this.name = name;
    }

    public SystemLocale getSystemLocale() {
        return systemLocale;
    }

    public void setSystemLocale(SystemLocale systemLocale) {
        this.systemLocale = systemLocale;
    }

    /**
     * Returns all counties of this country.
     *
     * @return All counties of this country.
     */
    public Set getCounties() {
        return counties;
    }

    /**
     * Sets all counties of this country.
     *
     * @param counties All counties of this country.
     */
    public void setCounties(Set counties) {
        this.counties = counties;
    }
}