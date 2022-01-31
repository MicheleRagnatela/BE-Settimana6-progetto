package it.business;

import it.data.ContoCorrente;
import jakarta.ejb.Local;

@Local
public interface BancomatEjbLocal {

	 public boolean versa(int numero, float quantita);
	 
	 public ContoCorrente getContoCorrente(int numero);
	 
	 public boolean preleva(int numero, float quantita);
	
}
