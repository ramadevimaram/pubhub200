package examples.pubhub.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity 
@Table(name="USER_TABLE")
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    private String firstName;
    private String lastName;
    @Id
    @Column(nullable = false,unique = true)
    private String userName;
    @Column(unique = true)
    private String email;
    private String address;
    private String password;

    public User() {
    }

    
    public User(String firstName,String lastName,String userName, String email,String address,String password) {
    	
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.address= address;
        this.password = password;
    }


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

   
}
