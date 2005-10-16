package ebooking.core.context;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContextEvent;

/**
 * ContainerContextLoaderListener.
 * <p/>
 * <p>ServletContextListener which delegates the actual loading of the
 * ApplicationContext to the super class and sets the ServletContext on the
 * ContainerManager to get a hold on the loaded ApplicationContext.
 *
 * @author Juergen Denzel
 * @version $Id: ContainerContextLoaderListener.java,v 1.1 2005/10/16 18:41:08 raedler Exp $
 */
public class ContainerContextLoaderListener extends ContextLoaderListener {
    // Constants -----------------------------------------------------

    // Attributes ----------------------------------------------------

    private ContextLoader contextLoader;

    // Static --------------------------------------------------------

    // Constructors --------------------------------------------------

    // Public --------------------------------------------------------

    public void contextInitialized(ServletContextEvent event) {
        this.contextLoader = createContextLoader();
        this.contextLoader.initWebApplicationContext(event.getServletContext());
        SpringContainerContext springContainerContext = newSpringContainerContext();
        springContainerContext.setServletContext(event.getServletContext());
        ContainerManager.getInstance().setContainerContext(springContainerContext);
    }

    /**
     * Close the root web application context.
     */
    public void contextDestroyed(ServletContextEvent event) {
        this.contextLoader.closeWebApplicationContext(event.getServletContext());
    }

    // Protected -----------------------------------------------------

    // Private -------------------------------------------------------

    private SpringContainerContext newSpringContainerContext() {
        return new SpringContainerContext();
    }
}
