package ebooking.module.base.form;

import org.springframework.web.servlet.mvc.AbstractWizardFormController;
import ebooking.module.base.service.BaseService;

/**
 * AbstractWizardForm.
 * <p/>
 * User: rro
 * Date: 20.06.2005
 * Time: 12:11:03
 *
 * @author Roman R&auml;dle
 * @version $Id: AbstractWizardForm.java,v 1.1 2005/10/16 18:27:11 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public abstract class AbstractWizardForm extends AbstractWizardFormController {

    private BaseService baseService;

    public BaseService getBaseService() {
        return baseService;
    }

    public void setBaseService(BaseService baseService) {
        this.baseService = baseService;
    }
}
