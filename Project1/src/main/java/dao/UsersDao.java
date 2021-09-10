package dao;

import models.User;

public interface UsersDao {
    User insertUser(User user);
    User getUser(String username);
    String getPassword(Integer userId);
}
