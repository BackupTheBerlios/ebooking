package ebooking.module.base.controller.command.system;

/**
 * County command object.
 * <p/>
 * User: rro
 * Date: 13.04.2005
 * Time: 09:02:36
 *
 * @author Roman R&auml;dle
 * @version $Id: CountyCommand.java,v 1.1 2005/10/16 18:27:07 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public class CountyCommand {

    /**
     * The country id.
     */
    private Long persistentId;

    private String key;

    /**
     * The name of the county.
     */
    private String name;

    private Long countryId;

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
     * Returns the name of the county.
     *
     * @return The name of the county.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the county.
     *
     * @param name The name of the county.
     */
    public void setName(String name) {
        this.name = name;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }
}
