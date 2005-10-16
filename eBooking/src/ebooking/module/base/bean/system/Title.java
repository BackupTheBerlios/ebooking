package ebooking.module.base.bean.system;

import ebooking.core.hibernate.sort.NameComparable;
import ebooking.core.hibernate.sort.NameComparable;

/**
 * Title bean.
 * <p/>
 * User: rro
 * Date: 08.04.2005
 * Time: 14:27:07
 *
 * @author Roman R&auml;dle
 * @version $Id: Title.java,v 1.1 2005/10/16 18:27:03 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public class Title implements NameComparable {

    /**
     * The id identifies the title of a person.
     */
    private Long id;

    private String key;

    /**
     * The title of a person, e.g. Mr.
     */
    private String name;

    private SystemLocale systemLocale;

    /**
     * Returns the id of the title of a person.
     *
     * @return Title id.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id of the title of a person.
     *
     * @param id Title id.
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
     * Returns the title of a person.
     *
     * @return Title of a person.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the title of a person.
     *
     * @param name Title of a person.
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
