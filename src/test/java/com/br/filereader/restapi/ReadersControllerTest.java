package com.br.filereader.restapi;

import com.br.filereader.BaseTest;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.io.File;

import static io.restassured.RestAssured.*;
import static io.restassured.http.ContentType.*;
import static org.hamcrest.Matchers.*;
import static org.springframework.http.HttpStatus.*;

/**
 * Class comments go here...
 *
 * @author André Franco
 * @version 1.0 11/07/2020
 */
class ReadersControllerTest extends BaseTest {


    @DisplayName("Dado um arquivo, validar os dados e salvar no banco de dados.")
    @Test
    public void testPost(){
        File avatarFile = new File("/Users/andrefranco/git/filereader/src/test/resources/arquivo.csv");
        given()
            .multiPart("arquivo", avatarFile)
            .when()
            .post("/api/readers/csv")
            .then()
            .statusCode(CREATED.value())
            .body("name", hasItem("Biel"))
            ;
    }




}