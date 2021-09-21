package exo.data.entity;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;

@Table(name = "commande")
@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Commande {
    @Id
    @Column(name = "commande_id", columnDefinition = "CHAR(5)", nullable = false)
    private String id;

    @Column(name = "date_creation", nullable = false)
    private LocalDateTime dateCreation;

    @Column(name = "date_confirm")
    private LocalDateTime dateConfirm;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

}
