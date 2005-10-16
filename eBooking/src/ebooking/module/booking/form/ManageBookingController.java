package ebooking.module.booking.form;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ebooking.module.base.form.AbstractWizardForm;
import ebooking.module.base.bean.system.Card;
import ebooking.module.booking.bean.Booking;
import ebooking.module.booking.form.command.BookingCommand;

import java.util.Map;
import java.util.List;
import java.util.LinkedList;
import java.util.HashMap;

/**
 * <p/>
 * User: rro
 * Date: 20.06.2005
 * Time: 12:09:14
 *
 * @author Roman R&auml;dle
 * @version $Id: ManageBookingController.java,v 1.1 2005/10/16 18:27:16 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public class ManageBookingController extends AbstractWizardForm {

    public ManageBookingController() {
        setCommandName("booking");
        setCommandClass(Booking.class);
        setPages(new String[]{
            "booking_manage_room",
            "booking_manage_type"
        });
    }

    protected Map referenceData(HttpServletRequest request, int page) throws Exception {
        Map model = super.referenceData(request, page);

        if (model == null) model = new HashMap();

        List cards = new LinkedList();
        cards.add(new Card("room", "_target0"));
        cards.add(new Card("type", "_target1"));

        model.put("cards", cards);
        model.put("controller", request.getRequestURI());

        return model;
    }

    protected Object formBackingObject(HttpServletRequest request) throws Exception {
        return new BookingCommand();
    }

    protected void onBindAndValidate(HttpServletRequest request, Object cmd, BindException errors, int page) throws Exception {
        super.onBindAndValidate(request, cmd, errors, page);
    }

    protected ModelAndView processFinish(HttpServletRequest request, HttpServletResponse response, Object cmd, BindException errors) throws Exception {
        return new ModelAndView("booking_list");
    }
}
