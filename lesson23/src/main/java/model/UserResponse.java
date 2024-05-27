package model;

public class UserResponse {

    private int code;
    private String type;
    private String message;
    private String contentType;

    public int getCode() {
        return code;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public String getContentType() {
        return contentType;
    }

    @Override
    public String toString() {
        return "model.UserResponse{" +
                "code=" + code +
                ", type='" + type + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}

