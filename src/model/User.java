/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Acer
 */
public class User {
     private String username;
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username){
        this.username=username;
    }
    
     private String password;
    public String getPassword() {
        return password;
    }
    
      public void setPassword(String password){
        this.password=password;
    
}
       private String role;
    public String getRole() {
        return password;
    }
    
      public void setRole(String role){
        this.role=role;
    
}
      public User(String username,String password,String role){
       this.username=username;
       this.role = role;
       this.password=password;
   }
}
