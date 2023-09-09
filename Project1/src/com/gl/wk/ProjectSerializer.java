package com.gl.wk;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class ProjectSerializer {
	ArrayList <Employee> elist1,elist2,elist3;
	
	
	HashMap <Project,ArrayList<Employee>> projectMap1;
	HashMap <Project,ArrayList<Employee>> projectMap2;
	HashMap <Project,ArrayList<Employee>> projectMap3;
	public ProjectSerializer()
	{
		elist1 = new ArrayList<Employee>();
		elist2 = new ArrayList<Employee>();
		elist3 = new ArrayList<Employee>();
	}
	public void populateProjectDetails()
	{
		elist1 = new ArrayList<Employee>();
		elist2 = new ArrayList<Employee>();
		elist3 = new ArrayList<Employee>();
		projectMap1 = new HashMap <Project,ArrayList<Employee>>();
		projectMap2 = new HashMap <Project,ArrayList<Employee>>();
		projectMap3 = new HashMap <Project,ArrayList<Employee>>();
		
		Project project1 = new Project("P1","Music Synthesizer",23);
		Project project2 = new Project("P2","Vehicle Movement Tracker",13);
		Project project3 = new Project("P3","Liquid Viscosity Finder",15);
		
		Employee e1 = new Employee("E001","Harsha","9383993933","RTNagar",1000);
		Employee e2 = new Employee("E002","Harish","9354693933","Jayanagar",2000);
		Employee e3 = new Employee("E003","Meenal","9383976833","Malleswaram",1500);
		elist1.add(e1);
		elist1.add(e2);
		elist1.add(e3);
		
		Employee e4 = new Employee("E004","Sundar","9334593933","Vijayanagar",3000);
		Employee e5 = new Employee("E005","Suman","9383678933","Indiranagar",2000);
		Employee e6 = new Employee("E006","Suma","9385493933","KRPuram",1750);
		elist2.add(e4);
		elist2.add(e5);
		elist2.add(e6);
		
		Employee e7 = new Employee("E007","Chitra","9383978933","Koramangala",4000);
		Employee e8 = new Employee("E008","Suraj","9383992133","Malleswaram",3000);
		Employee e9 = new Employee("E009","Manu","9345193933","RTNagar",2000);
		elist3.add(e7);
		elist3.add(e8);
		elist3.add(e9);
		
		projectMap1.put(project1, elist1);
		projectMap1.put(project2, elist2);
		projectMap1.put(project3, elist3); 
	}
	
	public void serializeProjectDetails(HashMap <Project,ArrayList<Employee>> projectMap)
	{
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("projects.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			populateProjectDetails();
			oos.writeObject(projectMap);
			oos.flush();
			oos.close();
			System.out.println("Serialized Map of Project Successfully...");
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
		
	}
	public static void main(String[] args)
	{
		ProjectSerializer projectSerializer = new ProjectSerializer();
		
		projectSerializer.projectMap1 = new HashMap <Project,ArrayList<Employee>>();
		//projectMap2 = new HashMap <Project,ArrayList<Employee>>();
		//projectMap3 = new HashMap <Project,ArrayList<Employee>>();
		
		Project project1 = new Project("P1","Music Synthesizer",23);
		Project project2 = new Project("P2","Vehicle Movement Tracker",13);
		Project project3 = new Project("P3","Liquid Viscosity Finder",15);
		
		Employee e1 = new Employee("E001","Harsha","9383993933","RTNagar",1000);
		Employee e2 = new Employee("E002","Harish","9354693933","Jayanagar",2000);
		Employee e3 = new Employee("E003","Meenal","9383976833","Malleswaram",1500);
		projectSerializer.elist1.add(e1);
		projectSerializer.elist1.add(e2);
		projectSerializer.elist1.add(e3);
		
		Employee e4 = new Employee("E004","Sundar","9334593933","Vijayanagar",3000);
		Employee e5 = new Employee("E005","Suman","9383678933","Indiranagar",2000);
		Employee e6 = new Employee("E006","Suma","9385493933","KRPuram",1750);
		projectSerializer.elist2.add(e4);
		projectSerializer.elist2.add(e5);
		projectSerializer.elist2.add(e6);
		
		Employee e7 = new Employee("E007","Chitra","9383978933","Koramangala",4000);
		Employee e8 = new Employee("E008","Suraj","9383992133","Malleswaram",3000);
		Employee e9 = new Employee("E009","Manu","9345193933","RTNagar",2000);
		projectSerializer.elist3.add(e7);
		projectSerializer.elist3.add(e8);
		projectSerializer.elist3.add(e9);
		
		projectSerializer.projectMap1.put(project1, projectSerializer.elist1);
		projectSerializer.projectMap1.put(project2, projectSerializer.elist2);
		projectSerializer.projectMap1.put(project3, projectSerializer.elist3);
		projectSerializer.serializeProjectDetails(projectSerializer.projectMap1);
	}
	

}

