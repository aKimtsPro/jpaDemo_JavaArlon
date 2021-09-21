package demo.data.entities;

import lombok.*;

import javax.persistence.*;

//@Entity
@Table(name = "section") // pas nécessaire car l'entité
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Section {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "section_id")
    private int id;
    @Column(name = "delegate_id", insertable = false)
    private Integer delegateId;
    @Column(name = "section_name")
    private String name;


}
