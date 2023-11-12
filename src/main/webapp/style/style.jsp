<style>
    body {
      font-family: "Arial", sans-serif;
      background-color: #f2f2f2;
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }

    .header {
        background-color: #0077be;
        color: black;
        padding: 20px;
        text-align: center;
    }

    .header-title {
        color: white;
        font-size: 30px;
    }

    input[type="text"],
    input[type="password"] {
      width: 100%;
      padding: 12px 20px;
      margin: 8px 0;
      display: inline-block;
      border: 1px solid #ccc;
      border-radius: 4px;
      box-sizing: border-box;
    }

    button {
      background-color: #0077be;
      color: white;
      padding: 14px 20px;
      margin: 8px 0;
      border: none;
      border-radius: 4px;
      cursor: pointer;
      width: 100%;
    }

    button:hover {
      background-color: #005a8c;
    }

    .cancelbtn {
      padding: 10px 18px;
      background-color: #f44336;
    }

    .imgcontainer {
      text-align: center;
      margin: 24px 0 12px 0;
    }

    img.avatar {
      width: 100px;
      height: 100px;
      border-radius: 50%;
    }

    .container {
      background-color: #fff;
      padding: 16px;
      width: 50%;
      border-radius: 4px;
      margin: 0 auto;
      text-align: left;
    }

    h2 {
      color: #0077be;
      text-align: center;
    }

    span.psw {
      float: right;
      padding-top: 16px;
    }

    form {
      margin-top: 50px;
    }

    .login-form {
      display: block;
      margin: 0 auto;
      width: 50%;
    }

    /* Change styles for span and cancel button on extra small screens */
    @media screen and (max-width: 300px) {
      span.psw {
        float: none;
      }

      .cancelbtn {
        width: 100%;
      }
    }
</style>
