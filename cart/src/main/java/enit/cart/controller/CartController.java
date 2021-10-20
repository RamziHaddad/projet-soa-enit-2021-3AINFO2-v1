package enit.cart.controller;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.DELETE;
import javax.ws.rs.core.Response;

import enit.cart.service.*;
import enit.cart.domain.entity.*;
import lombok.extern.slf4j.Slf4j;

//import lombok.extern.slf4j.Slf4j;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

//import javax.enterprise.context.ApplicationScoped;
//import javax.inject.Inject;
import javax.ws.rs.*;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;

@Path("cart")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
@Slf4j
public class CartController {
    
    @Inject
    //@RestClient
    CartService cartService;

    @GET
    @Path("/{id}")
    public Response getCart(@PathParam("id") Long id){
        Cart c = cartService.getCart(id);
        if(c.data.size() > 0){
            return Response.ok(cartService.getCart(id)).build();
        }else{
            return Response.status(404).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response addToCart(
        @PathParam("id") Long id, Demande demande) {
            Cart c = cartService.getCart(id);
            if(c.data.size() > 0){
                c.getData().add(demande);
                c.setData(c.getData());
                ArrayList<Demande> data= c.getData();
                cartService.addData(id, data);
            }else{
                cartService.createCart(id);
                ArrayList<Demande> data= new ArrayList<Demande>();
                data.add(demande);
                cartService.addData(id, data);
            }
            return Response.ok().build();
        }


        @DELETE
        @Path("/{id}")
        public Response deleteCart(@PathParam("id") Long id ){
             cartService.deleteCart(id);
             return Response.ok().build();
        }
    
    


}
