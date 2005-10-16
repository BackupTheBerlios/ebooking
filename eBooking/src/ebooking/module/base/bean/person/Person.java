package ebooking.module.base.bean.person;

import ebooking.module.base.bean.address.Address;

import java.util.Set;

/**
 * Person bean.
 * <p/>
 * User: rro
 * Date: 08.04.2005
 * Time: 14:27:07
 *
 * @author Roman R&auml;dle
 * @version $Id: Person.java,v 1.1 2005/10/16 18:27:03 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public class Person {

    /**
     * The id identifies the person.
     */
    private Long Id;

    /**
     * The title id of the person.
     */
    private String titleKey;

    /**
     * The academic title id of the person.
     */
    private String academicTitleKey;

    /**
     * The firstname of the person.
     */
    private String firstname;

    /**
     * The lastname of the person.
     */
    private String lastname;

    /**
     * The identification number of the person.
     */
    private String identificationNumber;

    /**
     * All addresses that belongs to this person.
     */
    private Address address;

    private Set bookings;

    /**
     * Returns the id of the person.
     *
     * @return Person id.
     */
    public Long getId() {
        return Id;
    }

    /**
     * Sets the id of the person.
     *
     * @param id Person id.
     */
    public void setId(Long id) {
        Id = id;
    }

    /**
     * Returns the title key of the person.
     *
     * @return Title key of the person.
     */
    public String getTitleKey() {
        return titleKey;
    }

    /**
     * Sets the title key of the person.
     *
     * @param titleKey Title key of the person.
     */
    public void setTitleKey(String titleKey) {
        this.titleKey = titleKey;
    }

    /**
     * Returns the academic title key of the person.
     *
     * @return Academic title key of the person.
     */
    public String getAcademicTitleKey() {
        return academicTitleKey;
    }

    /**
     * Sets the academic title key of the person.
     *
     * @param academicTitleKey Academic title key of the person.
     */
    public void setAcademicTitleKey(String academicTitleKey) {
        this.academicTitleKey = academicTitleKey;
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

    /**
     * Returns the identification number of the person.
     *
     * @return The identification number of the person.
     */
    public String getIdentificationNumber() {
        return identificationNumber;
    }

    /**
     * Sets the identification number of the person.
     *
     * @param identificationNumber The identification number of the person.
     */
    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set getBookings() {
        return bookings;
    }

    public void setBookings(Set bookings) {
        this.bookings = bookings;
    }
}
