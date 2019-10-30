package uk.co.mruoc.jsonapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import uk.co.mruoc.file.content.ContentLoader;
import uk.co.mruoc.jsonapi.fake.DefaultFakeAttributes;
import uk.co.mruoc.jsonapi.fake.FakeApiDocument;
import uk.co.mruoc.jsonapi.fake.FakeApiDocumentFactory;
import uk.co.mruoc.jsonapi.fake.FakeApiModule;

import java.io.IOException;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

class ApiDocumentDeserializerTest {

    @Test
    void shouldDeserializeJsonApiDocument() throws IOException {
        final ObjectMapper mapper = buildMapper(new FakeApiDocumentFactory.UuidIdParser());
        final String json = ContentLoader.loadContentFromClasspath("fake-attributes-document-without-id.json");

        final FakeApiDocument document = mapper.readValue(json, FakeApiDocument.class);

        assertThat(document).isEqualTo(new FakeApiDocument(new DefaultFakeAttributes(null)));
    }

    @Test
    void shouldDeserializeJsonApiDocumentWithUuidId() throws IOException {
        final ObjectMapper mapper = buildMapper(new FakeApiDocumentFactory.UuidIdParser());
        final String json = ContentLoader.loadContentFromClasspath("fake-attributes-document-with-uuid-id.json");

        final FakeApiDocument document = mapper.readValue(json, FakeApiDocument.class);

        assertThat(document).isEqualTo(new FakeApiDocument(new DefaultFakeAttributes()));
    }

    @Test
    void shouldDeserializeJsonApiDocumentWithStringId() throws IOException {
        final ObjectMapper mapper = buildMapper(new FakeApiDocumentFactory.StringIdParser());
        final String json = ContentLoader.loadContentFromClasspath("fake-attributes-document-with-string-id.json");

        final FakeApiDocument document = mapper.readValue(json, FakeApiDocument.class);

        assertThat(document).isEqualTo(new FakeApiDocument(new DefaultFakeAttributes("my-id")));
    }

    @Test
    void shouldDeserializeJsonApiDocumentWithNumericId() throws IOException {
        final ObjectMapper mapper = buildMapper(new FakeApiDocumentFactory.LongIdParser());
        final String json = ContentLoader.loadContentFromClasspath("fake-attributes-document-with-numeric-id.json");

        final FakeApiDocument document = mapper.readValue(json, FakeApiDocument.class);

        assertThat(document).isEqualTo(new FakeApiDocument(new DefaultFakeAttributes(123456789L)));
    }

    private static ObjectMapper buildMapper(final Function<String, Object> idParser) {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new FakeApiModule(idParser));
        return mapper;
    }

}
