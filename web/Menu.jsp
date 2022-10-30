<%-- 
    Document   : Menu.jsp
    Created on : Oct 27, 2022, 4:35:32 PM
    Author     : mrT
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar">
  <div class="container nav">
    <a href="Home" class="logo">
      <img src="img/logo.jpg" alt="" />
      <p>Q.Thanh</p>
    </a>

    <form action="search" method="post" >
      <div class="search">
        <svg
          xmlns="http://www.w3.org/2000/svg"
          fill="none"
          viewBox="0 0 24 24"
          stroke-width="1.5"
          stroke="currentColor"
          class="w-6 h-6"
          >
          <path
            stroke-linecap="round"
            stroke-linejoin="round"
            d="M21 21l-5.197-5.197m0 0A7.5 7.5 0 105.196 5.196a7.5 7.5 0 0010.607 10.607z"
            />
        </svg>
        <input value="${txt}"type="text" id="search" name="Search" placeholder="Search" />
      </div>
    </form>

    <div class="menu" style="display: flex; align-items: center;">
      <c:if test="${sessionScope.acc == null}">
        <a href="./login"><b>Login</b></a>
        <a href="./signup"><b>Sign up</b></a>
      </c:if>
      <c:if test="${sessionScope.acc != null}">
        <c:if test="${sessionScope.acc.isAdmin == 0}">
          <a href=""><b>Cart</b></a>
        </c:if>
        <c:if test="${sessionScope.acc.isAdmin == 1}">
          <a href="manager"><b>Manage</b></a>
        </c:if>
        <a href="./logout" style="display: flex;">
          <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" style="width: 3rem; height: 3rem;">
            <path stroke-linecap="round" stroke-linejoin="round" d="M17.982 18.725A7.488 7.488 0 0012 15.75a7.488 7.488 0 00-5.982 2.975m11.963 0a9 9 0 10-11.963 0m11.963 0A8.966 8.966 0 0112 21a8.966 8.966 0 01-5.982-2.275M15 9.75a3 3 0 11-6 0 3 3 0 016 0z" />
          </svg>
        </a>
        <a href="./logout"><b>Logout</b></a>
      </c:if>
    </div>
  </div>
</nav>

