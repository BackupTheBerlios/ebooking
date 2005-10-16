package ebooking.module.base.dao.support;

import ebooking.module.base.bean.address.Address;
import ebooking.module.base.bean.system.AcademicTitle;
import ebooking.module.base.bean.person.Person;
import ebooking.module.base.bean.system.Title;
import ebooking.module.base.bean.system.Country;
import ebooking.module.base.bean.system.*;
import ebooking.module.base.dao.BaseDao;
import ebooking.module.base.exception.SystemLocaleNotExistException;
import ebooking.core.menu.Menu;
import org.hibernate.LockMode;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.Serializable;
import java.util.List;

/**
 * Base data access object support class.
 * <p/>
 * User: rro
 * Date: 11.04.2005
 * Time: 16:45:06
 *
 * @author Roman R&auml;dle
 * @version $Id: BaseDaoSupport.java,v 1.1 2005/10/16 18:27:09 raedler Exp $
 * @since DAPS INTRA 1.0
 */
public class BaseDaoSupport extends HibernateDaoSupport implements BaseDao, ApplicationContextAware {

    /**
     * Logger to log messages and appearing exceptions.
     */
    private final static Log LOG = LogFactory.getLog(BaseDaoSupport.class);

    /**
     * The application context.
     */
    private ApplicationContext applicationContext;

    /**
     * Returns the application context.
     *
     * @return The application context.
     */
    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * Sets the application context.
     *
     * @param applicationContext The application Context.
     * @throws BeansException Bean definition exception.
     * @see ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
     */
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }


    /*
    #######################################
    Generally methods.
    #######################################
    */

    public List find(String query) {
        return getHibernateTemplate().find(query);
    }

    /**
     * @see ebooking.module.base.dao.BaseDao#findById(Class, java.io.Serializable)
     */
    public Object findById(Class entityClass, Serializable id) throws DataAccessException {
        return getHibernateTemplate().get(entityClass, id);
    }

    /**
     * @see ebooking.module.base.dao.BaseDao#findByProperty(Class, String, String)
     */
    public List findByProperty(Class entityClass, String property, String value) {
        String query = "from " + entityClass.getName() + " result where result." + property + "='" +
                value +
                "'";
        List result = getHibernateTemplate().find(query);

        if (result != null && result.size() > 0)
            return result;
        else
            return null;
    }

    /**
     * @see ebooking.module.base.dao.BaseDao#findAll(Class)
     */
    public List findAll(Class entityClass) {
        return getHibernateTemplate().find("from " + entityClass.getName());
    }

    /**
     * @see ebooking.module.base.dao.BaseDao#load(Class, java.io.Serializable)
     */
    public Object load(Class entityClass, Serializable serializable) throws DataAccessException {
        return getHibernateTemplate().load(entityClass, serializable);
    }

    /**
     * @see ebooking.module.base.dao.BaseDao#get(Class, java.io.Serializable)
     */
    public Object get(Class entityClass, Serializable serializable) throws DataAccessException {
        return getHibernateTemplate().get(entityClass, serializable);
    }

    /**
     * @see ebooking.module.base.dao.BaseDao#evict(Object)
     */
    public void evict(Object entity) {
        getHibernateTemplate().evict(entity);
    }

    /**
     * @see ebooking.module.base.dao.BaseDao#save(Object)
     */
    public void saveOrUpdate(Object entity) {
        saveOrUpdate(entity, false);
    }

    /**
     * @see ebooking.module.base.dao.BaseDao#save(Object, boolean)
     */
    public void saveOrUpdate(Object entity, boolean flush) throws DataAccessException {
        getHibernateTemplate().saveOrUpdate(entity);

        if (flush) {
            getHibernateTemplate().flush();
        }
    }

    /**
     * @see ebooking.module.base.dao.BaseDao#update(Object)
     */
    public void update(Object entity) {
        getHibernateTemplate().update(entity);
    }

    /**
     * @see ebooking.module.base.dao.BaseDao#save(Object)
     */
    public void save(Object entity) {
        save(entity, false);
    }

    /**
     * @see ebooking.module.base.dao.BaseDao#save(Object, boolean)
     */
    public void save(Object entity, boolean flush) throws DataAccessException {
        getHibernateTemplate().save(entity);

        if (flush) {
            getHibernateTemplate().flush();
        }
    }

    /**
     * @see ebooking.module.base.dao.BaseDao#delete(Object)
     */
    public void delete(Object entity) {
        getHibernateTemplate().delete(entity);
    }

    /**
     * @see ebooking.module.base.dao.BaseDao#reassociate(Object)
     */
    public void reassociate(Object entity) {
        try {
            getHibernateTemplate().lock(entity, LockMode.NONE);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Criteria createCriteria(Class clazz) {
        return getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(clazz);
    }

    /**
     * @see ebooking.module.base.dao.BaseDao#clearSession()
     */
    public void clearSession() {
        getSession().clear();
    }


    /*
    #######################################
    Person specific methods.
    #######################################
    */

    /**
     * @see ebooking.module.base.dao.BaseDao#insertPerson(ebooking.module.base.bean.person.Person)
     */
    public void insertPerson(Person person) {
        saveOrUpdate(person, false);
    }

    /**
     * @see ebooking.module.base.dao.BaseDao#update(Object)
     */
    public void updatePerson(Person person) {
        saveOrUpdate(person, false);
    }

    /**
     * @see ebooking.module.base.dao.BaseDao#getPersonById(Long)
     */
    public Person getPersonById(Long id) throws DataAccessException {
        return (Person) get(Person.class, id);
    }

    /**
     * @see ebooking.module.base.dao.BaseDao#getPersonsByProperty(String, String)
     */
    public List getPersonsByProperty(String property, String value) throws DataAccessException {
        return findByProperty(Person.class, property, value);
    }

    /**
     * @see ebooking.module.base.dao.BaseDao#getPersonById(Long)
     */
    public List getPersonsByAddress(Address address) throws DataAccessException {
        String query = "from " + Person.class + " result where result.addresses='" + address + "'";
        return getHibernateTemplate().find(query);
    }

    /**
     * @see ebooking.module.base.dao.BaseDao#getAllPersons()
     */
    public List getAllPersons() throws DataAccessException {
        return findAll(Person.class);
    }


    /*
    #######################################
    Title specific methods.
    #######################################
    */

    /**
     * @see ebooking.module.base.dao.BaseDao#insertTitle(ebooking.module.base.bean.system.Title)
     */
    public void insertTitle(Title title) {
        saveOrUpdate(title);
    }

    /**
     * @see ebooking.module.base.dao.BaseDao#updateTitle(ebooking.module.base.bean.system.Title)
     */
    public void updateTitle(Title title) {
        saveOrUpdate(title);
    }

    /**
     * @see ebooking.module.base.dao.BaseDao#getTitleById(Long)
     */
    public Title getTitleById(Long id) throws DataAccessException {
        return (Title) get(Title.class, id);
    }

    /**
     * @see ebooking.module.base.dao.BaseDao#getAllTitles()
     */
    public List getAllTitles() throws DataAccessException {
        return findAll(Title.class);
    }


    /*
    #######################################
    AcademicTitle specific methods.
    #######################################
    */

    /**
     * @see ebooking.module.base.dao.BaseDao#insertAcademicTitle(ebooking.module.base.bean.system.AcademicTitle)
     */
    public void insertAcademicTitle(AcademicTitle academicTitle) {
        saveOrUpdate(academicTitle);
    }

    /**
     * @see ebooking.module.base.dao.BaseDao#updateAcademicTitle(ebooking.module.base.bean.system.AcademicTitle)
     */
    public void updateAcademicTitle(AcademicTitle academicTitle) {
        saveOrUpdate(academicTitle);
    }

    /**
     * @see ebooking.module.base.dao.BaseDao#getAcademicTitleById(Long)
     */
    public AcademicTitle getAcademicTitleById(Long id) throws DataAccessException {
        return (AcademicTitle) get(AcademicTitle.class, id);
    }

    /**
     * @see ebooking.module.base.dao.BaseDao#getAllAcademicTitles()
     */
    public List getAllAcademicTitles() throws DataAccessException {
        return findAll(AcademicTitle.class);
    }


    /*
    #######################################
    Address specific methods.
    #######################################
    */

    /**
     * @see ebooking.module.base.dao.BaseDao#insertAddress(ebooking.module.base.bean.address.Address)
     */
    public void insertAddress(Address address) {
        saveOrUpdate(address, true);
    }

    /**
     * @see ebooking.module.base.dao.BaseDao#updateAddress(ebooking.module.base.bean.address.Address)
     */
    public void updateAddress(Address address) {
        saveOrUpdate(address, true);
    }

    /**
     * @see ebooking.module.base.dao.BaseDao#getAddressById(Long)
     */
    public Address getAddressById(Long id) throws DataAccessException {
        return (Address) get(Address.class, id);
    }

    /**
     * @see ebooking.module.base.dao.BaseDao#getAddressesByProperty(String, String)
     */
    public List getAddressesByProperty(String property, String value) throws DataAccessException {
        return findByProperty(Address.class, property, value);
    }

    /**
     * @see ebooking.module.base.dao.BaseDao#getAddressesByPerson(ebooking.module.base.bean.person.Person)
     */
    public List getAddressesByPerson(Person person) throws DataAccessException {
        String query = "from " + Address.class + " result where result.persons='" + person + "'";
        return getHibernateTemplate().find(query);
    }

    /**
     * @see ebooking.module.base.dao.BaseDao#getAllAddresses()
     */
    public List getAllAddresses() throws DataAccessException {
        return findAll(Address.class);
    }


    /*
    #######################################
    Country specific methods.
    #######################################
    */

    /**
     * @see ebooking.module.base.dao.BaseDao#insertCountry(ebooking.module.base.bean.system.Country)
     */
    public void insertCountry(Country country) {
        saveOrUpdate(country);
    }

    /**
     * @see ebooking.module.base.dao.BaseDao#updateCountry(ebooking.module.base.bean.system.Country)
     */
    public void updateCountry(Country country) {
        saveOrUpdate(country);
    }

    /**
     * @see ebooking.module.base.dao.BaseDao#getCountryById(Long)
     */
    public Country getCountryById(Long id) throws DataAccessException {
        return (Country) get(Country.class, id);
    }

    /**
     * @see ebooking.module.base.dao.BaseDao#getCountryByName(String)
     */
    public Country getCountryByName(String name) throws DataAccessException {
        List l = findByProperty(Country.class, "name", name);

        if (l != null)
            return (Country) l.get(0);
        else
            return null;
    }

    /**
     * @see ebooking.module.base.dao.BaseDao#getAllCountries()
     */
    public List getAllCountries() throws DataAccessException {
        return findAll(Country.class);
    }


    /*
    #######################################
    Country specific methods.
    #######################################
    */

    /**
     * @see ebooking.module.base.dao.BaseDao#insertCounty(ebooking.module.base.bean.system.County)
     */
    public void insertCounty(County county) {
        saveOrUpdate(county);
    }

    /**
     * @see ebooking.module.base.dao.BaseDao#updateCounty(ebooking.module.base.bean.system.County)
     */
    public void updateCounty(County county) {
        saveOrUpdate(county);
    }

    /**
     * @see ebooking.module.base.dao.BaseDao#getCountyById(Long)
     */
    public County getCountyById(Long id) throws DataAccessException {
        return (County) get(County.class, id);
    }

    /**
     * @see ebooking.module.base.dao.BaseDao#getCountyByName(String)
     */
    public County getCountyByName(String name) throws DataAccessException {
        List l = findByProperty(County.class, "name", name);

        if (l != null)
            return (County) l.get(0);
        else
            return null;
    }

    /**
     * @see ebooking.module.base.dao.BaseDao#getCountiesByCountry(ebooking.module.base.bean.system.Country)
     */
    public List getCountiesByCountry(Country country) throws DataAccessException {
        return getHibernateTemplate().find("from " + County.class.getName() + " as county where county.country=" + country);
    }

    /**
     * @see ebooking.module.base.dao.BaseDao#getAllCounties()
     */
    public List getAllCounties() throws DataAccessException {
        return findAll(County.class);
    }

    public void saveOrUpdateSystemLocale(SystemLocale systemLocale) {
        saveOrUpdate(systemLocale);
    }

    public SystemLocale getSystemLocaleByLocaleKey(String localeKey) {
        List systemLocaleList = findByProperty(SystemLocale.class, "key", localeKey);

        if (LOG.isDebugEnabled()) {
            LOG.debug("SystemLocale list: " + systemLocaleList);
        }

        if (systemLocaleList == null) {
            throw new SystemLocaleNotExistException("SystemLocale with the key [" + localeKey + "] doesn't exist.");
        }

        return (SystemLocale) systemLocaleList.get(0);
    }

    public List getAllSystemLocales() {
        return findAll(SystemLocale.class);
    }

    public User getUserByLoginId(String loginId) {
        List userList = getHibernateTemplate().find("from " + User.class.getName() + " as user where user.loginId = ?", new Object[]{loginId});

        if (userList.size() > 1) {
            throw new HibernateException("The user loginId isn't unique. But this should never get reality.");
        }

        if (userList.size() == 1) {
            return (User) userList.get(0);
        }

        return null;
    }


    public Menu getMenuByAuthorization(String key) {
        List menuList = getHibernateTemplate().find("from " + Menu.class.getName() + " as menu where menu.key = ?", new Object[]{key});

        if (menuList.size() > 1) {
            throw new HibernateException("The authorized menu key isn't unique. But this should never get reality.");
        }

        if (menuList.size() == 1) {
            return (Menu) menuList.get(0);
        }

        return null;
    }
}