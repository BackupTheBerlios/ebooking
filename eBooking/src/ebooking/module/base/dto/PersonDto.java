package ebooking.module.base.dto;

/**
 * Person data transfer object.
 * <p/>
 * User: rro
 * Date: 08.04.2005
 * Time: 14:27:07
 *
 * @author Roman R&auml;dle
 * @version $Id: PersonDto.java,v 1.1 2005/10/16 18:27:10 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public class PersonDto extends DataTransferObject {

    /**
     * The title of the person.
     */
    private String title;

    /**
     * The academic title of the person.
     */
    private String academicTitle;

    /**
     * The firstname of the person.
     */
    private String firstname;

    /**
     * The lastname of the person.
     */
    private String lastname;

    /**
     * Returns the title of the person.
     *
     * @return Title of the person.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the person.
     *
     * @param title Title of the person.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns the academic title of the person.
     *
     * @return Academic title of the person.
     */
    public String getAcademicTitle() {
        return academicTitle;
    }

    /**
     * Sets the academic title of the person.
     *
     * @param academicTitle Academic title of the person.
     */
    public void setAcademicTitle(String academicTitle) {
        this.academicTitle = academicTitle;
    }

    /**
     * Returns the firstname of the person.
     *
     * @return The firstname of the person.
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Sets the firstname of the person.
     *
     * @param firstname Firstname of the person.
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Returns the lastname of the person.
     *
     * @return The lastname of the person.
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Sets the lastname of the person.
     *
     * @param lastname The lastname of the person.
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}