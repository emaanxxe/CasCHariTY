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


public class SignINAssociation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
private userDAO userdao;
	
	public void init() throws ServletException{
		DAOFactory daoFactory = DAOFactory.getInstance();
		this.userdao = daoFactory.getuserDao();
	}
    
    public SignINAssociation() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		this.getServletContext().getRequestDispatcher("/SignINAssociation.jsp").forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("AssId");
		String name = request.getParameter("AssName");
		String email = request.getParameter("AssEmail");
		String password  = request.getParameter("AssPassword");
		
		Association association = new Association(id,name,email,password);
		
		boolean signInSuccessful = userdao.VerifyAssociation(association);
		
		if (signInSuccessful) {
            // Redirect to Association space
			int CollaborationCount = userdao.CollaborationsCountforAss(association);
			request.setAttribute("CollaborationCount", CollaborationCount);
			
			List<Collaboration> list =userdao.GetCollaborationsforAss(association);
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("/Association.jsp").forward(request, response);
           
            
        } else {
            // Redirect to login page with error message
            request.setAttribute("errorMessage", "Invalid credentials");
            request.getRequestDispatcher("/SignINAssociation.jsp").forward(request, response);
        }
		/*request.setAttribute("signInSuccessful",signInSuccessful);
		
		this.getServletContext().getRequestDispatcher("/SignINAssociation.jsp").forward(request, response);*/
		
	}

}
