package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Reimbursement;
import models.Response;
import service.ReimbursementService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

public class ReimbController extends HttpServlet {
    ReimbursementService reimbursementService = new ReimbursementService();
    public void getAllReimb(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        out.println(new ObjectMapper().writeValueAsString(new Response("Reimbursements retrieved", true, reimbursementService.getAllReimb())));
    }

    public void denyReimb(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        Integer reimbId = Integer.parseInt(req.getParameter("id"));
        Integer managerId = Integer.parseInt(req.getParameter("managerId"));

        reimbursementService.denyReimb(reimbId, managerId);

        out.println(new ObjectMapper().writeValueAsString(new Response("Reimbursement Denied", true, null)));
    }

    public void approveReimb(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        Integer reimbId = Integer.parseInt(req.getParameter("id"));
        Integer managerId = Integer.parseInt(req.getParameter("managerId"));

        reimbursementService.approveReimb(reimbId, managerId);

        out.println(new ObjectMapper().writeValueAsString(new Response("Reimbursement approved", true, null)));
    }

    public void listEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        Integer employeeId = Integer.parseInt(req.getParameter("id"));

        out.println(new ObjectMapper().writeValueAsString(new Response("Reimbursements Retrieved", true,
                reimbursementService.getAllReimbGivenId(employeeId))));
    }

    public void createReimbursement(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        String reqBody = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

        Reimbursement reimbursement = new ObjectMapper().readValue(reqBody, Reimbursement.class);

        System.out.println(reimbursement.toString());
        try {
            reimbursementService.createReimb(reimbursement);
        } catch (Exception e) {
            e.printStackTrace();
        }

        out.println(new ObjectMapper().writeValueAsString(new Response("Reimbursement created", true, null)));
    }
}
