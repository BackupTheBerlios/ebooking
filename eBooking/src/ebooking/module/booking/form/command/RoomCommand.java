package ebooking.module.booking.form.command;

import java.util.Set;
import java.util.HashSet;

/**
 * RoomCommand.
 * <p/>
 * User: rro
 * Date: 23.06.2005
 * Time: 00:15:27
 *
 * @author Roman R&auml;dle
 * @version $Id: RoomCommand.java,v 1.1 2005/10/16 18:27:16 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public class RoomCommand {

    private Long persistentId;

    private String key;
    private int bedAmount;

    private Set descriptions = new HashSet();

    private String description;
    private String systemLocaleKey;

    public Long getPersistentId() {
        return persistentId;
    }

    public void setPersistentId(Long persistentId) {
        this.persistentId = persistentId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getBedAmount() {
        return bedAmount;
    }

    public void setBedAmount(int bedAmount) {
        this.bedAmount = bedAmount;
    }

    public Set getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(Set descriptions) {
        this.descriptions = descriptions;
    }

    public void addDescription(String description, String systemLocaleKey) {
        this.descriptions.add(new RoomDescrCommand(description, systemLocaleKey));
    }

    public String getDescription() {
        System.out.println("GET DESCRIPTION: " + description);
        return description;
    }

    public void setDescription(String description) {
        System.out.println("SET DESCRIPTION: " + description);
        this.description = description;
    }

    public String getSystemLocaleKey() {
        return systemLocaleKey;
    }

    public void setSystemLocaleKey(String systemLocaleKey) {
        this.systemLocaleKey = systemLocaleKey;
    }
}