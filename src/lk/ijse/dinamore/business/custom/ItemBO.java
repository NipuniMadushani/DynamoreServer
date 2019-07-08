/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinamore.business.custom;

import lk.ijse.dinamore.business.SuperBO;
import lk.ijse.dinamore.dto.ItemDTO;

/**
 *
 * @author acer
 */
public interface ItemBO extends SuperBO{
    public boolean saveItem(ItemDTO dto)throws Exception;

    public ItemDTO find(String name)throws Exception;
}
