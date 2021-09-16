package entities.dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;

@Data
@Builder
public class SectionDTO {

    private int id;
    private Integer delegateId;
    private String name;
}
