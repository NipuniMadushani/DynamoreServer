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
public class TelOparator {
    @Id
    private int tid;  
    private String telName;
    private String telContract;
    private String telAddress;
    private int topQty;
    private String topDate;

    public TelOparator() {
    }

    public TelOparator(int tid, String telName, String telContract, String telAddress) {
        this.tid = tid;
        this.telName = telName;
        this.telContract = telContract;
        this.telAddress = telAddress;
        
    }
    public TelOparator(int a, int b, String c) {
        this.tid = a;
        this.topQty = b;
        this.topDate = c;
    
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTelName() {
        return telName;
    }

    public void setTelName(String telName) {
        this.telName = telName;
    }

    public String getTelContract() {
        return telContract;
    }

    public void setTelContract(String telContract) {
        this.telContract = telContract;
    }

    public String getTelAddress() {
        return telAddress;
    }

    public void setTelAddress(String telAddress) {
        this.telAddress = telAddress;
    }

    public int getTopQty() {
        return topQty;
    }

    public void setTopQty(int topQty) {
        this.topQty = topQty;
    }

    public String getTopDate() {
        return topDate;
    }

    public void setTopDate(String topDate) {
        this.topDate = topDate;
    }

    @Override
    public String toString() {
        return "TelOparator{" + "tid=" + tid + ", telName=" + telName + ", telContract=" + telContract + ", telAddress=" + telAddress + ", topQty=" + topQty + ", topDate=" + topDate + '}';
    }
    
    
}
