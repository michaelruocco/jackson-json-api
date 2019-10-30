package uk.co.mruoc.jsonapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import uk.co.mruoc.file.content.ContentLoader;
import uk.co.mruoc.jsonapi.fake.DefaultFakeAttributes;
import uk.co.mruoc.jsonapi.fake.FakeJsonApiDocument;
import uk.co.mruoc.jsonapi.fake.FakeJsonApiDocumentFactory;
import uk.co.mruoc.jsonapi.fake.FakeJsonApiModule;

import java.io.IOException;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

class JsonApiDocumentDeserializerTest {

    @Test
    void shouldDeserializeJsonApiDocument() throws IOException {
        final ObjectMapper mapper = buildMapper(new FakeJsonApiDocumentFactory.UuidIdParser());
        final String json = ContentLoader.loadContentFromClasspath("fake-attributes-document-without-id.json");

        final FakeJsonApiDocument document = mapper.readValue(json, FakeJsonApiDocument.class);

        assertThat(document).isEqualTo(new FakeJsonApiDocument(new DefaultFakeAttributes(null)));
    }

    @Test
    void shouldDeserializeJsonApiDocumentWithUuidId() throws IOException {
        final ObjectMapper mapper = buildMapper(new FakeJsonApiDocumentFactory.UuidIdParser());
        final String json = ContentLoader.loadContentFromClasspath("fake-attributes-document-with-uuid-id.json");

        final FakeJsonApiDocument document = mapper.readValue(json, FakeJsonApiDocument.class);

        assertThat(document).isEqualTo(new FakeJsonApiDocument(new DefaultFakeAttributes()));
    }

    @Test
    void shouldDeserializeJsonApiDocumentWithStringId() throws IOException {
        final ObjectMapper mapper = buildMapper(new FakeJsonApiDocumentFactory.StringIdParser());
        final String json = ContentLoader.loadContentFromClasspath("fake-attributes-document-with-string-id.json");

        final FakeJsonApiDocument document = mapper.readValue(json, FakeJsonApiDocument.class);

        assertThat(document).isEqualTo(new FakeJsonApiDocument(new DefaultFakeAttributes("my-id")));
    }

    @Test
    void shouldDeserializeJsonApiDocumentWithNumericId() throws IOException {
        final ObjectMapper mapper = buildMapper(new FakeJsonApiDocumentFactory.LongIdParser());
        final String json = ContentLoader.loadContentFromClasspath("fake-attributes-document-with-numeric-id.json");

        final FakeJsonApiDocument document = mapper.readValue(json, FakeJsonApiDocument.class);

        assertThat(document).isEqualTo(new FakeJsonApiDocument(new DefaultFakeAttributes(123456789L)));
    }

    private static ObjectMapper buildMapper(final Function<String, Object> idParser) {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new FakeJsonApiModule(idParser));
        return mapper;
    }

}
