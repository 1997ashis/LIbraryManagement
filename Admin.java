package com.nt.model;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Map;


@Document(collection="Admin")
public class Admin implements Serializable {
    @Id
    private String id;
    private String username;
    private String password;
    //private String role; 
    public Admin() {
        
    }

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
        
    }

    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
	}

   

    
}
