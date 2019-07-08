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
public class Report {
    @Id
    private int cid;
    private int cusId;
    private int tid;
    private int oid;
    
    private String date;
    private String processTime;
    private int qty;

    public Report() {
    }

    public Report(int cid, int cusId, int tid, int oid, String date, String processTime, int qty) {
        this.cid = cid;
        this.cusId = cusId;
        this.tid = tid;
        this.oid = oid;
        this.date = date;
        this.processTime = processTime;
        this.qty = qty;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
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

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProcessTime() {
        return processTime;
    }

    public void setProcessTime(String processTime) {
        this.processTime = processTime;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Report{" + "cid=" + cid + ", cusId=" + cusId + ", tid=" + tid + ", oid=" + oid + ", date=" + date + ", processTime=" + processTime + ", qty=" + qty + '}';
    }
    
    
}
