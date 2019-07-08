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
public class TelOperatorLogin {
    @Id
    private int tid;
    private String userName;
    private String password;

    public TelOperatorLogin() {
    }

    public TelOperatorLogin(int tid, String userName, String password) {
        this.tid = tid;
        this.userName = userName;
        this.password = password;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
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
        return "TelOperatorLogin{" + "tid=" + tid + ", userName=" + userName + ", password=" + password + '}';
    }
    
    
}
