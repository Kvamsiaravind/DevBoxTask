package dependencyinjection;

import exceptions.InvalidBrowserException;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.io.IOException;

import static drivers.BrowserLauncher.getBrowserDriver;


public class Hooks extends DependencyInjection {

    private DependencyInjection dependencyInjection;

    public Hooks(DependencyInjection dependencyInjection) {
        this.dependencyInjection = dependencyInjection;
    }

    @Before
    public void setUp() throws InvalidBrowserException, IOException {

        dependencyInjection.setDriver(getBrowserDriver());

        dependencyInjection.initializePageObjects();

        dependencyInjection.getDriver().manage().window().maximize();
    }

    @After
    public void tearDown() {
        if (dependencyInjection.getDriver() != null) {
            dependencyInjection.getDriver().quit();
        }
    }
}
