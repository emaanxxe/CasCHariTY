package Servlets;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import Beans.*;
import DBConnection.DAOFactory;
import DBConnection.userDAO;


public class SignINAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private userDAO userdao;
	
	public void init() throws ServletException{
		DAOFactory daoFactory = DAOFactory.getInstance();
		this.userdao = daoFactory.getuserDao();
	}
    
   
    public SignINAdmin() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/SignINAdmin.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*Admin admin = new Admin();
		admin.setID(request.getParameter("CasID"));
		admin.setEmail(request.getParameter("CasEmail"));
		admin.setPassword(request.getParameter("CasPass"));
		
		boolean alert = userdao.VerifyAdmin(admin);
		request.setAttribute("signInSuccessful", alert);
		
		*/
		String casID = request.getParameter("CasID");
        String casEmail = request.getParameter("CasEmail");
        String casPass = request.getParameter("CasPass");

        Admin admin = new Admin(casID, casEmail, casPass);

        boolean signInSuccessful = userdao.VerifyAdmin(admin);
       
        if (signInSuccessful) {
            // Redirect to Admin space
        	int DonationCount = userdao.AllDonationsCount();
			request.setAttribute("DonationCount", DonationCount);
			
			int CollaborationCount = userdao.AllCollaborationsCount();
			request.setAttribute("CollaborationCount", CollaborationCount);
			
			List<Donation> listDonations =userdao.GetDonationforAdmin();
			request.setAttribute("listDonations", listDonations);
			
			List<Collaboration> listCollaborations =userdao.GetCollaborationsforAdmin();
			request.setAttribute("listCollaborations", listCollaborations);
			
			//System.out.println(list.size());
			
			
			request.getRequestDispatcher("Admin.jsp").forward(request, response);
            //response.sendRedirect("Admin.jsp");
		
           
            
        } else {
            // Redirect to login page with error message
            request.setAttribute("errorMessage", "Invalid credentials");
            request.getRequestDispatcher("/SignINAdmin.jsp").forward(request, response);
        }
        
        
		//this.getServletContext().getRequestDispatcher("/SignINAdmin.jsp").forward(request, response);
	}

}
