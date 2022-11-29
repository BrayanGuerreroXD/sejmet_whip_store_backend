package com.project.sejmet.controllers;

import com.project.sejmet.entities.Sale;
import com.project.sejmet.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/sales")
public class SaleController {

    @Autowired
    SaleRepository saleRepository;


    @GetMapping
    public List<Sale> getSaleAll() {
        return saleRepository.findAll();
    }


    @GetMapping("/{id}")
    public Sale getSalebyId(@PathVariable int id) {

        Optional<Sale> sale = saleRepository.findById(id);

        if (sale.isPresent()) {
            return sale.get();
        }

        return null;
    }


    @PostMapping
    public Sale postSale(@RequestBody Sale sale) {
        saleRepository.save(sale);
        return sale;
    }


    @PutMapping("/{id}")
    public Sale putSalebyId(@PathVariable int id, @RequestBody Sale sale) {

        Optional<Sale> saleCurrent = saleRepository.findById(id);

        if (saleCurrent.isPresent()) {
            Sale saleReturn = saleCurrent.get();

            saleReturn.setUser(sale.getUser());
            saleReturn.setSaleDate(sale.getSaleDate());
            saleReturn.setDeliveryDate(sale.getDeliveryDate());
            saleReturn.setTotalPrice(sale.getTotalPrice());

            saleRepository.save(saleReturn);
            return saleReturn;
        }

        return null;
    }


    @DeleteMapping("/{id}")
    public Sale deleteSalebyId(@PathVariable int id) {

        Optional<Sale> sale = saleRepository.findById(id);

        if (sale.isPresent()) {
            Sale saleReturn = sale.get();
            saleRepository.deleteById(id);
            return saleReturn;
        }

        return null;
    }
}
