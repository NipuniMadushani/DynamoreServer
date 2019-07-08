/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinamore.business.custom;

import java.util.ArrayList;
import lk.ijse.dinamore.business.SuperBO;
import lk.ijse.dinamore.dto.ChefDTO;

/**
 *
 * @author acer
 */
public interface ChefBO extends SuperBO{
    public ArrayList<ChefDTO> view()throws Exception;
    public ArrayList<ChefDTO> chefReport(String name)throws Exception;
}
