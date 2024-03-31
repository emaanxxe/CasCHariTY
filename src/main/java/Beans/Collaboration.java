package Beans;

import java.util.Date;

public class Collaboration {

	private int id;
	private String AssID;
	private String AssName;
	private String AssEmail;
	private String WithCAS;
	private String CasID;
	private String Topic;
	private String Description;
	private Date date;
	private String Action;
	
	public Collaboration (int id, String AID ,String AN ,String AE ,String WC ,String CI ,String T ,String desc ,Date d ,String Ac) {
		this.id=id;
		this.AssID=AID;
		this.AssName=AN;
		this.AssEmail=AE;
		this.WithCAS=WC;
		this.CasID=CI;
		this.Topic=T;
		this.Description=desc;
		this.date=d;
		this.Action=Ac;
	}

	public Collaboration(){}
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getAssID() {
		return AssID;
	}


	public void setAssID(String assID) {
		AssID = assID;
	}


	public String getAssName() {
		return AssName;
	}


	public void setAssName(String assName) {
		AssName = assName;
	}


	public String getAssEmail() {
		return AssEmail;
	}


	public void setAssEmail(String assEmail) {
		AssEmail = assEmail;
	}


	public String getWithCAS() {
		return WithCAS;
	}


	public void setWithCAS(String withCAS) {
		WithCAS = withCAS;
	}


	public String getCasID() {
		return CasID;
	}


	public void setCasID(String casID) {
		CasID = casID;
	}


	public String getTopic() {
		return Topic;
	}


	public void setTopic(String topic) {
		Topic = topic;
	}


	public String getDescription() {
		return Description;
	}


	public void setDescription(String description) {
		Description = description;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}

	public String getAction() {
		return Action;
	}

	public void setAction(String action) {
		Action = action;
	}
	
	
	
}
