package br.net.supptech.personservice.services;

import br.net.supptech.personservice.models.PersonModel;

import java.util.List;

public interface PersonService {
    List<PersonModel> getPersons();
}
