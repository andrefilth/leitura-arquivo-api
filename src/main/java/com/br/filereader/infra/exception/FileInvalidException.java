package com.br.filereader.infra.exception;

/**
 * Class comments go here...
 *
 * @author André Franco
 * @version 1.0 11/07/2020
 */
public class FileInvalidException extends RuntimeException {

    public FileInvalidException(final String msg) {
        super(msg);
    }

}
