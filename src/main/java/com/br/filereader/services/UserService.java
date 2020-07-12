package com.br.filereader.services;

import com.br.filereader.infra.converter.UserDocumentConvert;
import com.br.filereader.infra.model.UserDocument;
import com.br.filereader.infra.model.UserResponse;
import com.br.filereader.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class comments go here...
 *
 * @author André Franco
 * @version 1.0 11/07/2020
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserDocumentConvert documentConvert;

    private final UserRepository repository;

    public void save(final List<UserResponse> users) {

        users.stream()
            .map(doc -> documentConvert.convert(doc))
            .forEach(saved ->{
                final UserDocument save = repository.save(saved);
                log.info("Salvo [] ", save);
            });

        log.info("Salvo com sucesso");


    }

    public List<UserDocument> listAll(){

        return  repository.findAll();
    }

}
