package com.baeldung.site.base;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.baeldung.config.GlobalConstants;
import com.baeldung.config.application.SeleniumConfig;
import com.google.common.util.concurrent.RateLimiter;

public abstract class BlogBaseDriver {

    @Autowired
    private SeleniumConfig seleniumConfig;

    @Autowired
    private RateLimiter rateLimiter;

    @Value("${base.url}")
    private String baseURL;

    protected String url;

    @PostConstruct
    public void setDriver() {
        this.seleniumConfig.getDriver();
    }

    public void loadUrl() {
        this.getWebDriver().get(this.url);
    }

    public void loadUrlWithThrottling() {
        rateLimiter.acquire();
        this.getWebDriver().get(this.url);
    }

    public void openNewWindow() {
        seleniumConfig.openNewWindow();
    }

    public void openNewWindowAndLoadPage() {
        this.openNewWindow();
        this.loadUrl();
    }

    public void closeWindow() {
        this.seleniumConfig.getDriver().close();
    }

    public void quiet() {
        if (null != this.seleniumConfig.getDriver()) {
            this.seleniumConfig.getDriver().quit();
        }

    }

    public String getTitle() {
        return this.seleniumConfig.getDriver().getTitle();
    }

    public WebDriver getWebDriver() {
        return seleniumConfig.getDriver();
    }

    public String getUrl() {
        return url;
    }

    protected abstract void setUrl(String url);

    public String getBaseURL() {
        return baseURL;
    }

    public boolean isLaunchFlag() {
        return Boolean.parseBoolean(System.getenv(GlobalConstants.LAUNCH_FLAG));
    }

    public WebElement findCategoriesContainerInPageFooter() {
        return this.getWebDriver().findElement(By.id("menu-categories"));
    }

    public void configureImplicitWait(long time, TimeUnit unit) {
        getWebDriver().manage().timeouts().implicitlyWait(time, unit);
    }

}
