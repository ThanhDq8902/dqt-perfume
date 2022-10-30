/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.RegisterDAO;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author mrT
 */
public class LoginControl extends HttpServlet {

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    Cookie[] c = request.getCookies();
    if (c != null) {
      for (Cookie cookie : c) {
        if (cookie.getName().equals("username")) {
          request.setAttribute("username", cookie.getValue());
        }
        if (cookie.getName().equals("password")) {
          request.setAttribute("password", cookie.getValue());
        }
      }
    }
    request.getRequestDispatcher("login.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    if (request.getAttribute("error") != null) {
      request.getRequestDispatcher("login.jsp").forward(request, response);
      return;
    }
    request.setCharacterEncoding("UTF-8");
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String remember = request.getParameter("remember");
    User user = RegisterDAO.login(username, password);
    if (user != null) {
      HttpSession session = request.getSession();
      session.setAttribute("acc", user);
      if (remember != null) {
        Cookie cu = new Cookie("username", username);
        Cookie cp = new Cookie("password", password);
        response.addCookie(cu);
        response.addCookie(cp);
      } else {
        Cookie[] cookies = request.getCookies();
        for (int i = 0; i < cookies.length; i++) {
          cookies[i].setMaxAge(0);
        }
      }
      response.sendRedirect("Home");
    } else {
      request.setAttribute("error", "Username or password is incorrect!");
      request.getRequestDispatcher("login").forward(request, response);
    }
  }
}
