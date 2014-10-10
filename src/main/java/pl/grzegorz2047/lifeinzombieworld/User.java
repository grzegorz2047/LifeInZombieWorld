/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.grzegorz2047.lifeinzombieworld;

public class User {
    
    
    private String name;
  
    public User(String username){
        this.name = username;
    }
  
    public String getName(){
        return this.name;
    }
  
    public void setName(String name){
        this.name = name;
    }
}
