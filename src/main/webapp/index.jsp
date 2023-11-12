<!DOCTYPE html>
<html>

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Registration</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <style>
    <jsp:include page="style/style.jsp"></jsp:include>
    </style>
</head>

<body>

    <header class="header">

            <h2 class="header-title"><%= application.getInitParameter("AppName") %></h2>

    </header>

    <div class="login-form">
        <h2>Login</h2>

        <form action="./login" method="post">

            <div class="container">
                <label for="username"><b>Username</b></label>
                <input type="text" placeholder="Enter Username" name="username" required>

                <label for="password"><b>Password</b></label>
                <input type="password" placeholder="Enter Password" name="password" required>

                <button type="submit">Login</button>
            </div>

            <div class="container">
                <span class="psw">New user? <a href="./registration">Register</a></span>
                <span class="psw">Forgot <a href="#">password?</a></span>
            </div>

        </form>
    </div>



</body>

</html>