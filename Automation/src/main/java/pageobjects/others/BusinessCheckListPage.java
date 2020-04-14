package pageobjects.others;

	import pageobjects.AbstractBasePageObject;
	import org.junit.Assert;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;

	/**
	 * Class representing Business Checklist Page in CRC application.
	 * Methods Load() and isLoaded() has to be implemented in a way that it represent the actual behaviour in real application.
	 */
	public class BusinessCheckListPage extends AbstractBasePageObject<BusinessCheckListPage> {

	    private static final Logger logger = LoggerFactory.getLogger(BusinessCheckListPage.class);

	    private static final String relativeUrl = "/home";

	    public BusinessCheckListPage(WebDriver driver, WebDriverWait wait, String url) {
	        super(driver, wait, url);
	        setRelativeUrl(relativeUrl);
	        logger.debug("Instantiating page objects for " + getClass().getName());
	    }

	    @Override
	    protected void load() {
	        logger.warn(getClass().getSimpleName() + " was not loaded, attempting to load it now");
	        navigate_and_wait();
	    }

	    @Override
	    public void isLoaded() throws Error {
	        String url = getDriver().getCurrentUrl();
	        Assert.assertTrue("Not on the business checklist page: " + url, url.endsWith(relativeUrl));
	        logger.warn(getClass().getSimpleName() + " was loaded successfully");
	    }
	}
