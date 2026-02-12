package computacion.marketplace.persistence.entity;

public class Response {
    private Integer code;
    private boolean success;
    private String message;

    public Response(Integer code, boolean success, String message) {
        this.code = code;
        this.success = success;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
