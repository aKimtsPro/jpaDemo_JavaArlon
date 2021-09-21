package exo.data.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Table(name = "client")
@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id", nullable = false)
    private Integer id;

    @Column(name = "client_prenom", nullable = false, length = 50)
    private String prenom;

    @Column(name = "client_nom", nullable = false, length = 50)
    private String nom;

    @Column(name = "client_adresse", nullable = false)
    private String adresse;

    @Column(name = "client_email", nullable = false, length = 100)
    private String email;

    @OneToMany(
            mappedBy = "client",
            orphanRemoval = true,
            cascade = CascadeType.ALL
    )
    private List<Commande> commandes;

}
