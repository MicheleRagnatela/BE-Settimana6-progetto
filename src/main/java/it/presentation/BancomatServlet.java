package it.presentation;

import java.io.IOException;
import java.io.PrintWriter;

import it.business.BancomatEjb;
import it.data.ContoCorrente;
import it.data.ContoCorrenteDAO;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class BancomatServlet
 */
public class BancomatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   @EJB
   BancomatEjb ban;
    public BancomatServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*ContoCorrenteDAO cc = new ContoCorrenteDAO(); 
		ban.setCd(cc);
		ContoCorrente conto = new ContoCorrente();
		
		int numero = Integer.parseInt(request.getParameter("numero"));
		float quantita = Float.valueOf(request.getParameter("quantita"));
		
		ban.versa(numero, quantita);*/
		
		String operazione = request.getParameter("operazione");
		if(operazione.equals("3")) {
			ContoCorrenteDAO cc = new ContoCorrenteDAO(); 
			ban.setCd(cc);
			ContoCorrente conto = new ContoCorrente();
			
			int numero = Integer.parseInt(request.getParameter("numero"));
			float quantita = Float.valueOf(request.getParameter("quantita"));
			
			ban.versa(numero, quantita);
			PrintWriter out = response.getWriter();
			out.println("Hai versato " + quantita + "euro");
			
		}
		
		if(operazione.equals("2")) {
			ContoCorrenteDAO cc = new ContoCorrenteDAO(); 
			ban.setCd(cc);
			
			
			int numero = Integer.parseInt(request.getParameter("numero"));
			float quantita = Float.valueOf(request.getParameter("quantita"));
			
			
			
			ban.preleva(numero, quantita);
			PrintWriter out = response.getWriter();
			
			out.println("Hai prelevato " + quantita + "euro");
			
		}
		if(operazione.equals("1")) {
			ContoCorrenteDAO cc = new ContoCorrenteDAO(); 
			ban.setCd(cc);
			 
			
			int numero = Integer.parseInt(request.getParameter("numero"));
			
			ContoCorrente conto = ban.getContoCorrente(numero);
			 
			
			 PrintWriter out = response.getWriter();
			 if (numero == conto.getNumero()) {
			 out.println("<h1>ContoCorrente</h1>");
			 out.println(" <table border = 1px solid black;>\r\n"
			 		+ "				<tr>\r\n"
			 		+ "					<th>Numero</th>\r\n"
			 		+ "					<th>Intestatario</th>\r\n"
			 		+ "					<th>Saldo</th>\r\n"
			 		+ "				</tr>\r\n"
			 		+ "				<tr>\r\n"
			 		+ "					<td>" + conto.getNumero() +"</td>\r\n"
			 		+ "					<td>" + conto.getIntestatario() + "</td>\r\n"
			 		+ "					<td>" + conto.getSaldo() + "</td>\r\n"
			 		+ "				</tr>\r\n"
			 		+ "			</table>\r\n"
			 		+ "			 ");
			 
			 }
			 else {
				 out.println("**** Non esiste nessun conto con questo numero ****");
			 }
				 
			 
			 
			 // out.println(conto.getNumero() + " " + conto.getIntestatario() + " " + conto.getSaldo());
			}
		
	}

}
