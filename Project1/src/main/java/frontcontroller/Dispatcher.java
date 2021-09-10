package frontcontroller;

import controller.ReimbController;
import controller.UserController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="dispatcher", urlPatterns = "/api/*")
public class Dispatcher extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserController userController = new UserController();
        ReimbController reimbController = new ReimbController();
        String URI = req.getRequestURI();
        System.out.println(URI);

        switch (URI) {
            case "/api/login":
                if (req.getMethod().equals("POST"))
                    userController.login(req, resp);
                break;
            case "/api/register":
                if (req.getMethod().equals("POST"))
                    userController.register(req, resp);
                break;
            case "/api/checkSession":
                userController.checkSession(req, resp);
                break;
            case "/api/logout":
                userController.logout(req, resp);
                break;
            case "/api/listManager":
                switch (req.getMethod()) {
                    case "GET":
                        reimbController.getAllReimb(req, resp);
                        break;
                }
                break;
            case "/api/listEmployee":
                reimbController.listEmployee(req, resp);
                break;
            case "/api/approve":
                reimbController.approveReimb(req, resp);
                break;
            case "/api/deny":
                reimbController.denyReimb(req, resp);
                break;
            case "/api/createReimb":
                if (req.getMethod().equals("POST"))
                    reimbController.createReimbursement(req, resp);
                break;
        }
    }
}
