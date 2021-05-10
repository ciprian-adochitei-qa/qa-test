package arnia;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.internal.FindsById;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

@DefaultUrl("https://www.arnia.com/contact/")
public class ContactPO extends PageObject {

    public void waitUntilInputIsDisplayed() {
        new WebDriverWait(this.getDriver(),5).until(visibilityOfElementLocated(By.name("Name")));
    }
    public boolean isDisplayed() {
        WebElementFacade name = $(By.name("Name"));
        return name.isDisplayed();
    }
    public void enterName(String value) {
        WebElementFacade name = $(By.name("Name"));
        name.type(value);
    }
    public void enterEmail(String value) {
        WebElementFacade email = $(By.name("Email"));
        typeInto(email, value);
    }
    public void enterPhone(String value) {
        WebElementFacade phone = $(By.name("Phone"));
        typeInto(phone, value);
    }
    public void enterMessage(String value) {
        WebElementFacade project = $(By.name("Message"));
        typeInto(project, value);
    }
    public void checkCaptcha() {
        this.getDriver().switchTo().frame(1);
        WebElementFacade captcha = $(By.xpath("//span[@id=\"recaptcha-anchor\"]"));
        System.out.println(captcha);
        clickOn(captcha);
//        solve googleai captcha ?


//        System.out.println(this.getDriver());
//        JavascriptExecutor jse = (JavascriptExecutor) this.getDriver();
//        jse.executeScript("window.frames[3].querySelector('#recaptcha-anchor').setAttribute('class','recaptcha-checkbox goog-inline-block recaptcha-checkbox-unchecked rc-anchor-checkbox recaptcha-checkbox-checked')");
    }
    public void submitForm() {
        WebElementFacade submit = $(By.xpath("//button[@type=\"submit\"]"));
        clickOn(submit);
    }

}