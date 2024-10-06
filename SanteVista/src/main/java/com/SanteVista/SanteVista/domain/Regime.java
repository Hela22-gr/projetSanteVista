package com.SanteVista.SanteVista.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "regime")
public class Regime implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 2, max = 50)
    @Pattern(regexp = "^[a-zA-ZÀ-ÿ'\\s-]+$")
    @Column(name = "name", nullable = false,  length = 50)
    private String name;
    @Column(name = "quantityFruit", nullable = false)
    private Integer QuantityFruit;
    @Column(name = "quantityVegetable", nullable = false)
    private Integer QuantityVegetable;
    @Column(name = "quantityProtein", nullable = false)
    private Integer QuantityProtein;
    @Column(name = "quantityCereal", nullable = false)
    private Integer QuantityCereal;
    @Size(min = 2)
    @Column(name = "interdits", nullable = false)
    private String forbidden;
    @Size(min = 2)
    @Column(name = "complement", nullable = false)
    private String complement;
    private String userId;
    private boolean status=true;
}
