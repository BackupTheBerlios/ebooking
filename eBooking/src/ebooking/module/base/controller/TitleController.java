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
 * @version $Id: TitleController.java,v 1.1 2005/10/16 18:27:07 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public class TitleController extends MultiActionController {

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

    public ModelAndView listTitlesForm(HttpServletRequest request, HttpServletResponse response) {
        /*
         * Set list_customers.jsp as the redirect page.
         */
        this.getServletContext().setAttribute("redirectPage", "list_title.jspa");

        Map model = new HashMap();

        MultiFilter filter = new MultiFilter();

        if (request.getParameter("id") != null) {
            filter.addPartCondition("title.id", request.getParameter("id"));
        }
        if (request.getParameter("key") != null) {
            filter.addPartCondition("title.key", request.getParameter("key"));
        }
        if (request.getParameter("name") != null) {
            filter.addPartCondition("title.name", request.getParameter("name"));
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

        List titleDtoList = baseService.getTitleDtoList(filter);

        model.put("titleDtoList", titleDtoList);
        model.put("pagesize", pagesize);

        /*
         * Get a plain string map -> used to backing the filter inputs.
         */
        model.putAll(MapUtils.getPlainStringMap(request.getParameterMap()));

        return new ModelAndView("title_list", model);
    }

    public ModelAndView deleteTitleForm(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");

        Long deleteId = new Long(id);

        baseService.deleteTitleByTitleId(deleteId);

        return new ModelAndView(new RedirectView("list_title.jspa"));
    }
}
