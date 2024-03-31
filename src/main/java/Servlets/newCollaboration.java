package Servlets;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import Beans.*;
import Beans.Donation;
import DBConnection.DAOFactory;
import DBConnection.userDAO;


public class newCollaboration extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	private userDAO userdao;
	
	public void init() throws ServletException{
		DAOFactory daoFactory = DAOFactory.getInstance();
		this.userdao = daoFactory.getuserDao();
	}
    
    public newCollaboration() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		this.getServletContext().getRequestDispatcher("/newCollaboration.jsp").forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Collaboration collaboration = new Collaboration();
		
		collaboration.setAssID(request.getParameter("AssId"));
		collaboration.setAssName(request.getParameter("AssName"));
		collaboration.setAssEmail(request.getParameter("AssEmail"));
		collaboration.setTopic(request.getParameter("Topic"));
		collaboration.setDescription(request.getParameter("description"));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date;
		try {
			date = sdf.parse(request.getParameter("date"));
			collaboration.setDate(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		userdao.NewCollaboration(collaboration);

		request.getRequestDispatcher("/newCollaboration.jsp").forward(request, response);
		
		//this.getServletContext().getRequestDispatcher("/SignUP.jsp").forward(request, response);
		
	}
}
