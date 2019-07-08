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
public class Customer_TpOperator {
    @Id
    private int cusId;
    private int tid;
    private String dateTime;

    public Customer_TpOperator() {
    }

    public Customer_TpOperator(int cusId, int tid, String dateTime) {
        this.cusId = cusId;
        this.tid = tid;
        this.dateTime = dateTime;
    }

    public int getCusId() {
        return cusId;
    }

    public void setCusId(int cusId) {
        this.cusId = cusId;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Customer_TpOperator{" + "cusId=" + cusId + ", tid=" + tid + ", dateTime=" + dateTime + '}';
    }
    
    
}
