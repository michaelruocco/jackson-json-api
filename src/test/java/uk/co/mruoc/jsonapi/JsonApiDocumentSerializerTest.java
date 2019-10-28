package uk.co.mruoc.jsonapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import uk.co.mruoc.file.content.ContentLoader;
import uk.co.mruoc.jsonapi.fake.FakeAttributes;
import uk.co.mruoc.jsonapi.fake.FakeJsonApiDocument;
import uk.co.mruoc.jsonapi.fake.FakeJsonApiDocumentWithId;
import uk.co.mruoc.jsonapi.fake.FakeJsonApiModule;

import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;

class JsonApiDocumentSerializerTest {

    private static final ObjectMapper MAPPER = buildMapper();

    @Test
    void shouldSerializeJsonApiDocument() throws JsonProcessingException {
        final JsonApiDocument<FakeAttributes> document = new FakeJsonApiDocument();

        final String json = MAPPER.writeValueAsString(document);

        final String expectedJson = ContentLoader.loadContentFromClasspath("fake-attributes-document.json");
        System.out.println(json);
        assertThatJson(json).isEqualTo(expectedJson);
    }

    @Test
    void shouldSerializeJsonApiDocumentWithId() throws JsonProcessingException {
        final JsonApiDocument<FakeAttributes> document = new FakeJsonApiDocumentWithId();

        final String json = MAPPER.writeValueAsString(document);

        final String expectedJson = ContentLoader.loadContentFromClasspath("fake-attributes-document-with-id.json");
        System.out.println(json);
        assertThatJson(json).isEqualTo(expectedJson);
    }

    private static ObjectMapper buildMapper() {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new FakeJsonApiModule());
        return mapper;
    }

}
