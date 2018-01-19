package common;


/**
 * Created by hechengjin on 17-8-2.
 */
public class ErrorMessage {
    private Integer code;
    private String result;

    public ErrorMessage() {
    }

    public ErrorMessage(Integer code, String result) {
        this.code = code;
        this.result = result;
    }

    public Integer getCode() {
        return code;
    }

    public ErrorMessage setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getResult() {
        return result;
    }

    public ErrorMessage setResult(String result) {
        this.result = result;
        return this;
    }


    public static ErrorMessage create(Integer code, String result) {
        if (code == null || code < 0) {
            throw new IllegalArgumentException("errorCode must greater than 0");
        }
        if (result == null) {
            throw new IllegalArgumentException("errorMsg can not be empty");
        }
        return new ErrorMessage(code, result);
    }
}
