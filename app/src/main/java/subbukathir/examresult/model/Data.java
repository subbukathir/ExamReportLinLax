package subbukathir.examresult.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by subbu on 04-07-2018.
 */

public class Data {

    @SerializedName("last_exam")
    private List<LastExam> lastExam = null;

    public List<LastExam> getLastExam() {
        return lastExam;
    }

    public void setLastExam(List<LastExam> lastExam) {
        this.lastExam = lastExam;
    }

}
