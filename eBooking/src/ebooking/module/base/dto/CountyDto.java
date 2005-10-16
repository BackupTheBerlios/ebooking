package ebooking.module.base.dto;

/**
 * <p/>
 * User: rro
 * Date: 14.05.2005
 * Time: 00:46:19
 *
 * @author Roman R&auml;dle
 * @version $Id: CountyDto.java,v 1.1 2005/10/16 18:27:10 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public class CountyDto extends DataTransferObject {

    private String key;
    private String name;
    private String countryName;
    private String systemLocaleLanguage;

    public CountyDto(Long persistentId, String key, String name, String countryName, String systemLocaleLanguage) {
        this.setPersistentId(persistentId);
        this.key = key;
        this.name = name;
        this.countryName = countryName;
        this.systemLocaleLanguage = systemLocaleLanguage;
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

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getSystemLocaleLanguage() {
        return systemLocaleLanguage;
    }

    public void setSystemLocaleLanguage(String systemLocaleLanguage) {
        this.systemLocaleLanguage = systemLocaleLanguage;
    }
}
