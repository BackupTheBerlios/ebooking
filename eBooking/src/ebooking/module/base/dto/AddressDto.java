package ebooking.module.base.dto;

/**
 * Address data transfer object.
 * <p/>
 * User: rro
 * Date: 08.04.2005
 * Time: 14:27:07
 *
 * @author Roman R&auml;dle
 * @version $Id: AddressDto.java,v 1.1 2005/10/16 18:27:10 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public class AddressDto extends DataTransferObject {

    /**
     * Street of an address, including street number.
     */
    private String street;

    /**
     * Zip code of an address.
     */
    private String zipCode;

    /**
     * City of an address.
     */
    private String city;

    /**
     * County of an address.
     */
    private String county;

    /**
     * Country of an address.
     */
    private String country;

    /**
     * State of an address.
     */
    private String state;

    /**
     * Postal name of a company, e.g. Zollern Seal Technology Herbertingen
     */
    private String postalName;

    /**
     * Department of a company, e.g. Goods receiving department.
     */
    private String department;

    /**
     * First telephone number of a person a company.
     */
    private String phone1;

    /**
     * Second telephone number of a person or a company.
     */
    private String phone2;

    /**
     * Telefax number of a person or a company.
     */
    private String telefax;

    /**
     * Mobile number of a person or a company assistant.
     */
    private String mobilePhone;

    /**
     * E-Mail address of a person or a company assistant.
     */
    private String email;

    /**
     * Internet address (www) of a person or a company.
     */
    private String www;

    /**
     * Returns the street of the address.
     *
     * @return The street of the address.
     */
    public String getStreet() {
        return street;
    }

    /**
     * Sets the street of the address.
     *
     * @param street The street of the address.
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Returns the zip code of the address.
     *
     * @return The zip code of the address.
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Sets the zip code of the address.
     *
     * @param zipCode The zip code of the address.
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * Returns the city of the address.
     *
     * @return The city of the address.
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city of the address.
     *
     * @param city The city of the address.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Returns the county of the address.
     *
     * @return The county of the address.
     */
    public String getCounty() {
        return county;
    }

    /**
     * Sets the county of the address.
     *
     * @param county The county of the address.
     */
    public void setCounty(String county) {
        this.county = county;
    }

    /**
     * Returns the country of the address.
     *
     * @return The country of the address.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the country of the address.
     *
     * @param country The country of the address.
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Returns the state of the address.
     *
     * @return The state of the address.
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the state of the address.
     *
     * @param state The state of the address.
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Returns the postal name of the address.
     *
     * @return The postal name of the address.
     */
    public String getPostalName() {
        return postalName;
    }

    /**
     * Sets the postal name of the address.
     *
     * @param postalName The postal name of the address.
     */
    public void setPostalName(String postalName) {
        this.postalName = postalName;
    }

    /**
     * Returns the department of the company.
     *
     * @return The department of the company.
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Sets the department of the company.
     *
     * @param department The department of the company.
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * Returns the first phone number of the person or the company.
     *
     * @return The first phone number of the person or the company.
     */
    public String getPhone1() {
        return phone1;
    }

    /**
     * Sets the first phone number of the person or the company.
     *
     * @param phone1 The first phone number of the person or the company.
     */
    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    /**
     * Returns the second phone number of the person or the company.
     *
     * @return The second phone number of the person or the company.
     */
    public String getPhone2() {
        return phone2;
    }

    /**
     * Sets the second phone number of the person or the company.
     *
     * @param phone2 The second phone number of the person or the company.
     */
    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    /**
     * Returns the telefax number of the person or the company.
     *
     * @return The telefax number of the person or the company.
     */
    public String getTelefax() {
        return telefax;
    }

    /**
     * Sets the telefax number of the person or the company.
     *
     * @param telefax The telefax number of the person or the company.
     */
    public void setTelefax(String telefax) {
        this.telefax = telefax;
    }

    /**
     * Returns the mobile phone number of the person or the company.
     *
     * @return The mobile phone number of the person or the company.
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     * Sets the mobile phone number of the person or the company.
     *
     * @param mobilePhone The second phone number of the person or the company.
     */
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    /**
     * Returns the email address of the person or the company.
     *
     * @return The email address of the person or the company.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the person or the company.
     *
     * @param email The email address of the person or the company.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the internet address (www) of the person or the company.
     *
     * @return The internet address (www) of the person or the company.
     */
    public String getWww() {
        return www;
    }

    /**
     * Sets the internet address (www) of the person or the company.
     *
     * @param www The internet address (www) of the person or the company.
     */
    public void setWww(String www) {
        this.www = www;
    }
}
