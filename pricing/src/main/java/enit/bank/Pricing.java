package enit.bank;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import enit.bank.Entity.Price;
import enit.bank.Entity.Product;
import enit.bank.Service.PriceService;

@ApplicationScoped
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Pricing {

    int id;
    float price;
    float promo;

    @Inject
    private PriceService priceService;

    Product prod;

    @POST
    @Path("/add/price")
    @Produces("application/json")
    public Response addPrice(Price price) {
        priceService.addPrice(prod.getId(), price);
        return Response.ok().build();
    }

    @GET
    @Path("/prices")
    @Produces("application/json")
    public Response getProduct() {
        List<Price> price = priceService.getPrice();
        return Response.ok(price).build();
    }

    @POST
    @Path("/price/set/new")
    protected void affecterPrix(float price) {
        this.price = price;
    }

    @POST
    @Path("/price/set/maj")
    protected void majPrix(float newPrice) {
        this.price = newPrice;

    }

    @GET
    @Path("/price/product")
    public String getPrixProduit(int idProduit) {
        if (this.id == idProduit) {
            return String.valueOf(this.price);
        } else {
            return ("le produit n'existe pas");
        }
    }

    @POST
    @Path("/promo/set/product")
    protected void ajouterPromoProduit(int idProduit, float newPromo) {
        this.promo = newPromo;
    }

    @POST
    @Path("/promo/maj/product")
    protected void majPromoProduit(float promoMAJ) {
        this.promo = promoMAJ;

    }

    @PUT
    @Path("/promo/activate/product")
    protected void activerPromoProduit(float promo, int idProduit) {
        if (this.id == idProduit) {
            float prixPromo = this.price * (1 - (promo / 100));
            majPrix(prixPromo);
        }
    }

    @DELETE
    @Path("/promo/desactivate/product")
    protected void desactiverPromoProduit(float promo, int idProduit) {
        if (this.id == idProduit) {
            float oldPrice = this.price * (1 + (promo / 100));
            majPrix(oldPrice);
        }

    }

    @POST
    @Path("/promo/set/Categorie")
    protected void ajouterPromoCategorie() {
    }

    @POST
    @Path("/promo/maj/Categorie")
    protected void majPromoCategorie(float promo) {

    }

    @PUT
    @Path("/promo/activate/Categorie")
    protected void activerPromoCategorie() {

    }

    @DELETE
    @Path("/promo/desactivate/Categorie")
    protected void desactiverPromoCategorie() {

    }

    @GET
    @Path("/price/total")

    public float getPrixTotal(int id, int quantity) {
        return price * quantity;
    }

}