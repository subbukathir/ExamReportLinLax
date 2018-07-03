package subbukathir.examresult.asyncprocess;

import android.content.Context;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import subbukathir.examresult.interfaces.ExamReportListener;
import subbukathir.examresult.model.Response;
import subbukathir.examresult.network.ApiClient;
import subbukathir.examresult.network.ApiInterface;

/**
 * Created by subbu on 04-07-2018.
 */

public class GetExamReport {
    private static final String TAG = GetExamReport.class.getSimpleName();
    private Context mContext;
    private ExamReportListener mCallback;
    private String strRequest="";

    private Response mResponse;

    private ApiInterface mInterface;
    private Call<Response> callLanguages;

    public GetExamReport(Context context, String strReq,ExamReportListener listener){

        this.mContext = context;
        this.mCallback = listener;
        this.strRequest = strReq;
        mInterface = ApiClient.getClient().create(ApiInterface.class);
        callLanguages = mInterface.getExamReport();
    }

    public void getExamReport(){
        Log.e(TAG,"getExamReport");
        try {
            callLanguages.enqueue(new Callback<Response>() {
                @Override
                public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                    if(response.isSuccessful()){
                        mResponse = response.body();
                        if(mResponse.getStatus()){
                            Log.e(TAG,"failed "+ mResponse.getMessage());
                            mCallback.onDataReceivedSuccess(mResponse);
                        }else {
                            Log.e(TAG,"failed "+ mResponse.getMessage());
                            mCallback.onDataFailure(mResponse.getMessage());
                        }
                    }
                    else{
                        Log.e(TAG,"isNotsuccess");
                        mCallback.onDataFailure(response.message());
                    }
                }

                @Override
                public void onFailure(Call<Response> call, Throwable t) {
                    Log.e(TAG,"isNotsuccess");
                    mCallback.onDataFailure(t.getMessage());
                }
            });
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
