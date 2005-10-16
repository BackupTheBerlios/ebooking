package ebooking.core.context;

import ebooking.core.context.ContainerContext;

/**
 * ContainerManager.
 * <p/>
 * <p>The ContainerManager keeps a reference to the ContainerContext which
 * provides access to all beans available with the Spring ApplicationContext.
 *
 * @author Juergen Denzel
 * @version $Id: ContainerManager.java,v 1.1 2005/10/16 18:41:08 raedler Exp $
 */
public class ContainerManager
{
    private static ContainerManager instance = new ContainerManager();
    private ContainerContext containerContext;

    public static ContainerManager getInstance()
    {
        return instance;
    }

    private ContainerManager()
    {
        containerContext = null;
    }

    public static Object getBean( String key )
    {
        return getInstance().getContainerContext().getBean( key );
    }

    public ContainerContext getContainerContext()
    {
        return containerContext;
    }

    public void setContainerContext( ContainerContext containerContext )
    {
        this.containerContext = containerContext;
    }
}