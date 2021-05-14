package one.digitalinnovation.personapi.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PhoneType {

    HOME("Home"),
    MOBILE("Mobile"),
    CONMERCIAL("Commercial");

    private final String description;

}
