package ebooking.module.base.controller;

import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ebooking.module.base.service.BaseService;
import ebooking.module.base.controller.command.system.SystemLocaleCommand;

import javax.servlet.http.HttpServletRequest;

/**
 * <p/>
 * User: rro
 * Date: 15.05.2005
 * Time: 15:58:11
 *
 * @author Roman R&auml;dle
 * @version $Id: ManageSystemLocaleController.java,v 1.1 2005/10/16 18:27:06 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public class ManageSystemLocaleController extends SimpleFormController {

    private BaseService baseService;

    public BaseService getBaseService() {
        return baseService;
    }

    public void setBaseService(BaseService baseService) {
        this.baseService = baseService;
    }

    protected Object formBackingObject(HttpServletRequest request) throws Exception {

        String key = request.getParameter("key");

        SystemLocaleCommand systemLocaleCmd = null;
        if (key != null) {
            systemLocaleCmd = baseService.getSystemLocaleCommandBySystemLocaleKey(key);
        }

        if (systemLocaleCmd != null) {
            return systemLocaleCmd;
        }

        return new SystemLocaleCommand();
    }

    protected ModelAndView onSubmit(Object o) throws Exception {

        SystemLocaleCommand systemLocaleCmd = (SystemLocaleCommand) o;

        baseService.saveOrUpdateSystemLocale(systemLocaleCmd);

        return new ModelAndView(new RedirectView("list_system_locale.jspa"));
    }
}
