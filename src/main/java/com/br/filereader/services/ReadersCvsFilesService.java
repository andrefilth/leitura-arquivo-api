package com.br.filereader.services;

import com.br.filereader.infra.converter.FileConverter;
import com.br.filereader.infra.converter.UserResponseConverter;
import com.br.filereader.infra.exception.FileInvalidException;
import com.br.filereader.infra.model.UserDocument;
import com.br.filereader.infra.model.UserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.valueOf;
import static java.nio.file.Files.lines;

/**
 * Class comments go here...
 *
 * @author André Franco
 * @version 1.0 11/07/2020
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class ReadersCvsFilesService {

    private final FileConverter fileConverter;

    private final UserResponseConverter responseConverter;

    private final UserService userService;

    public List<UserResponse> createFiles(final MultipartFile file) {

        final File convert = fileConverter.convert(file);
        try {
            final List<UserResponse> users = Files.lines(Paths.get(convert.getPath()))
                .skip(1)
                .map(line -> line.split(";"))
                .map(column -> responseConverter.convert(column))
                .collect(Collectors.toList());
            userService.save(users);
            return users;
        } catch (IOException e) {
            log.error("error ao gerar o arquivo");
            throw new FileInvalidException("erro ao gerar o arquivo");
        }
    }


    public List<UserDocument> listAll() {
        return userService.listAll();
    }

}
