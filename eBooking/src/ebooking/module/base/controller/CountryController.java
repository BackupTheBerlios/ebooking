package ebooking.module.base.controller;

import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ebooking.module.base.service.BaseService;
import ebooking.module.base.filter.support.MultiFilter;
import ebooking.module.base.filter.support.MultiFilter;
import ebooking.util.MapUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

/**
 * <p/>
 * User: rro
 * Date: 13.05.2005
 * Time: 23:47:07
 *
 * @author Roman R&auml;dle
 * @version $Id: CountryController.java,v 1.1 2005/10/16 18:27:04 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public class CountryController extends MultiActionController {

    /**
     * The base service support.
     */
    private BaseService baseService;

    /**
     * Returns the base service support.
     *
     * @return Base service support.
     */
    public BaseService getBaseService() {
        return baseService;
    }

    /**
     * Sets the base service support.
     *
     * @param baseService Base service support.
     */
    public void setBaseService(BaseService baseService) {
        this.baseService = baseService;
    }

    public ModelAndView listCountriesForm(HttpServletRequest request, HttpServletResponse response) {
        /*
         * Set list_customers.jsp as the redirect page.
         */
        this.getServletContext().setAttribute("redirectPage", "list_country.jspa");

        Map model = new HashMap();

        MultiFilter filter = new MultiFilter();

        if (request.getParameter("id") != null) {
            filter.addPartCondition("country.id", request.getParameter("id"));
        }
        if (request.getParameter("key") != null) {
            filter.addPartCondition("country.key", request.getParameter("key"));
        }
        if (request.getParameter("name") != null) {
            filter.addPartCondition("country.name", request.getParameter("name"));
        }
        if (request.getParameter("systemLocaleLanguage") != null) {
            filter.addPartCondition("systemLocale.language", request.getParameter("systemLocaleLanguage"));
        }
        if (request.getParameter("systemLocaleKey") != null) {
            filter.addPartCondition("systemLocale.key", request.getParameter("systemLocaleKey"));
        }

        String pagesize = "10";
        if (request.getParameter("pagesize") != null) {
            pagesize = request.getParameter("pagesize");
        }

        List countryDtoList = baseService.getCountryDtoList(filter);

        model.put("countryDtoList", countryDtoList);
        model.put("pagesize", pagesize);

        /*
         * Get a plain string map -> used to backing the filter inputs.
         */
        model.putAll(MapUtils.getPlainStringMap(request.getParameterMap()));

        return new ModelAndView("country_list", model);
    }

    public ModelAndView deleteCountryForm(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");

        Long deleteId = new Long(id);

        baseService.deleteCountryByCountryId(deleteId);

        return new ModelAndView(new RedirectView("list_country.jspa"));
    }
}
