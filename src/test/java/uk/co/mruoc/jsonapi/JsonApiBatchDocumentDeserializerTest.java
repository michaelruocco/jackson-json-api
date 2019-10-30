package uk.co.mruoc.jsonapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import uk.co.mruoc.file.content.ContentLoader;
import uk.co.mruoc.jsonapi.fake.DefaultFakeAttributes;
import uk.co.mruoc.jsonapi.fake.FakeJsonApiBatchDocument;
import uk.co.mruoc.jsonapi.fake.FakeJsonApiDocumentFactory;
import uk.co.mruoc.jsonapi.fake.FakeJsonApiModule;

import java.io.IOException;
import java.util.UUID;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

class JsonApiBatchDocumentDeserializerTest {

    @Test
    void shouldDeserializeJsonApiBatchDocument() throws IOException {
        final ObjectMapper mapper = buildMapper(new FakeJsonApiDocumentFactory.UuidIdParser());
        final String json = ContentLoader.loadContentFromClasspath("fake-attributes-batch-document-without-id.json");

        final FakeJsonApiBatchDocument document = mapper.readValue(json, FakeJsonApiBatchDocument.class);

        assertThat(document).isEqualTo(new FakeJsonApiBatchDocument(
                new DefaultFakeAttributes(null),
                new DefaultFakeAttributes(null)
        ));
    }

    @Test
    void shouldDeserializeJsonApiBatchDocumentWithUuidId() throws IOException {
        final ObjectMapper mapper = buildMapper(new FakeJsonApiDocumentFactory.UuidIdParser());
        final String json = ContentLoader.loadContentFromClasspath("fake-attributes-batch-document-with-uuid-id.json");

        final FakeJsonApiBatchDocument document = mapper.readValue(json, FakeJsonApiBatchDocument.class);

        assertThat(document).isEqualTo(new FakeJsonApiBatchDocument(
                new DefaultFakeAttributes(UUID.fromString("94e65ed0-1334-4c78-8c8f-bfd12773d041")),
                new DefaultFakeAttributes(UUID.fromString("3909018e-35d1-4196-9141-13a966005a67"))
        ));
    }

    @Test
    void shouldDeserializeJsonApiBatchDocumentWithStringId() throws IOException {
        final ObjectMapper mapper = buildMapper(new FakeJsonApiDocumentFactory.StringIdParser());
        final String json = ContentLoader.loadContentFromClasspath("fake-attributes-batch-document-with-string-id.json");

        final FakeJsonApiBatchDocument document = mapper.readValue(json, FakeJsonApiBatchDocument.class);

        assertThat(document).isEqualTo(new FakeJsonApiBatchDocument(
                new DefaultFakeAttributes("my-id-1"),
                new DefaultFakeAttributes("my-id-2")
        ));
    }

    @Test
    void shouldDeserializeJsonApiBatchDocumentWithNumericId() throws IOException {
        final ObjectMapper mapper = buildMapper(new FakeJsonApiDocumentFactory.LongIdParser());
        final String json = ContentLoader.loadContentFromClasspath("fake-attributes-batch-document-with-numeric-id.json");

        final FakeJsonApiBatchDocument document = mapper.readValue(json, FakeJsonApiBatchDocument.class);

        assertThat(document).isEqualTo(new FakeJsonApiBatchDocument(
                new DefaultFakeAttributes(123456789L),
                new DefaultFakeAttributes(999999999L)
        ));
    }

    private static ObjectMapper buildMapper(final Function<String, Object> idParser) {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new FakeJsonApiModule(idParser));
        return mapper;
    }

}
