/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinamore.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author acer
 */
@Entity
public class ChefLogin {
    @Id
    private int cid;
    private String userName;
    private String password;

    public ChefLogin() {
    }

    public ChefLogin(int cid, String userName, String password) {
        this.cid = cid;
        this.userName = userName;
        this.password = password;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ChefLogin{" + "cid=" + cid + ", userName=" + userName + ", password=" + password + '}';
    }
    
    
}
