/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import static javax.swing.text.StyleConstants.Size;
import javax.validation.constraints.Size;

/**
 *
 * @author pupil
 */
@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String Login;
    @Size(min =6)
    @Column(nullable = false)
    private String Password;
    private String salts;
    @OneToOne
    private Reader reader;

    public User() {
    }

    public User(String Login, String Password,String salts, Reader reader) {
        this.Login = Login;
        this.Password = Password;
        this.reader = reader;
        this.salts = salts;
    }

    public String getSalts() {
        return salts;
    }

    public void setSalts(String salts) {
        this.salts = salts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    @Override
    public String toString() {
        return "User{" 
                + "id=" + id 
                + ", Login=" + Login 
                + ", Password=" + Password 
                + ", reader=" + reader.getLastname() 
                + ", salts=" + salts
                + '}';
    }
    
    
}
