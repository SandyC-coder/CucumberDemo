package hooks;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Base.BaseTest;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class Hooks {

    @Before
    public void setUpBrowser() {
        // Launch the browser
        BaseTest.setUp();
        System.out.println("Browser launched before scenario");
    }

    @After
    public void tearDownBrowser(Scenario scenario) {
        // Check if the scenario failed
        if (scenario.isFailed()) {
            try {
                // Ensure screenshots folder exists
                File folder = new File("target/screenshots");
                if (!folder.exists()) {
                    folder.mkdir();
                }

                // Take screenshot
                File src = ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.FILE);

                // Generate a unique file name based on scenario name
                String fileName = "target/screenshots/" + scenario.getName().replaceAll(" ", "_") + ".png";

                // Copy the screenshot to the target folder
                FileUtils.copyFile(src, new File(fileName));

                System.out.println("Screenshot taken: " + fileName);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Close the browser for all scenarios
        BaseTest.tearDown();
        System.out.println("Browser closed after scenario");
    }
}