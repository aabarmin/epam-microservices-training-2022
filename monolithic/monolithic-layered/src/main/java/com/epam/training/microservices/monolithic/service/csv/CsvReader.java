package com.epam.training.microservices.monolithic.service.csv;

import java.util.Collection;
import java.util.Collections;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import lombok.SneakyThrows;

@Component
public class CsvReader {
    public <T> Collection<T> readResourceWithoutHeaders(Resource resource, Class<T> targetType) {
        return readResource(resource, targetType, false);
    }

    public <T> Collection<T> readResourceWithHeaders(Resource resource, Class<T> targetType) {
        return readResource(resource, targetType, true);
    }

    @SneakyThrows
    private <T> Collection<T> readResource(Resource resource, Class<T> targetType, boolean includeHeaders) {
        CsvSchema schema = includeHeaders ? 
            CsvSchema.emptySchema().withHeader() : 
            CsvSchema.emptySchema().withoutHeader();

        MappingIterator<T> values = new CsvMapper().readerFor(targetType)
            .with(schema)
            .readValues(resource.getInputStream());

        return values.readAll();
    }
}
