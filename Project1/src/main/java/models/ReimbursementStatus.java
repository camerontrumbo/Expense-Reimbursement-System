package models;

public class ReimbursementStatus {
    private Integer reimbStatusId;
    private String reimbStatus;

    public ReimbursementStatus(Integer reimbStatusId, String reimbStatus) {
        this.reimbStatusId = reimbStatusId;
        this.reimbStatus = reimbStatus;
    }

    public Integer getReimbStatusId() {
        return reimbStatusId;
    }

    public void setReimbStatusId(Integer reimbStatusId) {
        this.reimbStatusId = reimbStatusId;
    }

    public String getReimbStatus() {
        return reimbStatus;
    }

    public void setReimbStatus(String reimbStatus) {
        this.reimbStatus = reimbStatus;
    }

    @Override
    public String toString() {
        return "ReimbursementStatus{" +
                "reimbStatusId=" + reimbStatusId +
                ", reimbStatus='" + reimbStatus + '\'' +
                '}';
    }
}
