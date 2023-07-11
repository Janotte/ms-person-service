package br.net.supptech.personservice.services;

import br.net.supptech.personservice.models.PersonModel;
import br.net.supptech.personservice.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    PersonRepository personRepository;

    @Override
    public List<PersonModel> getPersons() {
        return personRepository.findAll();
    }
}