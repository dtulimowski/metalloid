package io.parser;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


public class FileParser {

    @Service
    public class CsvHandler {    public <T> List<T> handle(CsvSchema csvSchema, String classPathResource, Class<T> model) throws IOException {
        return mapRecordsToObjects(csvSchema, classPathResource, model);
    }    <U> List<U> mapRecordsToObjects(CsvSchema csvSchema, String classPathResource, Class<U> encodingType) throws IOException {
        CsvMapper csvMapper = new CsvMapper();
        csvMapper.enable(CsvParser.Feature.IGNORE_TRAILING_UNMAPPABLE);        ObjectReader reader = csvMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .readerFor(encodingType)
                .with(csvSchema);        MappingIterator<U> iterator;
        iterator = reader.readValues(new InputStreamReader(new FileInputStream(new ClassPathResource(classPathResource).getFile()), StandardCharsets.UTF_8));
        List<U> results = new ArrayList<>();
        iterator.forEachRemaining(results::add);
        return results;
    }
    }
}
