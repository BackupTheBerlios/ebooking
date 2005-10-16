package ebooking.module.base.service;

import org.springframework.dao.DataAccessException;
import org.hibernate.Criteria;

import java.io.Serializable;
import java.util.List;

import ebooking.module.base.bean.person.Person;
import ebooking.module.base.bean.address.Address;
import ebooking.module.base.bean.system.*;
import ebooking.module.base.controller.command.customer.CustomerCommand;
import ebooking.module.base.controller.command.system.TitleCommand;
import ebooking.module.base.controller.command.system.CountyCommand;
import ebooking.module.base.controller.command.system.*;
import ebooking.module.base.dao.BaseDao;
import ebooking.module.base.dto.CustomerDto;
import ebooking.module.base.filter.FilterInterface;
import ebooking.core.menu.Menu;


/**
 * Base service.
 * <p/>
 * User: rro
 * Date: 08.04.2005
 * Time: 14:27:07
 *
 * @author Roman R&auml;dle
 * @version $Id: BaseService.java,v 1.1 2005/10/16 18:27:13 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public interface BaseService {

    /*
    #######################################
    Generally methods.
    #######################################
    */

    /**
     * Returns the <code>BaseDao</code> to get an easier database access.
     *
     * @return The <code>BaseDao</code> for an easier database access.
     */
    public BaseDao getBaseDao();

    /**
     * Sets the <code>BaseDao</code> to get an easier database access.
     *
     * @param baseDao Base data access object for an easier database access.
     */
    public void setBaseDao(BaseDao baseDao);

    /**
     * Finds an object by its id.
     *
     * @param entityClass The entity class.
     * @param id          The id of the object.
     * @return The object that belongs to this id.
     * @throws DataAccessException Don't get access to the data.
     */
    public Object findById(Class entityClass, Serializable id) throws DataAccessException;

    /**
     * Finds an object by a property and a value.
     *
     * @param entityClass The entity class.
     * @param property    The property of the entity class.
     * @param value       A value that should match with the property.
     * @return A list of objects which property matches with the value.
     * @throws DataAccessException Don't get access to the data.
     */
    public List findByProperty(Class entityClass, String property, String value) throws DataAccessException;

    /**
     * Returns all objects in a list that belongs to this entity class.
     *
     * @param entityClass The entity class.
     * @return All objects in all list that belongs to this entity class.
     * @throws DataAccessException Don't get access to the data.
     */
    public List findAll(Class entityClass) throws DataAccessException;

    /**
     * Loads the object which id matches with the serializable.
     *
     * @param entityClass  The entity class.
     * @param serializable The identifier of the object.
     * @return An object which id matches with the serializable.
     * @throws DataAccessException Don't get access to the data.
     */
    public Object load(Class entityClass, Serializable serializable) throws DataAccessException;

    /**
     * Get an object which id matches with the serializable.
     *
     * @param entityClass  The entity class.
     * @param serializable The identifier of the object.
     * @return An object which id matches with the serializable.
     * @throws DataAccessException Don't get access to the data.
     */
    public Object get(Class entityClass, Serializable serializable) throws DataAccessException;

    /**
     * Evicts the object of the database.
     *
     * @param entity The object.
     */
    public void evict(Object entity);

    /**
     * Save or update procedure.
     *
     * @param entity The object that should be saved or up to date.
     */
    public void saveOrUpdate(Object entity);

    /**
     * Save or update procedure with an extra flush parameter.
     *
     * @param entity The object that should be saved or up to date.
     * @param flush  Whether a flush should be performed or not.
     * @throws DataAccessException Don't get access to the data.
     */
    public void saveOrUpdate(Object entity, boolean flush) throws DataAccessException;

    /**
     * Update procedure.
     *
     * @param entity The object that should be saved.
     */
    public void update(Object entity);

    /**
     * Save procedure.
     *
     * @param entity The object that should be saved.
     */
    public void save(Object entity);

    /**
     * Save procedure with an extra flush parameter.
     *
     * @param entity The object that should be saved.
     * @param flush  Whether a flush should be performed or not.
     * @throws DataAccessException Don't get access to the data.
     */
    public void save(Object entity, boolean flush) throws DataAccessException;

    /**
     * Deletes the object from the database.
     *
     * @param entity The object that should be deleted from the database.
     */
    public void delete(Object entity);

    /**
     * Reassociation of the object. Removes the lock of the object.
     *
     * @param entity The object that should get free.
     */
    public void reassociate(Object entity);

    /**
     * Clears the open session.
     */
    public void clearSession();


    /*
    #######################################
    Customer specific methods.
    #######################################
    */

    /**
     * Inserts the customer (<code>CustomerCommand</code>) into the database.
     *
     * @param customer The customer that should be inserted into the database.
     */
    public void insertCustomer(CustomerDto customer);

    public CustomerCommand getCustomerCommandByPersonId(Long id);



    /*
    #######################################
    Title specific methods.
    #######################################
    */

    /**
     * Inserts the <code>Title</code> into the database.
     *
     * @param title The <code>Title</code> that should be inserted into the database.
     */
    //public void insertTitle(Title title);

    /**
     * Updates the <code>Title</code> in the database.
     *
     * @param title The <code>Title</code> that should contain the updates.
     */
    //public void updateTitle(Title title);

    /**
     * Gets the <code>Title</code> by its id of the database.
     *
     * @param id The <code>Title</code> identifier.
     * @return Returns the <code>Title</code> that belongs to this id.
     * @throws DataAccessException Don't get access to the data.
     */
    //public Title getTitleById(Long id) throws DataAccessException;

    /**
     * Returns all titles in a <code>List</code>.
     *
     * @return All titles that are stored in the database.
     * @throws DataAccessException Don't get access to the data.
     */
    public List getAllTitles() throws DataAccessException;


    /*
    #######################################
    AcademicTitle specific methods.
    #######################################
    */

    /**
     * Inserts the <code>AcademicTitle</code> into the database.
     *
     * @param academicTitle The <code>AcademicTitle</code> that should be inserted into the
     *                      database.
     */
    //public void insertAcademicTitle(AcademicTitle academicTitle);

    /**
     * Update the <code>AcademicTitle</code> in the database.
     *
     * @param academicTitle The <code>AcademicTitle</code> that should contain the updates.
     */
    //public void updateAcademicTitle(AcademicTitle academicTitle);

    /**
     * Gets the <code>AcademicTitle</code> by its id of the database.
     *
     * @param id The <code>AcademicTitle</code> identifier.
     * @return Returns the <code>AcademicTitle</code> that belongs to this id.
     * @throws DataAccessException Don't get access to the data.
     */
    //public AcademicTitle getAcademicTitleById(Long id) throws DataAccessException;

    /**
     * Returns all academic titles in a <code>List</code>.
     *
     * @return All academic titles that are stored in the database.
     * @throws DataAccessException Don't get access to the data.
     */
    public List getAllAcademicTitles() throws DataAccessException;

    /*
    #######################################
    Country specific methods.
    #######################################
    */

    /**
     * Inserts the <code>Country</code> into the database.
     *
     * @param country The <code>Country</code> that should be inserted into the database.
     */
    //public void insertCountry(Country country);

    /**
     * Update the <code>Country</code> in the database.
     *
     * @param country The <code>Country</code> that should contain the updates.
     */
    //public void updateCountry(Country country);

    /**
     * Gets the <code>Country</code> by its id of the database.
     *
     * @param id The <code>Country</code> identifier.
     * @return Returns the <code>Country</code> that belongs to this id.
     * @throws DataAccessException Don't get access to the data.
     */
    //public Country getCountryById(Long id) throws DataAccessException;

    /**
     * Returns the <code>Country</code> identifying by its name.
     *
     * @param name The name of the country.
     * @return The <code>Country</code> that belongs to this country name.
     * @throws DataAccessException Don't get access to the data.
     */
    //public Country getCountryByName(String name) throws DataAccessException;

    /**
     * Returns all countries in a <code>List</code>.
     *
     * @return All countries that are stored in the database.
     * @throws DataAccessException Don't get access to the data.
     */
    public List getAllCountries() throws DataAccessException;


    /*
    #######################################
    County specific methods.
    #######################################
    */

    /**
     * Inserts the <code>County</code> into the database.
     *
     * @param county The <code>County</code> that should be inserted into the database.
     */
    //public void insertCounty(County county);

    /**
     * Update the <code>County</code> in the database.
     *
     * @param county The <code>County</code> that should contain the updates.
     */
    //public void updateCounty(County county);

    /**
     * Gets the <code>County</code> by its id of the database.
     *
     * @param id The <code>County</code> identifier.
     * @return Returns the <code>County</code> that belongs to this id.
     * @throws DataAccessException Don't get access to the data.
     */
    //public County getCountyById(Long id) throws DataAccessException;

    /**
     * Returns the <code>County</code> identifying by its name.
     *
     * @param name The name of the county.
     * @return The <code>County</code> that belongs to this county name.
     * @throws DataAccessException Don't get access to the data.
     */
    //public County getCountyByName(String name) throws DataAccessException;

    /**
     * Returns a <code>List</code> of <code>County</code> that belongs to the <code>Country</code>.
     *
     * @param country An <code>Country</code> object.
     * @return A <code>List</code> of those counties which belongs to the <code>Country</code>
     * @throws DataAccessException Don't get access to the data.
     */
    public List getCountiesByCountry(Country country) throws DataAccessException;

    /**
     * Returns all counties in a <code>List</code>.
     *
     * @return All counties that are stored in the database.
     * @throws DataAccessException Don't get access to the data.
     */
    public List getAllCounties() throws DataAccessException;

    public void deleteCustomerByPersonId(Long id);

    public void saveOrUpdateCustomer(CustomerCommand customerCmd);
    public List getCustomerDtoList(FilterInterface filter);

    public void saveOrUpdateTitle(TitleCommand titleCmd);
    public void deleteTitleByTitleId(Long id);
    public List getTitleDtoList(FilterInterface filter);
    public TitleCommand getTitleCommandByTitleId(Long id);

    public void saveOrUpdateAcademicTitle(AcademicTitleCommand academicTitleCmd);
    public void deleteAcademicTitleByAcademicTitleId(Long id);
    public List getAcademicTitleDtoList(FilterInterface filter);
    public AcademicTitleCommand getAcademicTitleCommandByAcademicTitleId(Long id);

    public void saveOrUpdateCountry(CountryCommand countryCmd);
    public void deleteCountryByCountryId(Long id);
    public List getCountryDtoList(FilterInterface filter);
    public CountryCommand getCountryCommandByCountryId(Long id);

    public void saveOrUpdateCounty(CountyCommand countyCmd);
    public void deleteCountyByCountyId(Long id);
    public List getCountyDtoList(FilterInterface filter);
    public CountyCommand getCountyCommandByCountyId(Long id);

    public SystemLocale getSystemLocale(String localeKey);
    public void saveOrUpdateSystemLocale(SystemLocaleCommand systemLocaleCmd);
    public void deleteSystemLocaleBySystemLocaleKey(String localeKey);
    public List getSystemLocaleDtoList(FilterInterface filter);
    public SystemLocaleCommand getSystemLocaleCommandBySystemLocaleKey(String localeKey);
    public List getAllSystemLocales();

    public User getUserByLoginId(String loginId);

    public Menu getMenuByAuthorization(String key);
}
