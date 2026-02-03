package tarea.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Numeros
 */
@WebServlet("/Numeros")
public class Numeros extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Numeros() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Leer parámetros y preparar salida
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String n1Param = request.getParameter("a");
		String n2Param = request.getParameter("b");
		String n3Param = request.getParameter("c");
		String entrada = "a=" + (n1Param == null ? "" : n1Param) + ", b=" + (n2Param == null ? "" : n2Param) + ", c=" + (n3Param == null ? "" : n3Param);
		String respuesta = "";

		try (java.io.PrintWriter out = response.getWriter()) {

			// Comprobar que haya valores
			if (n1Param == null || n2Param == null || n3Param == null || n1Param.trim().isEmpty()
					|| n2Param.trim().isEmpty() || n3Param.trim().isEmpty()) {

					respuesta = "Debe ingresar los tres números.";

			} else {
				try {
					double n1 = Double.parseDouble(n1Param);
					double n2 = Double.parseDouble(n2Param);
					double n3 = Double.parseDouble(n3Param);

					double mayor = n1;

					if (n2 > mayor) {
						mayor = n2;
					}
					if (n3 > mayor) {
						mayor = n3;
					}


					respuesta = "El número mayor es: " + mayor;

				} catch (NumberFormatException e) {
					respuesta = "Ingrese solo valores numéricos.";
				}
			}

			
			out.println("<!DOCTYPE html>");
			out.println("<html><head><meta charset='UTF-8'><title>Resultado</title></head><body>");
			out.println("<h2>Rafael Cruz</h2>");
			out.println("<h2>Cuenta: 12345678</h2>");
			out.println("<p>Operación realizada: Encontrar número mayor</p>");
			out.println("<table border='1'><tr><th>Entrada</th><th>Respuesta</th></tr>");
			out.println("<tr><td>" + (entrada.isEmpty() ? "-" : entrada) + "</td><td>" + respuesta + "</td></tr>");
			out.println("</table>");
			out.println("<p><a href=\"index.html\">Volver</a></p>");
			out.println("</body></html>");
		}
	}

}
