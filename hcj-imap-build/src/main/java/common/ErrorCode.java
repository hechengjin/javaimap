package common;

/**
 * Created by hechengjin on 17-8-2.
 */
public final class ErrorCode {

    private static ErrorMessage addErrorMsg(Integer code, String result) {
        return ErrorMessage.create(code, result);
    }

    //success
    public static final ErrorMessage SUCCESS = addErrorMsg(0, "SUCCESS. ");

    //unknown
    public static final ErrorMessage UNKNOWN = addErrorMsg(100000, "Unknown error. ");

    //illegal argument
    public static final ErrorMessage ILLEGAL_ARGUMENT = addErrorMsg(200000, "Illegal Argument. ");

    //db error
    public static final ErrorMessage DB_ERROR = addErrorMsg(300000, "DB Error. ");

    //business
    public static final ErrorMessage BS_NOSUCHPROVIDEREXCEPTION = addErrorMsg(500000, "No Such Provider Exception. ");
    public static final ErrorMessage BS_MESSAGINGEXCEPTION = addErrorMsg(500001, "Messaging Exception. ");
    public static final ErrorMessage BS_AUTHENTICATIONFAILEDEXCEPTION = addErrorMsg(500002, " LOGIN Login error password error. ");

}
