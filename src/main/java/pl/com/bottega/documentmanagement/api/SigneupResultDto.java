package pl.com.bottega.documentmanagement.api;

/**
 * Created by arkadiuszarak on 18/06/2016.
 */
public class SigneupResultDto {

    private boolean success;
    private String failureReason;

    public SigneupResultDto(){
        success = true;
    }

    public SigneupResultDto(String failureReason){
        this.failureReason = failureReason;
        success = false;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }
}
