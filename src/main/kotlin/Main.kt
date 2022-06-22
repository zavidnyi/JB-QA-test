package com.my.application

import org.openqa.selenium.By
import org.openqa.selenium.WebDriverException
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeDriverService
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.service.DriverService
import java.io.FileOutputStream


fun main(args: Array<String>){

    // disable Selenium logs
    java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(java.util.logging.Level.SEVERE);

    if (args.isEmpty()) {
        println("No website given!")
        return
    }

    // Disables chrome-driver logs
    val serviceBuilder = ChromeDriverService.Builder()
    val chromeDriverService = serviceBuilder.build()
    chromeDriverService.sendOutputTo(java.io.OutputStream.nullOutputStream())

    val driver = ChromeDriver(chromeDriverService,ChromeOptions().addArguments("--headless"))
    try {
        driver.get(args[0])

        println("Number of 'div' tags at ${args[0]}: ${driver.findElements(By.tagName("div")).size}")
    } catch (e: WebDriverException) {
        println("Connection failed!\nMake sure that URL is correct!")
    }

    driver.quit()
}

