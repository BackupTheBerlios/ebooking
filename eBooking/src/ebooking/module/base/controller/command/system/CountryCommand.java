package ebooking.module.base.controller.command.system;

/**
 * Country command object.
 * <p/>
 * User: rro
 * Date: 13.04.2005
 * Time: 08:52:34
 *
 * @author Roman R&auml;dle
 * @version $Id: CountryCommand.java,v 1.1 2005/10/16 18:27:07 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public class CountryCommand {

    private Long persistentId;

    private String key;

    /**
     * The name of the country.
     */
    private String name;

    private String systemLocaleKey;

    public Long getPersistentId() {
        return persistentId;
    }

    public void setPersistentId(Long persistentId) {
        this.persistentId = persistentId;
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
     * @return The country name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the country.
     *
     * @param name The country name.
     */
    public void setName(String name) {
        this.name = name;
    }

    public String getSystemLocaleKey() {
        return systemLocaleKey;
    }

    public void setSystemLocaleKey(String systemLocaleKey) {
        this.systemLocaleKey = systemLocaleKey;
    }
}
