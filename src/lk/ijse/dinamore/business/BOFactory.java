/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinamore.business;

import lk.ijse.dinamore.business.custom.impl.ChefBOImpl;
import lk.ijse.dinamore.business.custom.impl.CustomerBOImpl;
import lk.ijse.dinamore.business.custom.impl.ItemBOImpl;
import lk.ijse.dinamore.business.custom.impl.OrderDetailBOImpl;
import lk.ijse.dinamore.business.custom.impl.TelBOImpl;

/**
 *
 * @author acer
 */
public class BOFactory {

    private static BOFactory businesssFactory;

    public BOFactory() {
    }

    public enum BOType {
        CUSTOMER, ORDERS, ITEM, OD, CHEF, TEL
    }

    public static BOFactory getInstance() {
        if (businesssFactory == null) {
            businesssFactory = new BOFactory();
        }
        return businesssFactory;
    }

    public SuperBO getBOType(BOType type) {
        switch (type) {
            case TEL:
                return new TelBOImpl();
            case CUSTOMER:
                return new CustomerBOImpl();
            case ORDERS:
                return new OrderDetailBOImpl();
            case ITEM:
                return new ItemBOImpl();
            case OD:
                return new OrderDetailBOImpl();
            case CHEF:
                return new ChefBOImpl();
            default:
                return null;

        }
    }
}
