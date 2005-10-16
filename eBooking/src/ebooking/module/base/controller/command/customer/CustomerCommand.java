package ebooking.module.base.controller.command.customer;

/**
 * The customer form command object.
 * <p/>
 * User: rro
 * Date: 12.04.2005
 * Time: 09:06:59
 *
 * @author Roman R&auml;dle
 * @version $Id: CustomerCommand.java,v 1.1 2005/10/16 18:27:07 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public class CustomerCommand {

    private Long persistentId;
    private String titleKey;
    private String academicTitleKey;
    private String firstname;
    private String lastname;
    private String identificationNumber;

    private Long persistentAddressId;
    private String street;
    private String zipCode;
    private String city;
    private String countyKey;
    private String countryKey;
    private String postalName;
    private String department;
    private String phone1;
    private String phone2;
    private String telefax;
    private String mobilePhone;
    private String email;
    private String www;

    public Long getPersistentId() {
        return persistentId;
    }

    public void setPersistentId(Long persistentId) {
        this.persistentId = persistentId;
    }

    public String getTitleKey() {
        return titleKey;
    }

    public void setTitleKey(String titleKey) {
        this.titleKey = titleKey;
    }

    public String getAcademicTitleKey() {
        return academicTitleKey;
    }

    public void setAcademicTitleKey(String academicTitleKey) {
        this.academicTitleKey = academicTitleKey;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public Long getPersistentAddressId() {
        return persistentAddressId;
    }

    public void setPersistentAddressId(Long persistentAddressId) {
        this.persistentAddressId = persistentAddressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountyKey() {
        return countyKey;
    }

    public void setCountyKey(String countyKey) {
        this.countyKey = countyKey;
    }

    public String getCountryKey() {
        return countryKey;
    }

    public void setCountryKey(String countryKey) {
        this.countryKey = countryKey;
    }

    public String getPostalName() {
        return postalName;
    }

    public void setPostalName(String postalName) {
        this.postalName = postalName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getTelefax() {
        return telefax;
    }

    public void setTelefax(String telefax) {
        this.telefax = telefax;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWww() {
        return www;
    }

    public void setWww(String www) {
        this.www = www;
    }
}
