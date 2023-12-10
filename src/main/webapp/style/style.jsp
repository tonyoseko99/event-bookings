/* Common Styles for Login and Registration Pages */
body {
    font-family: 'Arial', sans-serif;
    background-color: #f0f0f0;
    margin: 0;
    padding: 0;
}

.header {
    background-color: #333;
    color: white;
    padding: 20px;
    text-align: center;
}

.header-title {
    margin: 0;
}

.login-form {
    width: 300px;
    margin: 50px auto;
    background-color: #fff;
    padding: 20px;
    box-shadow: 0px 0px 10px 0px rgba(0, 0, 0, 0.1);
}

.container {
    display: flex;
    flex-direction: column;
}

label {
    margin-bottom: 8px;
}

input {
    padding: 8px;
    margin-bottom: 16px;
    border: 1px solid #ccc;
    border-radius: 4px;
}

button {
    background-color: #333;
    color: white;
    padding: 10px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

button:hover {
    background-color: #555;
}

.psw {
    margin-top: 16px;
    font-size: 14px;
}

/* Styles specific to the Login Page */
.login-form h2 {
    color: #333;
}

/* Styles specific to the Registration Page */
.signup-form h2 {
    color: #333;
}

.nav {
    background-color: #333;
    color: white;
    padding: 10px;
    text-align: center;
}

.nav a {
    color: white;
    text-decoration: none;
    padding: 10px;
    margin: 0 5px;
}

.nav a:hover {
    background-color: #555;
}

.content {
    margin: 20px;
    padding: 20px;
    background-color: #fff;
    box-shadow: 0px 0px 10px 0px rgba(0, 0, 0, 0.1);
}

/* Media Query for Responsive Design */
@media (max-width: 600px) {
    .nav a {
        display: block;
        width: 100%;
        text-align: center;
    }
}

/* Toolbar Styles */
.topnav {
    background-color: #333;
    overflow: hidden;
    color: white;
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 10px;
}

.left {
    display: flex;
    align-items: center;
}

.left a {
    color: white;
    text-decoration: none;
    padding: 14px 16px;
    display: inline-block;
}

.left a:hover {
    background-color: #555;
}

.dropdown {
    display: inline-block;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}

.dropdown-content select {
    width: 100%;
    padding: 8px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

.dropdown:hover .dropdown-content {
    display: block;
}

.right a {
    color: white;
    text-decoration: none;
    padding: 14px 16px;
    display: inline-block;
}

.right a:hover {
    background-color: #555;
}

/* Styles for Add Event Button */
.add-event {
    text-align: center;
    margin-bottom: 20px;
}

.add-event-btn {
    display: inline-block;
    background-color: #4CAF50;
    color: white;
    padding: 10px 20px;
    text-decoration: none;
    border-radius: 4px;
    transition: background-color 0.3s ease;
}

.add-event-btn:hover {
    background-color: #45a049;
}

/* Styles for Add Event Button */
.add-event {
    text-align: right;
    margin: 20px;
}

.add-event-btn {
    background-color: #4CAF50;
    color: white;
    padding: 10px 20px;
    text-decoration: none;
    border-radius: 4px;
    transition: background-color 0.3s ease;
}

.add-event-btn:hover {
    background-color: #45a049;
}

/* Styles for Event Cards */
.event-cards {
    display: flex;
    flex-direction: column;
    align-items: center;
}

.event-card {
    width: 70%; /* Adjust the width as needed */
    box-sizing: border-box;
    border: 1px solid #ccc;
    border-radius: 4px;
    overflow: hidden;
    margin-bottom: 20px;
    transition: box-shadow 0.3s ease;
}

.event-card:hover {
    box-shadow: 0px 0px 10px 0px rgba(0, 0, 0, 0.1);
}

.event-card-content {
    display: flex;
}

.event-image {
    width: 40%; /* Adjust the width of the image */
    height: auto;
}

.event-details {
    padding: 16px;
    width: 60%; /* Adjust the width of the content */
}

.event-title {
    font-size: 18px;
    margin-bottom: 8px;
}

.event-description {
    color: #555;
}

.event-info {
    list-style: none;
    padding: 0;
    margin: 0;
}

.event-label {
    font-weight: bold;
}

.rsvp-btn {
    margin-top: 16px;
}

.view-event-btn,
.rsvp-event-btn {
    background-color: #333;
    color: white;
    padding: 8px 16px;
    text-decoration: none;
    border-radius: 4px;
    transition: background-color 0.3s ease;
    margin-right: 8px;
}

.view-event-btn:hover,
.rsvp-event-btn:hover {
    background-color: #555;
}

/* Styles for Form */
.add-form {
    max-width: 400px;
    margin: auto;
}

h3 {
    text-align: center;
    color: #333;
}

form {
    background-color: #fff;
    padding: 20px;
    box-shadow: 0px 0px 10px 0px rgba(0, 0, 0, 0.1);
    border-radius: 4px;
}

.label-container {
    display: flex;
    align-items: center;
    margin-bottom: 8px;
}

label {
    font-weight: bold;
    margin-right: 10px;
}

.required-mark {
    color: red;
}

input,
select {
    width: 100%;
    padding: 8px;
    margin-bottom: 16px;
    box-sizing: border-box;
    border: 1px solid #ccc;
    border-radius: 4px;
}

input[type="submit"] {
    background-color: #333;
    color: white;
    padding: 10px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

input[type="submit"]:hover {
    background-color: #555;
}


