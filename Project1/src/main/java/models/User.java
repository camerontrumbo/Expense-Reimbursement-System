package models;

public class User {
    private Integer ersUsersId;
    private String ersUsername;
    private String ersPassword;
    private String userFirstname;
    private String userLastName;
    private String userEmail;
    private Integer userRoleId;

    public User() {

    }

    public User(String userName, String password) {
        this.ersUsername = userName;
        this.ersPassword = password;
    }

    public User(Integer ersUsersId, String ersUsername, String ersPassword, String userFirstname, String userLastName,
                String userEmail, Integer userRoleId) {
        this.ersUsersId = ersUsersId;
        this.ersUsername = ersUsername;
        this.ersPassword = ersPassword;
        this.userFirstname = userFirstname;
        this.userLastName = userLastName;
        this.userEmail = userEmail;
        this.userRoleId = userRoleId;
    }

    public Integer getErsUsersId() {
        return ersUsersId;
    }

    public void setErsUsersId(Integer ersUsersId) {
        this.ersUsersId = ersUsersId;
    }

    public String getErsUsername() {
        return ersUsername;
    }

    public void setErsUsername(String ersUsername) {
        this.ersUsername = ersUsername;
    }

    public String getErsPassword() {
        return ersPassword;
    }

    public void setErsPassword(String ersPassword) {
        this.ersPassword = ersPassword;
    }

    public String getUserFirstname() {
        return userFirstname;
    }

    public void setUserFirstname(String userFirstname) {
        this.userFirstname = userFirstname;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    @Override
    public String toString() {
        return "User{" +
                "ersUsersId=" + ersUsersId +
                ", ersUsername='" + ersUsername + '\'' +
                ", ersPassword='" + ersPassword + '\'' +
                ", userFirstname='" + userFirstname + '\'' +
                ", userLastName='" + userLastName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userRoleId=" + userRoleId +
                '}';
    }
}
