package entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Section {

    @Id
    private int section_id;
    private int delegate_id;
    private String section_name;

}