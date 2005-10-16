package ebooking.core.context;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;
import java.util.Enumeration;
import java.util.List;
import java.util.ArrayList;

import ebooking.core.context.BeanNotFoundException;
import ebooking.core.context.ContainerContext;

/**
 * SpringContainerContext.
 * <p/>
 * <p>Wrapper class for the Spring ApplicationContext used by the ContainerManager.
 *
 * @author Juergen Denzel
 * @version $Id: SpringContainerContext.java,v 1.1 2005/10/16 18:41:08 raedler Exp $
 */
public class SpringContainerContext implements ContainerContext {
    // Constants -----------------------------------------------------

    private static final Log LOG = LogFactory.getLog(SpringContainerContext.class);

    // Attributes ----------------------------------------------------

    private ServletContext servletContext;

    // Containing the root WebApplicationContext plus all Servlet ApplicationContexts
    private ApplicationContext[] applicationContexts;

    // Static --------------------------------------------------------

    // Constructors --------------------------------------------------

    // Public --------------------------------------------------------

    public ServletContext getServletContext() {
        return servletContext;
    }

    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public Object getBean(Object key) {
        for (int i = 0; i < getApplicationContexts().length; i++) {
            Object bean = getBean(key, applicationContexts[i]);
            if (bean != null)
                return bean;
        }

        // we searched all ApplicationContexts but no matching bean was found
        LOG.warn("Bean not found: " + key);
        return null;
    }

    // Protected -----------------------------------------------------

    // Private -------------------------------------------------------

    private ApplicationContext[] getApplicationContexts() {
        if (applicationContexts == null) {
            // load once and cache it then
            List temp = new ArrayList();
            for (Enumeration e = servletContext.getAttributeNames(); e.hasMoreElements();) {
                String attributeName = (String) e.nextElement();
                Object attribute = servletContext.getAttribute(attributeName);

                // if we have an ApplicationContext add it
                if (attribute instanceof ApplicationContext)
                    temp.add(attribute);
            }
            applicationContexts = (ApplicationContext[]) temp.toArray(new ApplicationContext[temp.size()]);
        }

        return applicationContexts;
    }

    private Object getBean(Object key, ApplicationContext applicationContext) {
        if (applicationContext == null) {
            LOG.fatal("Spring Application context has not been set");
            throw new IllegalStateException("Spring Application context has not been set");
        }

        if (key == null) {
            LOG.error("The bean key cannot be null");
            throw new BeanNotFoundException("The bean key cannot be null");
        }

        if (key instanceof Class) {
            String names[] = applicationContext.getBeanDefinitionNames((Class) key);
            if (names == null || names.length == 0 || names.length > 1)
                ;
            else
                key = names[0];
        }

        try {
            return applicationContext.getBean(key.toString());
        } catch (NoSuchBeanDefinitionException ex) {
            // handled by calling method
        }
        return null;
    }
}
