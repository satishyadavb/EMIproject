package Com.EMI;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class calculateEMI
 */
@WebServlet("/calculateEMI")
public class calculateEMI extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		System.out.println("Servlet initialized by the calculate page");
		//it is a one time initialization, once we are done then next time we cant get it
		//we can itialixe some files, we can put some database properties
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Double P = Double.valueOf(request.getParameter("Loan amount"));
			
			Double I = Double.valueOf(request.getParameter("Monthly_Interest_Rate"));

			Double N = Double.valueOf(request.getParameter("Loan tenure"));

			Double Emi = (P * I * Math.pow((1 + I), N) / ((Math.pow((1 + I), N)) - 1));
			response.getWriter().append("Served at: ").append("EMI is" + "-"+Emi);
		} catch (Exception e) {
			PrintWriter e1 = response.getWriter().append("Invalid Input");
			response.getWriter().append((CharSequence) e1);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	@Override
	public void destroy() {
		System.out.println("Servlet destoryed");
		//close the streams, database connections, all other files which are upto servlets level
	}
}

