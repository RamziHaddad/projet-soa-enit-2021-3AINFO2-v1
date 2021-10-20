package enit.cart.service;

//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;

//import javax.persistence.PersistenceException;
//import javax.sql.DataSource;

import enit.cart.domain.entity.*;
import enit.cart.repository.*;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;


public class CartService {
    @Autowired
    CartRepo cartRepo;
    private Long id;
    private ArrayList<Demande> demande;


    public Cart getCart(Long id){
        Cart c = new Cart();
        c.setCartId(id);
        cartRepo.findById(id).map((cart) -> {
            if(cart.data.size() > 0){
                c.setData(cart.data);
            }
            return c;
        });
        return c;
    }
    public void createCart(Long id){
        Cart c=new Cart();
        c.setCartId(id);
        cartRepo.save(c);
    }
    public void addData(Long id, ArrayList<Demande> data){
       cartRepo.deleteById(id);
       Cart c=new Cart();
       c.setCartId(id);
       c.setData(data);
       cartRepo.save(c);

    }
    public void deleteCart(Long id){
        cartRepo.deleteById(id);
    }
}
