import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;

// This annotation is used to specify that the ExtentTestNGITestListener class should be used to listen to the test events.
// The listener will generate reports based on the test results using the ExtentReports library.
@Listeners(ExtentTestNGITestListener.class)

// Declaring the CheckoutTest class, which extends the Hooks class.
// By extending Hooks, CheckoutTest inherits the setup and teardown methods for WebDriver.
public class LoginTest extends Hooks {

    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);
    // Declaring a public variable of type CheckoutPage named 'checkoutPage'.
    // This will be used to interact with the CheckoutPage object during the tests.
    public LoginPage loginPage;

    // Declaring a public variable of type WebDriverWait named 'wait'.
    // WebDriverWait is used to explicitly wait for certain conditions or elements during test execution.
    public WebDriverWait wait;

    public SoftAssert softAssert;

    // Method annotated with @BeforeMethod, indicating that it will run before each test method.
    // This method is used to set up the page objects and other necessary components before each test.
    @BeforeMethod
    public void SetupPageObject() {

        // Initializing the checkoutPage object with the current WebDriver instance.
        // This allows the test methods to interact with elements on the checkout page.
        loginPage = new LoginPage(driver);

        // Initializing the WebDriverWait object with the current WebDriver instance and a timeout of 30 seconds.
        // This wait will be used to pause the execution until certain conditions are met or elements are found.
        wait = new WebDriverWait(driver, 30);
        softAssert = new SoftAssert();
    }

    @Test(description = "Authenticating with a new user")
    public void authenticatingTest() throws InterruptedException {
        loginPage.clickLoginIcon();
        Thread.sleep(2000);
        loginPage.clickAuthenticateIcon();
        Thread.sleep(2000);
        loginPage.setNameField("Anca");
        Thread.sleep(2000);
        loginPage.setEmailField("ulicigeta+11@gmail.com");
        Thread.sleep(2000);
        loginPage.setPassField("ParolaHaive11");
        Thread.sleep(2000);
        loginPage.clickCreatiContButton();
        Thread.sleep(10000);
        assertEquals(loginPage.getCodVerificare().getText(), "Cod de verificare");
    }

    @Test(description = "Login with a user")
    public void loginTest() {
        loginPage.loginTest();
        wait.until(ExpectedConditions.visibilityOf(loginPage.getDashboard()));
        assertEquals(loginPage.getDashboard().getText(), "Dashboard", "The user is not logged in, the dashboard page wasn't displayed.");
        ExtentTestNGITestListener.getTest().log(Status.PASS, "The user is logged in, the Dashboard page is displayed");
    }

    @Test(description = "Logout with a user")
    public void logoutTest() {
        loginPage.loginTest();
        wait.until(ExpectedConditions.visibilityOf(loginPage.getDashboard()));
        assertEquals(loginPage.getDashboard().getText(), "Dashboard", "The user is not logged in, the dashboard page wasn't displayed.");
        ExtentTestNGITestListener.getTest().log(Status.PASS, "The user is logged in, the Dashboard page is displayed");
        loginPage.clickAvatarIcon();
        assertEquals(loginPage.getEmailConfirmation().getText(), "ulicigeta+1@gmail.com");
        loginPage.clickIesiCont();
        wait.until(ExpectedConditions.visibilityOf(loginPage.getAutentificareText()));
        assertEquals(loginPage.getAutentificareText().getText(), "Autentificare");
    }

    @Test(description = "Negative Login test")
    public void NegativeLoginTest() throws InterruptedException {
        loginPage.NegativeLoginTest();
        Thread.sleep(3000);
        assertEquals(loginPage.getCevaNuAMersBine().getText(), "Ceva nu a mers bine");
        ExtentTestNGITestListener.getTest().log(Status.PASS, "The user wasn't able to log in with an invalid email or password");
    }

    @Test(description = "Entering null or invalid email input")
    public void invalidEmailTest() {
        loginPage.clickLoginIcon();
        wait.until(ExpectedConditions.visibilityOf(loginPage.getUserNameField()));
        loginPage.setUserNameField("");
        loginPage.setPasswordField("Fasttrackit");
        loginPage.clickLoginButton();
        assertEquals(loginPage.getErrorEmail().getText(), "Invalid email", "The user succeeded the login, which is not the expected result.");
        ExtentTestNGITestListener.getTest().log(Status.PASS, "The user was unable to login, the Email field was empty or invalid, error message is displayed.");
    }

    @Test(description = "Entering null or invalid password input")
    public void invalidPasswordTest() {
        loginPage.clickLoginIcon();
        wait.until(ExpectedConditions.visibilityOf(loginPage.getUserNameField()));
        loginPage.setUserNameField("ulicicgeta+1@gmail.com");
        loginPage.setPasswordField("Fast");
        loginPage.clickLoginButton();
        assertEquals(loginPage.getErrorPassword().getText(), "String must contain at least 8 character(s)");
        ExtentTestNGITestListener.getTest().log(Status.PASS, "The user was unable to login, the Password field was empty or invalid, error message is displayed.");
    }

    @Test(description = "Select a date on the dashboard")
    public void pickDashboardDateTest() throws InterruptedException {
        loginPage.loginTest();
        ExtentTestNGITestListener.getTest().log(Status.PASS, "The user logged in successfully");
        loginPage.clickWhenReady(loginPage.date());
        loginPage.clickPreviousMonthButton();
        loginPage.clickDay1();
        loginPage.clickDay3();
        //assert
        //logs
    }

    @Test(description = "Delete selected date on the dashboard")
    public void deletetDashboardDateTest() throws InterruptedException {
        loginPage.loginTest();
        ExtentTestNGITestListener.getTest().log(Status.PASS, "The user logged in successfully");
        loginPage.clickWhenReady(loginPage.date());
        loginPage.clickPreviousMonthButton();
        loginPage.clickDay1();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The first day was selected.");
        loginPage.clickDay3();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The third day was selected.");
        loginPage.clickStergeFiltruButton();
        assertEquals(loginPage.getPickADate().getText(), "Pick a date");
        ExtentTestNGITestListener.getTest().log(Status.PASS, "The selected dates were deleted.");
    }

    @Test(description = "Creating a new location")
    public void locationTest() throws InterruptedException {
        loginPage.loginTest();
        ExtentTestNGITestListener.getTest().log(Status.PASS, "The user logged in successfully");
        Thread.sleep(3000);
        loginPage.clickWhenReady(loginPage.getLocatiiIcon());
        loginPage.clickWhenReady(loginPage.getCreatiLocatieIcon());
        loginPage.sendKeysWhenReady(loginPage.getNameLocatieField(), "New location");
        loginPage.setAdressLocatieField("Address");
        loginPage.setCityLocatieField("City");
        loginPage.setCodeLocatieField("123456");
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(580, 2800);");
        Thread.sleep(1000);
        loginPage.clickCreatiLocatiaButton();
        wait.until(ExpectedConditions.visibilityOf(loginPage.getConfirmationLocation()));
        Thread.sleep(3000);
        assertEquals(loginPage.getConfirmationLocation().getText(), "New location", "The location is not created, the new element is not displayed in the page");
       ExtentTestNGITestListener.getTest().log(Status.PASS, "A new location was successfully created.");
    }

    @Test(description = "Creating menu")
    public void createMenuTest() throws InterruptedException {
        loginPage.loginTest();
        ExtentTestNGITestListener.getTest().log(Status.PASS, "The user logged in successfully");
        Thread.sleep(3000);
        loginPage.clickWhenReady(loginPage.getMeniuButton());
        Thread.sleep(1000);
        loginPage.clickWhenReady(loginPage.getCreatiMeniuButton());
        loginPage.sendKeysWhenReady(loginPage.getNumeMeniu(), "Meniul zilei");
        loginPage.sendKeysWhenReady(loginPage.getDescriereMeniu(), "Description");
        wait.until(ExpectedConditions.visibilityOf(loginPage.getCreatiMeniuButton()));
        loginPage.clickWhenReady(loginPage.getCreatiMeniuFinalButtton());
        Assert.assertEquals(loginPage.getMenuValidation().getText(), "Meniul zilei", "The menu was not created successfully.");
        ExtentTestNGITestListener.getTest().log(Status.PASS, "The menu was created and displayed successfully.");
    }

    @Test(description = "Adding a category to the menu")
    public void addingCategoryToMenuTest() throws InterruptedException {
        loginPage.loginTest();
        loginPage.clickWhenReady(loginPage.getMeniuButton());
        loginPage.clickWhenReady(loginPage.getMeniulZilei());
        loginPage.clickWhenReady(loginPage.getAddCategorieNouaButton());
        loginPage.setNameCat("Antreuri");
        loginPage.sendKeysWhenReady(loginPage.getDescriptionCat(), "Cele mai delicioase");
        loginPage.clickCreatiCatButton();
        wait.until(ExpectedConditions.visibilityOf(loginPage.getCategoryConfirmation()));
        Assert.assertEquals(loginPage.getCategoryConfirmation().getText(), "Antreuri (0)", "The category is not displayed on the page.");
        ExtentTestNGITestListener.getTest().log(Status.PASS,"The category was added successfully.");
    }

    @Test(description = "Removing a category from menu")
    public void removingCatfromMenu() throws InterruptedException {
        loginPage.loginTest();
        loginPage.clickWhenReady(loginPage.getMeniuButton());
        loginPage.clickWhenReady(loginPage.getMeniulZilei());
        loginPage.clickWhenReady(loginPage.getDeleteCategory());
        Thread.sleep(5000);
        try {
            if (loginPage.getCategoryConfirmation().isDisplayed()) {
                Assert.fail("Element is still present, the category is not removed.");
            }
        } catch (NoSuchElementException e) {
            ExtentTestNGITestListener.getTest().log(Status.PASS, "The category was removed successfully.");
            Assert.assertTrue(true, "Element is not present as expected");
        }

    }

    @Test(description = "Editing Category of the menu")
    public void editCatTest() throws InterruptedException {
        loginPage.loginTest();
        loginPage.clickWhenReady(loginPage.getMeniuButton());
        loginPage.clickWhenReady(loginPage.getMeniulZilei());
        loginPage.clickWhenReady(loginPage.getEditCatIcon());
        loginPage.deleteAndEditNameCat("test");
        loginPage.setEditDescriptionCat("Minunata");
        loginPage.clickWhenReady(loginPage.getSaveEditCat());
        wait.until(ExpectedConditions.visibilityOf(loginPage.getEditCatConfirmation()));
        Assert.assertEquals(loginPage.getEditCatConfirmation().getText(), "test (0)", "The category was not successfully edited.");
        ExtentTestNGITestListener.getTest().log(Status.PASS,"The category was successfully edited.");
    }

    @Test(description = "Creating products")
    public void creatingProductsTest() throws InterruptedException {
        loginPage.loginTest();
        loginPage.clickWhenReady(loginPage.getProduseIcon());
        loginPage.clickWhenReady(loginPage.getAdaugaProdusButton());
        wait.until(ExpectedConditions.visibilityOf(loginPage.getNameProduct()));
        loginPage.setNameProduct("Macaroane");
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(521, 1042);");
        Thread.sleep(1000);
        loginPage.selectCategoryDropdown();
        loginPage.selectTipProdusDrop();
        wait.until(ExpectedConditions.visibilityOf(loginPage.getPriceField()));
        loginPage.setPriceField("20");
        loginPage.clickWhenReady(loginPage.getCreatiProdusulButton());
        wait.until(ExpectedConditions.visibilityOf(loginPage.getConfirmationProduse()));
        Assert.assertEquals(loginPage.getConfirmationProduse().getText(), "Produse", "Produse page is not displayed.");
        ExtentTestNGITestListener.getTest().log(Status.PASS, "The product has been created and it's displayed on the products page.");
    }

    @Test(description = "Creating Set modificatori test")
    public void createSetModificatoriTest() throws InterruptedException {
        System.out.println(System.getenv("URL"));
        loginPage.loginTest();
        loginPage.clickWhenReady(loginPage.getSeturiModificatoriIcon());
        loginPage.clickWhenReady(loginPage.getCreeazaSetNou());
        wait.until(ExpectedConditions.visibilityOf(loginPage.getNumeModificator()));
        loginPage.setNumeModificator("Deserturi");
        loginPage.clickWhenReady(loginPage.getSelectatiModificatoriiField());


    }

}



