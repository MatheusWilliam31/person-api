package br.com.loose.personapi.resources;

import br.com.loose.personapi.dtos.PersonDTO;
import br.com.loose.personapi.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/people")
@RequiredArgsConstructor
public class PersonResource {

    private final PersonService personService;

    @GetMapping
    public ResponseEntity<List<PersonDTO>> findAll(){
        return new ResponseEntity<>(personService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> findById(@PathVariable("id") Long id){
        return new ResponseEntity<>(personService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PersonDTO> save(@RequestBody PersonDTO personDTO){
        return ResponseEntity.ok(personService.save(personDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        personService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
