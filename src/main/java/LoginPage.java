import com.aventstack.extentreports.Status;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;


// Declaring the CheckoutPage class, which extends the BasePage class.
// By extending BasePage, CheckoutPage inherits the WebDriver instance and the PageFactory initialization.
public class LoginPage extends BasePage {

    // Declaring a public WebDriverWait variable named 'wait'.
    // WebDriverWait is used for implementing explicit waits during interactions with web elements.
    public WebDriverWait wait;

    public SoftAssert softAssert;

    // Constructor for the CheckoutPage class that takes a WebDriver object as an argument.
    // This constructor calls the parent class (BasePage) constructor to initialize the WebDriver instance
    // and sets up the PageFactory to initialize the web elements on this page.
    public LoginPage(WebDriver driver) {
        // Calling the parent class (BasePage) constructor using 'super' to initialize the WebDriver.
        super(driver);

        // Initializing the WebDriverWait object with a 10-second timeout.
        // This will be used to wait for certain conditions or elements during test execution.
        wait = new WebDriverWait(driver, 10);
        softAssert = new SoftAssert();
    }

    // Locating the search bar element using the @FindBy annotation.
    // @FindBy is a Selenium annotation that helps locate elements on the web page.
    // Here, the element is being located by its 'id' attribute with the value "input-search".
    // Declare the WebElement as private to enforce encapsulation
    // This ensures that 'searchBar' cannot be accessed directly from outside this class
    @FindBy(id = "input-search")
    private WebElement searchBar;

    // A public method to set a value in the search bar.
    // This method interacts with the searchBar element and sends the text "mouse" to it.
    // Public method to interact with the private 'searchBar' element
    // Provides controlled access to the encapsulated WebElement
    public void setSearchBar(String search) {
        // Typing the word "mouse" into the search bar.
        searchBar.sendKeys(search);
    }

    // Locating the search button element using the @FindBy annotation.
    // The element is being located by its CSS selector, which identifies elements based on their classes.
    // Here, the button has the classes "btn", "btn-light", and "btn-sm".


    @FindBy(linkText = "Autentificare")
    private WebElement loginIcon;

    public void clickLoginIcon() {
        loginIcon.click();
    }

    @FindBy(name = "email")
    private WebElement userNameField;

    public void setUserNameField(String name) {
        userNameField.sendKeys(name);
    }

    public WebElement getUserNameField() {
        return userNameField;
    }

    @FindBy(name = "password")
    private WebElement passwordField;

    public void setPasswordField(String password) {
        passwordField.sendKeys(password);
    }

    @FindBy(xpath = "//button[text()='Autentificare']")
    private WebElement loginButton;

    public void clickLoginButton() {
        loginButton.click();
    }

    @FindBy(xpath = "//h1[text()='Dashboard']")
    private WebElement dashboard;

    public WebElement getDashboard() {
        return dashboard;
    }

    @FindBy(xpath = "//label[text()='Cod de verificare']")
    private WebElement codVerificare;

    public WebElement getCodVerificare() {
        return codVerificare;
    }

    @FindBy(xpath = "//div[text()='Invalid email']")
    private WebElement errorEmail;

    public WebElement getErrorEmail() {
        return errorEmail;
    }

    @FindBy(xpath = "//div[text()='String must contain at least 8 character(s)']")
    private WebElement errorPassword;

    public WebElement getErrorPassword() {
        return errorPassword;
    }

    @FindBy(xpath = "//span[@data-sentry-element='Avatar']")
    private WebElement avatarIcon;

    public void clickAvatarIcon() {
        avatarIcon.click();
    }

    @FindBy(xpath = "//div[text()='Ieşi din cont']")
    private WebElement iesiDinContButton;

    public void clickIesiCont() {
        iesiDinContButton.click();
    }

    @FindBy(xpath = "//p[text()='ulicigeta+1@gmail.com']")
    private WebElement emailConfirmation;

    public WebElement getEmailConfirmation() {
        return emailConfirmation;
    }

    @FindBy(xpath = "//div[text()='Ceva nu a mers bine']")
    private WebElement cevaNuAMersBine;

    public WebElement getCevaNuAMersBine() {
        return cevaNuAMersBine;
    }

    @FindBy(xpath = "(//button[@name='day' and text()='1'])[1]")
    private WebElement day1;

    public void clickDay1() {
        day1.click();
    }

    @FindBy(xpath = "(//button[@name='day' and text()='3'])[1]")
    private WebElement day3;

    public void clickDay3() {
        day3.click();
    }

    @FindBy(id = "date")
    private WebElement datePicker;

    public void clickDate() {
        datePicker.click();
    }

    public WebElement date() {
        return datePicker;
    }

    @FindBy(linkText = "Nu aveți un cont? Înregistrați-vă aici")
    private WebElement authenticateIcon;

    public void clickAuthenticateIcon() {
        authenticateIcon.click();
    }

    @FindBy(name = "firstName")
    private WebElement nameField;

    public void setNameField(String name) {
        nameField.sendKeys(name);
    }

    @FindBy(name = "email")
    private WebElement emailField;

    public void setEmailField(String email) {
        emailField.sendKeys(email);
    }

    @FindBy(name = "password")
    private WebElement passField;

    public void setPassField(String pass) {
        passField.sendKeys(pass);
    }

    @FindBy(xpath = "//button[text()='Creați contul']")
    private WebElement creatiContButton;

    public void clickCreatiContButton() {
        creatiContButton.click();
    }

    @FindBy(name = "previous-month")
    private WebElement previousMonthButton;

    public void clickPreviousMonthButton() {
        previousMonthButton.click();
    }

    @FindBy(linkText = "Locații")
    private WebElement locatiiIcon;

    public void clickLocatiiIcon() {
        locatiiIcon.click();
    }

    public WebElement getLocatiiIcon() {
        return locatiiIcon;
    }

    @FindBy(linkText = "Creați locație")
    private WebElement creatiLocatieIcon;

    public void clickCreatiLocatieIcon() {
        creatiLocatieIcon.click();
    }

    public WebElement getCreatiLocatieIcon() {
        return creatiLocatieIcon;
    }

    @FindBy(name = "name")
    private WebElement nameLocatieField;

    public void setNameLocatieField(String setName) {
        nameLocatieField.sendKeys(setName);
    }

    public WebElement getNameLocatieField() {
        return nameLocatieField;
    }

    public WebElement getNameLocatie() {
        return nameLocatieField;
    }

    @FindBy(name = "address")
    private WebElement adressLocatieField;

    public void setAdressLocatieField(String setAdress) {
        adressLocatieField.sendKeys(setAdress);
    }

    @FindBy(name = "city")
    private WebElement cityLocatieField;

    public void setCityLocatieField(String setCity) {
        cityLocatieField.sendKeys(setCity);
    }

    @FindBy(name = "postcode")
    private WebElement codeLocatieField;

    public void setCodeLocatieField(String post) {
        codeLocatieField.sendKeys(post);
    }

    @FindBy( xpath = "//button[contains(text(), 'Creați locația')]")
    private WebElement creatiLocatiaButton;

    public void clickCreatiLocatiaButton() {
        creatiLocatiaButton.click();
    }

    public WebElement getCreatiLocatiaButton() {
        return creatiLocatiaButton;
    }

    @FindBy(xpath = "//h1[text()='Autentificare']")
    public WebElement autentificareText;

    public WebElement getAutentificareText() {
        return autentificareText;
    }

    @FindBy(xpath = "//button[text()='Șterge filtru']")
    private WebElement stergeFiltruButton;

    public void clickStergeFiltruButton() {
        stergeFiltruButton.click();
    }

    @FindBy(xpath = "//span[text()='Pick a date']")
    private WebElement pickADate;

    public WebElement getPickADate() {
        return pickADate;
    }

    @FindBy(linkText = "Meniu")
    private WebElement meniuButton;

   public void clickMeniuButton() {
       meniuButton.click();
   }

   public WebElement getMeniuButton() {
       return meniuButton;
   }


   @FindBy(xpath = "//button[text()='Creați meniu']")
   private WebElement creatiMeniuButton;

   public void clickCreatiMeniuButton() {
       creatiMeniuButton.click();
   }

   public WebElement getCreatiMeniuButton() {
       return creatiMeniuButton;
   }

   @FindBy(name = "name")
   private WebElement numeMeniu;

   public void setNumeMeniu(String name) {
       numeMeniu.sendKeys(name);
   }

   public WebElement getNumeMeniu() {
       return numeMeniu;
   }

    @FindBy(id = "description")
    private WebElement descriereMeniu;

    public void setDescriereMeniu() {
        descriereMeniu.sendKeys("Test");
    }

    public WebElement getDescriereMeniu() {
        return descriereMeniu;
    }

    @FindBy(xpath = "(//button[text()='Creați meniu'])[2]")
    private WebElement creatiMeniuFinalButtton;

    public void clickCreatiMeniuFinalButton() {
        creatiMeniuFinalButtton.click();
    }

    @FindBy(xpath = "//h1[text()='Meniul zilei']")
    private WebElement menuValidation;

    public WebElement getMenuValidation() {
        return menuValidation;
    }

    public WebElement getCreatiMeniuFinalButtton() {
        return creatiMeniuFinalButtton;
    }

    @FindBy(xpath = "//span[text()='Meniul zilei']")
    private WebElement meniulZilei;

    public void clickMeniulZilei() {
        meniulZilei.click();
    }

    public WebElement getMeniulZilei() {
        return meniulZilei;
    }

    @FindBy(xpath = "//button[text()='Categorie nouă']")
    private WebElement addCategorieNouaButton;

    public void clickAddCategorie() {
        addCategorieNouaButton.click();
    }
    public WebElement getAddCategorieNouaButton() {
        return addCategorieNouaButton;
    }

    @FindBy(name = "name")
    private WebElement nameCat;

    public void setNameCat(String name) {
        nameCat.sendKeys(name);
    }

@FindBy(xpath = "//textarea[@placeholder='ex: Antreuri']")
private WebElement descriptionCat;

    public void setDescriptionCat(String description) {
        descriptionCat.sendKeys(description);
    }

    public WebElement getDescriptionCat() {
        return descriptionCat;
    }

@FindBy(xpath = "//button[text()='Creați']")
private WebElement creatiCatButton;

    public void clickCreatiCatButton() {
        creatiCatButton.click();
    }

//    xpath = "(//button[@data-sentry-component='DeleteCategoryButton']([1]"
    @FindBy(css = ".lucide.lucide-trash.size-4.text-destructive")
    private WebElement deleteCategory;

    public void clickDeleteCat() {
        deleteCategory.click();
    }

    public WebElement getDeleteCategory() {
        return deleteCategory;
    }

    @FindBy(xpath = "//h2[text()= 'Antreuri']")
    private WebElement categoryConfirmation;

    public WebElement getCategoryConfirmation() {
        return categoryConfirmation;
    }

    @FindBy(xpath = "(//button[@type='button'])[3]")
    private WebElement editCatIcon;

    public void clickEditCatIcon() {
        editCatIcon.click();
    }

    public WebElement getEditCatIcon() {
        return editCatIcon;
    }
//name = "name"
    @FindBy(xpath = "//input[@name='name']")
    private WebElement editNameCat;

    public void deleteAndEditNameCat(String name) {
        wait.until(ExpectedConditions.elementToBeClickable(editNameCat));
        editNameCat.click();
        editNameCat.sendKeys(Keys.COMMAND + "a");
        editNameCat.sendKeys(Keys.BACK_SPACE);
        wait.until(ExpectedConditions.visibilityOf(editCatIcon));
        editNameCat.sendKeys(name);
    }

    @FindBy(xpath = "//textarea[@name='description']")
    private WebElement editDescriptionCat;

    public void setEditDescriptionCat(String des) {
        wait.until(ExpectedConditions.elementToBeClickable(editDescriptionCat));
        editDescriptionCat.click();
        editDescriptionCat.sendKeys(Keys.COMMAND + "a");
        editDescriptionCat.sendKeys(Keys.BACK_SPACE);
        wait.until(ExpectedConditions.visibilityOf(editDescriptionCat));
        editDescriptionCat.sendKeys(des);
    }

    public WebElement getEditDescriptionCat() {
        return editDescriptionCat;
    }

    @FindBy(xpath = "//button[text()='Salvați']")
    private WebElement saveEditCat;

    public void clickSaveEditCat() {
        saveEditCat.click();
    }

    public WebElement getSaveEditCat() {
        return saveEditCat;
    }

    @FindBy(css = ".text-lg.font-semibold")
    private WebElement editCatConfirmation;

    public WebElement getEditCatConfirmation() {
        return editCatConfirmation;
    }

    @FindBy(linkText= "Produse")
    private WebElement produseIcon;

    public void clickProduseIcon() {
        produseIcon.click();
    }

    public WebElement getProduseIcon() {
        return produseIcon;
    }

    @FindBy(xpath = "//a[text()='Adaugă produs']")
    private WebElement adaugaProdusButton;

    public WebElement getAdaugaProdusButton() {
        return adaugaProdusButton;
    }

    @FindBy (name = "name")
    private WebElement nameProduct;

    public void setNameProduct(String name) {
        nameProduct.sendKeys(name);
    }

    public WebElement getNameProduct() {
        return nameProduct;
    }
//    "(//button[@type='button' and @role='combobox' and @aria-invalid='false'])[1]"
    @FindBy(xpath = "//button[@role='combobox']")
    private WebElement categoryDropdown;

    public void clickCategoryDropdown() {
        categoryDropdown.click();
    }

    public WebElement getCategoryDropdown() {
       return categoryDropdown;
    }

    @FindBy(xpath = "//span[text()='test']")
    private WebElement optionDropdown;

    public void clickOptionDropdown() {
        optionDropdown.click();
    }

    public WebElement getOptionDropdown() {
        return optionDropdown;
    }

    public void selectCategoryDropdown() {
        categoryDropdown.click();
        wait.until(ExpectedConditions.visibilityOf(optionDropdown));
        optionDropdown.click();
    }


    @FindBy(xpath = "//span[text()='Diverse']")
    private WebElement diverseCat;

    public void clickDiverseCat() {
        diverseCat.click();
    }

    public WebElement getDiverseCat() {
        return diverseCat;
    }

    @FindBy(xpath = "(//button[@role='combobox'])[2]")
    private WebElement tipProdus;

    public WebElement getTipProdus() {
        return tipProdus;
    }

    public void selectTipProdusDrop() {
        tipProdus.click();
        wait.until(ExpectedConditions.visibilityOf(alteleTypeProduct));
        alteleTypeProduct.click();
    }

    @FindBy(xpath = "//span[text()='Altele']")
    private WebElement alteleTypeProduct;

    public WebElement getAlteleTypeProduct() {
        return alteleTypeProduct;
    }

    @FindBy(name = "price")
    private WebElement priceField;

    public void setPriceField(String price) {
        priceField.sendKeys(price);
    }

    public WebElement getPriceField() {
        return priceField;
    }

    @FindBy(xpath = "//button[text()='Creați produsul']")
    private WebElement creatiProdusulButton;

    public WebElement getCreatiProdusulButton() {
        return creatiProdusulButton;
    }

    @FindBy(xpath = "//h1[text()='Produse']")
    private WebElement confirmationProduse;

    public WebElement getConfirmationProduse() {
        return confirmationProduse;
    }

    @FindBy(xpath = "//span[text()='Seturi modificatori']")
    private WebElement seturiModificatoriIcon;

    public WebElement getSeturiModificatoriIcon() {
        return seturiModificatoriIcon;
    }

    @FindBy(xpath = "//button[text()='Creează un nou set']")
    private WebElement creeazaSetNou;

    public WebElement getCreeazaSetNou() {
        return creeazaSetNou;
    }

    @FindBy(name = "name")
    private WebElement numeModificator;

    public WebElement getNumeModificator() {
        return numeModificator;
    }

    public void setNumeModificator(String modif) {
        numeModificator.sendKeys(modif);
    }

    @FindBy(xpath = "//input[@placeholder='Selectati modificatorii']")
    private WebElement selectatiModificatoriiField;

    public WebElement getSelectatiModificatoriiField() {
        return selectatiModificatoriiField;
    }

    @FindBy (css = ".text-xl.font-semibold.leading-none.tracking-tight")
    private WebElement confirmationLocation;

    public WebElement getConfirmationLocation() {
        return confirmationLocation;
    }

    public void loginTest() {
        clickLoginIcon();
        wait.until(ExpectedConditions.visibilityOf(userNameField));
        setUserNameField("ulicigeta+1@gmail.com");
        setPasswordField("ParolaHaive1");
        clickLoginButton();
    }

    public void selectOption(WebElement element, String option) {
        Select optionSelect = new Select(element);
        optionSelect.selectByVisibleText(option);
    }

    public void NegativeLoginTest() {
        clickLoginIcon();
        wait.until(ExpectedConditions.visibilityOf(userNameField));
        setUserNameField("dino@dino.com");
        setPasswordField("choochoochooo");
        clickLoginButton();
    }

    public void clickWhenReady(WebElement locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    public void sendKeysWhenReady(WebElement locator, String text) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.sendKeys(text);
    }



}