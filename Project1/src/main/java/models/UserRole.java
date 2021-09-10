package models;

public class UserRole {
    private Integer ersUserRoleId;
    private String userRole;

    public UserRole(Integer ersUserRoleId, String userRole) {
        this.ersUserRoleId = ersUserRoleId;
        this.userRole = userRole;
    }

    public Integer getErsUserRoleId() {
        return ersUserRoleId;
    }

    public void setErsUserRoleId(Integer ersUserRoleId) {
        this.ersUserRoleId = ersUserRoleId;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "ersUserRoleId=" + ersUserRoleId +
                ", userRole='" + userRole + '\'' +
                '}';
    }
}
