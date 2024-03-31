package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import Beans.Association;
import Beans.Collaboration;
import Beans.Donateur;
import DBConnection.DAOFactory;
import DBConnection.userDAO;

/**
 * Servlet implementation class SignUPAssociation
 */
public class SignUPAssociation extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	private userDAO userdao;
	
	public void init() throws ServletException{
		DAOFactory daoFactory = DAOFactory.getInstance();
		this.userdao = daoFactory.getuserDao();
	}
    
    public SignUPAssociation() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		this.getServletContext().getRequestDispatcher("/SignUPAssociation.jsp").forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Association association = new Association();
	
		association.setAssID(request.getParameter("AssId"));
		association.setAssName(request.getParameter("AssName"));
		association.setAssEmail(request.getParameter("AssEmail"));
		association.setAssPassword(request.getParameter("AssPassword"));
		association.setAssPhone(request.getParameter("AssPhone"));
		association.setAssAdress(request.getParameter("AssAddress"));
		
		userdao.AddAssociation(association);
		
		int CollaborationCount = userdao.CollaborationsCountforAss(association);
		request.setAttribute("CollaborationCount", CollaborationCount);
		
		List<Collaboration> list =userdao.GetCollaborationsforAss(association);
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/Association.jsp").forward(request, response);
		
		request.setAttribute("Message", "Inscription réussie !");
		request.getRequestDispatcher("/Association.jsp").forward(request, response);
		
		/*request.setAttribute("Association",association);
		
		this.getServletContext().getRequestDispatcher("/SignUPAssociation.jsp").forward(request, response);
		*/
	}

}
