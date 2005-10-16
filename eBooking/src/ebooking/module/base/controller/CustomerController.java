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
import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 * The <code>CustomerController</code> serves some useful methods like listCustomersFrom,...
 * <p/>
 * User: rro
 * Date: 14.04.2005
 * Time: 22:46:59
 *
 * @author Roman R&auml;dle
 * @version $Id: CustomerController.java,v 1.1 2005/10/16 18:27:05 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public class CustomerController extends MultiActionController {

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

    public ModelAndView listCustomersForm(HttpServletRequest request, HttpServletResponse response) {
        /*
         * Set list_customers.jsp as the redirect page.
         */
        this.getServletContext().setAttribute("redirectPage", "list_customer.jspa");

        Map model = new HashMap();

        MultiFilter filter = new MultiFilter();

        if (request.getParameter("firstname") != null) {
            filter.addPartCondition("person.firstname", request.getParameter("firstname"));
        }
        if (request.getParameter("lastname") != null) {
            filter.addPartCondition("person.lastname", request.getParameter("lastname"));
        }
        if (request.getParameter("street") != null) {
            filter.addPartCondition("address.street", request.getParameter("street"));
        }
        if (request.getParameter("zipCode") != null) {
            filter.addPartCondition("address.zipCode", request.getParameter("zipCode"));
        }
        if (request.getParameter("city") != null) {
            filter.addPartCondition("address.city", request.getParameter("city"));
        }

        String pagesize = "10";
        if (request.getParameter("pagesize") != null) {
            pagesize = request.getParameter("pagesize");
        }

        List customerDtoList = baseService.getCustomerDtoList(filter);

        model.put("customerDtoList", customerDtoList);
        model.put("pagesize", pagesize);

        /*
         * Get a plain string map -> used to backing the filter inputs.
         */
        model.putAll(MapUtils.getPlainStringMap(request.getParameterMap()));

        return new ModelAndView("customer_list", model);
    }

    public ModelAndView deleteCustomerForm(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");

        Long deleteId = new Long(id);

        baseService.deleteCustomerByPersonId(deleteId);

        return new ModelAndView(new RedirectView("list_customer.jspa"));
    }
}
