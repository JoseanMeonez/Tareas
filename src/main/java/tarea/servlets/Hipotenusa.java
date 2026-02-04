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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		// Opcion a ejecutar
		String compute = request.getParameter("compute");
		String v1 = request.getParameter("v1");
		String v2 = request.getParameter("v2");
		String entrada = "";
		String respuesta = "";

		if (compute == null ||
			v1 == null || v2 == null || 
			v1.trim().isEmpty() || v2.trim().isEmpty()
		) {
			respuesta = "Introduce los dos valores necesarios.";
			entrada = "";
		} else {
			try {
				double x = Double.parseDouble(v1);
				double y = Double.parseDouble(v2);
				
				if ("a".equals(compute)) {
					
					entrada = "b=" + v1 + ", c=" + v2;
					respuesta = computeA(x, y);

				} else if ("b".equals(compute)) {
					
					entrada = "a=" + v1 + ", c=" + v2;
					respuesta = computeB(x, y);

				} else {

					entrada = "a=" + v1 + ", b=" + v2;
					respuesta = computeC(x, y);

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
			out.println("<p>Operación realizada: Calcular lado " + (compute == null ? "" : compute) + "</p>");
			out.println("<table border='1'><tr><th>Entrada</th><th>Respuesta</th></tr>");
			out.println("<tr><td>" + (entrada.isEmpty() ? "-" : entrada) + "</td><td>" + respuesta + "</td></tr>");
			out.println("</table>");
			out.println("<p><a href='index.html'>Volver</a></p>");
			out.println("</body></html>");
		}
	}

	// Calcular a = sqrt(b^2 + c^2)
	private String computeA(double b, double c) {
		double a = Math.sqrt(b * b + c * c);

		return String.format("a = %.4f", a);
	}

	// Calcular b = sqrt(a^2 - c^2)
	private String computeB(double a, double c) {
		double inside = a * a - c * c;
		
		if (inside < 0) {
			return "a² - c² (" + inside + ") es negativo. No hay raíz real.";
		}
		
		double b = Math.sqrt(inside);
		
		return String.format("b = %.4f", b);
	}

	// Calcular c = sqrt(a^2 - b^2)
	private String computeC(double a, double b) {
		double inside = a * a - b * b;
		
		if (inside < 0) {
			return "a² - b² (" + inside + ") es negativo. No hay raíz real.";
		}
		
		double c = Math.sqrt(inside);
		
		return String.format("c = %.4f", c);
	}

}
