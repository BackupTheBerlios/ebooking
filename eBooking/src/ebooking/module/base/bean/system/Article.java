package ebooking.module.base.bean.system;

import java.util.Set;

/**
 * <p/>
 * User: rro
 * Date: 28.05.2005
 * Time: 13:44:51
 *
 * @author Roman R&auml;dle
 * @version $Id: Article.java,v 1.1 2005/10/16 18:27:03 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public class Article {

    private Long id;
    private String key;
    private Float price;
    private Boolean vatIncluded;
    private Unit singularUnit;
    private Set singularUnits;
    private Unit pluralUnit;
    private Set pluralUnits;
    private ArticleDescription description;
    private Set descriptions;

    public Article() {

    }

    public Article(Long id, String key, Float price, Boolean vatIncluded, Unit singularUnit, Unit pluralUnit, ArticleDescription description) {
        this.id = id;
        this.key = key;
        this.price = price;
        this.vatIncluded = vatIncluded;
        this.singularUnit = singularUnit;
        this.pluralUnit = pluralUnit;
        this.description = description;
    }

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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Boolean getVatIncluded() {
        return vatIncluded;
    }

    public void setVatIncluded(Boolean vatIncluded) {
        this.vatIncluded = vatIncluded;
    }

    public Unit getSingularUnit() {
        return singularUnit;
    }

    public void setSingularUnit(Unit singularUnit) {
        this.singularUnit = singularUnit;
    }

    public Set getSingularUnits() {
        return singularUnits;
    }

    public void setSingularUnits(Set singularUnits) {
        this.singularUnits = singularUnits;
    }

    public Unit getPluralUnit() {
        return pluralUnit;
    }

    public void setPluralUnit(Unit pluralUnit) {
        this.pluralUnit = pluralUnit;
    }

    public Set getPluralUnits() {
        return pluralUnits;
    }

    public void setPluralUnits(Set pluralUnits) {
        this.pluralUnits = pluralUnits;
    }

    public ArticleDescription getDescription() {
        return description;
    }

    public void setDescription(ArticleDescription description) {
        this.description = description;
    }

    public Set getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(Set descriptions) {
        this.descriptions = descriptions;
    }
}
