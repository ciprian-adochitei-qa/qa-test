package arnia;


import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertFalse;
//import src.main.java.arnia.ContactPO;

@RunWith(SerenityRunner.class)
public class FrontEndTest {

    @Managed
    WebDriver driver;

    @Test
    public void shouldInstantiateAWebDriverInstanceForAWebTest() {

        ContactPO contact = new ContactPO();

        contact.open();
        contact.waitUntilInputIsDisplayed();
        contact.enterName("Stefan");
        contact.enterEmail("email@yes.com");
        contact.enterPhone("0755555555");
        contact.enterMessage("very long message here...");
        contact.checkCaptcha();
        contact.submitForm();

        assertFalse(contact.isDisplayed());
    }
}