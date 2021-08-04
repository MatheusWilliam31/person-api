package br.com.loose.personapi.services;

import br.com.loose.personapi.dtos.PersonDTO;
import br.com.loose.personapi.dtos.mappers.PersonMapper;
import br.com.loose.personapi.entities.Person;
import br.com.loose.personapi.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    public List<PersonDTO> findAll(){
        return personMapper.toDto(personRepository.findAll());
    }

    public PersonDTO findById(Long id){
        Person person = personRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return personMapper.toDto(person);
    }

    public PersonDTO save(PersonDTO personDTO){
        Person person = personMapper.toEntity(personDTO);
        Person savePerson = personRepository.save(person);
        return personMapper.toDto(savePerson);
    }

    public void deleteById(Long id){
        personRepository.deleteById(id);
    }

}
