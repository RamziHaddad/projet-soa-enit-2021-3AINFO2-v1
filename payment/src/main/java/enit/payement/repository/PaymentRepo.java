package enit.payment.repository;

import java.util.ArrayList;
import java.util.List;

import enit.payement.domain.entity.OrderToPay;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepo extends CrudRepository<OrderToPay, Long> {

}