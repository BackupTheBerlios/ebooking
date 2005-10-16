package ebooking.module.base.controller;

import ebooking.module.base.service.BaseService;
import ebooking.module.base.controller.command.system.TitleCommand;
import ebooking.module.base.controller.command.system.TitleCommand;
import ebooking.module.base.controller.command.system.AcademicTitleCommand;
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
 * @version $Id: ManageAcademicTitleController.java,v 1.1 2005/10/16 18:27:05 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public class ManageAcademicTitleController extends SimpleFormController {

    private BaseService baseService;

    public BaseService getBaseService() {
        return baseService;
    }

    public void setBaseService(BaseService baseService) {
        this.baseService = baseService;
    }

    protected ModelAndView onSubmit(Object o) throws Exception {
        AcademicTitleCommand academicTitleCmd = (AcademicTitleCommand) o;
        baseService.saveOrUpdateAcademicTitle(academicTitleCmd);

        return new ModelAndView(new RedirectView("list_academic_title.jspa"));
    }

    protected Object formBackingObject(HttpServletRequest request) throws Exception {

        String idString = request.getParameter("id");

        AcademicTitleCommand academicTitleCmd = null;
        if (idString != null) {
            Long id = Long.valueOf(idString);

            academicTitleCmd = baseService.getAcademicTitleCommandByAcademicTitleId(id);
        }

        if (academicTitleCmd == null) return new AcademicTitleCommand();

        return academicTitleCmd;
    }

    protected Map referenceData(HttpServletRequest httpServletRequest) throws Exception {

        Map model = new HashMap();

        List allSystemLocales = baseService.getAllSystemLocales();

        model.put("allSystemLocales", allSystemLocales);

        return model;
    }
}
