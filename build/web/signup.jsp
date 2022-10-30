<%-- 
    Document   : sigup
    Created on : Oct 28, 2022, 1:41:23 PM
    Author     : mrT
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.tailwindcss.com"></script>
    <link rel="icon" type="image/png" href="image/favicon.png" />
    <title>Signup | @prometheusalpha</title>
  </head>

  <body class="bg-gray-800 text-white flex justify-center items-center py-20 font-['Inter']">
    <div class="w-full sm:w-[500px] text-center bg-gray-700 p-10 rounded-3xl">
      <h1 class="text-6xl font-bold my-6">Sign up</h1>
      <div class="">
        <div class="">
          <form id="Signup" class="flex flex-col" action="signup" method="POST">
            <input type="text" autocomplete="off"
                   class="bg-gray-600 p-4 my-4 rounded-3xl focus:outline-none focus:ring-2 focus:ring-blue-600" id="inputName"
                   name="fullname" placeholder="Full Name">

            <input type="text" autocomplete="off"
                   class="bg-gray-600 p-4 my-4 rounded-3xl focus:outline-none focus:ring-2 focus:ring-blue-600" name="username"
                   id="inputUserName" placeholder="Username">
            <input type="password" autocomplete="off"
                   class="bg-gray-600 p-4 my-4 rounded-3xl focus:outline-none focus:ring-2 focus:ring-blue-600" name="password"
                   id="inputPassword" placeholder="Password">
            <input type="password" autocomplete="off"
                   class="bg-gray-600 p-4 my-4 rounded-3xl focus:outline-none focus:ring-2 focus:ring-blue-600" name="re-pass"
                   id="rePassword" placeholder="Re-Password">
            <div class="text-red-500 mb-3 hidden" id="error">Password must be at least 8 characters</div>
            <input type="text" autocomplete="off"
                   class="bg-gray-600 p-4 my-4 rounded-3xl focus:outline-none focus:ring-2 focus:ring-blue-600" id="phoneNumber"
                   name="phoneNumber" placeholder="Phone Number">
            <input type="text" autocomplete="off"
                   class="bg-gray-600 p-4 my-4 rounded-3xl focus:outline-none focus:ring-2 focus:ring-blue-600" id="email"
                   name="email" placeholder="Your-email">
            <select class="bg-gray-600 text-white p-4 my-4 rounded-3xl pr-5" name="S_question">
              <option value="0" selected="true" class="hidden">Choose a question</option>
              <c:forEach items="${questions}" var="o">
                <option value="${o.id}">${o.question} </option>
                
              </c:forEach>

            </select>
            <input type="text" name="answer" autocomplete="off" 
                   class="bg-gray-600 p-4 my-4 rounded-3xl focus:outline-none focus:ring-2 focus:ring-blue-600" id="inputName"
                   placeholder="Answer"/>
            <div class="text-xl">
              Already had an account ? <a class="text-blue-500 font-semibold" href="login">Log in</a>
            </div>
            <button type="submit" id="submit"
                    class="text-2xl font-semibold bg-blue-600 p-4 my-4 rounded-3xl disabled:bg-gray-600">Sign up</button>
          </form>
        </div>
      </div>
    </div>
    <script>
      document.querySelector("#inputPassword").addEventListener("keyup", function (event) {
        event.preventDefault();
        if (event.keyCode === 13) {
          document.querySelector("#Signup").submit();
        }
      });
      document.querySelector("#rePassword").addEventListener("input", function (event) {
        event.preventDefault();
        let password = document.querySelector("#inputPassword").value;
        if (password !== event.target.value) {
          document.querySelector("#error").style.display = "block";
          document.querySelector("#error").innerHTML = "Incorrect Re-Password";
        } else {
          document.querySelector("#error").style.display = "none";
        }
      });
    </script>
  </body>

</html>
