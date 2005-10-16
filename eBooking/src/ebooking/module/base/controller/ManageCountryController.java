package ebooking.module.base.controller;

import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.validation.Errors;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import ebooking.module.base.service.BaseService;
import ebooking.module.base.controller.command.system.CountryCommand;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.List;
import java.util.HashMap;

/**
 * <p/>
 * User: Tom
 * Date: 14.05.2005
 * Time: 14:07:31
 *
 * @author Thomas R&auml;dle
 * @version $Id: ManageCountryController.java,v 1.1 2005/10/16 18:27:05 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public class ManageCountryController extends SimpleFormController {

    private static final Log LOG = LogFactory.getLog(ManageCountryController.class);

    private BaseService baseService = null;

    public BaseService getBaseService() {
        return baseService;
    }

    public void setBaseService(BaseService baseService) {
        this.baseService = baseService;
    }

    protected ModelAndView onSubmit(Object o) throws Exception {

        CountryCommand countryCmd = (CountryCommand) o;
        baseService.saveOrUpdateCountry(countryCmd);

        return new ModelAndView(new RedirectView("list_country.jspa"));
    }

    protected Object formBackingObject(HttpServletRequest request) throws Exception {

        String idString = request.getParameter("id");

        CountryCommand countryCmd = null;
        if (idString != null) {
            Long id = Long.valueOf(idString);

            countryCmd = baseService.getCountryCommandByCountryId(id);
        }

        if (countryCmd == null) return new CountryCommand();

        return countryCmd;
    }

    protected Map referenceData(HttpServletRequest httpServletRequest) throws Exception {

        Map model = new HashMap();

        List allSystemLocales = baseService.getAllSystemLocales();

        model.put("allSystemLocales", allSystemLocales);

        return model;
    }
}
