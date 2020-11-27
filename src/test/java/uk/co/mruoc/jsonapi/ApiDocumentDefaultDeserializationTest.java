package uk.co.mruoc.jsonapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import uk.co.mruoc.file.content.ContentLoader;
import uk.co.mruoc.jsonapi.fake.FakeApiDocument;
import uk.co.mruoc.jsonapi.fake.FakeApiModuleObjectMapperFactory;
import uk.co.mruoc.jsonapi.fake.FakeDomainObjectMother;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class ApiDocumentDefaultDeserializationTest {

    private final FakeApiModuleObjectMapperFactory factory = new FakeApiModuleObjectMapperFactory();

    @Test
    void shouldDeserializeJsonApiDocumentWithNullIdObject() throws IOException {
        final ObjectMapper mapper = factory.withNoOpIdParser();
        final String json = ContentLoader.loadContentFromClasspath("fake-attributes-document-without-id.json");

        final FakeApiDocument document = mapper.readValue(json, FakeApiDocument.class);

        assertThat(document.getAttributes()).isEqualTo(FakeDomainObjectMother.nullId());
    }

    @Test
    void shouldDeserializeJsonApiDocumentWithUuidIdObject() throws IOException {
        final ObjectMapper mapper = factory.withUuidIdParser();
        final String json = ContentLoader.loadContentFromClasspath("fake-attributes-document-with-uuid-id.json");

        final FakeApiDocument document = mapper.readValue(json, FakeApiDocument.class);

        assertThat(document.getAttributes()).usingRecursiveComparison().isEqualTo(FakeDomainObjectMother.uuidId1());
    }

    @Test
    void shouldDeserializeJsonApiDocumentWithStringIdObject() throws IOException {
        final ObjectMapper mapper = factory.withStringIdParser();
        final String json = ContentLoader.loadContentFromClasspath("fake-attributes-document-with-string-id.json");

        final FakeApiDocument document = mapper.readValue(json, FakeApiDocument.class);

        assertThat(document.getAttributes()).isEqualTo(FakeDomainObjectMother.stringId1());
    }

    @Test
    void shouldDeserializeJsonApiDocumentWithNumericIdObject() throws IOException {
        final ObjectMapper mapper = factory.withNumericIdParser();
        final String json = ContentLoader.loadContentFromClasspath("fake-attributes-document-with-numeric-id.json");

        final FakeApiDocument document = mapper.readValue(json, FakeApiDocument.class);

        assertThat(document.getAttributes()).usingRecursiveComparison().isEqualTo(FakeDomainObjectMother.numericId1());
    }

}
