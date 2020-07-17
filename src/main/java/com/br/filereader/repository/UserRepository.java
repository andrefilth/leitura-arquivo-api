package com.br.filereader.repository;

import com.br.filereader.infra.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Class comments go here...
 *
 * @author André Franco
 * @version 1.0 11/07/2020
 */
@Repository
public interface UserRepository extends JpaRepository<UserModel, String> {

}
