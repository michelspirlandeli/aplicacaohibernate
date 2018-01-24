package br.michel.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
	 * 
	 */
@Entity	
@Table(name="users")
public class User implements java.io.Serializable {

	    private static final long serialVersionUID = 1L;
	    @Id
	    @Column(name="id",nullable=false)
	    private Integer id;

	    @Column(name="name",nullable=false)
	    private String name;

	    @Column(name="login",nullable=false)
	    private String login;

	    @Column(name="password",nullable=false)
	    private String password;

	    @OneToMany(mappedBy="owner",fetch=FetchType.LAZY)
	    private List<Product> products;

	    @OneToMany(mappedBy="ownerOfSale",fetch=FetchType.LAZY)
	    private List<Sale> salesOfUser;
	    
	    public User(){
	    }

	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public String getLogin() {
	        return login;
	    }

	    public void setLogin(String login) {
	        this.login = login;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public boolean isValidPassword(String passwordToTest) {
	        return passwordToTest.equals(password);
	    }

	    public List<Product> getProducts() {
	        return products;
	    }

	    public void setProducts(List<Product> products) {
	        this.products = products;
	    }

	    public List<Sale> getSalesOfUser() {
	        return salesOfUser;
	    }

	    public void setSalesOfUser(List<Sale> salesOfUser) {
	        this.salesOfUser = salesOfUser;
	    }

	    @Override
	    public boolean equals(Object obj) {
	        if (obj == null) {
	            return false;
	        }
	        if (getClass() != obj.getClass()) {
	            return false;
	        }
	        final User other = (User) obj;
	        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
	            return false;
	        }
	        return true;
	    }

	    @Override
	    public int hashCode() {
	        int hash = 5;
	        hash = 47 * hash + (this.id != null ? this.id.hashCode() : 0);
	        return hash;
	    }

	    @Override
	    public String toString() {
	        return name;
	    }
}
