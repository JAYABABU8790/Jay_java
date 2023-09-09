package com.glca.serialization;

import java.io.*;
import java.util.*;

class Employee implements Serializable{
    String EmployeeId;
    String EmployeeName;
    String EmployeePhone;
    String EmployeeAddress;
    int EmployeeSalary;

    public Employee(String EmployeeId,String EmployeeName,String EmployeePhone,String EmployeeAddress,int EmployeeSalary){
        this.EmployeeId=EmployeeId;
        this.EmployeeName=EmployeeName;
        this.EmployeePhone=EmployeePhone;
        this.EmployeeAddress=EmployeeAddress;
        this.EmployeeSalary=EmployeeSalary;
    }
    @Override
    public String toString(){
        return "Employee[employeeId="+EmployeeId+",EmployeeName="+EmployeeName+
                ",EmployeePhone="+EmployeePhone+",EmployeeAddress="+EmployeeAddress+
                ",EmployeeSalary="+EmployeeSalary+"]";

    }
}
class Project implements Serializable {
    String projectCode;
    String projectName;
    int projectStrength;

    public Project(String projectCode,String projectName,int projectStrength){
        this.projectCode=projectCode;
        this.projectName=projectName;
        this.projectStrength=projectStrength;
    }
    @Override
    public String toString(){
        return "Project [projectCode="+projectCode+",projectName="+projectName+"," +
                "projectStrength="+projectStrength+"]";
    }
}
class ProjectSerializer{
    List<Employee>elist1=new ArrayList<>();
    List<Employee>elist2=new ArrayList<>();
    List<Employee>elist3=new ArrayList<>();
    Map<Project,List<Employee>>projectMap1=new LinkedHashMap<>();

    public void serializeProjectDetails(Map<Project,List<Employee>>projectMap){
        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("project_data.ser"))){
            oos.writeObject(projectMap);
            System.out.println("Serialized data");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void deserializeProjectDetails(){
        try (ObjectInputStream ois=new ObjectInputStream(new FileInputStream("project_data.ser"))){
            Map<Project,List<Employee>>deserializeMap=(Map<Project, List<Employee>>)ois.readObject();
            for (Map.Entry<Project,List<Employee>>entry:deserializeMap.entrySet()){
                Project project=entry.getKey();
                List<Employee>employees=entry.getValue();
                System.out.println("Deserialize Data:");
                System.out.println("The Project");
                System.out.println(project);
                System.out.println("Has the following Employees");
                System.out.println("Employees.........");

                System.out.println(employees);
            }
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

}

public class Serialization {
    public static void main(String[] args) {
        Project project1 = new Project("P1","Music Synthesizer",23);
        Project project2 = new Project("P2","Vehicle Movement Tracker",13);
        Project project3 = new Project("P3","Liquid Viscosity Finder",15);

        Employee e1 = new Employee("E001","Harsha","9383993933","RTNagar",1000);
        Employee e2 = new Employee("E002","Harish","9354693933","Jayanagar",2000);
        Employee e3 = new Employee("E003","Meenal","9383976833","Malleswaram",1500);


        Employee e4 = new Employee("E004","Sundar","9334593933","Vijayanagar",3000);
        Employee e5 = new Employee("E005","Suman","9383678933","Indiranagar",2000);
        Employee e6 = new Employee("E006","Suma","9385493933","KRPuram",1750);


        Employee e7 = new Employee("E007","Chitra","9383978933","Koramangala",4000);
        Employee e8 = new Employee("E008","Suraj","9383992133","Malleswaram",3000);
        Employee e9 = new Employee("E009","Manu","9345193933","RTNagar",2000);

        ProjectSerializer projectSerializer=new ProjectSerializer();

        projectSerializer.elist1.addAll(Arrays.asList(e1,e2,e3));
        projectSerializer.elist2.addAll(Arrays.asList(e4,e5,e6));
        projectSerializer.elist3.addAll(Arrays.asList(e7,e8,e9));

        projectSerializer.projectMap1.put(project1,projectSerializer.elist1);
        projectSerializer.projectMap1.put(project2,projectSerializer.elist2);
        projectSerializer.projectMap1.put(project3,projectSerializer.elist3);

        projectSerializer.serializeProjectDetails(projectSerializer.projectMap1);
        projectSerializer.deserializeProjectDetails();

    }
}
