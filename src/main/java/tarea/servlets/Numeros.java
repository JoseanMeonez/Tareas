package tarea.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String aParam = request.getParameter("a");
		String bParam = request.getParameter("b");
		String cParam = request.getParameter("c");
		String tipo = request.getParameter("tipo");

		String operacion = "";
		String entrada = "";
		String respuesta = "";

		try {
			double a = Double.parseDouble(aParam);
			double b = Double.parseDouble(bParam);
			double c = Double.parseDouble(cParam);

			entrada = "a=" + a + ", b=" + b + ", c=" + c;

			switch (tipo) {
				case "mayor":
					operacion = "Encontrar numero mayor";
					respuesta = "El numero mayor es: " + numeroMayor(a, b, c);
					break;

				case "menor":
					operacion = "Encontrar numero menor";
					respuesta = "El numero menor es: " + numeroMenor(a, b, c);
					break;

				case "repetido":
					operacion = "Numero que más se repite";
					respuesta = numeroRepetido(a, b, c);
					break;

				default:
					respuesta = "Operación no valida.";
			}

		} catch (NumberFormatException e) {
			operacion = "Error";
			entrada = "Valores invalidos";
			respuesta = "Ingrese solo números validos.";
		}


		try (PrintWriter out = response.getWriter()) {
			out.println("<!DOCTYPE html>");
			out.println("<html><head><meta charset='UTF-8'><title>Resultado - Numeros</title></head><body>");
			out.println("<h2>Jose Rafael Cruz</h2>");
			out.println("<h2>Cuenta: 202310020071</h2>");
			out.println("<p>Operación realizada: " + operacion + "</p>");
			out.println("<table border='1'>");
			out.println("<tr><th>Entrada</th><th>Respuesta</th></tr>");
			out.println("<tr><td>" + (entrada.isEmpty() ? "-" : entrada) + "</td>");
			out.println("<td>" + respuesta + "</td></tr>");
			out.println("</table>");
			out.println("<p><a href='index.html'>Regresar</a></p>");
			out.println("</body></html>");
		}
	}

	// Mayor
	private double numeroMayor(double a, double b, double c) {
		double mayor = a;
		if (b > mayor) mayor = b;
		if (c > mayor) mayor = c;
		return mayor;
	}

	// Menor
	private double numeroMenor(double a, double b, double c) {
		double menor = a;
		if (b < menor) menor = b;
		if (c < menor) menor = c;
		return menor;
	}

	// Repetido
	private String numeroRepetido(double a, double b, double c) {
		if (a == b && b == c) {
			return "Los tres numeros son iguales: " + a;
		} else if (a == b || a == c) {
			return "El numero que mas se repite es: " + a;
		} else if (b == c) {
			return "El numero que mas se repite es: " + b;
		} else {
			return "No hay números repetidos.";
		}
	}
}
