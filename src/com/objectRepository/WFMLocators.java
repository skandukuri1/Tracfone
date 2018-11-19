package com.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WFMLocators {

	public By activeLink = By.xpath("//*[@id='lnk_wfmhome_activate']");
	public By cntFamilyMobile =By.cssSelector("[id='btn_continuetracfonephone']");
	//public By cntFamilyMobile = By.xpath("//*[@id='btn_continuetracfonephone']");
	//public By txtSIMEntry = By.xpath("/html/body/tf-update-lang/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div/div[3]/form/div/div[2]/div[2]/div/div[2]/tf-textbox/div/div[1]/input");
	public By txtSIMEntry = By.xpath("//*[@id='tfvalesn-esn' and @class!='ng-isolate-scope']");
	//public By chkSIMConfirm = By.xpath("/html/body/tf-update-lang/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div/div[3]/form/div/div[2]/div[3]/div/div[2]/div/label");
	public By chkSIMConfirm = By.cssSelector("[class='tf-label-note tf-label-small']");
	public By cntSIMConfirm = By.xpath("//*[@id='btn_imeicontinue']/span");
	//public By txtSecurePIN = By.xpath("/html/body/div[1]/div/div/div/modal-popup/div[2]/div[2]/form/div[1]/tf-textbox/div/div/input");
	public By txtSecurePIN = By.xpath("//*[@id='updateSecPin-pin' and @class!='ng-isolate-scope']");
	//public By cntSecurePIN = By.xpath("/html/body/div[1]/div/div/div/modal-popup/div[2]/div[2]/form/div[2]/wfm-button-primary/span[1]/button");
	public By cntSecurePIN = By.xpath("//*[@id='updateSecPin_btn']/span");
	public By txtEnterZIP =  By.xpath("(//*[@id='zip'])[2]");
	//public By txtEnterZIP =  By.xpath("/html/body/tf-update-lang/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div/div[3]/tf-split-vertical-or/div/div[3]/div/tf-split-vertical-or-right/form/tf-icon-widget/div/div[1]/div/div/div[5]/tf-textbox/div/div/input");
	public By cntZIPCode = By.xpath("(//*[@id='btn_continuezipcode'])[1]");
	//public By cntZIPCode = By.xpath("/html/body/tf-update-lang/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div/div[3]/tf-split-vertical-or/div/div[3]/div/tf-split-vertical-or-right/form/tf-icon-widget/div/div[2]/div/div[2]/tf-button-primary/span[1]/button");
	public By txtPIN = By.xpath("(//*[@id='pinmin'])[2]");
	//public By txtPIN = By.xpath("/html/body/tf-update-lang/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div/div[3]/div[1]/div/div[1]/tf-split-vertical-or/div/div[1]/div/tf-split-vertical-or-left/form/tf-icon-widget/div/div[1]/div/div/div[5]/tf-textbox/div/div[1]/input");
	public By cntPIN = By.cssSelector("[id='airtimePinActivation_btn']");
	//public By cntPIN = By.xpath("/html/body/tf-update-lang/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div/div[3]/div[1]/div/div[1]/tf-split-vertical-or/div/div[1]/div/tf-split-vertical-or-left/form/tf-icon-widget/div/div[2]/div/div[2]/tf-button-primary/span[1]/button");
	public By btnCreateNewAccount = By.cssSelector("[id='btn_createaccount']");
	//public By btnCreateNewAccount = By.xpath("/html/body/tf-update-lang/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[1]/div[2]/div/div[2]/tf-icon-widget/div/div[2]/div/div[2]/tf-button-primary/span[2]/button");
	public By txtEmailID = By.xpath("(//*[@id='createacfm.user_email'])[2]");
	//public By txtEmailID = By.xpath("/html/body/tf-update-lang/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[4]/div/div/div/form/div[1]/div[2]/div[1]/div[1]/tf-textbox/div/div/input");
	public By txtDOB = By.xpath("(//*[@id='createacfm-DOB'])[2]");
	//public By txtDOB = By.xpath("/html/body/tf-update-lang/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[4]/div/div/div/form/div[1]/div[2]/div[1]/div[2]/div/tf-date/div/div/input");
	public By txtPassword = By.xpath("(//*[@id='createacfm-user_pwd'])[2]");
	//public By txtPassword = By.xpath("/html/body/tf-update-lang/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[4]/div/div/div/form/div[1]/div[2]/div[2]/div[1]/tf-textbox/div/div/input");
	public By txtConfirmPassword = By.xpath("(//*[@id='createacfm-confirmuser_pwd'])[2]");
	//public By txtConfirmPassword = By.xpath("/html/body/tf-update-lang/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[4]/div/div/div/form/div[1]/div[2]/div[2]/div[2]/tf-textbox/div/div/input");
	public By txtAccountPIN = By.xpath("(//*[@id='createacfm-user_pin'])[2]");
	//public By txtAccountPIN = By.xpath("/html/body/tf-update-lang/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[4]/div/div/div/form/div[1]/div[2]/div[3]/div[1]/tf-textbox/div/div/input");
	public By btnCreateAccount = By.cssSelector("[id='btn_createnew']");
	//public By btnCreateAccount = By.xpath("/html/body/tf-update-lang/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[4]/div/div/div/form/div[2]/div[2]/div/tf-split-horizontal-or/div/div[1]/div/tf-split-horizontal-or-top/div/wfm-button-primary/span[1]/button");
	public By cntThankYou = By.cssSelector("[id='btn_continue11']");
	//public By cntThankYou = By.xpath("/html/body/div[1]/div/div/div/modal-popup/div[2]/div[2]/form/div/div[2]/div[2]/tf-button-primary/span[2]/button");
	public By cntRequestSubmitted = By.cssSelector("button[id='btn_activatepin']");
	//public By cntRequestSubmitted = By.xpath("/html/body/tf-update-lang/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div[2]/tf-button-primary/span[2]/button");
	//ActivationByop
	public By btnByopContinue = By.cssSelector("button[id='btn_continuesmartphone']");
	public By btnByopTerms = By.cssSelector("button[id='btn_acceptterms&conditions']");
	public By txtByopSim = By.xpath("(//input[@id='simbyop'])[1]");
	public By btnByopSim = By.cssSelector("button[id='btn_collectsim']");
	public By txtSecurityPin = By.cssSelector("input[name='updateSecPin-pin']");
	public By btnSecurityPin = By.cssSelector("button[id='updateSecPin_btn']");
	//Activation with purchase
	public By btnCCCardContinue = By.cssSelector("button[id='airtimePurchaseActivation_btn']");
	//Redemption with pin locators
	public By myAccountLink = By.cssSelector("a[id='lnk_myaccount']");
	public By ogTitle = By.xpath("//meta[@property='og:title']");
	public By txtPhone = By.cssSelector("input[id='createac-device']");
	public By btnContinue = By.cssSelector("[id='btn_continue25']");
	public By txtPassword1 = By.xpath("(//input[@id='wfmloginpinpwd-pwd'])[1]");
	public By btnLogIn = By.cssSelector("[id='btn_login']");
	public By payServiceLink = By.xpath("(//a[@id='lnk_PayService'])[1]");	
	public By enterPhoneNumber = By.cssSelector("input[name='devicemin']");
	
	public By btnPayNow = By.cssSelector("button[id='RenewService']");
	public By payService =  By.cssSelector("a[id='lnk_payservice'])");
	//public By dropDownSelectDevice = By.xpath("(//input[@ng-click='$select.toggle($event)'])[2]");
	public By dropDownSelectDevice = By.xpath("//input[@class='ui-select-search ui-select-toggle ng-valid ng-touched ng-dirty ng-valid-parse ng-empty']");
	
	public By txtPin = By.cssSelector("input[id='form_redeem.pin']");
	public By btnAddServicePlan = By.cssSelector("button[id='AddServicePlan']");
	public By btnAddServicePlan1 = By.cssSelector("button[id='AddAirtime']");
	public By btnDone = By.cssSelector("button[id='done']");
	//Redemption with Purchase locators
	public By txtPhoneNumber = By.cssSelector("input[id='formphone-min']");
	public By btnServicePlan = By.cssSelector("button[id='monthly_481']");
	public By btnAutoPayNo = By.cssSelector("button[id='addToCartOneTimePurchpopup_btn']");
	public By btnAutoPayYes = By.cssSelector("button[id='addToCartEnroll_popup_btn']");
	public By paymentMethodLnk = By.xpath("//span[text()='PAYMENT METHOD']");
	public By txtCardNo = By.cssSelector("input[id='formName.number_mask']");
	public By txtCvv = By.cssSelector("input[id='cvv']");
	public By selectMonth = By.xpath("(//div[@class='selectize-input'])[1]");
	public By selectJanuary = By.xpath("(//*[@class='dropdown-content-item ng-scope'])[1]");
	public By selectYear = By.xpath("(//div[@class='selectize-input'])[1]");
	public By selectYear2022 = By.xpath("(//*[@class='dropdown-content-item ng-scope'])[6]");
	public By txtFname = By.cssSelector("input[id='fname']");
	public By txtLname = By.cssSelector("input[id='lname']");
	public By txtAddress1 = By.cssSelector("input[id='address1']");
	public By txtCity = By.cssSelector("input[id='city']");
	public By txtZipCode = By.cssSelector("input[id='zipcode']");
	public By selectState = By.xpath("(//div[@class='selectize-input'])[3]");
	public By selectStateCA = By.xpath("//div[@title='CA']");
	//public By selectCountry = By.xpath("(//div[@class='selectize-input'])[4]");
	public By btnPlaceMyOrder = By.cssSelector("button[id='PlaceMyorder']");
	public By btnActivateNoPin = By.cssSelector("button[id='btn_activatenopin']");
	public By btnDoneConfirm = By.cssSelector("button[id='done_confirmation']");
	public By btnNoThanks =By.xpath("//span[text()='No, Thanks']");
	public By btnContinueToPayment = By.cssSelector("button[id='ContinueToPayment']");
}