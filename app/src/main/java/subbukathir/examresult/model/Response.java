package subbukathir.examresult.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by subbu on 04-07-2018.
 */

public class Response {
    @SerializedName("data")
    private Data data;
    @SerializedName("status")
    private Boolean status;
    @SerializedName("message")
    private String message;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
