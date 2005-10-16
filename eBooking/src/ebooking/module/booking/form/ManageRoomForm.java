package ebooking.module.booking.form;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.validation.BindException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;

import ebooking.module.base.bean.system.Card;
import ebooking.module.base.form.AbstractWizardForm;
import ebooking.module.booking.form.command.RoomCommand;
import ebooking.module.booking.form.command.RoomDescrCommand;
import ebooking.util.EncoderUtils;
import ebooking.core.Constants;

/**
 * ManageRoomForm.
 * <p/>
 * User: rro
 * Date: 22.06.2005
 * Time: 23:27:32
 *
 * @author Roman R&auml;dle
 * @version $Id: ManageRoomForm.java,v 1.1 2005/10/16 18:27:16 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public class ManageRoomForm extends AbstractWizardForm {

    public ManageRoomForm() {
        this.setCommandName("room");
        this.setCommandClass(RoomCommand.class);
        this.setPages(new String[]{
            "room_manage_room",
            "room_manage_type"
        });
    }

    protected Object formBackingObject(HttpServletRequest httpServletRequest) throws Exception {
        RoomCommand roomCmd = new RoomCommand();

        return roomCmd;
    }

    /**
     * @see org.springframework.web.servlet.mvc.AbstractWizardFormController#referenceData(javax.servlet.http.HttpServletRequest, int)
     */
    protected Map referenceData(HttpServletRequest request, int page) throws Exception {
        Map model = super.referenceData(request, page);

        if (model == null) model = new HashMap();

        /*
         * @todo Load cards from database.
         */
        List cards = new LinkedList();
        cards.add(new Card("room", "_target0"));
        cards.add(new Card("type", "_target1"));

        System.out.println("EncoderUtils: " + EncoderUtils.encodeURL(request, "/base/add_room.jspa"));

        model.put(Constants.CARDS_NAME, cards);
        model.put(Constants.FORM_NAME, "room");
        model.put(Constants.MANAGE_HEADER, "room.header");

        return model;
    }

    protected void onBindAndValidate(HttpServletRequest request, Object cmd, BindException errors, int page) throws Exception {

        RoomCommand roomCmd = (RoomCommand) cmd;

        switch (page) {
            case 0:
                break;

            case 1:

                String action = request.getParameter("action");

                if ("delete".equals(action)) {
                    System.out.println("remove room description");

                    
                }
                else if ("edit".equals(action)) {
                    System.out.println("edit room description");
                }
                else {
                    String description = roomCmd.getDescription();
                    String systemLocaleKey = roomCmd.getSystemLocaleKey();

                    roomCmd.addDescription(description, systemLocaleKey);
                }

                break;

        }

    }

    protected ModelAndView processFinish(HttpServletRequest request, HttpServletResponse response, Object cmd, BindException errors) throws Exception {
        RoomCommand roomCmd = (RoomCommand) cmd;



        return new ModelAndView(new RedirectView("add_room.jspa"));
    }
}