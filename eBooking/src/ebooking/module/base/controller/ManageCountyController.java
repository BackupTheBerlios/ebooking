package ebooking.module.base.controller;

import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ebooking.module.base.service.BaseService;
import ebooking.module.base.controller.command.system.CountyCommand;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.List;
import java.util.HashMap;

/**
 * <p/>
 * User: rro
 * Date: 15.05.2005
 * Time: 14:03:07
 *
 * @author Roman R&auml;dle
 * @version $Id: ManageCountyController.java,v 1.1 2005/10/16 18:27:05 raedler Exp $
 * @since DAPS INTRA
 */
public class ManageCountyController extends SimpleFormController {

    private BaseService baseService;

    public BaseService getBaseService() {
        return baseService;
    }

    public void setBaseService(BaseService baseService) {
        this.baseService = baseService;
    }

    protected Map referenceData(HttpServletRequest request) throws Exception {

        Map model = new HashMap();

        List allCountries = baseService.getAllCountries();

        model.put("allCountries", allCountries);

        return model;
    }

    protected Object formBackingObject(HttpServletRequest request) throws Exception {

        String idString = request.getParameter("id");

        CountyCommand countyCmd = null;
        if (idString != null) {
            Long id = Long.valueOf(idString);

            countyCmd = baseService.getCountyCommandByCountyId(id);
        }

        if (countyCmd != null) {
            return countyCmd;
        }

        return new CountyCommand();
    }

    protected ModelAndView onSubmit(Object o) throws Exception {
        CountyCommand countyCommand = (CountyCommand) o;

        baseService.saveOrUpdateCounty(countyCommand);

        return new ModelAndView(new RedirectView("list_county.jspa"));
    }
}
