package uk.co.mruoc.jsonapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import uk.co.mruoc.file.content.ContentLoader;
import uk.co.mruoc.jsonapi.fake.FakeApiDocument;
import uk.co.mruoc.jsonapi.fake.FakeApiModuleObjectMapperFactory;
import uk.co.mruoc.jsonapi.fake.FakeDomainObjectMother;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class ApiDocumentDeserializerTest {

    private final FakeApiModuleObjectMapperFactory factory = new FakeApiModuleObjectMapperFactory();

    @Test
    void shouldDeserializeJsonApiDocument() throws IOException {
        final ObjectMapper mapper = factory.withNoOpIdParser();
        final String json = ContentLoader.loadContentFromClasspath("fake-attributes-document-without-id.json");

        final FakeApiDocument document = mapper.readValue(json, FakeApiDocument.class);

        assertThat(document).isEqualTo(new FakeApiDocument(FakeDomainObjectMother.nullId()));
    }

    @Test
    void shouldDeserializeJsonApiDocumentWithUuidId() throws IOException {
        final ObjectMapper mapper = factory.withUuidIdParser();
        final String json = ContentLoader.loadContentFromClasspath("fake-attributes-document-with-uuid-id.json");

        final FakeApiDocument document = mapper.readValue(json, FakeApiDocument.class);

        assertThat(document).isEqualTo(new FakeApiDocument(FakeDomainObjectMother.uuidId1()));
    }

    @Test
    void shouldDeserializeJsonApiDocumentWithStringId() throws IOException {
        final ObjectMapper mapper = factory.withStringIdParser();
        final String json = ContentLoader.loadContentFromClasspath("fake-attributes-document-with-string-id.json");

        final FakeApiDocument document = mapper.readValue(json, FakeApiDocument.class);

        assertThat(document).isEqualTo(new FakeApiDocument(FakeDomainObjectMother.stringId1()));
    }

    @Test
    void shouldDeserializeJsonApiDocumentWithNumericId() throws IOException {
        final ObjectMapper mapper = factory.withNumericIdParser();
        final String json = ContentLoader.loadContentFromClasspath("fake-attributes-document-with-numeric-id.json");

        final FakeApiDocument document = mapper.readValue(json, FakeApiDocument.class);

        assertThat(document).isEqualTo(new FakeApiDocument(FakeDomainObjectMother.numericId1()));
    }

}
