package ebooking.module.base.event;

import org.springframework.context.ApplicationListener;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import ebooking.module.base.service.BaseService;

/**
 * AbstractApplicationListener.
 * <p/>
 * User: rro
 * Date: 17.06.2005
 * Time: 18:52:32
 *
 * @author Roman R&auml;dle
 * @version $Id: AbstractApplicationListener.java,v 1.1 2005/10/16 18:27:10 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public abstract class AbstractApplicationListener implements ApplicationListener {

    protected final Log LOG = LogFactory.getLog(this.getClass());

    public final static int DEBUG = 0;
    public final static int INFO = 1;
    public final static int WARN = 2;
    public final static int ERROR = 3;
    public final static int FATAL = 4;

    private MailSender mailSender;
    private BaseService baseService;

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public BaseService getBaseService() {
        return baseService;
    }

    public void setBaseService(BaseService baseService) {
        this.baseService = baseService;
    }

    protected void sendMail(String from, String to, String cc, String subject, String content) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(from);
        msg.setTo(to);
        msg.setCc(cc);
        msg.setSubject(subject);
        msg.setText(content);
        mailSender.send(msg);
    }

    protected void logPersistent(int level, String message) {
        // todo: implement persistent logging
    }
}

