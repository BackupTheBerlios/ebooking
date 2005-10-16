package ebooking.module.base.controller.command.system;

/**
 * <p/>
 * User: rro
 * Date: 18.05.2005
 * Time: 22:30:26
 *
 * @author Roman R&auml;dle
 * @version $Id: TitleCommand.java,v 1.1 2005/10/16 18:27:07 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public class TitleCommand {

    private Long persistentId;

    private String key;

    private String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSystemLocaleKey() {
        return systemLocaleKey;
    }

    public void setSystemLocaleKey(String systemLocaleKey) {
        this.systemLocaleKey = systemLocaleKey;
    }
}
