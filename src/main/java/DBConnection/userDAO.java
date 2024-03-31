package DBConnection;

import java.util.List;

import Beans.*;

public interface userDAO {

	void AddDonateur(Donateur donateur);
	
	boolean VerifyDonateur(Donateur donateur);
	
	boolean VerifyAdmin(Admin admin);

	void AddAssociation(Association association);
	
	boolean VerifyAssociation(Association association);
	
	void NewDonation(Donation donation);
	
	int DonationCountforDonor(Donateur donateur);
	
	int AllDonationsCount();
	
	List<Donation> GetDonationforDonor(Donateur donateur);
	
	List<Donation> GetDonationforAdmin();
	
	
	void NewCollaboration(Collaboration collaboration);
	
	int CollaborationsCountforAss(Association association);
	
	int AllCollaborationsCount();
	
	List<Collaboration> GetCollaborationsforAss(Association association);
	
	List<Collaboration> GetCollaborationsforAdmin();
	
}
