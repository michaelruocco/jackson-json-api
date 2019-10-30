package uk.co.mruoc.jsonapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import uk.co.mruoc.file.content.ContentLoader;
import uk.co.mruoc.jsonapi.fake.DefaultFakeAttributes;
import uk.co.mruoc.jsonapi.fake.FakeApiBatchDocument;
import uk.co.mruoc.jsonapi.fake.FakeApiDocumentFactory;
import uk.co.mruoc.jsonapi.fake.FakeApiModule;

import java.io.IOException;
import java.util.UUID;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

class ApiBatchDocumentDeserializerTest {

    @Test
    void shouldDeserializeJsonApiBatchDocument() throws IOException {
        final ObjectMapper mapper = buildMapper(new FakeApiDocumentFactory.UuidIdParser());
        final String json = ContentLoader.loadContentFromClasspath("fake-attributes-batch-document-without-id.json");

        final FakeApiBatchDocument document = mapper.readValue(json, FakeApiBatchDocument.class);

        assertThat(document).isEqualTo(new FakeApiBatchDocument(
                new DefaultFakeAttributes(null),
                new DefaultFakeAttributes(null)
        ));
    }

    @Test
    void shouldDeserializeJsonApiBatchDocumentWithUuidId() throws IOException {
        final ObjectMapper mapper = buildMapper(new FakeApiDocumentFactory.UuidIdParser());
        final String json = ContentLoader.loadContentFromClasspath("fake-attributes-batch-document-with-uuid-id.json");

        final FakeApiBatchDocument document = mapper.readValue(json, FakeApiBatchDocument.class);

        assertThat(document).isEqualTo(new FakeApiBatchDocument(
                new DefaultFakeAttributes(UUID.fromString("94e65ed0-1334-4c78-8c8f-bfd12773d041")),
                new DefaultFakeAttributes(UUID.fromString("3909018e-35d1-4196-9141-13a966005a67"))
        ));
    }

    @Test
    void shouldDeserializeJsonApiBatchDocumentWithStringId() throws IOException {
        final ObjectMapper mapper = buildMapper(new FakeApiDocumentFactory.StringIdParser());
        final String json = ContentLoader.loadContentFromClasspath("fake-attributes-batch-document-with-string-id.json");

        final FakeApiBatchDocument document = mapper.readValue(json, FakeApiBatchDocument.class);

        assertThat(document).isEqualTo(new FakeApiBatchDocument(
                new DefaultFakeAttributes("my-id-1"),
                new DefaultFakeAttributes("my-id-2")
        ));
    }

    @Test
    void shouldDeserializeJsonApiBatchDocumentWithNumericId() throws IOException {
        final ObjectMapper mapper = buildMapper(new FakeApiDocumentFactory.LongIdParser());
        final String json = ContentLoader.loadContentFromClasspath("fake-attributes-batch-document-with-numeric-id.json");

        final FakeApiBatchDocument document = mapper.readValue(json, FakeApiBatchDocument.class);

        assertThat(document).isEqualTo(new FakeApiBatchDocument(
                new DefaultFakeAttributes(123456789L),
                new DefaultFakeAttributes(999999999L)
        ));
    }

    private static ObjectMapper buildMapper(final Function<String, Object> idParser) {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new FakeApiModule(idParser));
        return mapper;
    }

}
