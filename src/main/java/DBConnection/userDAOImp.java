package DBConnection;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import Beans.Admin;
import Beans.Association;
import Beans.Collaboration;
import Beans.Donateur;
import Beans.Donation;


public class userDAOImp implements userDAO {
	private DAOFactory daoFactory;
	
	Connection connection = null;
	PreparedStatement statement = null;
	
	String CasID="123CAS2024";
	String To_CAS="CAS";
	
	public userDAOImp(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void AddDonateur(Donateur donateur) {
	
		try {
			connection = daoFactory.getConnection();
			statement = connection.prepareStatement("INSERT INTO donateur(name,email,password,phone,adresse) VALUES(?, ? ,? ,? ,?);");
			statement.setString(1, donateur.getName());
			statement.setString(2, donateur.getEmail());
			statement.setString(3, donateur.getPassword());
			statement.setString(4, donateur.getPhone());
			statement.setString(5, donateur.getAdress());
			
			statement.executeUpdate();
			
		}catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public boolean VerifyDonateur(Donateur donateur) {
		
		boolean signInSuccessful = false;
		try {
			connection = daoFactory.getConnection();
			statement = connection.prepareStatement("SELECT * FROM donateur WHERE email = ? AND password = ?;");
			statement.setString(1, donateur.getEmail());
			statement.setString(2, donateur.getPassword());
			
			ResultSet Adm = statement.executeQuery();
			
			if (Adm.next()) {
				String hashedEmail = Adm.getString("email"); 
				String hashedPass = Adm.getString("password");
				
					
				if ((donateur.getEmail().equals(hashedEmail)) && (donateur.getPassword().equals(hashedPass))){
					signInSuccessful = true;
					System.out.println("Donateur Sign in successful.");
		        }
					
			}
			else {
				System.out.println("Error :(");
			}
			
			
		}catch (SQLException e) {
            e.printStackTrace();
        }
		
		return signInSuccessful;
	}

	
	@Override
	public boolean VerifyAdmin(Admin admin) {
		boolean signInSuccessful = false;
		try {
			connection = daoFactory.getConnection();
			statement = connection.prepareStatement("SELECT * FROM admin WHERE CasID = ? AND CasEmail = ? AND CasPass = ?;");
			statement.setString(1, admin.getID());
			statement.setString(2, admin.getEmail());
			statement.setString(3, admin.getPassword());
			
			ResultSet Adm = statement.executeQuery();
			
			if (Adm.next()) {
				String hashedID = Adm.getString("CasID"); 
				String hashedEmail = Adm.getString("CasEmail");
				String hashedPassw = Adm.getString("CasPass");
					
				if ((admin.getID().equals(hashedID)) && (admin.getEmail().equals(hashedEmail)) && (admin.getPassword().equals(hashedPassw))){
					signInSuccessful = true;
					System.out.println("Sign in successful.");
		        }
					
			}
			else {
				System.out.println("Error :(");
			}
			
			
		}catch (SQLException e) {
            e.printStackTrace();
        }
		
		return signInSuccessful;
	}

	@Override
	public void AddAssociation(Association association) {
		
		try {
			connection = daoFactory.getConnection();
			statement = connection.prepareStatement("INSERT INTO association(AssId,AssName,AssEmail,AssPassword,AssPhone,AssAddress) VALUES(?, ?, ? ,? ,? ,?);");
			statement.setString(1, association.getAssID());
			statement.setString(2, association.getAssName());
			statement.setString(3, association.getAssEmail());
			statement.setString(4, association.getAssPassword());
			statement.setString(5, association.getAssPhone());
			statement.setString(6, association.getAssAdress());
			
			statement.executeUpdate();
			System.out.println("Association Sign UP successful.");
			
		}catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public boolean VerifyAssociation(Association association) {
		boolean signInSuccessful = false;
		try {
			connection = daoFactory.getConnection();
			statement = connection.prepareStatement("SELECT * FROM association WHERE AssId = ? AND AssName = ? AND AssEmail = ? AND AssPassword = ?;");
			statement.setString(1,association.getAssID());
			statement.setString(2,association.getAssName());
			statement.setString(3,association.getAssEmail());
			statement.setString(4,association.getAssPassword());
			
			ResultSet Adm = statement.executeQuery();
			
			if (Adm.next()) {
				String hashedID = Adm.getString("AssId");
				String hashedName = Adm.getString("AssName");
				String hashedEmail = Adm.getString("AssEmail");
				String hashedPass = Adm.getString("AssPassword");
					
				if ((association.getAssID().equals(hashedID)) && (association.getAssName().equals(hashedName)) && (association.getAssEmail().equals(hashedEmail)) && (association.getAssPassword().equals(hashedPass))){
					signInSuccessful = true;
					System.out.println("Association Sign in successful.");
		        }
					
			}
			else {
				System.out.println("Error :(");
			}
			
			
		}catch (SQLException e) {
            e.printStackTrace();
        }
		
		return signInSuccessful;
	}

	@Override
	public void NewDonation(Donation donation) {
		try {
			connection = daoFactory.getConnection();
			statement = connection.prepareStatement("INSERT INTO donations(email,CasID,Amount,paymentMode,date,To_CAS,name) VALUES(?, ? ,? ,? ,?, ?, ?);");
			statement.setString(1, donation.getDonorEmail());
		    statement.setString(2, CasID);
		    statement.setDouble(3, donation.getAmount());
		    statement.setString(4, donation.getPaymentMode());
		    
		    java.util.Date utilDate = donation.getDate();
		    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		    statement.setDate(5, sqlDate);
		    
		    statement.setString(6, To_CAS);
		    statement.setString(7, donation.getDonorName());
			
			statement.executeUpdate();
			
		}catch (SQLException e) {
            e.printStackTrace();
        }
		
		
	}

	@Override
	public int DonationCountforDonor(Donateur donateur) {
		int hashedCount=-1;
		try {
			connection = daoFactory.getConnection();
			statement = connection.prepareStatement("select count(*) AS DonationCount from donations where email= ?;");
			statement.setString(1, donateur.getEmail());
			
			
			ResultSet Don = statement.executeQuery();
			if (Don.next()) {
				hashedCount = Don.getInt("DonationCount");
				System.out.println(hashedCount);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(hashedCount);
		}
		
		System.out.println(hashedCount);
		return hashedCount;
	}
	
	
	@Override
	public int AllDonationsCount() {
		int hashedCount=-1;
		try {
			connection = daoFactory.getConnection();
			statement = connection.prepareStatement("select count(*) AS DonationCount from donations;");
			
			ResultSet Don = statement.executeQuery();
			if (Don.next()) {
				hashedCount = Don.getInt("DonationCount");
				System.out.println(hashedCount);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(hashedCount);
		}
		
		System.out.println(hashedCount);
		return hashedCount;
	}
	
	

	@Override
	public List<Donation> GetDonationforDonor(Donateur donateur) {
		
		List<Donation> list=new ArrayList<>();
		try {
			connection = daoFactory.getConnection();
			statement = connection.prepareStatement("select * from donations where email=?;");
			statement.setString(1, donateur.getEmail());
			
			ResultSet Donations = statement.executeQuery();
			while(Donations.next()) {
			
				int hashedID = Donations.getInt("id");
				String hashedName = Donations.getString("name");
				String hashedEmail = Donations.getString("email");
				String hashedCasID = Donations.getString("CasID");
				double hashedAmount = Donations.getDouble("Amount");
				String hashedPMode = Donations.getString("paymentMode");
				Date hashedDate = Donations.getDate("date");
				String hashedToCAS = Donations.getString("To_CAS");
			
				
				Donation hashedDonation = new Donation();
	            hashedDonation.setId(hashedID);
	            hashedDonation.setDonorName(hashedName);
	            hashedDonation.setDonorEmail(hashedEmail);
	            hashedDonation.setCasID(hashedCasID);;
	            hashedDonation.setAmount(hashedAmount);
	            hashedDonation.setPaymentMode(hashedPMode);
	            hashedDonation.setDate(hashedDate);
	            hashedDonation.setTo_CAS(hashedToCAS);
	            
				System.out.println(hashedDonation.getAmount());
				list.add(hashedDonation);	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(list);
		return list;
	}

	@Override
	public List<Donation> GetDonationforAdmin() {
		
		List<Donation> list=new ArrayList<>();
		try {
			connection = daoFactory.getConnection();
			statement = connection.prepareStatement("select * from donations;");
			
			ResultSet Donations = statement.executeQuery();
			while(Donations.next()) {
			
				int hashedID = Donations.getInt("id");
				String hashedName = Donations.getString("name");
				String hashedEmail = Donations.getString("email");
				String hashedCasID = Donations.getString("CasID");
				double hashedAmount = Donations.getDouble("Amount");
				String hashedPMode = Donations.getString("paymentMode");
				Date hashedDate = Donations.getDate("date");
				String hashedToCAS = Donations.getString("To_CAS");
				
				Donation hashedDonation = new Donation();
	            hashedDonation.setId(hashedID);
	            hashedDonation.setDonorName(hashedName);
	            hashedDonation.setDonorEmail(hashedEmail);
	            hashedDonation.setCasID(hashedCasID);
	            hashedDonation.setAmount(hashedAmount);
	            hashedDonation.setPaymentMode(hashedPMode);
	            hashedDonation.setDate(hashedDate);
	            hashedDonation.setTo_CAS(hashedToCAS);
	            
				System.out.println(hashedDonation.getAmount());
				list.add(hashedDonation);	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(list);
		return list;
	}

	@Override
	public void NewCollaboration(Collaboration collaboration) {
		
		try {
			connection = daoFactory.getConnection();
			statement = connection.prepareStatement("INSERT INTO collaboration(With_CAS,AssID,AssName,AssEmail,Topic,Description,date,CasID) VALUES(?, ? ,? ,? ,?, ?,? ,?);");
			statement.setString(1, To_CAS);
		    statement.setString(2, collaboration.getAssID());
		    statement.setString(3, collaboration.getAssName());
		    statement.setString(4, collaboration.getAssEmail());
		    statement.setString(5, collaboration.getTopic());
		    statement.setString(6, collaboration.getDescription());
		    
		    java.util.Date utilDate = collaboration.getDate();
		    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		    statement.setDate(7, sqlDate);
		    
		    statement.setString(8, CasID);
			
			statement.executeUpdate();
			System.out.println("succeful");
			
		}catch (SQLException e) {
            e.printStackTrace();
            System.out.println("erreur");
        }
		
		
	}

	@Override
	public int CollaborationsCountforAss(Association association) {
		int hashedCount=-1;
		try {
			connection = daoFactory.getConnection();
			statement = connection.prepareStatement("select count(*) AS CollaborationCount from collaboration where AssID= ?;");
			statement.setString(1, association.getAssID());
			
			
			ResultSet Colab = statement.executeQuery();
			if (Colab.next()) {
				hashedCount = Colab.getInt("CollaborationCount");
				System.out.println(hashedCount);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(hashedCount);
		}
		
		System.out.println(hashedCount);
		return hashedCount;
	}

	@Override
	public int AllCollaborationsCount() {
		int hashedCount=-1;
		try {
			connection = daoFactory.getConnection();
			statement = connection.prepareStatement("select count(*) AS CollaborationCount from collaboration;");
			
			ResultSet Don = statement.executeQuery();
			if (Don.next()) {
				hashedCount = Don.getInt("CollaborationCount");
				System.out.println(hashedCount);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(hashedCount);
		}
		
		System.out.println(hashedCount);
		return hashedCount;
	}

	@Override
	public List<Collaboration> GetCollaborationsforAss(Association association) {
		List<Collaboration> list=new ArrayList<>();
		try {
			connection = daoFactory.getConnection();
			statement = connection.prepareStatement("select * from collaboration where AssID=?;");
			statement.setString(1, association.getAssID());
			
			ResultSet collaborations = statement.executeQuery();
			while(collaborations.next()) {
			
				int hashedID = collaborations.getInt("id");
				String hashedAssID = collaborations.getString("AssID");
				String hashedAssName = collaborations.getString("AssName");
				String hashedAssEmail = collaborations.getString("AssEmail");
				String hashedTopic = collaborations.getString("Topic");
				String hashedDescription = collaborations.getString("Description");
				Date hashedDate = collaborations.getDate("date");
				String hashedWithCas = collaborations.getString("With_CAS");
				String hashedCasID = collaborations.getString("CasID");
				String hashedAction = collaborations.getString("Action");
				
				Collaboration hashedCollaboration = new Collaboration();
				hashedCollaboration.setId(hashedID);
				hashedCollaboration.setAssID(hashedAssID);
				hashedCollaboration.setAssName(hashedAssName);
				hashedCollaboration.setAssEmail(hashedAssEmail);
				hashedCollaboration.setTopic(hashedTopic);
				hashedCollaboration.setDescription(hashedDescription);
				hashedCollaboration.setDate(hashedDate);
				hashedCollaboration.setCasID(hashedCasID);;
				hashedCollaboration.setWithCAS(hashedWithCas);
				hashedCollaboration.setAction(hashedAction);
	           
				
				list.add(hashedCollaboration);	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(list);
		return list;
	}

	@Override
	public List<Collaboration> GetCollaborationsforAdmin() {
		List<Collaboration> list=new ArrayList<>();
		try {
			connection = daoFactory.getConnection();
			statement = connection.prepareStatement("select * from collaboration;");
			
			ResultSet collaborations = statement.executeQuery();
			while(collaborations.next()) {
			
				int hashedID = collaborations.getInt("id");
				String hashedAssID = collaborations.getString("AssID");
				String hashedAssName = collaborations.getString("AssName");
				String hashedAssEmail = collaborations.getString("AssEmail");
				String hashedTopic = collaborations.getString("Topic");
				String hashedDescription = collaborations.getString("Description");
				Date hashedDate = collaborations.getDate("date");
				String hashedWithCas = collaborations.getString("With_CAS");
				String hashedCasID = collaborations.getString("CasID");
				String hashedAction = collaborations.getString("Action");
				
				Collaboration hashedCollaboration = new Collaboration();
				hashedCollaboration.setId(hashedID);
				hashedCollaboration.setAssID(hashedAssID);
				hashedCollaboration.setAssName(hashedAssName);
				hashedCollaboration.setAssEmail(hashedAssEmail);
				hashedCollaboration.setTopic(hashedTopic);
				hashedCollaboration.setDescription(hashedDescription);
				hashedCollaboration.setDate(hashedDate);
				hashedCollaboration.setCasID(hashedCasID);;
				hashedCollaboration.setWithCAS(hashedWithCas);
				hashedCollaboration.setAction(hashedAction);
	           
				
				list.add(hashedCollaboration);	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(list);
		return list;
	}

	

}
