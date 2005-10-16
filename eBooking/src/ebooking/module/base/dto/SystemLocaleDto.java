package ebooking.module.base.dto;

/**
 * <p/>
 * User: rro
 * Date: 15.05.2005
 * Time: 15:10:14
 *
 * @author Roman R&auml;dle
 * @version $Id: SystemLocaleDto.java,v 1.1 2005/10/16 18:27:10 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public class SystemLocaleDto extends DataTransferObject {

    private String key;
    private String language;
    private String countryName;

    public SystemLocaleDto(Long persistentId, String key, String language, String countryName) {
        setPersistentId(persistentId);
        this.key = key;
        this.language = language;
        this.countryName = countryName;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
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
