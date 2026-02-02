package tarea.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Hipotenusa
 */
@WebServlet("/Hipotenusa")
public class Hipotenusa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hipotenusa() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Preparar la respuesta en UTF-8
		response.setContentType("text/html;charset=UTF-8");
		
		// Mostrar un formulario simple para introducir a y b
		try (java.io.PrintWriter out = response.getWriter()) {
			out.println("<!DOCTYPE html>");
			out.println("<html><head><meta charset='UTF-8'><title>Hipotenusa</title></head><body>");
			out.println("<h1>Calcular hipotenusa (c = √(a² - b²))</h1>");
			out.println("<form method=\"post\" action=\"Hipotenusa\">");
			out.println("a: <input name=\"a\" /> <br/>");
			out.println("b: <input name=\"b\" /> <br/>");
			out.println("<button type=\"submit\">Calcular</button>");
			out.println("</form>");
			out.println("</body></html>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Leer parámetros y preparar salida
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String aParam = request.getParameter("a");
		String bParam = request.getParameter("b");
		
		try (java.io.PrintWriter out = response.getWriter()) {
			out.println("<!DOCTYPE html>");
			out.println("<html><head><meta charset='UTF-8'><title>Resultado</title></head><body>");
			out.println("<h1>Resultado</h1>");
			
			// Comprobar que haya valores
			if (aParam == null || bParam == null || aParam.trim().isEmpty() || bParam.trim().isEmpty()) {
				out.println("<p style='color:red;'>Introduce valores para a y b.</p>");
			} else {
				// Intentar convertir a números
				try {
					double a = Double.parseDouble(aParam);
					double b = Double.parseDouble(bParam);
					
					// Calcular c = sqrt(a^2 - b^2)
					double inside = a * a - b * b;
					if (inside < 0) {
						out.println("<p style='color:red;'>a² - b² es negativo. No hay raíz real.</p>");
					} else {
						double c = Math.sqrt(inside);
						out.println("<p>Resultado: c = " + c + "</p>");
					}
				} catch (NumberFormatException e) {
					out.println("<p style='color:red;'>Valores inválidos. Escribe números.</p>");
				}
			}
			
			out.println("<p><a href=\"Hipotenusa\">Volver</a></p>");
			out.println("</body></html>");
		}
	}

}
