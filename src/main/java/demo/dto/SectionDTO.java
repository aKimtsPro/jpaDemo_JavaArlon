package demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SectionDTO {

    private int id;
    private Integer delegateId;
    private String name;
}
