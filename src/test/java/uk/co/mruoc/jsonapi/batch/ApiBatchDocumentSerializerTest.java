package uk.co.mruoc.jsonapi.batch;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import uk.co.mruoc.file.content.ContentLoader;
import uk.co.mruoc.jsonapi.fake.DefaultFakeDomainObject;
import uk.co.mruoc.jsonapi.fake.FakeApiBatchDocument;
import uk.co.mruoc.jsonapi.fake.FakeApiModule;
import uk.co.mruoc.jsonapi.fake.FakeApiNumericIdBatchDocument;
import uk.co.mruoc.jsonapi.fake.FakeApiStringIdBatchDocument;

import java.util.UUID;

import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;

class ApiBatchDocumentSerializerTest {

    private static final ObjectMapper MAPPER = buildMapper();

    @Test
    void shouldSerializeBatchJsonApiDocumentWithoutId() throws JsonProcessingException {
        final FakeApiBatchDocument document = new FakeApiBatchDocument(
                new DefaultFakeDomainObject(null),
                new DefaultFakeDomainObject(null)
        );

        final String json = MAPPER.writeValueAsString(document);

        final String expectedJson = ContentLoader.loadContentFromClasspath("fake-attributes-batch-document-without-id.json");
        assertThatJson(json).isEqualTo(expectedJson);
    }

    @Test
    void shouldSerializeBatchJsonApiDocumentWithUuidId() throws JsonProcessingException {
        final FakeApiStringIdBatchDocument document = new FakeApiStringIdBatchDocument(
                new DefaultFakeDomainObject(UUID.fromString("94e65ed0-1334-4c78-8c8f-bfd12773d041")),
                new DefaultFakeDomainObject(UUID.fromString("3909018e-35d1-4196-9141-13a966005a67"))
        );

        final String json = MAPPER.writeValueAsString(document);

        final String expectedJson = ContentLoader.loadContentFromClasspath("fake-attributes-batch-document-with-uuid-id.json");
        assertThatJson(json).isEqualTo(expectedJson);
    }

    @Test
    void shouldSerializeBatchJsonApiDocumentWithStringId() throws JsonProcessingException {
        final FakeApiStringIdBatchDocument document = new FakeApiStringIdBatchDocument(
                new DefaultFakeDomainObject("my-id-1"),
                new DefaultFakeDomainObject("my-id-2")
        );

        final String json = MAPPER.writeValueAsString(document);

        final String expectedJson = ContentLoader.loadContentFromClasspath("fake-attributes-batch-document-with-string-id.json");
        assertThatJson(json).isEqualTo(expectedJson);
    }

    @Test
    void shouldSerializeBatchJsonApiDocumentWithNumericId() throws JsonProcessingException {
        final FakeApiNumericIdBatchDocument document = new FakeApiNumericIdBatchDocument(
                new DefaultFakeDomainObject(123456789),
                new DefaultFakeDomainObject(999999999)
        );

        final String json = MAPPER.writeValueAsString(document);

        final String expectedJson = ContentLoader.loadContentFromClasspath("fake-attributes-batch-document-with-numeric-id.json");
        assertThatJson(json).isEqualTo(expectedJson);
    }

    private static ObjectMapper buildMapper() {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new FakeApiModule());
        return mapper;
    }

}
