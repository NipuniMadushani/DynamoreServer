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
public class OrderDetail {
    @Id
    private int oid;
    private int iid;
    private int qty;

    public OrderDetail() {
    }

    public OrderDetail(int oid, int iid, int qty) {
        this.oid = oid;
        this.iid = iid;
        this.qty = qty;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "OrderDetail{" + "oid=" + oid + ", iid=" + iid + ", qty=" + qty + '}';
    }
    
    
}
