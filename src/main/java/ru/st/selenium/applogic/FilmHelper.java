package ru.st.selenium.applogic;


import ru.st.selenium.model.Film;

public interface FilmHelper {
	void create(Film film);
	void delete(Film film);	
	void search(String title);
}
