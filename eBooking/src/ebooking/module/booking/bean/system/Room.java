package ebooking.module.booking.bean.system;

import java.util.Set;

/**
 * <p/>
 * User: rro
 * Date: 27.05.2005
 * Time: 12:08:16
 *
 * @author Roman R&auml;dle
 * @version $Id: Room.java,v 1.1 2005/10/16 18:27:15 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public class Room {

    private Long id;
    private String key;
    private String description;
    private Float price;
    private Set types;
    private Integer bedAmount;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Set getTypes() {
        return types;
    }

    public void setTypes(Set types) {
        this.types = types;
    }

    public Integer getBedAmount() {
        return bedAmount;
    }

    public void setBedAmount(Integer bedAmount) {
        this.bedAmount = bedAmount;
    }
}
