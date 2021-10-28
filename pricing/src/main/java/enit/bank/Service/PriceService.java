package enit.bank.Service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import enit.bank.Entity.Price;
import enit.bank.Repository.PriceRepo;

@ApplicationScoped
public class PriceService {

    @Inject
    private PriceRepo priceRepository;

    public List<Price> getPrice() {
        return priceRepository.listAll();
    }

    @Transactional
    public void addPrice(int id, Price price) {

        priceRepository.persist(price);
    }

}
