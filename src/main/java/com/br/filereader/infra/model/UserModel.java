package com.br.filereader.infra.model;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * Class comments go here...
 *
 * @author André Franco
 * @version 1.0 11/07/2020
 */
@Builder
@Entity
@Table(name = "users")
public class UserModel {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Getter
    @NotNull
    private final String name;

    @Getter
    @NotNull
    private final String cpf;

    @Getter
    @NotNull
    private final Integer age;

    @Getter
    @NotNull
    private final String phone;

    @Getter
    @NotNull
    private final String address;

    @Getter
    @NotNull
    @Column(name = "created_at")
    private final LocalDateTime createdAt;


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
            .append("id", id)
            .append("name", name)
            .append("age", age)
            .append("phone", phone)
            .append("address", address)
            .append("createdAt", createdAt)
            .build();
    }

}
