package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import Beans.Donateur;
import Beans.Donation;
import DBConnection.DAOFactory;
import DBConnection.userDAO;


public class SignINDonateur extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	private userDAO userdao;
	
	public void init() throws ServletException{
		DAOFactory daoFactory = DAOFactory.getInstance();
		this.userdao = daoFactory.getuserDao();
	}
    
    public SignINDonateur() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		this.getServletContext().getRequestDispatcher("/SignINDonateur.jsp").forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String email = request.getParameter("email");
		String password  = request.getParameter("password");
		
		Donateur donateur = new Donateur(email,password);
		
		boolean signInSuccessful = userdao.VerifyDonateur(donateur);
		
		if (signInSuccessful) {
            // Redirect to Association space
			
			int DonationCount = userdao.DonationCountforDonor(donateur);
			request.setAttribute("DonationCount", DonationCount);
			
			List<Donation> list =userdao.GetDonationforDonor(donateur);
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("Donateur.jsp").forward(request, response);
            //response.sendRedirect("Donateur.jsp");
            
        } else {
            // Redirect to login page with error message
            request.setAttribute("errorMessage", "Invalid credentials");
            request.getRequestDispatcher("/SignINDonateur.jsp").forward(request, response);
        }
		
		
	}

}
