package test.helper;

import test.controller.ElementController;
import test.data.ValidUserData;
import test.pages.PageLogin;

public class LoginHelper {

    public static void Login(ElementController elementController, PageLogin pageLogin, ValidUserData validUserData) {

        // input credential for login
        elementController.typeText(pageLogin.getInput_email(), validUserData.getEmail());
        elementController.typeText(pageLogin.getInput_pass(), validUserData.getPassword());

        // click login
        elementController.click(pageLogin.getBtn_submitLogin());
    }

}
