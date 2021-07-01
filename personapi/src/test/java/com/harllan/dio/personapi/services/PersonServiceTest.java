package com.harllan.dio.personapi.services;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.harllan.dio.personapi.dto.mapper.PersonMapper;
import com.harllan.dio.personapi.dto.request.PersonDTO;
import com.harllan.dio.personapi.dto.response.MessageResponseDTO;
import com.harllan.dio.personapi.entities.Person;
import com.harllan.dio.personapi.repositories.PersonRepository;

import static com.harllan.dio.personapi.utils.PersonUtils.createFakeDTO;
import static com.harllan.dio.personapi.utils.PersonUtils.createFakeEntity;


@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {
	
	@Mock
    private PersonRepository personRepository;

    @Mock
    private PersonMapper personMapper;

    @InjectMocks
    private PersonService personService;
	
	@Test
	void testGivenPersonDTOThenReturnSuccessSavedMessage() {
	    PersonDTO personDTO = createFakeDTO();
	    Person expectedSavedPerson = createFakeEntity();
	
	    when(personMapper.toModel(personDTO)).thenReturn(expectedSavedPerson);
	    when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);
	
	    MessageResponseDTO successMessage = personService.create(personDTO);
	
	    assertEquals("Person successfully created with ID 1", successMessage.getMessage());
	}

}
