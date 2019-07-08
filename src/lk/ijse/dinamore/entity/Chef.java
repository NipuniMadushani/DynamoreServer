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
public class Chef {
    @Id
    private int cid;
    private String chefName;
    private String chefContract;
    private String chefAddress;
    private int top;

    public Chef() {
    }

    public Chef(int cid, String chefName, String chefContract, String chefAddress) {
        this.cid = cid;
        this.chefName = chefName;
        this.chefContract = chefContract;
        this.chefAddress = chefAddress;
    }

    public Chef(int a, String chefName, int chefContract, String chefAddress) {
        this.cid = a;
        this.chefName = chefName;
        this.top = chefContract;
        this.chefAddress = chefAddress;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getChefName() {
        return chefName;
    }

    public void setChefName(String chefName) {
        this.chefName = chefName;
    }

    public String getChefContract() {
        return chefContract;
    }

    public void setChefContract(String chefContract) {
        this.chefContract = chefContract;
    }

    public String getChefAddress() {
        return chefAddress;
    }

    public void setChefAddress(String chefAddress) {
        this.chefAddress = chefAddress;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    @Override
    public String toString() {
        return "Chef{" + "cid=" + cid + ", chefName=" + chefName + ", chefContract=" + chefContract + ", chefAddress=" + chefAddress + ", top=" + top + '}';
    }
    
    
}
