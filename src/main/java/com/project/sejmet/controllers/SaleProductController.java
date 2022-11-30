package com.project.sejmet.controllers;

import com.project.sejmet.entities.SaleProduct;
import com.project.sejmet.repository.SaleProductRepository;
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
@RequestMapping("/sales_products")
public class SaleProductController {

    @Autowired
    SaleProductRepository saleProductRepository;


    @GetMapping
    public List<SaleProduct> getSaleProductAll() {
        return saleProductRepository.findAll();
    }


    @GetMapping("/{id}")
    public SaleProduct getSaleProductbyId(@PathVariable int id) {

        Optional<SaleProduct> saleProduct = saleProductRepository.findById(id);

        if (saleProduct.isPresent()) {
            return saleProduct.get();
        }

        return null;
    }


    @PostMapping
    public SaleProduct postSaleProduct(@RequestBody SaleProduct saleProduct) {
        saleProductRepository.save(saleProduct);
        return saleProduct;
    }


    @PutMapping("/{id}")
    public SaleProduct putSaleProductbyId(@PathVariable int id, @RequestBody SaleProduct saleProduct) {

        Optional<SaleProduct> saleProductCurrent = saleProductRepository.findById(id);

        if (saleProductCurrent.isPresent()) {
            SaleProduct saleProductReturn = saleProductCurrent.get();

            saleProductReturn.setSale(saleProduct.getSale());
            saleProductReturn.setProduct(saleProduct.getProduct());
            saleProductReturn.setProductAmount(saleProduct.getProductAmount());

            saleProductRepository.save(saleProductReturn);
            return saleProductReturn;
        }

        return null;
    }


    @DeleteMapping("/{id}")
    public SaleProduct deleteSaleProductbyId(@PathVariable int id) {

        Optional<SaleProduct> saleProduct = saleProductRepository.findById(id);

        if (saleProduct.isPresent()) {
            SaleProduct saleProductReturn = saleProduct.get();
            saleProductRepository.deleteById(id);
            return saleProductReturn;
        }

        return null;
    }
}
