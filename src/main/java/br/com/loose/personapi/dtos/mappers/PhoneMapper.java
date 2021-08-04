package br.com.loose.personapi.dtos.mappers;

import br.com.loose.personapi.dtos.PhoneDTO;
import br.com.loose.personapi.entities.Phone;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PhoneMapper extends EntityMapper<PhoneDTO, Phone> {

}
