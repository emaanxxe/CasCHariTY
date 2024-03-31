package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import Beans.Admin;
import Beans.Donateur;
import Beans.Donation;
import DBConnection.DAOFactory;
import DBConnection.userDAO;


public class newDonation extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	private userDAO userdao;
	
	public void init() throws ServletException{
		DAOFactory daoFactory = DAOFactory.getInstance();
		this.userdao = daoFactory.getuserDao();
	}
    
    public newDonation() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		this.getServletContext().getRequestDispatcher("/newDonation.jsp").forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Donation donation = new Donation();
		Donateur donateur = new Donateur();
		
		/*donateur.setName(request.getParameter("name"));
		donateur.setEmail(request.getParameter("email"));
		donation.setDonateur(donateur);*/
		
		donation.setDonorName(request.getParameter("name"));
		donation.setDonorEmail(request.getParameter("email"));
		
		double amount = Double.parseDouble(request.getParameter("amount"));
		donation.setAmount(amount);
		
		donation.setPaymentMode(request.getParameter("cash"));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date;
		try {
			date = sdf.parse(request.getParameter("date"));
			donation.setDate(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		userdao.NewDonation(donation);
		
		//HttpSession session = request.getSession();
		//session.setAttribute("donateur", donateur);

		request.getRequestDispatcher("/newDonation.jsp").forward(request, response);
		
		//this.getServletContext().getRequestDispatcher("/SignUP.jsp").forward(request, response);
		
	}

}
