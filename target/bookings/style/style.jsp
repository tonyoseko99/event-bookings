<style>

body{
    margin: 0;
    padding: 0;
    font-family: sans-serif;
    background-color: #f8f9fa;
}

.container{
    width: 100%;
    padding: 20px;
    background-color: #fff;
    box-shadow: 0px 0px 10px 0px rgba(0, 0, 0, 0.1);
    overflow-x: hidden;
    overflow-y: auto;
}

.topnav {
    background-color: #333;
    overflow: hidden;
    width: 100%;
    position: fixed;
    top: 0;
    z-index: 1;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    align-items: center;
    padding: 20px;
    margin-bottom: 150px;

}

.topnav .left {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    align-items: center;
    margin-x: 20px;
}

.topnav a{
    color: #f2f2f2;
    text-decoration: none;
    font-size: 17px;
    margin-left: 20px;
}

.topnav a:hover {
    background-color: #ddd;
    color: black;
}


.topnav a.active {
    background-color: #4CAF50;
    color: white;
}

/* CSS Styles for Event Cards */
/* CSS Styles for Event Cards */
.event-card {
    display: flex;
    flex-direction: column;
    width: 60%; /* Adjust width as needed */
    margin: 20px;
    padding: 20px;
    border: 2px solid #ccc;
    border-radius: 10px;
    box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.2);
}

.event-card .event-item {
    display: flex;
    flex-direction: row;
    align-items: center;
    width: 70%;
}

.event-item .event-image {
    flex: 0 0 150px; /* Width of the image */
    margin-right: 20px;
    border-radius: 5px;
}

.event-item .event-details {
    flex: 1;
}

.event-item .event-title {
    font-size: 22px;
    margin-bottom: 10px;
}

.event-item .event-description {
    font-size: 16px;
    line-height: 1.5;
}

.event-item .event-info {
    list-style: none;
    margin: 0;
    padding: 0;
}

.event-item .event-label {
    font-weight: bold;
    margin-right: 10px;
}

.event-item .event-btn {
    display: inline-block;
    padding: 10px 20px;
    background-color: #007bff;
    color: white;
    border: none;
    border-radius: 5px;
    text-decoration: none;
    cursor: pointer;
}


.add-event-form{
  width: 100%;
  padding: 20px;
  background-color: #fff;
  box-shadow: 0px 0px 10px 0px rgba(0, 0, 0, 0.1);
}

.add-event-form input{
  width: 100%;
  padding: 10px;
  border: 1px solid #ddd;
  border-radius: 5px;
  margin-bottom: 10px;
}

.add-event-form h2{
  text-align: center;
  color: #007BFF;
  margin-bottom: 20px;
}

.add-event-form button{
  width: 100%;
  padding: 10px;
  background-color: #007BFF;
  border: none;
  border-radius: 5px;
  color: #fff;
  cursor: pointer;
}

.add-event-form button:hover{
  background-color: #0056b3;
}

.add-event-form label{
  display: block;
  margin-bottom: 5px;
}


.login-form {
    width: auto;
    margin: 0 auto;
    padding: 30px;
    background-color: #fff;
    box-shadow: 0px 0px 20px 0px rgba(0, 0, 0, 0.1);
}

.login-form h2 {
    text-align: center;
    color: #007BFF;
    margin-bottom: 20px;
}

.container {
    margin-bottom: 20px;
}

.container label {
    display: block;
    margin-bottom: 5px;
}

.container input {
    width: 100%;
    padding: 10px;
    border: 1px solid #ddd;
    border-radius: 5px;
    margin-bottom: 10px;
}

.container button {
    width: 100%;
    padding: 10px;
    background-color: #007BFF;
    border: none;
    border-radius: 5px;
    color: #fff;
    cursor: pointer;
}

.container button:hover {
    background-color: #0056b3;
}

.psw {
    display: block;
    color: #888;
    text-align: center;
}

.psw a {
    color: #007BFF;
}

.psw a:hover {
    color: #0056b3;
}






</style>
