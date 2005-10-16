package ebooking.module.base.controller;

import ebooking.module.base.service.BaseService;
import ebooking.module.base.controller.command.system.TitleCommand;
import ebooking.module.base.controller.command.system.TitleCommand;
import ebooking.core.Constants;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

/**
 * <p/>
 * User: rro
 * Date: 24.04.2005
 * Time: 18:57:54
 *
 * @author Roman R&auml;dle
 * @version $Id: ManageTitleController.java,v 1.1 2005/10/16 18:27:06 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public class ManageTitleController extends SimpleFormController {

    private BaseService baseService;

    public BaseService getBaseService() {
        return baseService;
    }

    public void setBaseService(BaseService baseService) {
        this.baseService = baseService;
    }

    protected ModelAndView onSubmit(Object o) throws Exception {
        TitleCommand titleCmd = (TitleCommand) o;
        baseService.saveOrUpdateTitle(titleCmd);

        return new ModelAndView(new RedirectView("list_title.jspa"));
    }

    protected Object formBackingObject(HttpServletRequest request) throws Exception {

        String idString = request.getParameter("id");

        TitleCommand titleCmd = null;
        if (idString != null) {
            Long id = Long.valueOf(idString);

            titleCmd = baseService.getTitleCommandByTitleId(id);
        }

        if (titleCmd == null) return new TitleCommand();

        return titleCmd;
    }

    protected Map referenceData(HttpServletRequest httpServletRequest) throws Exception {

        Map model = new HashMap();

        List allSystemLocales = baseService.getAllSystemLocales();

        model.put(Constants.MANAGE_HEADER, "title.header");
        model.put("allSystemLocales", allSystemLocales);

        return model;
    }
}
