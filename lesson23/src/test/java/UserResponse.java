import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

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

    public <T> T as(Class<T> responseClass) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(this);
            return mapper.readValue(json, responseClass);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}

