package business.mapper;

import data.entities.Section;
import dto.SectionDTO;

public class SectionMapper {

    public SectionDTO entityToDto(Section entity){
        return SectionDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .delegateId(entity.getDelegateId())
                .build();
    }

}
