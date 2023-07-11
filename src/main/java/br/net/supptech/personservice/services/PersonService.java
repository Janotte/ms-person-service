package br.net.supptech.personservice.services;

import br.net.supptech.personservice.models.PersonModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonService {
    List<PersonModel> getPersons();

    PersonModel savePerson(PersonModel personModel);

    Optional<PersonModel> findPersonById(UUID personId);

    void deletePerson(PersonModel personModel);
}
