package com.niles.productapi.service;

import com.niles.productapi.domain.Product;
import com.niles.productapi.domain.dto.CreateRequestProductDTO;
import com.niles.productapi.domain.dto.SearchResponseProductDTO;
import com.niles.productapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<SearchResponseProductDTO> getAll() {
        var products = repository.findAll();
        var productList = products.stream().map(SearchResponseProductDTO::new).collect(Collectors.toList());
        return productList;
    }

    public SearchResponseProductDTO findById(Long id) {
        var product = repository.getReferenceById(id);
        if (product != null) {
            return new SearchResponseProductDTO(product);
        }
        return null;
    }

    public List<SearchResponseProductDTO> getProductByCategoryId(Long id) {
        List<Product> product = repository.getProductByCategory(id);
        if (product != null) {
            var productCategory = product.stream().map(SearchResponseProductDTO::new).collect(Collectors.toList());
            return productCategory;
        }
        return null;
    }

    public SearchResponseProductDTO findByProductIdentifier(String productIdentifier) {
        Product product = repository.findByProductIdentifier(productIdentifier);
        if (product != null) {
            return new SearchResponseProductDTO(product);
        }
        return null;
    }

    public void save(CreateRequestProductDTO dto) {
        if (dto != null) {
            repository.save(new Product(dto));
        }
    }

    public void delete(Long id) {
        Optional<Product> product = repository.findById(id);
        if (product.isPresent()) {
            repository.delete(product.get());
        }
    }

}

