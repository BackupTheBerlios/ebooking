package ebooking.module.base.controller;

import ebooking.module.base.service.BaseService;
import ebooking.module.base.controller.command.customer.CustomerCommand;
import ebooking.module.base.bean.system.Country;
import ebooking.module.base.bean.system.County;
import ebooking.module.base.bean.system.SystemLocale;
import ebooking.module.base.bean.system.Country;
import ebooking.module.base.bean.system.County;
import ebooking.core.hibernate.sort.NameComparator;
import ebooking.util.ListUtils;
import ebooking.core.Constants;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.validation.BindException;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * The <code>MangageCustomerController</code> manages the two actions insert and update customer.
 * <p/>
 * User: rro
 * Date: 10.04.2005
 * Time: 23:29:13
 *
 * @author Roman R&auml;dle
 * @version $Id: ManageCustomerController.java,v 1.1 2005/10/16 18:27:06 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public class ManageCustomerController extends SimpleFormController {

    /**
     * Logs all messages and errors that appears during the runtime.
     */
    private static final Log LOG = LogFactory.getLog(ManageCustomerController.class);

    /**
     * The base service support.
     */
    private BaseService baseService;

    private CustomerCommand customerCmd = null;
    private Set allCountries = null;

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

    /**
     * @see SimpleFormController#showForm(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.springframework.validation.BindException)
     */
    protected ModelAndView showForm(HttpServletRequest request, HttpServletResponse response,
                                    BindException errors) throws Exception {
        return super.showForm(request, response, errors);
    }

    /**
     * @see SimpleFormController#referenceData(javax.servlet.http.HttpServletRequest)
     */
    protected Map referenceData(HttpServletRequest request) throws Exception {
        /*
         * Get all reference datas that are used to show the formular page.
         */
        Map referenceData = new HashMap();

        Enumeration localeEnum = request.getLocales();

        SystemLocale systemLocale = null;
        Locale locale = null;
        String localeKey = null;
        while (systemLocale == null && localeEnum.hasMoreElements()) {
            locale = (Locale) localeEnum.nextElement();
            localeKey = locale.getLanguage();

            systemLocale = baseService.getSystemLocale(localeKey);
        }

        if (systemLocale == null) {
            systemLocale = baseService.getSystemLocale("de");
        }

        Set allTitles = systemLocale.getTitles();
        if (allTitles != null) referenceData.put("allTitles", allTitles);

        Set allAcademicTitles = systemLocale.getAcademicTitles();
        if (allAcademicTitles != null) referenceData.put("allAcademicTitles", allAcademicTitles);

        allCountries = systemLocale.getCountries();
        if (allCountries != null) referenceData.put("allCountries", allCountries);

        referenceData.put(Constants.MANAGE_HEADER, "customer.header");
        referenceData.put("htmlJS", getHtmlJSScript());

        return referenceData;
    }

    /**
     * @see SimpleFormController#onBindAndValidate(javax.servlet.http.HttpServletRequest, Object, org.springframework.validation.BindException)
     */
    protected void onBindAndValidate(HttpServletRequest request, Object command, BindException errors)
            throws Exception {

        /*
         * Bind all appeared errors to the customer command object.
         */
        errors.setNestedPath("customer");
        getValidator().validate(command, errors);
        errors.setNestedPath("");
    }

    /**
     * @see SimpleFormController#formBackingObject(javax.servlet.http.HttpServletRequest)
     */
    protected Object formBackingObject(HttpServletRequest request) throws Exception {
        /*
         * Get the customer with the given id.
         */
        String idString = request.getParameter("id");

        customerCmd = null;
        if (idString != null) {
            Long id = Long.valueOf(idString);

            customerCmd = baseService.getCustomerCommandByPersonId(id);
        }

        if (customerCmd != null) return customerCmd;

        return new CustomerCommand();
    }

    /**
     * @see SimpleFormController#onSubmit(Object, org.springframework.validation.BindException)
     */
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object o, BindException e) throws Exception {

        CustomerCommand customerCmd = (CustomerCommand) o;

        /*
         * Get the redirect page.
         */
        String redirectPage = (String) this.getServletContext().getAttribute("redirectPage");

        /*
         * If redirect page is not set use the default redirect page.
         */
        if (redirectPage == null) {
            redirectPage = "list_customer.jspa";
        }

        if (LOG.isDebugEnabled()) {
            LOG.debug("Redirect to page " + redirectPage);
            LOG.debug("Persistent customer [person] id: " + customerCmd.getPersistentId());
        }

        if (customerCmd != null) {
            baseService.saveOrUpdateCustomer(customerCmd);
        }

        return new ModelAndView(new RedirectView(redirectPage));
    }

    private String getHtmlJSScript() {
        StringBuffer htmlJS = new StringBuffer();
        htmlJS.append("    var Associate = new Array();                                                                                                                      \n");

        for (Iterator i = allCountries.iterator(); i.hasNext();) {
            Country country = (Country) i.next();
            String countryKey = country.getKey();

            Set counties = country.getCounties();

            htmlJS.append("    Associate['" + countryKey + "'] = new Array();                                                                                                 \n");

            for (Iterator j = counties.iterator(); j.hasNext();) {
                County county = (County) j.next();
                String countyKey = county.getKey();
                String countyName = county.getName();

                htmlJS.append("    Associate['" + countryKey + "']['" + countyKey + "'] = \"" + countyName + "\";                                                              \n");
            }
        }

        htmlJS.append("                                                                                                                                                      \n");
        htmlJS.append("    function refreshCountySelect(form, countryKeyAdd, selected, start, reset) {                                                                        \n");
        htmlJS.append("        for (var i in form.countyKey.options) {                                                                                                        \n");
        htmlJS.append("            form.countyKey.options[i] = null;                                                                                                          \n");
        htmlJS.append("        }                                                                                                                                             \n");
        htmlJS.append("                                                                                                                                                      \n");
        htmlJS.append("        form.countyKey.options[form.countyKey.options.length] = new Option(\"\", 'empty', false, false);                                                      \n");
        htmlJS.append("                                                                                                                                                      \n");
        htmlJS.append("        for (var countyKeyAdd in Associate[countryKeyAdd]) {                                                                                            \n");
        htmlJS.append("            if (countyKeyAdd == selected && (start || reset)) {                                                                                        \n");
        htmlJS.append("                form.countyKey.options[form.countyKey.options.length] = new Option(Associate[countryKeyAdd][countyKeyAdd], countyKeyAdd, true, true);      \n");
        htmlJS.append("            }                                                                                                                                         \n");
        htmlJS.append("            else {                                                                                                                                    \n");
        htmlJS.append("                form.countyKey.options[form.countyKey.options.length] = new Option(Associate[countryKeyAdd][countyKeyAdd], countyKeyAdd, false, false);    \n");
        htmlJS.append("            }                                                                                                                                         \n");
        htmlJS.append("        }                                                                                                                                             \n");
        htmlJS.append("    }                                                                                                                                                 \n");

        if (customerCmd != null) {
            htmlJS.append("                                                                                                                                                  \n");
            htmlJS.append("    refreshCountySelect(document.customerForm, '" + customerCmd.getCountryKey() + "', '" + customerCmd.getCountyKey() + "', true, false);               \n");
        }

        return htmlJS.toString();
    }
}
