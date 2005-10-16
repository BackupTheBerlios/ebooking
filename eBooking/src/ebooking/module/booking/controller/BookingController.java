package ebooking.module.booking.controller;

import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ebooking.module.booking.service.BookingService;
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
 * Date: 20.05.2005
 * Time: 00:44:19
 *
 * @author Roman R&auml;dle
 * @version $Id: BookingController.java,v 1.1 2005/10/16 18:27:15 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public class BookingController extends MultiActionController {

    private BookingService bookingService;

    public BookingService getBookingService() {
        return bookingService;
    }

    public void setBookingService(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public ModelAndView listBookingsForm(HttpServletRequest request, HttpServletResponse response) {
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

        String pagesize = "10";
        if (request.getParameter("pagesize") != null) {
            pagesize = request.getParameter("pagesize");
        }

        List bookingDtoList = bookingService.getBookingDtoList(filter);

        model.put("bookingDtoList", bookingDtoList);
        model.put("pagesize", pagesize);

        /*
         * Get a plain string map -> used to backing the filter inputs.
         */
        model.putAll(MapUtils.getPlainStringMap(request.getParameterMap()));

        return new ModelAndView("booking_list", model);
    }

    /*
    public ModelAndView deleteBookingForm(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");

        Long deleteId = new Long(id);

        bookingService.deleteCustomerByPersonId(deleteId);

        return new ModelAndView(new RedirectView("list_customer.jspa"));
    }
    */
}
