<!DOCTYPE html>
<html lang="en">
<head>
    <title>Registration</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        <jsp:include page="style/style.jsp"></jsp:include>
    </style>
</head>
<body>
    <header class="header">
            <h2 class="header-title"><%= application.getInitParameter("AppName") %></h2>
    </header>

    <div class="login-form">
        <h2>Signup</h2>

        <form action="registration" method="post">
            <div class="container">
                <label for="username"><b>Username</b></label>
                <input type="text" placeholder="Enter Username" name="username" required>

                <label for="password"><b>Password</b></label>
                <input type="password" placeholder="Enter Password" name="password" required>

                <label for="confirmPassword"><b>confirmPassword</b></label>
                <input type="password" placeholder="Confirm Password" name="confirmPassword" required>

                <button type="submit">Signup</button>
            </div>

            <div class="container">
                <span class="psw">Have an account? <a href="./login">Login</a></span>
                <span class="psw">Forgot <a href="#">password?</a></span>
            </div>
        </form>
    </div>
</body>
</html>