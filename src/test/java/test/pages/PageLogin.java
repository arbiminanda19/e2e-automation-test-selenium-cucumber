package test.pages;

import org.openqa.selenium.By;

public class PageLogin {

    By input_email = By.id("email");
    By input_pass = By.id("password");
    By btn_submitLogin = By.xpath("//button[@type='submit'][contains(text(),'login')]");
    By alert_wrongCred = By.xpath("//div[@role='alert'][contains(text(),'Kredensial')][contains(text(),'salah')]");

    public By getInput_email() {
        return input_email;
    }

    public By getInput_pass() {
        return input_pass;
    }

    public By getBtn_submitLogin() {
        return btn_submitLogin;
    }

    public By getAlert_wrongCred() {
        return alert_wrongCred;
    }
}
