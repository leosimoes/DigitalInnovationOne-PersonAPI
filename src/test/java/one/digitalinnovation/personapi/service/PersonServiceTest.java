package one.digitalinnovation.personapi.service;

import one.digitalinnovation.personapi.dto.MessageResponseDTO;
import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.repository.PersonRepository;
import one.digitalinnovation.personapi.utils.PersonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {
    
    @Mock
    private PersonRepository personRepository;
    
    @InjectMocks
    private PersonService personService;

    @Test
    void testGiveDTOThenReturnSaveMessage() {
        PersonDTO personDTO = PersonUtils.createFakeDTO();
        Person expectedSavedPerson = PersonUtils.createFakeEntity();

        when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);

        MessageResponseDTO expectedSucessMessage = createMessageSucessResponse();

        MessageResponseDTO sucessMessage = personService.createPerson(personDTO);

        Assertions.assertEquals(expectedSucessMessage, sucessMessage);
    }

    private MessageResponseDTO createMessageSucessResponse(){
        return MessageResponseDTO
                .builder()
                .message("Created person with ID 1")
                .build();
    }

}
