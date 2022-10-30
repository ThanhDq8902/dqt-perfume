<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.tailwindcss.com"></script>
    <link rel="icon" type="image/png" href="image/favicon.png" />
    <title>Login | @prometheusalpha</title>
  </head>

  <body class="bg-gray-800 text-white flex justify-center items-center h-screen font-['Inter']">
    <div class="w-full sm:w-[500px] text-center bg-gray-700 p-10 rounded-3xl">
      <h1 class="text-6xl font-bold my-6">Login</h1>
      <div class="">
        <div class="">
          <form id="Login" class="flex flex-col" action="login" method="POST">
            <input type="text" 
                   class="bg-gray-600 p-4 my-4 focus:outline-none focus:ring-2 focus:ring-blue-600 rounded-3xl"
                   id="inputUserName" placeholder="Username" autocomplete="off" name="username">
            <input type="password" 
                   class="bg-gray-600 p-4 my-4 focus:outline-none focus:ring-2 focus:ring-blue-600 rounded-3xl"
                   id="inputPassword" placeholder="Password" name="password">
            <div class="text-red-500 mb-3" id="error">${requestScope.error}</div>

            <div class="text-xl">
              New here? <a class="text-blue-500 font-semibold" href="signup.html">Sign Up</a>
            </div>
            <button type="submit" class="text-2xl font-semibold bg-blue-600 p-4 my-4 rounded-3xl">Login</button>
          </form>
        </div>
      </div>
    </div>
  </body>

</html>
