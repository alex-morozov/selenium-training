package ru.st.selenium.applogic2;

import org.openqa.selenium.By;

import ru.st.selenium.applogic.FilmHelper;
import ru.st.selenium.model.Film;

public class FilmHelper2 extends DriverBasedHelper implements FilmHelper {

  public FilmHelper2(ApplicationManager2 manager) {
    super(manager.getWebDriver());
  }

  @Override
  public void create(Film film) {
  	 pages.addMoviePage.ensurePageLoaded()
       .setNameField(film.getTitle())
       .setYearField(film.getYear())
       .clickSubmitButton();
  }

  @Override
  public void delete(Film film) {
    // TODO Auto-generated method stub

  }

  @Override
  public void search(String title) {
	  pages.internalPage.ensurePageLoaded()
	 .searchMovie(title);	  
  }
  
  @Override
  public void checkSearchResults(){
	  assertEquals("Bug", driver.findElement(By.cssSelector("div.title")).getText());
  }
  }



}
