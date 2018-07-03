package subbukathir.examresult.network;


import retrofit2.Call;
import retrofit2.http.GET;
import subbukathir.examresult.model.Response;

/**
 * Created by subbu on 04-07-2018.
 */

public interface ApiInterface {
    @GET(ApiConstant.MAPI_SINGLE+ApiConstant.INDEX)
    Call<Response> getExamReport();
}
