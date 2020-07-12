package com.br.filereader.restapi;

import com.br.filereader.infra.model.UserDocument;
import com.br.filereader.infra.model.UserResponse;
import com.br.filereader.services.ReadersCvsFilesService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Class comments go here...
 *
 * @author André Franco
 * @version 1.0 11/07/2020
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/readers", produces = APPLICATION_JSON_VALUE)
public class ReadersController {

    private final ReadersCvsFilesService filesService;

    @ApiOperation("Envia arquivo csv")
    @PostMapping(value = "/csv", consumes = "multipart/form-data")
    @ResponseStatus(CREATED)
    public @ResponseBody
    List<UserResponse> create(@RequestParam("arquivo") final MultipartFile file){

        return filesService.createFiles(file);
    }

    @ApiOperation("Listar todos")
    @GetMapping
    @ResponseStatus(OK)
    public List<UserDocument> listAll(){

        return filesService.listAll();
    }

}
