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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");

		try (java.io.PrintWriter out = response.getWriter()) {
			out.println("<!DOCTYPE html>");
			out.println("<html><head><meta charset='UTF-8'><title>Número mayor</title></head><body>");
			out.println("<h1>Encontrar el número mayor</h1>");
			out.println("<form method='post' action='Numeros'>");
			out.println("Número 1: <input name='a'><br>");
			out.println("Número 2: <input name='b'><br>");
			out.println("Número 3: <input name='c'><br>");
			out.println("<button type='submit'>Calcular</button>");
			out.println("</form>"); 
			out.println("</body></html>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String a = request.getParameter("a");
		String b = request.getParameter("b");
		String c = request.getParameter("c");

		try (java.io.PrintWriter out = response.getWriter()) {
			out.println("<!DOCTYPE html>");
			out.println("<html><head><meta charset='UTF-8'><title>Resultado</title></head><body>");
			out.println("<h1>Resultado</h1>");

			if (a == null || b == null || c == null ||
				a.trim().isEmpty() || b.trim().isEmpty() || c.trim().isEmpty()) {

				out.println("<p style='color:red;'>Ingrese los tres números.</p>");

			} else {
				try {
					double n1 = Double.parseDouble(a);
					double n2 = Double.parseDouble(b);
					double n3 = Double.parseDouble(c);

					double mayor = n1;

					if (n2 > mayor) mayor = n2;
					if (n3 > mayor) mayor = n3;

					out.println("<p>El número mayor es: <strong>" + mayor + "</strong></p>");

				} catch (NumberFormatException e) {
					out.println("<p style='color:red;'>Solo se permiten números.</p>");
				}
			}

			out.println("<p><a href='index.html'>Volver</a></p>");
			out.println("</body></html>");
		}
	}
}

