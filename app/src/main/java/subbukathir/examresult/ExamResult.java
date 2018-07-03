package subbukathir.examresult;

import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import subbukathir.examresult.asyncprocess.GetExamReport;
import subbukathir.examresult.interfaces.ExamReportListener;
import subbukathir.examresult.model.LastExam;
import subbukathir.examresult.model.Response;
import subbukathir.examresult.utils.AppUtils;

public class ExamResult extends AppCompatActivity implements ExamReportListener {
    private static final String TAG = ExamResult.class.getName();

    private LastExam mResponse;
    @BindView(R.id.llProgress)
    LinearLayout llProgress;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.nsvExamReport)
    NestedScrollView nsvExamReport;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tvExamName)
    TextView tvExamName;
    @BindView(R.id.tvTotalMark)
    TextView tvTotalMark;
    @BindView(R.id.tvCorrect)
    TextView tvCorrect;
    @BindView(R.id.tvWrong)
    TextView tvWrong;
    @BindView(R.id.tvSkipped)
    TextView tvSkipped;
    @BindView(R.id.btnPractiveTest)
    AppCompatButton btnPractiveTest;
    @BindView(R.id.tvExamDate)
    TextView tvExamDate;
    @BindView(R.id.tvExamDuration)
    TextView tvExamDuration;
    @BindView(R.id.tvStartTime)
    TextView tvStartTime;
    @BindView(R.id.tvEndTime)
    TextView tvEndTime;
    @BindView(R.id.tvMark)
    TextView tvMark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_result);
        ButterKnife.bind(this);

        setupToolbar();
        enableLoading();
        getData();

    }


    /**
     * ---------------------------------------------------------------------------------------------------------------------------
     * Private methods
     * ---------------------------------------------------------------------------------------------------------------------------
     */
    private void enableLoading() {
        llProgress.setVisibility(View.VISIBLE);
        nsvExamReport.setVisibility(View.GONE);
    }

    private void disableLoading() {
        llProgress.setVisibility(View.GONE);
        nsvExamReport.setVisibility(View.VISIBLE);
    }

    private void getData() {
        new GetExamReport(ExamResult.this, "", this).getExamReport();
    }

    private void setupToolbar() {
        this.setSupportActionBar(toolbar);
        this.getSupportActionBar().setTitle(R.string.lbl_exam_report);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        this.getSupportActionBar().setHomeAsUpIndicator(null);
    }

    private void bindData() {
        tvExamName.setText(mResponse.getExamName() + "");
        tvTotalMark.setText(String.format(getString(R.string.exam_result_total_mark), mResponse.getMark().toString()));

        tvCorrect.setText(String.format(getString(R.string.exam_result_correct),
                AppUtils.calculatePercentage(Double.parseDouble(mResponse.getTotalQuestions()), Double.parseDouble(mResponse.getExamCorrectAnswer()))));
        tvWrong.setText(String.format(getString(R.string.exam_result_wrong),
                AppUtils.calculatePercentage(Double.parseDouble(mResponse.getTotalQuestions()), Double.parseDouble(mResponse.getExamWrongAnswer()))));
        tvSkipped.setText(String.format(getString(R.string.exam_result_skipped),
                AppUtils.calculatePercentage(Double.parseDouble(mResponse.getTotalQuestions()), Double.parseDouble(mResponse.getExamSkippedAnswer()))));

        btnPractiveTest.setText(mResponse.getExamName());
        tvExamDate.setText(AppUtils.getExamDate(mResponse.getExamStartTime()));
        tvExamDuration.setText(AppUtils.getExamDuration(mResponse.getExamStartTime(), mResponse.getExamEndTime()));
        tvStartTime.setText(AppUtils.getExamTime(mResponse.getExamStartTime()));
        tvEndTime.setText(AppUtils.getExamTime(mResponse.getExamEndTime()));
        tvMark.setText(String.valueOf(mResponse.getMark()) + "%");
    }

    /**
     * ---------------------------------------------------------------------------------------------------------------------------
     * Implement methods
     * ---------------------------------------------------------------------------------------------------------------------------
     */

    @Override
    public void onDataReceivedSuccess(Response response) {
        disableLoading();
        this.mResponse = response.getData().getLastExam().get(0);
        bindData();
    }


    @Override
    public void onDataFailure(String strMsg) {
        Toast.makeText(this, strMsg, Toast.LENGTH_SHORT).show();
    }
}
