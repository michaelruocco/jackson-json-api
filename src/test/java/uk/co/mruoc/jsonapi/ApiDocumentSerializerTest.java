package uk.co.mruoc.jsonapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import uk.co.mruoc.file.content.ContentLoader;
import uk.co.mruoc.jsonapi.fake.FakeApiDocument;
import uk.co.mruoc.jsonapi.fake.FakeApiDocumentWithId;
import uk.co.mruoc.jsonapi.fake.FakeApiModuleObjectMapperFactory;
import uk.co.mruoc.jsonapi.fake.FakeDomainObjectMother;

import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;

class ApiDocumentSerializerTest {

    private final FakeApiModuleObjectMapperFactory factory = new FakeApiModuleObjectMapperFactory();

    @Test
    void shouldSerializeJsonApiDocumentWithoutId() throws JsonProcessingException {
        final ObjectMapper mapper = factory.withNoOpIdParser();
        final FakeApiDocument document = new FakeApiDocument(FakeDomainObjectMother.nullId());

        final String json = mapper.writeValueAsString(document);

        final String expectedJson = ContentLoader.loadContentFromClasspath("fake-attributes-document-without-id.json");
        assertThatJson(json).isEqualTo(expectedJson);
    }

    @Test
    void shouldSerializeJsonApiDocumentWithUuidId() throws JsonProcessingException {
        final ObjectMapper mapper = factory.withUuidIdParser();
        final FakeApiDocument document = new FakeApiDocumentWithId(FakeDomainObjectMother.uuidId1());

        final String json = mapper.writeValueAsString(document);

        final String expectedJson = ContentLoader.loadContentFromClasspath("fake-attributes-document-with-uuid-id.json");
        assertThatJson(json).isEqualTo(expectedJson);
    }

    @Test
    void shouldSerializeJsonApiDocumentWithStringId() throws JsonProcessingException {
        final ObjectMapper mapper = factory.withStringIdParser();
        final FakeApiDocument document = new FakeApiDocumentWithId(FakeDomainObjectMother.stringId1());

        final String json = mapper.writeValueAsString(document);

        final String expectedJson = ContentLoader.loadContentFromClasspath("fake-attributes-document-with-string-id.json");
        assertThatJson(json).isEqualTo(expectedJson);
    }

    @Test
    void shouldSerializeJsonApiDocumentWithNumericId() throws JsonProcessingException {
        final ObjectMapper mapper = factory.withNumericIdParser();
        final FakeApiDocument document = new FakeApiDocumentWithId(FakeDomainObjectMother.numericId1());

        final String json = mapper.writeValueAsString(document);

        final String expectedJson = ContentLoader.loadContentFromClasspath("fake-attributes-document-with-numeric-id.json");
        assertThatJson(json).isEqualTo(expectedJson);
    }

}
