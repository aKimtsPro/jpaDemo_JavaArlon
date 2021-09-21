package exo.data.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Table(name = "categorie")
@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Categorie {

    @Id
    @Column(name = "categorie_id", columnDefinition = "CHAR(3)", nullable = false)
    private String id;

    @Column(name = "nom", nullable = false, length = 20)
    private String nom;

    @Column(name = "description", length = 500)
    private String description;

    @ManyToMany(mappedBy = "categories")
    private List<Produit> produits;

}
