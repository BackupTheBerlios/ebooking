package ebooking.module.base.controller.command.system;

/**
 * <p/>
 * User: rro
 * Date: 15.05.2005
 * Time: 15:00:47
 *
 * @author Roman R&auml;dle
 * @version $Id: SystemLocaleCommand.java,v 1.1 2005/10/16 18:27:07 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public class SystemLocaleCommand {

    private Long persistentId;
    private String localeKey;
    private String language;
    private String countryName;

    public Long getPersistentId() {
        return persistentId;
    }

    public void setPersistentId(Long persistentId) {
        this.persistentId = persistentId;
    }

    public String getLocaleKey() {
        return localeKey;
    }

    public void setLocaleKey(String localeKey) {
        this.localeKey = localeKey;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
