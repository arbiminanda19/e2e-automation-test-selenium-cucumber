package test.pages;

import org.openqa.selenium.By;

public class PageDashboard {

    By txt_storeName = By.xpath("//dd[contains(text(),'hai')]//preceding-sibling::dt");

    public By getTxt_storeName() {
        return txt_storeName;
    }
}
