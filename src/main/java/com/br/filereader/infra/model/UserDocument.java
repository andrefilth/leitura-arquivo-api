package com.br.filereader.infra.model;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * Class comments go here...
 *
 * @author André Franco
 * @version 1.0 11/07/2020
 */
@Builder
@Getter
@Document(collection = "users")
public class UserDocument {

    @Id
    private final String id;
    private final String name;
    @Indexed
    private final String cpf;
    private final Integer age;
    private final String phone;
    private final String address;
    private final LocalDateTime createdAt;

    @Override
    public String toString() {
        return "UserDocument{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", cpf='" + cpf + '\'' +
            ", age=" + age +
            ", phone='" + phone + '\'' +
            ", address='" + address + '\'' +
            ", createdAt=" + createdAt +
            '}';
    }

}
