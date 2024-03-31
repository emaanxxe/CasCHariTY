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
import DBConnection.userDAOImp;



public class SignUPDonateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private userDAO userdao;
	
	public void init() throws ServletException{
		DAOFactory daoFactory = DAOFactory.getInstance();
		this.userdao = daoFactory.getuserDao();
	}
    
    public SignUPDonateur() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		this.getServletContext().getRequestDispatcher("/SignUPDonateur.jsp").forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Donateur donateur = new Donateur();
		donateur.setName(request.getParameter("name"));
		donateur.setEmail(request.getParameter("email"));
		donateur.setPassword(request.getParameter("password"));
		donateur.setPhone(request.getParameter("phone"));
		donateur.setAdress(request.getParameter("adresse"));
		
		userdao.AddDonateur(donateur);
		
		request.setAttribute("donateur",donateur);
		
		int DonationCount = userdao.DonationCountforDonor(donateur);
		request.setAttribute("DonationCount", DonationCount);
		
		List<Donation> list =userdao.GetDonationforDonor(donateur);
		request.setAttribute("list", list);
		
		request.setAttribute("Message", "Inscription réussie !");
		request.getRequestDispatcher("/Donateur.jsp").forward(request, response);
		
		//this.getServletContext().getRequestDispatcher("/SignUP.jsp").forward(request, response);
		
	}

}
