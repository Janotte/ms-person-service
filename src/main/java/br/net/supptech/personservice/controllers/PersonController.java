package br.net.supptech.personservice.controllers;

import br.net.supptech.personservice.models.PersonModel;
import br.net.supptech.personservice.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}