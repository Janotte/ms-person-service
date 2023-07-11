package br.net.supptech.personservice.services;

import br.net.supptech.personservice.models.PersonModel;
import br.net.supptech.personservice.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    PersonRepository personRepository;

    @Override
    public List<PersonModel> getPersons() {
        return personRepository.findAll();
    }

    @Override
    public PersonModel savePerson(PersonModel personModel) {
        return personRepository.save(personModel);
    }

    @Override
    public Optional<PersonModel> findPersonById(UUID personId) {
        return personRepository.findById(personId);
    }

    @Override
    public void deletePerson(PersonModel personModel) {
        personRepository.delete(personModel);
    }
}