package ebooking.module.base.bean.system;

import ebooking.core.hibernate.sort.NameComparable;
import ebooking.core.hibernate.sort.NameComparable;

/**
 * Academic title bean.
 * <p/>
 * User: rro
 * Date: 08.04.2005
 * Time: 14:27:07
 *
 * @author Roman R&auml;dle
 * @version $Id: AcademicTitle.java,v 1.1 2005/10/16 18:27:03 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public class AcademicTitle implements NameComparable {

    /**
     * The id identifies the academic title of a person.
     */
    private Long id;

    private String key;

    /**
     * The academic title of a person, e.g. Prof. Dr.
     */
    private String name;

    private SystemLocale systemLocale;

    /**
     * Returns the id of the academic title of a person.
     *
     * @return Academic title id.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id of the academic title of a person.
     *
     * @param id Academic title id.
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
     * Returns the academic title of a person.
     *
     * @return Academic title of a person.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the academic title of a person.
     *
     * @param name Academic title of a person.
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
}
