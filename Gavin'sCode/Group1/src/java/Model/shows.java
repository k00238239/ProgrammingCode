/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author gavok
 */
public class shows implements Serializable{
    private int showsID;
    private String category;
    private String department;
    private Date startingDate;
    private Date closingDate;
    private String description;

    public shows() {
    }

    public shows( String category, String department, Date startingDate, Date closingDate, String description) {
       this.showsID = showsID;
        this.category = category;
        this.department = department;
        this.startingDate = startingDate;
        this.closingDate = closingDate;
        this.description = description;
    }

    public shows(String category, String department, String  startingDate, String  closingDate, String description) {
        
        
      
    }

 

   

    /**
     * @return the showsID
     */
    public int getShowsID() {
        return showsID;
    }

    /**
     * @param showsID the showsID to set
     */
    public void setShowsID(int showsID) {
        this.showsID = showsID;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * @param department the department to set
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * @return the StartingDate
     */
    public Date getstartingDate() {
        return startingDate;
    }

    /**
     * @param StartingDate the StartingDate to set
     */
    public void setstartingDate(Date StartingDate) {
        this.startingDate = StartingDate;
    }

    /**
     * @return the closingDate
     */
    public Date getClosingDate() {
        return closingDate;
    }

    /**
     * @param closingDate the closingDate to set
     */
    public void setClosingDate(Date closingDate) {
        this.closingDate = closingDate;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
     public void getUserInput() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter category");
        category = s.next();
        System.out.println("Enter department");
        department = s.next();
        System.out.println("Enter startingDate" + startingDate);
       
        System.out.println("Enter closingDate" +closingDate);
        
    }


      public boolean createshow() {

        showsdb showsdb = new showsdb(category,department,startingDate,closingDate,description);
        return showsdb.createshow();
    }
        
    public ArrayList<shows> findAllShows() { 
    
     showsdb showdb = new showsdb();
        return showdb.findAllShows();
     
    }
   public shows findshowsByshowsID(int showsID) {
         showsdb showdb = new showsdb();
        return showdb.findshowsByshowsID(showsID);
   }
    public boolean updateshows(String showsID){
       
        showsdb showdb = new showsdb();
        return showdb.updateshows(showsID);
    }
    public boolean updateshows(){
        System.out.println("shows:update");
        this.Print();
        
          showsdb showdb = new showsdb();
        return showdb.updateshows();
    }
      public boolean deleteshows(String showsID){
       
         showsdb showdb = new showsdb();
        return showdb.deleteshows(showsID);
    }
    public boolean deleteshowsByshowsID(String showsID){
       
        showsdb showdb = new showsdb();
        return showdb.updateshows(category);
    }
        public void Print(){
            System.out.println("category " +category);
        System.out.println("department " +department);
        System.out.println("startingDate " +startingDate);
        System.out.println("closingDate " + closingDate);
        System.out.println("description" +description);
    
}
    
    
}
