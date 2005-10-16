package ebooking.module.base.dto;

/**
 * <p/>
 * User: rro
 * Date: 13.05.2005
 * Time: 23:56:26
 *
 * @author Roman R&auml;dle
 * @version $Id: CountryDto.java,v 1.1 2005/10/16 18:27:10 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public class CountryDto extends DataTransferObject {

    private String key;
    private String name;
    private String systemLocaleLanguage;
    private String systemLocaleKey;

    public CountryDto(Long persistentId, String key, String name, String systemLocaleLanguage, String systemLocaleKey) {
        setPersistentId(persistentId);
        this.key = key;
        this.name = name;
        this.systemLocaleLanguage = systemLocaleLanguage;
        this.systemLocaleKey = systemLocaleKey;
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

    public String getSystemLocaleLanguage() {
        return systemLocaleLanguage;
    }

    public void setSystemLocaleLanguage(String systemLocaleLanguage) {
        this.systemLocaleLanguage = systemLocaleLanguage;
    }

    public String getSystemLocaleKey() {
        return systemLocaleKey;
    }

    public void setSystemLocaleKey(String systemLocaleKey) {
        this.systemLocaleKey = systemLocaleKey;
    }
}
