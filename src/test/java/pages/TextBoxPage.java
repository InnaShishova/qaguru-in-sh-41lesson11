package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {

    private final SelenideElement userNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submitButton = $("#submit"),
            checkName = $("#output #name"),
            checkEmail = $("#output #email"),
            checkCurrentAddress = $("#output #currentAddress"),
            checkPermanentAddress = $("#output #permanentAddress");

    public TextBoxPage openPage() {
        open("/text-box");
        $(".text-center").shouldHave(text("Text Box"));
        return this;
    }

    public TextBoxPage removeBanners() {
        executeJavaScript("document.querySelector('#fixedban')?.remove()");
        executeJavaScript("document.querySelector('footer')?.remove()");
        return this;
    }

    public TextBoxPage setFullName(String value) {
        userNameInput.setValue(value);
        return this;
    }

    public TextBoxPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public TextBoxPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        permanentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage submit() {
        submitButton.click();
        return this;
    }

    public TextBoxPage checkResult(String name,
                                   String email,
                                   String currentAddress,
                                   String permanentAddress) {

        checkName.shouldHave(text(name));
        checkEmail.shouldHave(text(email));
        checkCurrentAddress.shouldHave(text(currentAddress));
        checkPermanentAddress.shouldHave(text(permanentAddress));

        return this;
    }
}