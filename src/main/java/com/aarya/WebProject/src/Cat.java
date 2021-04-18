package com.aarya.WebProject.src;

public class Cat {
	
	private int ID;
	private String NAME;
	private char GENDER;
	private String OWNER;
	private String BIRTH;
	
	public Cat(int id, String name, char gender, String owner, String birth) {
		this.ID = id;
		this.NAME = name;
		this.GENDER = gender;
		this.OWNER = owner;
		this.BIRTH = birth;
	}
	
	public Cat(String name, char gender, String owner, String birth) {
		this(0, name, gender, owner, birth);
	}

	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}

	/**
	 * @return the nAME
	 */
	public String getNAME() {
		return NAME;
	}

	/**
	 * @return the gENDER
	 */
	public char getGENDER() {
		return GENDER;
	}

	/**
	 * @return the oWNER
	 */
	public String getOWNER() {
		return OWNER;
	}

	/**
	 * @return the bIRTH
	 */
	public String getBIRTH() {
		return BIRTH;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * @param nAME the nAME to set
	 */
	public void setNAME(String nAME) {
		NAME = nAME;
	}

	/**
	 * @param gENDER the gENDER to set
	 */
	public void setGENDER(char gENDER) {
		GENDER = gENDER;
	}

	/**
	 * @param oWNER the oWNER to set
	 */
	public void setOWNER(String oWNER) {
		OWNER = oWNER;
	}

	/**
	 * @param bIRTH the bIRTH to set
	 */
	public void setBIRTH(String bIRTH) {
		BIRTH = bIRTH;
	}
	
	
	public String toJSON() {
		StringBuilder res = new StringBuilder("{");
		
		res.append(String.format("\"ID\": %d,", ID));
		res.append(String.format("\"NAME\": \"%s\",", NAME));
		res.append(String.format("\"GENDER\": \"%c\",", GENDER));
		res.append(String.format("\"OWNER\": \"%s\",", OWNER));
		res.append(String.format("\"BIRTH\": \"%s\"", BIRTH));
		
		res.append("}");
		
		return res.toString();
	}
}
