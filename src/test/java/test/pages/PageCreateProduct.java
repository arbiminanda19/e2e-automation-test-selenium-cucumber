package test.pages;

import org.openqa.selenium.By;

public class PageCreateProduct {

    By txt_newProduct = By.xpath("//h2[contains(text(),'baru')]/a[@href='/products']");

    public By getTxt_newProduct() {
        return txt_newProduct;
    }
}
