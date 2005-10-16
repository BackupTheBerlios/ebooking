package ebooking.module.base.bean.system;

import java.util.Set;

/**
 * <p/>
 * User: rro
 * Date: 12.05.2005
 * Time: 23:26:50
 *
 * @author Roman R&auml;dle
 * @version $Id: SystemLocale.java,v 1.1 2005/10/16 18:27:03 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public class SystemLocale {
    private Long id;
    private String key;
    private String language;
    private String countryName;
    private Set titles;
    private Set academicTitles;
    private Set countries;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set getTitles() {
        return titles;
    }

    public void setTitles(Set titles) {
        this.titles = titles;
    }

    public Set getAcademicTitles() {
        return academicTitles;
    }

    public void setAcademicTitles(Set academicTitles) {
        this.academicTitles = academicTitles;
    }

    public Set getCountries() {
        return countries;
    }

    public void setCountries(Set countries) {
        this.countries = countries;
    }
}
