package ebooking.module.base.event;

import org.springframework.context.ApplicationEvent;

import java.util.Date;

import ebooking.module.base.form.command.LoginCommand;

/**
 * LoginListener.
 * <p/>
 * User: rro
 * Date: 17.06.2005
 * Time: 18:50:29
 *
 * @author Roman R&auml;dle
 * @version $Id: LoginListener.java,v 1.1 2005/10/16 18:27:11 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public class LoginListener extends AbstractApplicationListener {

    public void onApplicationEvent(ApplicationEvent event) {
        if (event.getSource() instanceof LoginCommand) {
            LoginCommand loginCommand = (LoginCommand) event.getSource();
            Date date = new Date();

            /*
            SystemEventType systemEventType = getBaseService().getSystemEventType("event_basebp.userlogin");
            if (systemEventType != null) {
                SystemEvent systemEvent = new SystemEvent();
                systemEvent.setKey("event_basebp.userlogin");
                systemEvent.setDate(date);
                systemEvent.setDescr("Log in User: " + loginCommand.getLoginId());

                systemEvent.setUser(getBaseService().getUserByLoginId(loginCommand.getLoginId()));
                systemEvent.setSystemEventType(systemEventType);
                systemEventType.getSystemEvent().add(systemEvent);

                getBaseService().save(systemEventType);
            }
            */

            LOG.info("User logged in: " + loginCommand.getLoginId());
        }
    }
}

