package it.business;

import it.data.ContoCorrente;
import it.data.ContoCorrenteDAO;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;

/**
 * Session Bean implementation class BancomatEjb
 */
@Stateless
@LocalBean
public class BancomatEjb implements BancomatEjbLocal {

    private ContoCorrenteDAO cd;
   
   
    public BancomatEjb() {
        // TODO Auto-generated constructor stub
    }
    public boolean preleva(int numero, float quantita) {
    	
    	return cd.preleva(numero, quantita);
    }
    public ContoCorrente getContoCorrente(int numero) {
    	return cd.getContoCorrente(numero);
    }
    
   public boolean versa(int numero, float quantita) {
	  return cd.versa(numero,  quantita);
   }
	   
	public ContoCorrenteDAO getCd() {
		return cd;
	}
	public void setCd(ContoCorrenteDAO cd) {
		this.cd = cd;
	}

}
