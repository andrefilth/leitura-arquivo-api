package com.br.filereader.infra.converter;

import com.br.filereader.infra.model.UserResponse;
import org.springframework.stereotype.Component;

import static java.lang.Integer.valueOf;

/**
 * Class comments go here...
 *
 * @author André Franco
 * @version 1.0 11/07/2020
 */
@Component
public class UserResponseConverter implements Converter<String[], UserResponse> {

    @Override
    public UserResponse convert(final String[] column) {
        return UserResponse
            .builder()
            .name(column[0])
            .cpf(column[1])
            .age(valueOf(column[2]))
            .phone(column[3])
            .address(column[4])
            .build();
    }

}
