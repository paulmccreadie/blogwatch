blogwatch
=========

- three Maven profiles are available, "headless-browser-windows", "headless-browser-linux" and "ui-brower-windows" for running tests using Maven.
- for running JUnits test from IDE, we need to "spring.profiles.active" environment variable to either "headless-browse" and "ui-brower". "target.env" environment variable also should be set to "win" or "linux" for headless browser.
- headless browser is configured with phantomJS. Please download phantomjs.exe from  http://phantomjs.org/download.html ad copy it in the bin/win or bin/linux directory.
- ui browser has been configured with Firefox and tested with Firefox version 56.0 (64 bit) on windows 
- javascript message tests only work in headless browser as geckodriver is an implementation of W3C WebDriver which doesn�t specify a log interface at the moment, so this is expected behaviour.
	