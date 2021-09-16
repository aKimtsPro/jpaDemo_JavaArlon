package entities.business.mapper;

import entities.Section;
import entities.dto.SectionDTO;

public class SectionMapper {

    public SectionDTO entityToDto(Section entity){
        return SectionDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .delegateId(entity.getDelegateId())
                .build();
    }

}
