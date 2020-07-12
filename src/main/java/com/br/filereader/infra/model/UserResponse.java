package com.br.filereader.infra.model;

import lombok.Builder;
import lombok.Getter;

/**
 * Class comments go here...
 *
 * @author André Franco
 * @version 1.0 11/07/2020
 */
@Getter
@Builder
public class UserResponse {

    private final String name;
    private final String cpf;
    private final Integer age;
    private final String phone;
    private final String address;

}
