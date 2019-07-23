package tppreferenceusage;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletAccueil
 */
@WebServlet("/ServletAccueil")
public class ServletAccueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Integer nbPassage = 0;

    /**
     * Default constructor. 
     */
    public ServletAccueil() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	super.init();
    	String param = this.getServletContext().getInitParameter("COULEURS");
    	List<String> couleursDisponibles = Arrays.asList(param.split(","));
    	ServletContext application = this.getServletContext();
    	application.setAttribute("couleurs", couleursDisponibles);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		nbPassage = 0;
		if(cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("nbPassage")) {
					nbPassage = Integer.parseInt(cookie.getValue());
				}
			}
		}
		nbPassage++;
		Cookie cookie = new Cookie("nbPassage", String.valueOf(nbPassage));
		response.addCookie(cookie);
		
		request.setAttribute("nbPassage", nbPassage);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/accueiljstl.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String couleurChoisie = request.getParameter("couleurs");
		HttpSession session = request.getSession();
		session.setAttribute("couleurChoisie", couleurChoisie);
		
		request.setAttribute("nbPassage", nbPassage);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/accueiljstl.jsp");
		rd.forward(request, response);
	}

}
