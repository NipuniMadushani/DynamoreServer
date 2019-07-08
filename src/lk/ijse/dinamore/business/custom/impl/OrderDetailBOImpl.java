/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinamore.business.custom.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.ijse.dinamore.business.custom.OrderDetailBO;
import lk.ijse.dinamore.business.repository.RepositryFactory;
import lk.ijse.dinamore.business.repository.custom.OrderDetailRepositry;
import lk.ijse.dinamore.dto.OrderDetailDTO;
import lk.ijse.dinamore.entity.OrderDetail;
import lk.ijse.dinamore.resource.DBConnection;

/**
 *
 * @author acer
 */
public class OrderDetailBOImpl implements OrderDetailBO{
    
    private OrderDetailRepositry orderDetailRepositry;

    public OrderDetailBOImpl() {
        orderDetailRepositry=(OrderDetailRepositry) RepositryFactory.getInstance().getRepository(RepositryFactory.RepositryType.OD);
    }
      
    @Override
    public ArrayList<OrderDetailDTO> searchOrder(String oid) throws Exception {
        try {
            Connection connection = DBConnection.getConnection();
            orderDetailRepositry.setConnection(connection);
            
            List<OrderDetail> od = orderDetailRepositry.searchOrder(oid);
            ArrayList<OrderDetailDTO> oDto = new ArrayList<>();
            for (OrderDetail o : od) {
                OrderDetailDTO dto=new OrderDetailDTO(o.getOid(), o.getIid(), o.getQty());
                oDto.add(dto);
            }
            return oDto;
        } catch (Exception ex) {
            Logger.getLogger(OrderDetailBOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
