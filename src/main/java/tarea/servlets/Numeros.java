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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Preparar la respuesta en UTF-8
		response.setContentType("text/html;charset=UTF-8");

		// Mostrar un formulario simple para introducir a y b
		try (java.io.PrintWriter out = response.getWriter()) {
			out.println("<!DOCTYPE html>");
			out.println("<html><head><meta charset='UTF-8'><title>Que Numero es mayor</title></head><body>");
			out.println("<h1>Calcular el numero mayor</h1>");
			out.println("<form method=\"post\" action=\"Numeros\">");
			out.println("a: <input name=\"a\" /> <br/>");
			out.println("b: <input name=\"b\" /> <br/>");
			out.println("c: <input name=\"c\" /> <br/>");
			out.println("<button type=\"submit\">Calcular</button>");
			out.println("</form>");
			out.println("</body></html>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String n1Param = request.getParameter("a");
		String n2Param = request.getParameter("b");
		String n3Param = request.getParameter("c");

		try (java.io.PrintWriter out = response.getWriter()) {
			out.println("<!DOCTYPE html>");
			out.println("<html><head><meta charset='UTF-8'><title>Resultado</title></head><body>");
			out.println("<h1>Resultado</h1>");

			if (n1Param == null || n2Param == null || n3Param == null || n1Param.trim().isEmpty()
					|| n2Param.trim().isEmpty() || n3Param.trim().isEmpty()) {

				out.println("<p style='color:red;'>Debe ingresar los tres números.</p>");

			} else {
				try {
					double n1 = Double.parseDouble(n1Param);
					double n2 = Double.parseDouble(n2Param);
					double n3 = Double.parseDouble(n3Param);

					double mayor = n1;
					double menor = n1;

					if (n2 > mayor) {
						mayor = n2;
					}
					if (n3 > mayor) {
						mayor = n3;
					}

					if (n2 < menor) {
						menor = n2;
					}
					if (n3 < menor) {
						menor = n3;
					}

					if (n1 == n2 && n2 == n3) {
						out.println("<p>Los tres números son iguales: " + n1 + "</p>");
					} else {
						out.println("<p>El número mayor es: <strong>" + mayor + "</strong></p>");
						out.println("<p>El número menor es: <strong>" + menor + "</strong></p>");
					}

				} catch (NumberFormatException e) {
					out.println("<p style='color:red;'>Ingrese solo valores numéricos.</p>");
				}
			}

			out.println("<p><a href=\"Numeros\">Volver</a></p>");
			out.println("</body></html>");
		}
	}
}
