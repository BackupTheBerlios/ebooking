package ebooking.module.base.form;

import ebooking.module.base.service.BaseService;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.context.ApplicationEvent;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;

/**
 * AbstractForm.
 * <p/>
 * User: rro
 * Date: 17.06.2005
 * Time: 10:21:16
 *
 * @author Roman R&auml;dle
 * @version $Id: AbstractForm.java,v 1.1 2005/10/16 18:27:11 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public abstract class AbstractForm extends SimpleFormController {

    /**
     * A logger for this class and subclasses.
     */
    protected final Log LOG = LogFactory.getLog(getClass());

    /**
     * The <code>BaseService</code> object contains service methods to
     * store transient objects to the database.
     */
    private BaseService baseService;

    /**
     * Returns the base service.
     *
     * @return The <code>BaseService</code> object.
     */
    public BaseService getBaseService() {
        return baseService;
    }

    /**
     * Sets the base service.
     *
     * @param baseService The <code>BaseService</code> object.
     */
    public void setBaseService(BaseService baseService) {
        this.baseService = baseService;
    }

    /**
     * Fires a new ApplicationEvent with the given object as source.
     *
     * @param source The source of the event.
     */
    protected void fireApplicationEvent(Object source) {
        this.getApplicationContext().publishEvent(new ApplicationEvent(source) {
        });
    }
}
