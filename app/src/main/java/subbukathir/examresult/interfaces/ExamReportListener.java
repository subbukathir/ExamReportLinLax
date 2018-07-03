package subbukathir.examresult.interfaces;

import subbukathir.examresult.model.Response;

/**
 * Created by subbu on 04-07-2018.
 */

public interface ExamReportListener {
    void onDataReceivedSuccess(Response response);
    void onDataFailure(String strMsg);
}
