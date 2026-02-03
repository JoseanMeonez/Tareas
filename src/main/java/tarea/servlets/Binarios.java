package tarea.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Binarios
 */
@WebServlet("/Binarios")
public class Binarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Binarios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        String valor = request.getParameter("valor");
        String tipo = request.getParameter("tipo");
        String resultado = "";

        try {
            if ("toDecimal".equals(tipo)) {
                // Binario -> Decimal
                int decimal = Integer.parseInt(valor, 2);
                resultado = "El binario " + valor + " en decimal es: " + decimal;
            } else {
                // Decimal -> Binario
                int decimal = Integer.parseInt(valor);
                resultado = "El decimal " + valor + " en binario es: " + Integer.toBinaryString(decimal);
            }
        } catch (NumberFormatException e) {
            resultado = "Error: El formato del número no corresponde a la conversión seleccionada.";
        }

        try (PrintWriter out = response.getWriter()) {
            out.println("<html><body>");
            out.println("<h3>Resultado del Inciso 1</h3>");
            out.println("<p>" + resultado + "</p>");
            out.println("<a href='index.html'>Regresar</a>");
            out.println("</body></html>");
        }
    }
}
