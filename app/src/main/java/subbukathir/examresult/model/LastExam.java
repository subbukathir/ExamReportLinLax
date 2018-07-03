package subbukathir.examresult.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by subbu on 04-07-2018.
 */

public class LastExam {
    @SerializedName("exam_name")
    private String examName;
    @SerializedName("total_questions")
    private String totalQuestions;
    @SerializedName("exam_duration")
    private String examDuration;
    @SerializedName("exam_prdfn_id")
    private String examPrdfnId;
    @SerializedName("exam_id")
    private String examId;
    @SerializedName("exam_user_id")
    private String examUserId;
    @SerializedName("exam_correct_answer")
    private String examCorrectAnswer;
    @SerializedName("exam_wrong_answer")
    private String examWrongAnswer;
    @SerializedName("exam_skipped_answer")
    private String examSkippedAnswer;
    @SerializedName("exam_start_time")
    private String examStartTime;
    @SerializedName("exam_end_time")
    private String examEndTime;
    @SerializedName("mark")
    private Integer mark;

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(String totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public String getExamDuration() {
        return examDuration;
    }

    public void setExamDuration(String examDuration) {
        this.examDuration = examDuration;
    }

    public String getExamPrdfnId() {
        return examPrdfnId;
    }

    public void setExamPrdfnId(String examPrdfnId) {
        this.examPrdfnId = examPrdfnId;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public String getExamUserId() {
        return examUserId;
    }

    public void setExamUserId(String examUserId) {
        this.examUserId = examUserId;
    }

    public String getExamCorrectAnswer() {
        return examCorrectAnswer;
    }

    public void setExamCorrectAnswer(String examCorrectAnswer) {
        this.examCorrectAnswer = examCorrectAnswer;
    }

    public String getExamWrongAnswer() {
        return examWrongAnswer;
    }

    public void setExamWrongAnswer(String examWrongAnswer) {
        this.examWrongAnswer = examWrongAnswer;
    }

    public String getExamSkippedAnswer() {
        return examSkippedAnswer;
    }

    public void setExamSkippedAnswer(String examSkippedAnswer) {
        this.examSkippedAnswer = examSkippedAnswer;
    }

    public String getExamStartTime() {
        return examStartTime;
    }

    public void setExamStartTime(String examStartTime) {
        this.examStartTime = examStartTime;
    }

    public String getExamEndTime() {
        return examEndTime;
    }

    public void setExamEndTime(String examEndTime) {
        this.examEndTime = examEndTime;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }
}
