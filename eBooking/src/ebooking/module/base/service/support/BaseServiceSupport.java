package ebooking.module.base.service.support;

import ebooking.module.base.bean.address.Address;
import ebooking.module.base.bean.person.Person;
import ebooking.module.base.bean.system.Title;
import ebooking.module.base.bean.system.Country;
import ebooking.module.base.bean.system.County;
import ebooking.module.base.bean.system.*;
import ebooking.module.base.controller.command.customer.CustomerCommand;
import ebooking.module.base.controller.command.system.TitleCommand;
import ebooking.module.base.controller.command.system.CountryCommand;
import ebooking.module.base.controller.command.system.CountyCommand;
import ebooking.module.base.controller.command.system.*;
import ebooking.module.base.dao.BaseDao;
import ebooking.module.base.service.BaseService;
import ebooking.module.base.dto.CustomerDto;
import ebooking.module.base.filter.FilterInterface;
import ebooking.module.base.exception.SystemLocaleNotExistException;
import ebooking.module.base.exception.CountryNotExistException;
import ebooking.core.menu.Menu;
import org.springframework.dao.DataAccessException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.Iterator;

/**
 * The <code>BaseServiceSupport</code> supports some useful basic methods.
 * <p/>
 * User: rro
 * Date: 11.04.2005
 * Time: 20:43:14
 *
 * @author Roman R&auml;dle
 * @version $Id: BaseServiceSupport.java,v 1.1 2005/10/16 18:27:15 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public class BaseServiceSupport implements BaseService {
    /**
     * Logger to log messages and appearing exceptions.
     */
    private final static Log LOG = LogFactory.getLog(BaseServiceSupport.class);

    /**
     * Base data access object.
     */
    private BaseDao baseDao;


    /*
    #######################################
    Generally methods.
    #######################################
    */

    /**
     * Returns base data access object.
     *
     * @return Base data access object.
     * @see ebooking.module.base.service.BaseService#getBaseDao()
     */
    public BaseDao getBaseDao() {
        return baseDao;
    }

    /**
     * Sets base data access object.
     *
     * @param baseDao Base data access object.
     * @see ebooking.module.base.service.BaseService#setBaseDao(ebooking.module.base.dao.BaseDao)
     */
    public void setBaseDao(BaseDao baseDao) {
        this.baseDao = baseDao;
    }

    /**
     * @see ebooking.module.base.service.BaseService#findById(Class, java.io.Serializable)
     */
    public Object findById(Class entityClass, Serializable id) {
        return baseDao.findById(entityClass, id);
    }

    /**
     * @see ebooking.module.base.service.BaseService#findByProperty(Class, String, String)
     */
    public List findByProperty(Class entityClass, String property, String value) {
        return baseDao.findByProperty(entityClass, property, value);
    }

    /**
     * @see ebooking.module.base.service.BaseService#findAll(Class)
     */
    public List findAll(Class entityClass) {
        return baseDao.findAll(entityClass);
    }

    /**
     * @see ebooking.module.base.service.BaseService#load(Class, java.io.Serializable)
     */
    public Object load(Class entityClass, Serializable serializable) throws DataAccessException {
        return baseDao.load(entityClass, serializable);
    }

    /**
     * @see ebooking.module.base.service.BaseService#get(Class, java.io.Serializable)
     */
    public Object get(Class entityClass, Serializable serializable) throws DataAccessException {
        return baseDao.get(entityClass, serializable);
    }

    /**
     * @see ebooking.module.base.service.BaseService#evict(Object)
     */
    public void evict(Object entity) {
        baseDao.evict(entity);
    }

    /**
     * @see ebooking.module.base.service.BaseService#saveOrUpdate(Object)
     */
    public void saveOrUpdate(Object entity) {
        baseDao.saveOrUpdate(entity);
    }

    /**
     * @see ebooking.module.base.service.BaseService#save(Object, boolean)
     */
    public void saveOrUpdate(Object entity, boolean flush) throws DataAccessException {
        baseDao.saveOrUpdate(entity, flush);
    }

    /**
     * @see ebooking.module.base.service.BaseService#update(Object)
     */
    public void update(Object entity) {
        baseDao.update(entity);
    }

    /**
     * @see ebooking.module.base.service.BaseService#save(Object)
     */
    public void save(Object entity) {
        baseDao.save(entity);
    }

    /**
     * @see ebooking.module.base.service.BaseService#save(Object)
     */
    public void save(Object entity, boolean flush) throws DataAccessException {
        baseDao.save(entity, flush);
    }

    /**
     * @see ebooking.module.base.service.BaseService#delete(Object)
     */
    public void delete(Object entity) {
        baseDao.delete(entity);
    }

    /**
     * @see ebooking.module.base.service.BaseService#reassociate(Object)
     */
    public void reassociate(Object entity) {
        baseDao.reassociate(entity);
    }


    /**
     * @see ebooking.module.base.service.BaseService#clearSession()
     */
    public void clearSession() {
        baseDao.clearSession();
    }


    /*
    #######################################
    Customer specific methods.
    #######################################
    */

    /**
     * @see BaseService#insertCustomer(ebooking.module.base.dto.CustomerDto)
     */
    public void insertCustomer(CustomerDto customerDto) {
        /*
        StringBuffer condition = new StringBuffer();

        condition.append("from " + Person.class.getName() + " as person where ");
        condition.append("person.firstname='" + customer.getFirstname() + "'" );
        */
        Person person = new Person();
        Address address = new Address();
        /*
        address.setStreet(customerDto.getStreet());
        address.setZipCode(customerDto.getZipCode());
        address.setCity(customerDto.getCity());
        address.setCountyId(Long.valueOf(customerDto.getCounty()));
        address.setCountryId(Long.valueOf(customerDto.getCountry()));
        address.setStateId(Long.valueOf(customerDto.getState()));
        address.setPostalName(customerDto.getPostalName());
        address.setDepartment(customerDto.getDepartment());
        address.setPhone1(customerDto.getPhone1());
        address.setPhone2(customerDto.getPhone2());
        address.setTelefax(customerDto.getTelefax());
        address.setMobilePhone(customerDto.getMobilePhone());
        address.setEmail(customerDto.getEmail());
        address.setWww(customerDto.getWww());

        System.out.println("INSERT BEGIN");
        //baseDao.insertAddress(address);

        person.setTitleId(Long.valueOf(customerDto.getTitle()));
        person.setAcademicTitleId(Long.valueOf(customerDto.getAcademicTitle()));
        person.setFirstname(customerDto.getFirstname());
        person.setLastname(customerDto.getLastname());
        person.setAddress(address);

        baseDao.insertPerson(person);
        */
        System.out.println("INSERT END");
    }

    public void deleteCustomerByPersonId(Long id) {
        Person person = (Person) baseDao.get(Person.class, id);

        if (LOG.isDebugEnabled()) {
            LOG.debug("");
        }

        System.out.println("ENTITY: " + person);

        if (person != null) {
            delete(person);
        }

        Address address = (Address) person.getAddress();

        Set persons = address.getPersons();

        persons.remove(person);

        if (persons.size() < 1) {
            baseDao.delete(address);
        }
    }

    public CustomerCommand getCustomerCommandByPersonId(Long id) {
        if (LOG.isDebugEnabled()) LOG.debug("Get customer by its id [" + id + "]");

        Person person = baseDao.getPersonById(id);
        Address address = person.getAddress();

        CustomerCommand customerCmd = new CustomerCommand();

        if (LOG.isDebugEnabled()) {
            LOG.debug("Persistent person: " + person);
            LOG.debug("Persistent address: " + address);
        }

        customerCmd.setPersistentId(person.getId());
        customerCmd.setTitleKey(person.getTitleKey());
        customerCmd.setAcademicTitleKey(person.getAcademicTitleKey());
        customerCmd.setFirstname(person.getFirstname());
        customerCmd.setLastname(person.getLastname());
        customerCmd.setIdentificationNumber(person.getIdentificationNumber());

        customerCmd.setPersistentAddressId(address.getId());
        customerCmd.setStreet(address.getStreet());
        customerCmd.setZipCode(address.getZipCode());
        customerCmd.setCity(address.getCity());
        customerCmd.setCountyKey(address.getCountyKey());
        customerCmd.setCountryKey(address.getCountryKey());
        customerCmd.setPostalName(address.getPostalName());
        customerCmd.setDepartment(address.getDepartment());
        customerCmd.setPhone1(address.getPhone1());
        customerCmd.setPhone2(address.getPhone2());
        customerCmd.setTelefax(address.getTelefax());
        customerCmd.setMobilePhone(address.getMobilePhone());
        customerCmd.setEmail(address.getEmail());
        customerCmd.setWww(address.getWww());

        return customerCmd;
    }

    public List getAllTitles() throws DataAccessException {
        return baseDao.getAllTitles();
    }

    public List getAllAcademicTitles() throws DataAccessException {
        return baseDao.getAllAcademicTitles();
    }

    public List getAllCountries() throws DataAccessException {
        return baseDao.getAllCountries();
    }

    public List getAllCounties() throws DataAccessException {
        return baseDao.getAllCounties();
    }

    /*
    public Person createPerson(String key, Person person) {
        Person pers = getPersonById(person.getId());

        if (pers == null) {
            pers = new Person();
        }

        save(pers);

        return pers;
    }

    public void deletePerson(Person toDelete) {
        Person person = getPersonById(toDelete.getId());

        if (person != null) {
            delete(person);
        }
    }

    public Address createAddress(String key, Address address) {
        Address addr = getAddressById(address.getId());

        if (addr == null) {
            addr = new Address();
        }

        save(addr);

        return addr;
    }

    public void deleteAddress(Address toDelete) {
        Address address = getAddressById(toDelete.getId());

        if (address != null) {
            delete(address);
        }
    }
    */

    public void saveOrUpdateCustomer(CustomerCommand customerCmd) {
        Person person = new Person();
        Address address = new Address();

        person.setId(customerCmd.getPersistentId());
        person.setTitleKey(customerCmd.getTitleKey());
        person.setAcademicTitleKey(customerCmd.getAcademicTitleKey());
        person.setFirstname(customerCmd.getFirstname());
        person.setLastname(customerCmd.getLastname());
        person.setIdentificationNumber(customerCmd.getIdentificationNumber());

        address.setId(customerCmd.getPersistentAddressId());

        System.out.println("ADDRESS PERSISTENT ID: " + customerCmd.getPersistentAddressId());

        address.setStreet(customerCmd.getStreet());
        address.setZipCode(customerCmd.getZipCode());
        address.setCity(customerCmd.getCity());
        address.setCountyKey(customerCmd.getCountyKey());
        address.setCountryKey(customerCmd.getCountryKey());
        address.setPostalName(customerCmd.getPostalName());
        address.setDepartment(customerCmd.getDepartment());
        address.setPhone1(customerCmd.getPhone1());
        address.setPhone2(customerCmd.getPhone2());
        address.setTelefax(customerCmd.getTelefax());
        address.setMobilePhone(customerCmd.getMobilePhone());
        address.setEmail(customerCmd.getEmail());
        address.setWww(customerCmd.getWww());

        person.setAddress(address);

        System.out.println("BEFORE INSERT PERSON");
        baseDao.insertPerson(person);

        System.out.println("AFTER INSERT PERSON");
    }

    /**
     * @see ebooking.module.base.service.BaseService#getCustomerDtoList(FilterInterface filter)
     */
    public List getCustomerDtoList(FilterInterface filter) {
        StringBuffer condition = new StringBuffer();
        condition.append("select new ebooking.module.base.dto.CustomerDto(person.id, person.firstname, person.lastname, address.street, address.zipCode, address.city) from ");
        condition.append(Person.class.getName() + " as person join person.address as address");

        condition.append(filter.getCondition());

        return baseDao.find(condition.toString());
    }

    /**
     * @see ebooking.module.base.service.BaseService#saveOrUpdateTitle(ebooking.module.base.controller.command.system.TitleCommand)
     */
    public void saveOrUpdateTitle(TitleCommand titleCmd) {
        SystemLocale systemLocale = baseDao.getSystemLocaleByLocaleKey(titleCmd.getSystemLocaleKey());

        if (systemLocale == null) {
            throw new SystemLocaleNotExistException("No such SystemLocale exist with the key [" + titleCmd.getSystemLocaleKey()+ "]");
        }

        Title title = new Title();

        title.setId(titleCmd.getPersistentId());
        title.setKey(titleCmd.getKey());
        title.setName(titleCmd.getName());
        title.setSystemLocale(systemLocale);

        baseDao.saveOrUpdate(title);
    }

    /**
     * @see ebooking.module.base.service.BaseService#deleteTitleByTitleId(Long)
     */
    public void deleteTitleByTitleId(Long id) {
        Title title = baseDao.getTitleById(id);

        if (LOG.isDebugEnabled()) {
            LOG.debug("The Title [" + title.getName() + "] will be deleted.");
        }

        if (title != null) baseDao.delete(title);
    }

    /**
     * @see ebooking.module.base.service.BaseService#getTitleDtoList(ebooking.module.base.filter.FilterInterface)
     */
    public List getTitleDtoList(FilterInterface filter) {
        StringBuffer condition = new StringBuffer();
        condition.append("select new ebooking.module.base.dto.TitleDto(title.id, title.key, title.name, systemLocale.language, systemLocale.key) from ");
        condition.append(Title.class.getName() + " as title join title.systemLocale as systemLocale");

        condition.append(filter.getCondition());

        return baseDao.find(condition.toString());
    }

    /**
     * @see ebooking.module.base.service.BaseService#getTitleCommandByTitleId(Long)
     */
    public TitleCommand getTitleCommandByTitleId(Long id) {

        Title title = baseDao.getTitleById(id);
        SystemLocale systemLocale = title.getSystemLocale();

        TitleCommand titleCommand = new TitleCommand();
        titleCommand.setPersistentId(title.getId());
        titleCommand.setKey(title.getKey());
        titleCommand.setName(title.getName());
        titleCommand.setSystemLocaleKey(systemLocale.getKey());

        return titleCommand;
    }

    /**
     * @see ebooking.module.base.service.BaseService#saveOrUpdateAcademicTitle(ebooking.module.base.controller.command.system.AcademicTitleCommand)
     */
    public void saveOrUpdateAcademicTitle(AcademicTitleCommand academicTitleCmd) {
        SystemLocale systemLocale = baseDao.getSystemLocaleByLocaleKey(academicTitleCmd.getSystemLocaleKey());

        if (systemLocale == null) {
            throw new SystemLocaleNotExistException("No such SystemLocale exist with the key [" + academicTitleCmd.getSystemLocaleKey()+ "]");
        }

        AcademicTitle academicTitle = new AcademicTitle();
        academicTitle.setId(academicTitleCmd.getPersistentId());
        academicTitle.setKey(academicTitleCmd.getKey());
        academicTitle.setName(academicTitleCmd.getName());
        academicTitle.setSystemLocale(systemLocale);

        baseDao.saveOrUpdate(academicTitle);
    }

    /**
     * @see ebooking.module.base.service.BaseService#deleteAcademicTitleByAcademicTitleId(Long)
     */
    public void deleteAcademicTitleByAcademicTitleId(Long id) {
        AcademicTitle academicTitle = baseDao.getAcademicTitleById(id);

        if (LOG.isDebugEnabled()) {
            LOG.debug("The AcademicTitle [" + academicTitle.getName() + "] will be deleted.");
        }

        if (academicTitle != null) baseDao.delete(academicTitle);
    }

    /**
     * @see ebooking.module.base.service.BaseService#getAcademicTitleDtoList(ebooking.module.base.filter.FilterInterface)
     */
    public List getAcademicTitleDtoList(FilterInterface filter) {
        StringBuffer condition = new StringBuffer();
        condition.append("select new ebooking.module.base.dto.AcademicTitleDto(academicTitle.id, academicTitle.key, academicTitle.name, systemLocale.language, systemLocale.key) from ");
        condition.append(AcademicTitle.class.getName() + " as academicTitle join academicTitle.systemLocale as systemLocale");

        condition.append(filter.getCondition());

        return baseDao.find(condition.toString());
    }

    /**
     * @see ebooking.module.base.service.BaseService#getAcademicTitleCommandByAcademicTitleId(Long)
     */
    public AcademicTitleCommand getAcademicTitleCommandByAcademicTitleId(Long id) {
        AcademicTitle academicTitle = baseDao.getAcademicTitleById(id);
        SystemLocale systemLocale = academicTitle.getSystemLocale();

        AcademicTitleCommand academicTitleCmd = new AcademicTitleCommand();
        academicTitleCmd.setPersistentId(academicTitle.getId());
        academicTitleCmd.setKey(academicTitle.getKey());
        academicTitleCmd.setName(academicTitle.getName());
        academicTitleCmd.setSystemLocaleKey(systemLocale.getKey());

        return academicTitleCmd;
    }

    /**
     * @see ebooking.module.base.service.BaseService#getCountiesByCountry(ebooking.module.base.bean.system.Country)
     */
    public List getCountiesByCountry(Country country) throws DataAccessException {
        return baseDao.getCountiesByCountry(country);
    }

    public void saveOrUpdateCountry(CountryCommand countryCmd) {
        SystemLocale systemLocale = baseDao.getSystemLocaleByLocaleKey(countryCmd.getSystemLocaleKey());

        if (LOG.isDebugEnabled()) {
            LOG.debug("SystemLocale key [" + countryCmd.getSystemLocaleKey() + "]");
        }

        if (systemLocale == null) {
            throw new SystemLocaleNotExistException("No such SystemLocale exist with the key: [" + countryCmd.getSystemLocaleKey() + "]");
        }

        Country country = null;
        for (Iterator i = systemLocale.getCountries().iterator(); i.hasNext();) {
            Country tmp = (Country) i.next();

            if (LOG.isDebugEnabled()) {
                LOG.debug("The tmp country key [" + tmp.getKey() + "] and the countryCmd key is: [" + countryCmd.getKey() + "]");
            }

            if (tmp.getKey().equals(countryCmd.getKey())) {
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Found existing country with the key: [" + countryCmd.getKey() + "]");
                }
                country = tmp;
                break;
            }
        }

        if (LOG.isDebugEnabled() && country != null) {
            LOG.debug("Country key [" + country.getKey() + "] and country name [" + country.getName() + "]");
        }

        if (country == null) {
            country = new Country();
            if (LOG.isDebugEnabled()) {
                LOG.debug("New country was added with the key: [" + countryCmd.getKey() + "]");
            }

            country.setId(countryCmd.getPersistentId());
            country.setKey(countryCmd.getKey());
            country.setSystemLocale(systemLocale);
        }

        country.setName(countryCmd.getName());

        baseDao.insertCountry(country);
    }

    public void deleteCountryByCountryId(Long id) {

        Country country = baseDao.getCountryById(id);

        baseDao.delete(country);
    }

    public List getCountryDtoList(FilterInterface filter) {
        StringBuffer condition = new StringBuffer();
        condition.append("select new ebooking.module.base.dto.CountryDto(country.id, country.key, country.name, systemLocale.language, systemLocale.key) from ");
        condition.append(Country.class.getName() + " as country join country.systemLocale as systemLocale");

        condition.append(filter.getCondition());

        return baseDao.find(condition.toString());
    }

    public List getCountyDtoList(FilterInterface filter) {
        StringBuffer condition = new StringBuffer();
        condition.append("select new ebooking.module.base.dto.CountyDto(county.id, county.key, county.name, country.name, systemLocale.language) from ");
        condition.append(County.class.getName() + " as county join county.country as country join country.systemLocale as systemLocale");

        condition.append(filter.getCondition());

        return baseDao.find(condition.toString());
    }

    public CountyCommand getCountyCommandByCountyId(Long id) {
        County county = baseDao.getCountyById(id);
        Country country = county.getCountry();

        CountyCommand countyCmd = new CountyCommand();
        countyCmd.setPersistentId(county.getId());
        countyCmd.setKey(county.getKey());
        countyCmd.setName(county.getName());
        countyCmd.setCountryId(country.getId());

        return countyCmd;
    }

    public CountryCommand getCountryCommandByCountryId(Long id) {
        Country country = baseDao.getCountryById(id);
        SystemLocale systemLocale = country.getSystemLocale();

        CountryCommand countryCmd = new CountryCommand();
        countryCmd.setPersistentId(country.getId());
        countryCmd.setKey(country.getKey());
        countryCmd.setName(country.getName());
        countryCmd.setSystemLocaleKey(systemLocale.getKey());

        return countryCmd;
    }

    public void saveOrUpdateCounty(CountyCommand countyCmd) {
        Country country = baseDao.getCountryById(countyCmd.getCountryId());

        if (LOG.isDebugEnabled()) {
            LOG.debug("Country Id [" + countyCmd.getCountryId() + "]");
        }

        if (country == null) {
            throw new CountryNotExistException("No such Country exist with this id: [" + countyCmd.getCountryId() + "]");
        }

        County county = null;
        for (Iterator i = country.getCounties().iterator(); i.hasNext();) {
            County tmp = (County) i.next();

            if (LOG.isDebugEnabled()) {
                LOG.debug("The tmp county key [" + tmp.getKey() + "] and the countyCmd key is: [" + countyCmd.getKey() + "]");
            }

            if (tmp.getKey().equals(countyCmd.getKey())) {
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Found existing county with the key: [" + countyCmd.getKey() + "]");
                }
                county = tmp;
                break;
            }
        }

        if (LOG.isDebugEnabled() && county != null) {
            LOG.debug("County key [" + county.getKey() + "] and county name [" + county.getName() + "]");
        }

        if (county == null) {
            county = new County();
            if (LOG.isDebugEnabled()) {
                LOG.debug("New county was added with the key: [" + countyCmd.getKey() + "]");
            }

            county.setId(countyCmd.getPersistentId());
            county.setKey(countyCmd.getKey());
            county.setCountry(country);
        }

        county.setName(countyCmd.getName());

        baseDao.insertCounty(county);
    }

    public void deleteCountyByCountyId(Long id) {

        County county = baseDao.getCountyById(id);

        baseDao.delete(county);
    }

    public SystemLocale getSystemLocale(String localeKey) {
        return baseDao.getSystemLocaleByLocaleKey(localeKey);
    }

    public void saveOrUpdateSystemLocale(SystemLocaleCommand systemLocaleCmd) {

        if (LOG.isDebugEnabled()) {
            LOG.debug("System Locale key [" + systemLocaleCmd.getLocaleKey() + "]");
        }

        SystemLocale systemLocale = null;
        try {
            systemLocale = baseDao.getSystemLocaleByLocaleKey(systemLocaleCmd.getLocaleKey());
        }
        catch (SystemLocaleNotExistException slnee) {
            // empty because SystemLocaleNotExist so create a new SystemLocale
        }

        if (systemLocale == null) {
            systemLocale = new SystemLocale();
        }

        systemLocale.setId(systemLocaleCmd.getPersistentId());
        systemLocale.setKey(systemLocaleCmd.getLocaleKey());
        systemLocale.setLanguage(systemLocaleCmd.getLanguage());
        systemLocale.setCountryName(systemLocaleCmd.getCountryName());

        baseDao.saveOrUpdateSystemLocale(systemLocale);
    }

    public void deleteSystemLocaleBySystemLocaleKey(String localeKey) {

        SystemLocale systemLocale = baseDao.getSystemLocaleByLocaleKey(localeKey);

        System.out.println("TITLES: " + systemLocale.getTitles());

        baseDao.delete(systemLocale);
    }

    public List getSystemLocaleDtoList(FilterInterface filter) {
        StringBuffer condition = new StringBuffer();
        condition.append("select new ebooking.module.base.dto.SystemLocaleDto(systemLocale.id, systemLocale.key, systemLocale.language, systemLocale.countryName) from ");
        condition.append(SystemLocale.class.getName() + " as systemLocale");

        condition.append(filter.getCondition());

        return baseDao.find(condition.toString());
    }

    public SystemLocaleCommand getSystemLocaleCommandBySystemLocaleKey(String localeKey) {

        SystemLocale systemLocale = baseDao.getSystemLocaleByLocaleKey(localeKey);

        SystemLocaleCommand systemLocaleCmd = new SystemLocaleCommand();
        systemLocaleCmd.setPersistentId(systemLocale.getId());
        systemLocaleCmd.setLocaleKey(systemLocale.getKey());
        systemLocaleCmd.setLanguage(systemLocale.getLanguage());
        systemLocaleCmd.setCountryName(systemLocale.getCountryName());

        return systemLocaleCmd;
    }

    public List getAllSystemLocales() {
        return baseDao.getAllSystemLocales();
    }

    public User getUserByLoginId(String loginId) {
        return baseDao.getUserByLoginId(loginId);
    }

    public Menu getMenuByAuthorization(String key) {
        return baseDao.getMenuByAuthorization(key);
    }
}
