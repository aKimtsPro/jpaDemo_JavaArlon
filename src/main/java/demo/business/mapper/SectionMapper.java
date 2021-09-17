package demo.business.mapper;

import demo.data.entities.Section;
import demo.dto.SectionDTO;

public class SectionMapper {

    public SectionDTO entityToDto(Section entity){
        return SectionDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .delegateId(entity.getDelegateId())
                .build();
    }

}
