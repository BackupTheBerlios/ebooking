package ebooking.module.booking.form.command;

/**
 * RoomDescrCommand.
 * <p/>
 * User: rro
 * Date: 23.06.2005
 * Time: 23:17:24
 *
 * @author Roman R&auml;dle
 * @version $Id: RoomDescrCommand.java,v 1.1 2005/10/16 18:27:16 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public class RoomDescrCommand {

    private Long persistentId;

    private String key;
    private String description;

    private String systemLocaleKey;

    public RoomDescrCommand(String description, String systemLocaleKey) {
        this.description = description;
        this.systemLocaleKey = systemLocaleKey;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSystemLocaleKey() {
        return systemLocaleKey;
    }

    public void setSystemLocaleKey(String systemLocaleKey) {
        this.systemLocaleKey = systemLocaleKey;
    }
}