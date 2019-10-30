package uk.co.mruoc.jsonapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import uk.co.mruoc.file.content.ContentLoader;
import uk.co.mruoc.jsonapi.fake.FakeAttributes;
import uk.co.mruoc.jsonapi.fake.MyApiDocument;
import uk.co.mruoc.jsonapi.fake.MyApiDocumentWithId;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class ApiDocumentDefaultDeserializationTest {

    @Test
    void shouldDeserializeJsonApiDocumentWithoutCustomDeserializer() throws IOException {
        final ObjectMapper mapper = buildMapper();
        final String json = ContentLoader.loadContentFromClasspath("fake-attributes-document-without-id.json");

        final MyApiDocument document = mapper.readValue(json, MyApiDocument.class);

        assertThat(document).isEqualTo(new MyApiDocument(buildFakeAttributes()));
    }

    @Test
    void shouldDeserializeJsonApiDocumentWithUuidIdWithoutCustomDeserializer() throws IOException {
        final ObjectMapper mapper = buildMapper();
        final String json = ContentLoader.loadContentFromClasspath("fake-attributes-document-with-uuid-id.json");

        final MyApiDocumentWithId document = mapper.readValue(json, MyApiDocumentWithId.class);

        assertThat(document).isEqualTo(new MyApiDocumentWithId("94e65ed0-1334-4c78-8c8f-bfd12773d041", buildFakeAttributes()));
    }

    @Test
    void shouldDeserializeJsonApiDocumentWithStringIdWithoutCustomDeserializer() throws IOException {
        final ObjectMapper mapper = buildMapper();
        final String json = ContentLoader.loadContentFromClasspath("fake-attributes-document-with-string-id.json");

        final MyApiDocumentWithId document = mapper.readValue(json, MyApiDocumentWithId.class);

        assertThat(document).isEqualTo(new MyApiDocumentWithId("my-id", buildFakeAttributes()));
    }

    @Test
    void shouldDeserializeJsonApiDocumentWithNumericIdWithoutCustomDeserializer() throws IOException {
        final ObjectMapper mapper = buildMapper();
        final String json = ContentLoader.loadContentFromClasspath("fake-attributes-document-with-numeric-id.json");

        final MyApiDocumentWithId document = mapper.readValue(json, MyApiDocumentWithId.class);

        assertThat(document).isEqualToComparingFieldByField(new MyApiDocumentWithId(123456789, buildFakeAttributes()));
    }

    private static FakeAttributes buildFakeAttributes() {
        final FakeAttributes attributes = new FakeAttributes();
        attributes.setValue1("fake-value-1");
        attributes.setValue2("fake-value-2");
        return attributes;
    }

    private static ObjectMapper buildMapper() {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new ApiModule());
        return mapper;
    }

}
