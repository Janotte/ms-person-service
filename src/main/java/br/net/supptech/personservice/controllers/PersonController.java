package br.net.supptech.personservice.controllers;

import br.net.supptech.personservice.models.PersonModel;
import br.net.supptech.personservice.services.PersonService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping
    public ResponseEntity<List<PersonModel>> getPersons() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(personService.getPersons());
    }

    @PostMapping
    public ResponseEntity<PersonModel> createNewPerson(@RequestBody PersonModel personModel) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(personService.savePerson(personModel));
    }

    @GetMapping("/{personId}")
    public ResponseEntity<?> getPerson(@PathVariable UUID personId) {
        Optional<PersonModel> optionalPersonModel = personService.findPersonById(personId);
        if (optionalPersonModel.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person not found!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(optionalPersonModel.get());
    }

    @PutMapping("/{personId}")
    public ResponseEntity<?> updatePerson(@PathVariable UUID personId, @RequestBody PersonModel personModel) {
        Optional<PersonModel> optionalPersonModel = personService.findPersonById(personId);
        if (optionalPersonModel.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person not found!");
        }
        BeanUtils.copyProperties(personModel, optionalPersonModel.get(), "personId");
        return ResponseEntity.status(HttpStatus.OK).body(personService.savePerson(optionalPersonModel.get()));
    }
}