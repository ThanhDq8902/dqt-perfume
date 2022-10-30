package controller;

import dao.RegisterDAO;
import entity.SecurityQuestion;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

public class SignupControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<SecurityQuestion> question = RegisterDAO.getQuestions();
        request.setAttribute("questions",question);
        request.getRequestDispatcher("signup.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String fullname = request.getParameter("fullname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String re_pass = request.getParameter("re-pass");
        String phone_num = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        int quesID = Integer.parseInt(request.getParameter("S_question"));
        String answer = request.getParameter("answer");
        
        if (!password.equals(re_pass)) {
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        }else{
            RegisterDAO.signup(fullname, username, password, phone_num,email,quesID,answer);
            response.sendRedirect("login.jsp");
        }
        
    }
}
