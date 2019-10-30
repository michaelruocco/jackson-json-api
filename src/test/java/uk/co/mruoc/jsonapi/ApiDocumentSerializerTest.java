package uk.co.mruoc.jsonapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import uk.co.mruoc.file.content.ContentLoader;
import uk.co.mruoc.jsonapi.fake.DefaultFakeDomainObject;
import uk.co.mruoc.jsonapi.fake.FakeApiDocument;
import uk.co.mruoc.jsonapi.fake.FakeApiDocumentWithId;
import uk.co.mruoc.jsonapi.fake.FakeApiModule;

import java.util.UUID;

import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;

class ApiDocumentSerializerTest {

    private static final ObjectMapper MAPPER = buildMapper();

    @Test
    void shouldSerializeJsonApiDocumentWithoutId() throws JsonProcessingException {
        final FakeApiDocument document = new FakeApiDocument(new DefaultFakeDomainObject());

        final String json = MAPPER.writeValueAsString(document);

        final String expectedJson = ContentLoader.loadContentFromClasspath("fake-attributes-document-without-id.json");
        assertThatJson(json).isEqualTo(expectedJson);
    }

    @Test
    void shouldSerializeJsonApiDocumentWithUuidId() throws JsonProcessingException {
        final FakeApiDocument document = new FakeApiDocumentWithId(new DefaultFakeDomainObject(UUID.fromString("94e65ed0-1334-4c78-8c8f-bfd12773d041")));

        final String json = MAPPER.writeValueAsString(document);

        final String expectedJson = ContentLoader.loadContentFromClasspath("fake-attributes-document-with-uuid-id.json");
        assertThatJson(json).isEqualTo(expectedJson);
    }

    @Test
    void shouldSerializeJsonApiDocumentWithStringId() throws JsonProcessingException {
        final FakeApiDocument document = new FakeApiDocumentWithId(new DefaultFakeDomainObject("my-id"));

        final String json = MAPPER.writeValueAsString(document);

        final String expectedJson = ContentLoader.loadContentFromClasspath("fake-attributes-document-with-string-id.json");
        assertThatJson(json).isEqualTo(expectedJson);
    }

    @Test
    void shouldSerializeJsonApiDocumentWithNumericId() throws JsonProcessingException {
        final FakeApiDocument document = new FakeApiDocumentWithId(new DefaultFakeDomainObject(123456789));

        final String json = MAPPER.writeValueAsString(document);

        final String expectedJson = ContentLoader.loadContentFromClasspath("fake-attributes-document-with-numeric-id.json");
        assertThatJson(json).isEqualTo(expectedJson);
    }

    private static ObjectMapper buildMapper() {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new FakeApiModule());
        return mapper;
    }

}
