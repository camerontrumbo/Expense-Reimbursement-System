package service;

import dao.UsersDao;
import dao.UsersDaoImpl;
import models.User;

public class UserService {
    UsersDao userDao;

    public UserService() { userDao = UsersDaoImpl.getInstance(); }

    public User registerUser(User user) {
        User tempUser = userDao.getUser(user.getErsUsername());

        if (tempUser == null) {
            userDao.insertUser(user);
            return userDao.getUser(user.getErsUsername());
        }

        return null;
    }

    public User Login(User user) {
        if (user == null)
            return null;

        User tempUser = userDao.getUser(user.getErsUsername());

        if (tempUser == null)
            return null;

        if (!tempUser.getErsPassword().equals(user.getErsPassword())) {
            return null;
        }

        return tempUser;
    }
}
