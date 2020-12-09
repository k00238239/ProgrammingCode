/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author gavok
 */
public class showsdb {
    private String showsID;
     private String category;
    private String department;
    private Date startingDate;
    private Date closingDate;
    private String description;

    public showsdb() {
    }

    public showsdb( String category, String department, Date startingDate, Date closingDate, String description) {
      
        this.category = category;
        this.department = department;
        this.startingDate = startingDate;
        this.closingDate = closingDate;
        this.description = description;
    }

    /**
     * @return the showsID
     */
    public String getShowsID() {
        return showsID;
    }

    /**
     * @param showsID the showsID to set
     */
    public void setShowsID(String showsID) {
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
     * @return the startingDate
     */
    public Date getStartingDate() {
        return startingDate;
    }

    /**
     * @param startingDate the startingDate to set
     */
    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
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
     public boolean createshow() {
     //   boolean inserted = false;

        Connection c = DatabaseHelper.getConnection();
        String template = "INSERT INTO pieces (Category,Department,StartingDate,ClosingDate,Description) VALUES (?,?,?,?,?)";
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
       
        if (c != null) {
            try {
                PreparedStatement inserter = c.prepareStatement(template);
                inserter.setString(1, this.category);
                inserter.setString(2, this.department);
               sqlDate = new java.sql.Date(this.startingDate.getTime());
                inserter.setDate(3, sqlDate);
                 sqlDate = new java.sql.Date(this.closingDate.getTime());
                inserter.setDate(4, sqlDate);
                inserter.setString(5, this.description);
                System.out.println(inserter);
                int i = inserter.executeUpdate();
                return true;
            } catch (SQLException ex) {
                System.out.println("Error on find all " + ex);
                return false;
            }
           
        }  
        return true;
    }
     public ArrayList<shows> findAllShows() {

        System.out.println(" find all shows");
        ArrayList<shows> allshows = new ArrayList<shows>();

        Connection c = DatabaseHelper.getConnection();

        String template = "SELECT * FROM pieces";

        if (c != null) {
            try {
                PreparedStatement inserter = c.prepareStatement(template);
                ResultSet resultSet = inserter.executeQuery();

                while (resultSet.next()) {
                    shows s = new shows();
                    s.setCategory(resultSet.getString("Category" ));
                    s.setDepartment(resultSet.getString("Department"));
                    s.setstartingDate(resultSet.getDate("StartingDate" ));
                    s.setClosingDate(resultSet.getDate("ClosingDate" ));
                    s.setDescription(resultSet.getString("Description" ));

                     allshows.add(s);

                }

                System.out.println(inserter);
                inserter.close();
                c.close();
            } catch (SQLException ex) {
                System.out.println("Error on find all " + ex);
            }

        }
        return allshows;
    }
//public shows findBookByshowsID(int showsID) {
//        
//        shows show = null;
//        System.out.println(" find all shows by ID");
//        Connection c = DatabaseHelper.getConnection();
//
//        String template = "SELECT * FROM pieces where ShowsID = ?";
//        
//        if (c != null) {
//            try {
//                PreparedStatement inserter = c.prepareStatement(template);
//                inserter.setInt(1, showsID);
//                ResultSet resultSet = inserter.executeQuery();
//                System.out.println(inserter);
//                while (resultSet.next()) {
//                    shows s = new shows();
//                     s.setCategory(resultSet.getString("category"));
//                    s.setDepartment(resultSet.getString("department"));
//                    s.setstartingDate(resultSet.getDate("startingDate"));
//                   s.setClosingDate(resultSet.getDate("closingDate" ));
//                    s.setDescription(resultSet.getString("description"));
//                   
//                   
//                }
//                inserter.close();
//                c.close();
//            } catch (SQLException ex) {
//                System.out.println("Error on find all " + ex);
//            }
//
//        }
//        return findBookByshowsID(showsID);
//    }    

    
    
}
