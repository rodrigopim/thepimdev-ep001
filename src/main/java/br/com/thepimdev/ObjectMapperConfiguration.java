package br.com.thepimdev;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;

import io.quarkus.arc.All;
import io.quarkus.jackson.ObjectMapperCustomizer;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Singleton;

public class ObjectMapperConfiguration {

    @Singleton
    @Produces
    ObjectMapper objectMapper(@All List<ObjectMapperCustomizer> cutomizers) {
        ObjectMapper mapper = JsonMapper.builder()
            // .configure(SerializationFeature.WRAP_ROOT_VALUE, true)
            .configure(SerializationFeature.INDENT_OUTPUT, true)
            .build();

        // ObjectMapper mapper = new ObjectMapper();
        // mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
        // mapper.configure(SerializationFeature.INDENT_OUTPUT, true);

        for (ObjectMapperCustomizer customizer : cutomizers) {
            customizer.customize(mapper);
        }
        return mapper;
    }
}
