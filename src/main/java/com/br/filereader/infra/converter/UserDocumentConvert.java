package com.br.filereader.infra.converter;

import com.br.filereader.infra.model.UserModel;
import com.br.filereader.infra.model.UserResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Class comments go here...
 *
 * @author André Franco
 * @version 1.0 11/07/2020
 */
@Component
public class UserDocumentConvert implements Converter<UserResponse, UserModel> {

    @Override
    public UserModel convert(final UserResponse userResponse) {
        return UserModel
            .builder()
            .name(userResponse.getName())
            .address(userResponse.getAddress())
            .age(userResponse.getAge())
            .cpf(userResponse.getCpf())
            .phone(userResponse.getPhone())
            .createdAt(LocalDateTime.now())
            .build();
    }

}
