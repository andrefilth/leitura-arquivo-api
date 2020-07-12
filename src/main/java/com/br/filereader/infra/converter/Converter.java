package com.br.filereader.infra.converter;

import java.io.IOException;

/**
 * Class comments go here...
 *
 * @author André Franco
 * @version 1.0 11/07/2020
 */
@FunctionalInterface
public interface Converter<T, D> {

     D convert(final T t);

}
