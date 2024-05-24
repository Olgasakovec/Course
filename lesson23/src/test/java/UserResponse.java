public class UserResponse {
    private int code;
    private String type;
    private String message;
    private int statusCode;
    private String contentType;

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "code=" + code +
                ", type='" + type + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getContentType() {
        return contentType;
    }

    public UserResponse as(Class<UserResponse> userResponseClass) {
        return this;
    }
}

