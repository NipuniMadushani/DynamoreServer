/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinamore.business.custom;

import java.util.ArrayList;
import lk.ijse.dinamore.business.SuperBO;
import lk.ijse.dinamore.dto.OrderDetailDTO;

/**
 *
 * @author acer
 */
public interface OrderDetailBO extends SuperBO{
    public ArrayList<OrderDetailDTO> searchOrder(String oid)throws Exception ;
}
