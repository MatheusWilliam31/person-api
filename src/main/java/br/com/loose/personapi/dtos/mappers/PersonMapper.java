package br.com.loose.personapi.dtos.mappers;

import br.com.loose.personapi.dtos.PersonDTO;
import br.com.loose.personapi.entities.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = PhoneMapper.class)
public interface PersonMapper extends EntityMapper<PersonDTO, Person>{

}
