package enit.bank.Repository;

import javax.enterprise.context.ApplicationScoped;

import enit.bank.Entity.Price;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class PriceRepo implements PanacheRepository<Price> {

}
