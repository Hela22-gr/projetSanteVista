package com.SanteVista.SanteVista.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ActivitePhysique implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 2, max = 50)
    @Pattern(regexp = "^[a-zA-ZÀ-ÿ'\\s-]+$")
    @Column(name = "name", nullable = false,  length = 50)
    private String name;
    @Column(name = "duree")
    private Integer duree;
    private String link;
    private Integer repetition;

    //private String[] userIds;

    @ElementCollection
    @CollectionTable(name = "activite_physique_user_ids", joinColumns = @JoinColumn(name = "activite_physique_id"))
    @Column(name = "user_id")
    private Set<String> userIds = new HashSet<>();

}
