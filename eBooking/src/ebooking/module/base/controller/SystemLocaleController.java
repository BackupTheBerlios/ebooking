package ebooking.module.base.controller;

import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ebooking.module.base.service.BaseService;
import ebooking.module.base.filter.support.MultiFilter;
import ebooking.module.base.bean.system.SystemLocale;
import ebooking.util.MapUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

/**
 * <p/>
 * User: rro
 * Date: 15.05.2005
 * Time: 15:02:13
 *
 * @author Roman R&auml;dle
 * @version $Id: SystemLocaleController.java,v 1.1 2005/10/16 18:27:06 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public class SystemLocaleController extends MultiActionController {

    private BaseService baseService;

    public BaseService getBaseService() {
        return baseService;
    }

    public void setBaseService(BaseService baseService) {
        this.baseService = baseService;
    }

    public ModelAndView listSystemLocalesForm(HttpServletRequest request, HttpServletResponse response) {

        /*
         * Set list_system_locale.jspa as the redirect page.
         */
        this.getServletContext().setAttribute("redirectPage", "list_system_locale.jspa");

        Map model = new HashMap();

        MultiFilter filter = new MultiFilter();

        if (request.getParameter("key") != null) {
            filter.addPartCondition("systemLocale.key", request.getParameter("key"));
        }
        if (request.getParameter("language") != null) {
            filter.addPartCondition("systemLocale.language", request.getParameter("language"));
        }
        if (request.getParameter("countryName") != null) {
            filter.addPartCondition("country.name", request.getParameter("countryName"));
        }

        String pagesize = "10";
        if (request.getParameter("pagesize") != null) {
            pagesize = request.getParameter("pagesize");
        }

        List systemLocaleDtoList = baseService.getSystemLocaleDtoList(filter);

        model.put("systemLocaleDtoList", systemLocaleDtoList);
        model.put("pagesize", pagesize);

        /*
         * Get a plain string map -> used to backing the filter inputs.
         */
        model.putAll(MapUtils.getPlainStringMap(request.getParameterMap()));

        return new ModelAndView("system_locale_list", model);
    }

    public ModelAndView deleteSystemLocaleForm(HttpServletRequest request, HttpServletResponse response) {
        String key = request.getParameter("key");

        baseService.deleteSystemLocaleBySystemLocaleKey(key);

        return new ModelAndView(new RedirectView("list_system_locale.jspa"));
    }
}
