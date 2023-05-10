package com.niles.productapi.domain;

import com.niles.productapi.domain.dto.CreateRequestProductDTO;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


@Entity(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Float price;
    private String description;
    private String productIdentifier;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", productIdentifier='" + productIdentifier + '\'' +
                ", category=" + category +
                '}';
    }

    public Product(CreateRequestProductDTO dto) {
        this.name = dto.name();
        this.price = dto.price();
        this.description = dto.description();
        this.productIdentifier = dto.productIdentifier();
        this.category = dto.category();


    }
}
