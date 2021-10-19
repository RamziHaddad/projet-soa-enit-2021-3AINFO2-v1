package enit.cart.service;

//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;

//import javax.persistence.PersistenceException;
//import javax.sql.DataSource;

import enit.cart.domain.entity.*;
import enit.cart.repository.*;

import org.springframework.beans.factory.annotation.Autowired;


public class CartService {
    @Autowired
    CartRepo cartRepo;


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
    public void removeFromCart(Demande d) {
		ListIterator<Demande> iterator1 = data.listIterator();
		while(iterator1.hasNext()) {
			Demande d2 = iterator1.next();
			if (d2.productId().equals(d.productId())) {
				this.data.remove(d);
				break;
			}
		}
	}
    
}
