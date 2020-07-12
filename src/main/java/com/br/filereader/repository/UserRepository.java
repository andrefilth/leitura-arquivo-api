package com.br.filereader.repository;

import com.br.filereader.infra.model.UserDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Class comments go here...
 *
 * @author André Franco
 * @version 1.0 11/07/2020
 */
public interface UserRepository extends MongoRepository<UserDocument, String> {

}
