package ebooking.module.base.dto;

/**
 * The customer data transfer object.
 * <p/>
 * User: rro
 * Date: 12.04.2005
 * Time: 09:06:59
 *
 * @author Roman R&auml;dle
 * @version $Id: CustomerDto.java,v 1.1 2005/10/16 18:27:10 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public class CustomerDto extends DataTransferObject {

    private String firstname;
    private String lastname;
    private String street;
    private String zipCode;
    private String city;

    /**
     * Initialization of cutomer data transfer object.
     *
     * @param persistentId The database persistent id.
     * @param firstname The firstname of the customer.
     * @param lastname The lastname of the customer.
     * @param street The street of the customer's address.
     * @param zipCode The zipCode of the customer's address.
     * @param city The city of the customer's address.
     */
    public CustomerDto(Long persistentId, String firstname, String lastname, String street, String zipCode, String city) {
        setPersistentId(persistentId);
        this.firstname = firstname;
        this.lastname = lastname;
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
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
}