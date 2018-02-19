package Utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 *
 * @author teyyub
 */
public class SQLQuery {

    public static final String SAVE_DEPO = "{call hrm.saveDepo(?,?,?,?)}";

    public static final String UPDATE_DEPO = "{call hrm.updateDepo(?,?,?,?,?)}";
    public static final String DELETE_DEPO = "{call hrm.deleteDepo(?)}";

    public static final String DELETE_RESERVATION = "{call hrm.deleteReserv(?)}";

//    public static String GetCompletetServices = "{? =call hrm.getCompletetServices()}";
    public static final String UPDATE_EVENT_RESIZE = "{call hrm.updateEvent(?)}";

    public static final String GET_SERVICES_TYPE = "{? =call hrm.getServicetype()}";

    public static final String GET_SERVICE_BY_WORKER_ID = "{ ? =call hrm.getServiceByWorkerId(?)}";

    public static final String GET_DONE_SERVICE_BY_WORKER_ID = "{ ? =call hrm.getDoneServiceByWorkerId(?)}";

    public static final String SAVE_OPERATION = "{call hrm.saveOperation(?,?,?,?)}";

    public static final String SAVE_OPERATION_NEW = "{call hrm.saveOperation_new(?,?,?,?,?,?)}";

    public static final String SAVE_RULE = "{call botanika.save_rule(?)}";

    public static final String USER_RULE = "{call botanika.user_rule(?,?)}";

    public static final String UPDATE_USER_RULE = "{call botanika.update_userrule(?,?)}";

    public static final String SAVE_USER_MENU = "{call botanika.save_user_menu(?,?)}";

    public static final String GET_RULES = "{? = call botanika.getRules()}";

    public static final String GET_USER_RULES = "{? = call botanika.getUserRules(?)}";

    public static final String GET_USER_MENUS = "{? = call botanika.getUserMenus(?)}";

    public static final String DELETE_RULE = "{call botanika.delete_rule(?)}";

    public static final String DELETE_USER = "{call botanika.delete_User(?)}";

    public static final String SAVE_RESERV = "{call hrm.saveReserv(?,?,?,?,?)}";

    public static final String UPDATE_OPERATION = "{call hrm.updateOperation(?,?,?,?)}";

    public static final String endOperation = "{call hrm.endOperation(?,?)}";

    public static final String GET_LITERATURE = "{? = call botanika.getLiteratures()}";

    public static final String GET_COUNTRY = "{? = call botanika.getCountrys()}";

    public static final String GET_CONTINENT = "{? = call botanika.getContinents()}";

    public static final String GET_REGION = "{? = call botanika.getRegions()}";

    public static final String GET_VOUCHER = "{? = call botanika.getVoucher()}";

    public static final String GET_TYPE = "{? = call botanika.getType()}";

    public static final String GET_STATUS = "{? = call botanika.getStatus()}";

    public static final String GET_COLLECTION = "{? = call botanika.getCollection()}";

    public static final String GET_EPITHET = "{? = call botanika.getEpithet()}";

    public static final String GET_RANK = "{? = call botanika.getSpeciesRanks()}";

    public static final String GET_SOURCE = "{? = call botanika.getSources()}";

    public static final String GET_COLLECTORS = "{? = call botanika.getCollectors()}";

    public static final String GET_FIRST_COLLECTORS = "{? = call botanika.get_first_coll()}";

    public static final String GET_CATEGORYS = "{? = call botanika.getCategory()}";

    public static final String GET_GENUS = "{? = call botanika.getGenus()}";

    public static final String GET_SPECIMEN = "{? = call botanika.getSpecimen(?)}";

    public static final String GET_FAMILYS = "{? = call botanika.getFamily()}";

    public static final String GET_SERIES = "{? = call botanika.getSeries()}";

    public static final String GET_INSTITUTION = "{? = call botanika.getInstitution()}";

    public static final String SAVE_SERIE = "{ call botanika.save_combos(?,?,?)}";

    public static final String SAVE_VOUCHER = "{ call botanika.save_combos(?,?,?)}";

    public static final String SAVE_COLLECTOR = "{ call botanika.save_combos(?,?,?)}";

    public static final String SAVE_FIRST_COLLECTOR = "{ call botanika.save_first_coll(?,?)}";

    public static final String SAVE_FAMILY = "{ call botanika.save_family(?,?)}";

    public static final String SAVE_GENUS = "{ call botanika.save_genus(?,?,?,?,?,?,?,?,?)}";

    public static final String SAVE_TAXON = "{ call botanika.save_taxon(?,?,?,?,?)}";

    public static final String SAVE_TAXON_WITH_IDS = "{ call botanika.save_taxon(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

    public static final String SAVE_EPITHET = "{ call botanika.save_combos(?,?,?)}";

    public static final String SAVE_SPECIMEN = "{ call botanika.save_specimen(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

    public static final String UPDATE_EPITHET = "{ call botanika.update_combos(?,?,?,?)}";

    public static final String SAVE_MESSAGE = "{ call botanika.save_message(?,?)}";

    public static final String GET_CUSTOMER_BY_PARAM = "{? = call hrm.getClients(?,?)}";

    public static final String GET_CUSTOMER_BY_PARAM_FOR_OPERATION = "{? = call hrm.getClientForOperation(?,?)}";

    public static final String SAVE_LITERATURE = "{call botanika.save_literature(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

    public static final String SAVE_AUTHOR = "{call botanika.save_author(?,?)}";

    public static final String UPDATE_AUTHOR = "{call botanika.update_author(?,?,?)}";

    public static final String GET_AUTHORS = "{? = call botanika.getAuthors()}";

    public static final String SAVE_CLIENT = "{? = call hrm.saveClient(?,?,?,?,?,?)}";

    public static final String UPDATE_CLIENT = "{call hrm.updateClient(?,?,?,?,?,?,?)}";

    public static final String GetDepo = "{? = call hrm.getdepo()}";

    public static final String GET_WORKERS = "{? = call hrm.getWorkers()}";

    public static final String SEARCH_WORKER_BY_PARAM = "{? = call hrm.searchWorker1(?,?)}";

    public static final String GET_WORKER_STATISTIC = "{? =call hrm.getWorkersStatistic()}";

    public static final String GET_MESSAGES = "{? =call botanika.getUserMessages()}";

    public static final String GET_USERS = "{? =call botanika.getUsers()}";

    public static final String GetStatus = "{? = call hrm.getStatus()}";
    public static final String GET_OPERATIONS = "{? = call hrm.getOperationList()}";
    public static final String GET_OPERATIONS_BY_DATE = "{? = call hrm.getOperationListByDate(?)}";

    public static final String GET_RESERVATION = "{? = call hrm.getReservation()}";
    public static final String getReservationByWorkerId = "{? = call hrm.getReservation_by_worker_id(?)}";
    public static final String getClients = "{? = call hrm.getClients()}";

    public static final String GetCompOperationList = "{? = call hrm.getComOperationList()}";
//    public static final String GetMenuList = "{? = call hrm.getMenuList()}";

    public static final String GET_MENU_LIST = "{? = call botanika.getMenuList()}";

    public static final String GET_USER_MENU_LIST = "{? = call botanika.getUserMenuList(?)}";

    public static final String callSaveUser = "{call sec.newUser(?,?,?)}";

    public static final String SAVE_USER = "{call botanika.save_user(?,?)}";

//    public static final String GET_USERS = "{? = call hrm.getUsers()}";
    public static final String callAddEvent = "{call sec.addEvent(?,?,?,?)}";
    public static final String callPrizeByCode = "{? =call hrm.GetPriceByBarcode(?)}";

    public static final String getServiceByBarcode = "{? =call hrm.GetServiceByBarcode(?)}";
    public static final String SAVE_WORKS = "{call hrm.saveWorks(?,?,?)}";

    public static final String GetUserDailyEarn = "{ ? =call hrm.getUserDailyEarn(?)}";
    public static final String callFileSave = "{ ? =call hrm.getUserDailyEarn(?)}";
    public static final String getUserType = "select id from sec.userstype order by 1";
    public static final String checkPassword = "select s.id, s.name,s.password, s.type_id as type from sec.users s where s.email_address=?";
    public static final String adminPage = "admin.xhtml?faces-redirect=true";
    public static final String userPage = "users.xhtml";
    public static final String workerPage = "worker.xhtml?faces-redirect=true";
    public static final String errorPage = "error.xhtml?faces-redirect=true";
    public static final String events = "select * from sec.userschedule where active=1";
    public static final String checkUser = "{? =call botanika.checkUser(?,?)}";

    private static final String DATE_PATTERN = "dd.MM.yyyy";

    /**
     * The date formatter.
     */
    private static final DateTimeFormatter DATE_FORMATTER
            = DateTimeFormatter.ofPattern(DATE_PATTERN);
    private static Object DateUtil;

    /**
     * Returns the given date as a well formatted String. The above defined
     * {@link DateUtil#DATE_PATTERN} is used.
     *
     * @param date the date to be returned as a string
     * @return formatted string
     */
    public static String format(LocalDate date) {
        if (date == null) {
            return null;
        }
        return DATE_FORMATTER.format(date);
    }

    /**
     * Converts a String in the format of the defined
     * {@link DateUtil#DATE_PATTERN} to a {@link LocalDate} object.
     *
     * Returns null if the String could not be converted.
     *
     * @param dateString the date as String
     * @return the date object or null if it could not be converted
     */
    public static LocalDate parse(String dateString) {
        try {
            return DATE_FORMATTER.parse(dateString, LocalDate::from);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    /**
     * Checks the String whether it is a valid date.
     *
     * @param dateString
     * @return true if the String is a valid date
     */
    public static boolean validDate(String dateString) {
        // Try to parse the String.
        return  SQLQuery.parse(dateString) != null;
    }

}
