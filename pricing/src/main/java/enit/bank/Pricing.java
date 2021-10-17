package enit.bank;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.Path;


@Path("/api/price")
public class Pricing {
    int id;
    float price;
    float promo;

    @POST
    @Path("/price/set/new")
    protected void affecterPrix(float price){
        this.price=price;
    }

    @POST
    @Path("/price/set/maj")
    protected void majPrix(float newPrice){
        this.price= newPrice;

    }

    @GET
    @Path("/price/product")
    public String getPrixProduit (int idProduit){
        if(this.id==idProduit){
            return String.valueOf(this.price);
        }
        else {
            return ("le produit n'existe pas") ;
        }
    }

    @POST
    @Path("/promo/set/product")
    protected void ajouterPromoProduit(int idProduit, float newPromo){
        this.promo= newPromo;
    }

    @POST
    @Path("/promo/maj/product")
    protected void majPromoProduit(float promoMAJ){
        this.promo=promoMAJ;

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

    @GET
    @Path("/price/total")
    public float getPrixTotal(int id, int quantity){
        return 0;
    }
}