package enit.bank;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/persons")
public class Pricing {
    int idProduct;
    float prix;
    float promo;

    @POST
    @Path("/price/set/new")
    protected void affecterPrix(float prix){

    }

    @POST
    @Path("/price/set/maj")
    protected void majPrix(float prix){

    }

    @GET("/price/product/{pricing}")
    @Path("/price/product")
    public float getPrixProduit(int id){
        return 0.0;
    }

    @POST
    @Path("/promo/set/product")
    protected void ajouterPromoProduit(float promo){

    }

    @POST
    @Path("/promo/maj/product")
    protected void majPromoProduit(float promo){

    }

    @PUT
    @Path("/promo/activate/product")
    protected void activerPromoProduit(){

    }

    @DELETE
    @Path("/promo/desactivate/product")
    protected void desactiverPromoProduit(){

    }

    @POST
    @Path("/promo/set/Categorie")
    protected void ajouterPromoCategorie(float promo){

    }

    @POST
    @Path("/promo/maj/Categorie")
    protected void majPromoCategorie(float promo){

    }

    @PUT
    @Path("/promo/activate/Categorie")
    protected void activerPromoCategorie(){

    }

    @DELETE
    @Path("/promo/desactivate/Categorie")
    protected void desactiverPromoCategorie(){

    }

    @GET("/price/total/{pricing}")
    @Path("/price/total")
    public float getPrixTotal(int id, int quantite){
        return 0.0;
    }
}
