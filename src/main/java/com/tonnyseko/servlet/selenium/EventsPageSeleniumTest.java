package com.tonnyseko.servlet.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EventsPageSeleniumTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        // Set up the WebDriver before each test
        driver = new ChromeDriver();
        driver.get("http://localhost:3000/events");
    }

    @Test
    public void testSearchEvents() {
        // Locate the search input field and the search button
        WebElement searchInput = driver.findElement(By.id("search"));
        WebElement searchButton = driver.findElement(By.xpath("//button[contains(text(),'Search')]"));

        // Type a search query
        searchInput.sendKeys("Technology");

        // Click the search button
        searchButton.click();

        // Add assertions based on the expected results after searching
        // For example, you can check if the filtered events are displayed correctly
        // Uncomment and modify the following line based on your application
        // assertEquals("Expected Result", driver.findElement(By.id("result")).getText());
    }

    @Test
    public void testSortByCategory() {
        // Locate the category dropdown
        WebElement categoryDropdown = driver.findElement(By.tagName("select"));

        // Select a category from the dropdown
        // For example, selecting "Technology"
        categoryDropdown.sendKeys("Technology");

        // Add assertions based on the expected results after sorting by category
        // Uncomment and modify the following line based on your application
        // assertEquals("Expected Result", driver.findElement(By.id("result")).getText());
    }

    @Test
    public void testAddEventButton() {
        // Check if the "Add Event" button is displayed based on user role
        WebElement addEventButton = driver.findElement(By.xpath("//button[contains(text(),'Add Event')]"));

        // Add assertions based on the expected behavior for the "Add Event" button
        // Uncomment and modify the following line based on your application
        // assertEquals("Expected Result", driver.findElement(By.id("result")).getText());
    }

    @AfterEach
    public void tearDown() {
        // Clean up after each test
        if (driver != null) {
            driver.quit();
        }
    }
}

