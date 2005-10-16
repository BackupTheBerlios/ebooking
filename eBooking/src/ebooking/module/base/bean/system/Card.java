package ebooking.module.base.bean.system;

/**
 * Card.
 * <p/>
 * User: rro
 * Date: 21.06.2005
 * Time: 00:19:56
 *
 * @author Roman R&auml;dle
 * @version $Id: Card.java,v 1.1 2005/10/16 18:27:03 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public class Card {

    /**
     * The persistent id.
     */
    private Long id;

    /**
     * The i18n key of the card.
     */
    private String key;

    /**
     * The link of the card.
     * Maybe a link like "_target1" that will be used by the
     * AbstractWizardFormController.
     */
    private String link;

    /**
     * The empty constructor.
     */
    public Card() {

    }

    /**
     * Create a new card with the i18n card key and the link
     * where this card points to.
     *
     * @param key The i18n key of the card.
     * @param link The link where the card points to.
     */
    public Card(String key, String link) {
        this.key = key;
        this.link = link;
    }

    /**
     * Returns the i18n key of the card.
     *
     * @return The i18n key.
     */
    public String getKey() {
        return key;
    }

    /**
     * Sets the i18n key of the card.
     *
     * @param key The i18n key.
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Returns the link where the card points to.
     *
     * @return The link where the card points to.
     */
    public String getLink() {
        return link;
    }

    /**
     * Sets the link where the card should point to.
     *
     * @param link The link where the card should point to.
     */
    public void setLink(String link) {
        this.link = link;
    }
}
