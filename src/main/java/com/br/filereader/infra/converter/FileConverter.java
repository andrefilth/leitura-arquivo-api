package com.br.filereader.infra.converter;

import com.br.filereader.infra.exception.FileInvalidException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Class comments go here...
 *
 * @author André Franco
 * @version 1.0 11/07/2020
 */
@Slf4j
@Component
public class FileConverter implements Converter<MultipartFile, File> {

    @Override
    public File convert(final MultipartFile multipartFile){
        File convFile = new File( multipartFile.getOriginalFilename() );
        try {
            FileOutputStream fos = new FileOutputStream( convFile );
            fos.write( multipartFile.getBytes() );
            fos.close();
            return convFile;
        }catch (IOException e){
            log.error("Error ao gerar o arquivo ");
            throw new FileInvalidException("Erro ao gerar o arquivo");
        }
    }

}
