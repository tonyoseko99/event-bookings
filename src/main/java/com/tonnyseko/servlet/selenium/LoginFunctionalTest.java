package com.tonnyseko.servlet.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginFunctionalTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        // Set up the WebDriver before each test
        driver = new ChromeDriver();
        driver.get("http://localhost:3000/bookings/");
    }

    @Test
    public void testLoginSuccess() {
        // Locate username, password, and submit button elements
        WebElement usernameInput = driver.findElement(By.name("username"));
        WebElement passwordInput = driver.findElement(By.name("password"));
        WebElement submitButton = driver.findElement(By.cssSelector("button"));

        // Enter valid credentials and click the submit button
        usernameInput.sendKeys("valid_username");
        passwordInput.sendKeys("valid_password");
        submitButton.click();

        // Add an assertion for successful login
        // Modify the following line based on your application's behavior after a successful login
        assertEquals("Expected Success Message", driver.findElement(By.id("successMessage")).getText());
    }

    @Test
    public void testLoginFailure() {
        // Locate username, password, and submit button elements
        WebElement usernameInput = driver.findElement(By.name("username"));
        WebElement passwordInput = driver.findElement(By.name("password"));
        WebElement submitButton = driver.findElement(By.cssSelector("button"));

        // Enter invalid credentials and click the submit button
        usernameInput.sendKeys("invalid_username");
        passwordInput.sendKeys("invalid_password");
        submitButton.click();

        // Add an assertion for a failed login
        // Modify the following line based on your application's behavior after a failed login
        assertEquals("Expected Error Message", driver.findElement(By.id("errorMessage")).getText());
    }

    @AfterEach
    public void tearDown() {
        // Clean up after each test
        if (driver != null) {
            driver.quit();
        }
    }
}
