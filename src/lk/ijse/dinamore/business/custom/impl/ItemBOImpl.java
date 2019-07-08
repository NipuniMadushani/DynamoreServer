/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinamore.business.custom.impl;

import java.sql.Connection;
import lk.ijse.dinamore.business.custom.ItemBO;
import lk.ijse.dinamore.business.repository.RepositryFactory;
import lk.ijse.dinamore.business.repository.custom.ItemRepositry;
import lk.ijse.dinamore.dto.ItemDTO;
import lk.ijse.dinamore.entity.Item;
import lk.ijse.dinamore.resource.DBConnection;

/**
 *
 * @author acer
 */
public class ItemBOImpl implements ItemBO{
    
    private ItemRepositry itemRepositry;

    public ItemBOImpl() {
        itemRepositry=(ItemRepositry) RepositryFactory.getInstance().getRepository(RepositryFactory.RepositryType.ITEM);
    }
    
    
    @Override
    public boolean saveItem(ItemDTO dto) throws Exception {
        Connection connection=DBConnection.getConnection();
        itemRepositry.setConnection(connection);
        Item i=new Item(dto.getIid(), dto.getItemName(), dto.getQty());
        return itemRepositry.save(i);
    }

    @Override
    public ItemDTO find(String name) throws Exception {
        Connection connection=DBConnection.getConnection();
        itemRepositry.setConnection(connection);
        Item i=itemRepositry.find(name);
        if(i!=null){
            return new ItemDTO(i.getIid(), i.getItemName(), i.getItemPrice());
        }
        return null;
    }
    
}
