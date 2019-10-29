package uk.co.mruoc.jsonapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import org.junit.jupiter.api.Test;
import uk.co.mruoc.file.content.ContentLoader;
import uk.co.mruoc.jsonapi.fake.DefaultFakeAttributes;
import uk.co.mruoc.jsonapi.fake.FakeAttributes;
import uk.co.mruoc.jsonapi.fake.FakeJsonApiDocument;
import uk.co.mruoc.jsonapi.fake.FakeJsonApiDocumentWithId;
import uk.co.mruoc.jsonapi.fake.FakeJsonApiModule;

import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;

class JsonApiDocumentSerializerTest {

    private static final ObjectMapper MAPPER = buildMapper();

    @Test
    void shouldSerializeJsonApiDocument() throws JsonProcessingException {
        final JsonApiDocument<FakeAttributes> document = new FakeJsonApiDocument(new DefaultFakeAttributes());

        final String json = MAPPER.writeValueAsString(document);

        final String expectedJson = ContentLoader.loadContentFromClasspath("fake-attributes-document.json");
        assertThatJson(json).isEqualTo(expectedJson);
    }

    @Test
    void shouldSerializeJsonApiDocumentWithStringId() throws JsonProcessingException {
        final JsonApiDocument<FakeAttributes> document = new FakeJsonApiDocumentWithId();

        final String json = MAPPER.writeValueAsString(document);

        final String expectedJson = ContentLoader.loadContentFromClasspath("fake-attributes-document-with-string-id.json");
        assertThatJson(json).isEqualTo(expectedJson);
    }

    @Test
    void shouldSerializeJsonApiDocumentWithNumericId() throws JsonProcessingException {
        final JsonApiDocument<FakeAttributes> document = new FakeJsonApiDocument(123456789, new DefaultFakeAttributes());

        final String json = MAPPER.writeValueAsString(document);

        final String expectedJson = ContentLoader.loadContentFromClasspath("fake-attributes-document-with-numeric-id.json");
        assertThatJson(json).isEqualTo(expectedJson);
    }

    private static ObjectMapper buildMapper() {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new Jdk8Module());
        mapper.registerModule(new FakeJsonApiModule());
        return mapper;
    }

}