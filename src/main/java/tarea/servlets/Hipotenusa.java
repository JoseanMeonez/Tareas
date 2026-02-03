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
	
		String entrada = "a=" + (aParam == null ? "" : aParam) + ", b=" + (bParam == null ? "" : bParam);
		String respuesta = "";
	
		if (aParam == null || bParam == null || aParam.trim().isEmpty() || bParam.trim().isEmpty()) {
			respuesta = "Introduce valores para a y b.";
		} else {
			try {
				double a = Double.parseDouble(aParam);
				double b = Double.parseDouble(bParam);
				double inside = a * a - b * b;
				if (inside < 0) {
					respuesta = "a² - b² es negativo (" + String.format("%.4f", inside) + "). No hay raíz real.";
				} else {
					double c = Math.sqrt(inside);
					respuesta = String.format("c = %.4f", c);
				}
			} catch (NumberFormatException e) {
				respuesta = "Valores inválidos. Escribe números.";
			}
		}
	
		try (java.io.PrintWriter out = response.getWriter()) {
			out.println("<!DOCTYPE html>");
			out.println("<html><head><meta charset='UTF-8'><title>Resultado - Hipotenusa</title></head><body>");
			out.println("<h2>Andrés Meoñez</h2>");
			out.println("<h2>Cuenta: 201910030181</h2>");
			out.println("<p>Operación realizada: Calcular c = √(a² - b²)</p>");
			out.println("<table border='1'><tr><th>Entrada</th><th>Respuesta</th></tr>");
			out.println("<tr><td>" + (entrada.isEmpty() ? "-" : entrada) + "</td><td>" + respuesta + "</td></tr>");
			out.println("</table>");
			out.println("<p><a href='index.html'>Volver</a></p>");
			out.println("</body></html>");
		}
	}

}
