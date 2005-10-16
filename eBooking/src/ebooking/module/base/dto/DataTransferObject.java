package ebooking.module.base.dto;

import java.io.Serializable;

/**
 * DataTransferObject.
 * <p/>
 * <p>Base data transfer object. Data transfer objects will be used as
 * carrier between the service layer and the view layer.
 * <p/>
 * <p>Large object graphs can be very difficult to deal with in the view layer.
 * The data transfer object carries only those informations which are needed
 * in the view.
 * <p/>
 * <p>For example, if we want to show all available BusinessPartners in the view,
 * we would have to deal with the whole object graph of <code>BusinessPartner</code>.
 * Normally in the view there are only very few pieces of the object needed for visualization,
 * e.g. the address name. So in this example we would read the business partner objects from
 * the datastore and send back a DTO containing only the business partner id and the
 * address name of the default address type. This way we have a lean object to deal with in the view,
 * but still have all necessary information needed for further processing.
 *
 * @author Juergen Denzel
 * @version $Id: DataTransferObject.java,v 1.1 2005/10/16 18:27:10 raedler Exp $
 */
public abstract class DataTransferObject implements Serializable {
    

    /**
     * Data transfer object tuple identifier.
     */
    private Long persistentId;

    /**
     * Returns the data transfer object tuple identifier.
     *
     * @return The data transfer object tuple identifier.
     */
    public Long getPersistentId() {
        return persistentId;
    }

    /**
     * Sets the data transfer object tuple identifier.
     *
     * @param persistentId The data transfer object tuple identifier.
     */
    public void setPersistentId(Long persistentId) {
        this.persistentId = persistentId;
    }
}
