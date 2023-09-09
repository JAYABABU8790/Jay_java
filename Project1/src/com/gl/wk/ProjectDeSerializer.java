package com.gl.wk;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class ProjectDeSerializer {

	HashMap <Project,ArrayList<Employee>> projectMap;
	
	public ProjectDeSerializer()
	{
		projectMap = new HashMap<Project,ArrayList<Employee>>();
		
	}
	public void deSerializeProjectDetails()
	{
		FileInputStream fis;
		try {
			fis = new FileInputStream("projects.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			projectMap = (HashMap<Project, ArrayList<Employee>>) ois.readObject();
			
			Set <Entry<Project,ArrayList<Employee>>> myEntrySet = projectMap.entrySet();
			Iterator  entryIter = myEntrySet.iterator();
			while(entryIter.hasNext())
			{
				Entry <Project,ArrayList<Employee>> myEntry = (Entry<Project, ArrayList<Employee>>) entryIter.next();
				System.out.println("The Project "+myEntry.getKey()+" Has the following Employees ");
				System.out.println("Employees .............");
				System.out.println(myEntry.getValue());
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(IOException ioe)
		{
			ioe.printStackTrace();
		} catch(ClassNotFoundException cnfe)
		{
			cnfe.printStackTrace();
		}
		
	}
	public static void main(String[] args)
	{
		ProjectDeSerializer deSerializer = new ProjectDeSerializer();
		deSerializer.deSerializeProjectDetails();
	}
}

