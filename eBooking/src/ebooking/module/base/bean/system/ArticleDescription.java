package ebooking.module.base.bean.system;

/**
 * <p/>
 * User: rro
 * Date: 28.05.2005
 * Time: 13:45:00
 *
 * @author Roman R&auml;dle
 * @version $Id: ArticleDescription.java,v 1.1 2005/10/16 18:27:03 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public class ArticleDescription {

    private Long id;
    private Article article;
    private String description;
    private SystemLocale systemLocale;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SystemLocale getSystemLocale() {
        return systemLocale;
    }

    public void setSystemLocale(SystemLocale systemLocale) {
        this.systemLocale = systemLocale;
    }
}
