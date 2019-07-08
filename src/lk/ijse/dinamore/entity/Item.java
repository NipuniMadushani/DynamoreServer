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
public class Item {

    @Id
    private int iid;
    private String itemName;
    private double itemPrice;

    public Item() {
    }

    public Item(int iid, String itemName, double itemPrice) {
        this.iid = iid;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public Item(String name, double price) {

        this.itemName = name;
        this.itemPrice = price;
    }

    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    @Override
    public String toString() {
        return "Item{" + "iid=" + iid + ", itemName=" + itemName + ", itemPrice=" + itemPrice + '}';
    }

}
