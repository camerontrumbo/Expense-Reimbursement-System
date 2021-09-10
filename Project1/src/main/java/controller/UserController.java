package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.bcel.internal.generic.ACONST_NULL;
import mail.Mail;
import models.Response;
import models.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

public class UserController extends HttpServlet {
    UserService userService = new UserService();

    public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        String requestBody = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        User user = new ObjectMapper().readValue(requestBody, User.class);
        User tempUser = userService.Login(user);
        if (tempUser != null) {
            HttpSession httpSession = req.getSession(true);
            httpSession.setAttribute("userObj", tempUser);
            out.println(new ObjectMapper().writeValueAsString(new Response("login successful", true, tempUser)));
        } else {
            out.println(new ObjectMapper().writeValueAsString(new Response("Incorrect Username or Password", false, null)));
        }
    }

    public void checkSession(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        User user = (User) req.getSession().getAttribute("userObj");

        if(user != null){
            out.println(new ObjectMapper().writeValueAsString(new Response("Session found", true, user)));
        }else{
            out.println(new ObjectMapper().writeValueAsString(new Response("No session", false, null)));
        }
    }

    public void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        req.getSession().setAttribute("userObj", null);

        out.println(new ObjectMapper().writeValueAsString(new Response("session terminated", true, null)));
    }

    public void register(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        String requestBody = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

        User tempUser = new ObjectMapper().readValue(requestBody, User.class);

        User pulledUser = userService.registerUser(tempUser);

        if (pulledUser != null) {
            //Sending mail to user
            Mail mail = new Mail();
            mail.sendMail(tempUser.getUserEmail(), tempUser.getErsUsername(), tempUser.getErsPassword());
            out.println(new ObjectMapper().writeValueAsString(new Response("New user has been created", true, pulledUser)));
        } else {
            out.println(new ObjectMapper().writeValueAsString(new Response("There is another user with that name", false, null)));
        }

    }
}
