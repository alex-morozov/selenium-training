package ru.st.selenium.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddMoviePage extends InternalPage {

	public AddMoviePage(PageManager pages) {
		super(pages);
	}
	
  @FindBy(name = "name")
  private WebElement nameField;
	
  @FindBy(name = "year")
  private WebElement yearField;
  
  @FindBy(name = "imdbsearch")
  private WebElement imdbsearchField;
  
  @FindBy(name = "duration")
  private WebElement duration;
  
  @FindBy(name = "submit")
  private WebElement submitButton;
  
  private Select permissionDropdown() {
    return new Select(driver.findElement(By.name("permission")));
  }
  
  public String getName() {
    return nameField.getAttribute("value");
  }

  public String getYear() {
    return yearField.getAttribute("value");
  }

  public AddMoviePage setNameField(String text) {
    nameField.sendKeys(text);
    return this;
  }

  public AddMoviePage setYearField(String text) {
    yearField.sendKeys(text);
    return this;
  }

  public AddMoviePage setImdbsearch(String text) {
	  imdbsearchField.sendKeys(text);
    return this;
  }
  
  public void clickSubmitButton() {
	    submitButton.click();
	  }

  public String getRole() {
    return permissionDropdown().getFirstSelectedOption().getText();
  }

  public AddMoviePage ensurePageLoaded() {
    super.ensurePageLoaded();
    wait.until(presenceOfElementLocated(By.name("name")));
    return this;
  }
}
