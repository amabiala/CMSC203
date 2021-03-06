

import java.io.*;
import java.util.*;

public class ManagementCompany {

	private String name;
	private String taxID;
	private Property[] properties;
	private double mgmFeePer;
	private final int MAX_PROPERTY=5;
	private final int MGMT_WIDTH=10;
	private int MGMT_DEPTH=10;
	private Plot plot;
	private int count=0;

	public ManagementCompany() {
		name=" ";
		taxID=" ";
		mgmFeePer=0;
		properties=new Property[MAX_PROPERTY];
		plot=new Plot();
		
	}

	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.name=name;
		this.taxID=taxID;
		mgmFeePer=mgmFee;
		properties=new Property[MAX_PROPERTY];
		
	}

	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
		this.name=name;
		this.taxID=taxID;
		mgmFeePer=mgmFee;	
		properties=new Property[MAX_PROPERTY];
		plot=new Plot(x,y,width,depth);
	}

	public ManagementCompany(ManagementCompany otherCompany) {
		name=otherCompany.name;
		taxID=otherCompany.taxID;
		mgmFeePer=otherCompany.mgmFeePer;
		plot=new Plot(otherCompany.plot);
		properties=new Property[MAX_PROPERTY];
	}

	public int addProperty(Property property) {
		if (property==null) {
			return -1;
		}
		if(count>MAX_PROPERTY) {
			return -2;
		}
		if (!(plot.encompasses(property.getPlot()))) {
			return -3;
		}
		for(int i=0; i<count;i++) {
			if(properties[i].getPlot().overlaps(property.getPlot())) {
				return -4;
		}
		}
		properties[count]=property;
		count++;
		return count-1;
		
	}

	public int addProperty(String propertyName, String city, double rentAmount, String owner) {
		Property property=new Property(propertyName,city,rentAmount,owner);
		return addProperty(property);
			
	}

	public int addProperty(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
		Property property=new Property(propertyName,city,rentAmount,owner,x,y,width,depth);
		return addProperty(property);
	}

	public double totalRent() {
		double totalRent=0;
		for(int i=0; i<MAX_PROPERTY;i++) {
			totalRent+= properties[i].getRentAmount();
		}
		return totalRent;
	}

	public String maxRentProp() {
		double maxRent;
		String output=null;
		maxRent=properties[0].getRentAmount();
		for(int i=1; i<MAX_PROPERTY;i++) {
			if(maxRent<properties[i].getRentAmount()) {
				maxRent=properties[i].getRentAmount();
			}
			if(maxRent==properties[i].getRentAmount()) {
				output="The property with the highest rent:\n"+properties[i].toString();
			}
		}
		return output;
	}

	public int maxPropertyRentIndex() {
		double maxRent;
		int index=0;
		maxRent=properties[0].getRentAmount();
		for(int i=1; i<MAX_PROPERTY;i++) {
			if(maxRent<properties[i].getRentAmount()) {
				maxRent=properties[i].getRentAmount();
				index=i;
			}
		}
		return index;
	}

	private String displayPropertyAtIndex(int i) {
		return properties[i].toString();
	}

	public String toString() {
		String output=null;
		output+="List of the properties for: "+name+", taxID: "+taxID+"\n";
		output+="______________________________________________________\n";
	
		for(int i=0; i<properties.length;i++) {
			output+=properties[i].toString()+"\n";
		}
		output+="______________________________________________________\n";
		output+="Total management fee: "+totalRent()*mgmFeePer/100;
		return output;
	}

}
