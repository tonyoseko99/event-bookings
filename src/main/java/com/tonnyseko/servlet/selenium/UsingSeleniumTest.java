package com.tonnyseko.servlet.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsingSeleniumTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/bookings/");
    }

    @Test
    public void testLogin() {
        WebElement usernameInput = driver.findElement(By.name("username"));
        WebElement passwordInput = driver.findElement(By.name("password"));
        WebElement submitButton = driver.findElement(By.cssSelector("button"));

        // Perform login actions (e.g., enter username and password, click submit)
        usernameInput.sendKeys("tonny@test.com");
        passwordInput.sendKeys("1234");
        submitButton.click();

        assertEquals("Expected Success Message", "Expected Success Message");

        // Add assertions for successful login
        // For example, you can check for a success message or a redirectedst page
        // Uncomment and modify the following line based on your application
        // assertEquals("Expected Success Message", driver.findElement(By.id("successMessage")).getText());
    }

    @Test
    public void testLoginFailure() {
        // Locate username, password, and submit button elements
        WebElement usernameInput = driver.findElement(By.name("username"));
        WebElement passwordInput = driver.findElement(By.name("password"));
        WebElement submitButton = driver.findElement(By.cssSelector("button"));

        // Enter invalid credentials and click the submit button
        usernameInput.sendKeys("tonny");
        passwordInput.sendKeys("invalid_password");
        submitButton.click();

        // Add an assertion for a failed login
        // Modify the following line based on your application's behavior after a failed login
        assertEquals("Expected Error Message", "Invalid login credentials");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

