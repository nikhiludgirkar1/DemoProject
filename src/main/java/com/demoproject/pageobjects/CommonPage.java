package com.demoproject.pageobjects;//package com.orangehrm.pageobjects;
//
//import java.lang.invoke.MethodHandles;
//
//import com.orangehrm.helper.api.OrangeConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import com.microsoft.playwright.Locator;
//import com.microsoft.playwright.Page;
//import com.microsoft.playwright.options.WaitForSelectorState;
//import com.socotra.helper.api.SupConstants;
//import com.socotra.pageobjects.pages.CommonLocators;
//
//public class CommonPage {
//    private Page page;
//
//    private CommonLocators commonLocators;
//    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
//
//    public CommonPage(Page page) {
//        this.page = page;
//        this.commonLocators = new CommonLocators(page);
//    }
//
//    public Locator getIdLocator(String id) {
//        return new CommonLocators(page).getIdLocator(id);
//    }
//
//    public void clickTab(String tabName) {
//        page.locator(commonLocators.getElementByRoleAndText("tab", tabName)).click();
//    }
//
//    public void getHeaderText(String headerText) {
//    }
//
//    public boolean isSelectorVisible(String selector) {
//        return isSelectorVisible(selector, SupConstants.PROPERTIES_CONFIG.maxElementTimeOutInSec() * 1000);
//    }
//
//    public boolean isSelectorVisible(String selector, double timeout) {
//        try {
//            page.waitForSelector(selector, new Page.WaitForSelectorOptions().setTimeout(timeout));
//            return page.locator(selector).isVisible();
//        } catch (Exception e) {
//            logger.debug("Exception occured while waiting for selector :: {}", e.getMessage());
//            return false;
//        }
//    }
//
//    public boolean isSelectorNotVisible(String selector) {
//        return isSelectorNotVisible(selector, OrangeConstants.PROPERTIES_CONFIG.mediumWaitInMillis());
//    }
//
//    public boolean isSelectorNotVisible(String selector, double timeout) {
//        try {
//            page.waitForSelector(selector,
//                    new Page.WaitForSelectorOptions().setState(WaitForSelectorState.DETACHED).setTimeout(timeout));
//            return page.locator(selector).isHidden();
//        } catch (Exception e) {
//            return false;
//        }
//    }
//}