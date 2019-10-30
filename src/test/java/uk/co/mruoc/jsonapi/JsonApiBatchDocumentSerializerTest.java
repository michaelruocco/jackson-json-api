package uk.co.mruoc.jsonapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import org.junit.jupiter.api.Test;
import uk.co.mruoc.file.content.ContentLoader;
import uk.co.mruoc.jsonapi.fake.DefaultFakeAttributes;
import uk.co.mruoc.jsonapi.fake.FakeJsonApiBatchDocument;
import uk.co.mruoc.jsonapi.fake.FakeJsonApiModule;
import uk.co.mruoc.jsonapi.fake.FakeJsonApiNumericIdBatchDocument;
import uk.co.mruoc.jsonapi.fake.FakeJsonApiStringIdBatchDocument;

import java.util.UUID;

import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;

class JsonApiBatchDocumentSerializerTest {

    private static final ObjectMapper MAPPER = buildMapper();

    @Test
    void shouldSerializeBatchJsonApiDocumentWithoutId() throws JsonProcessingException {
        final FakeJsonApiBatchDocument document = new FakeJsonApiBatchDocument(
                new DefaultFakeAttributes(null),
                new DefaultFakeAttributes(null)
        );

        final String json = MAPPER.writeValueAsString(document);

        final String expectedJson = ContentLoader.loadContentFromClasspath("fake-attributes-batch-document-without-id.json");
        assertThatJson(json).isEqualTo(expectedJson);
    }

    @Test
    void shouldSerializeBatchJsonApiDocumentWithUuidId() throws JsonProcessingException {
        final FakeJsonApiStringIdBatchDocument document = new FakeJsonApiStringIdBatchDocument(
                new DefaultFakeAttributes(UUID.fromString("94e65ed0-1334-4c78-8c8f-bfd12773d041")),
                new DefaultFakeAttributes(UUID.fromString("3909018e-35d1-4196-9141-13a966005a67"))
        );

        final String json = MAPPER.writeValueAsString(document);

        final String expectedJson = ContentLoader.loadContentFromClasspath("fake-attributes-batch-document-with-uuid-id.json");
        assertThatJson(json).isEqualTo(expectedJson);
    }

    @Test
    void shouldSerializeBatchJsonApiDocumentWithStringId() throws JsonProcessingException {
        final FakeJsonApiStringIdBatchDocument document = new FakeJsonApiStringIdBatchDocument(
                new DefaultFakeAttributes("my-id-1"),
                new DefaultFakeAttributes("my-id-2")
        );

        final String json = MAPPER.writeValueAsString(document);

        final String expectedJson = ContentLoader.loadContentFromClasspath("fake-attributes-batch-document-with-string-id.json");
        assertThatJson(json).isEqualTo(expectedJson);
    }

    @Test
    void shouldSerializeBatchJsonApiDocumentWithNumericId() throws JsonProcessingException {
        final FakeJsonApiNumericIdBatchDocument document = new FakeJsonApiNumericIdBatchDocument(
                new DefaultFakeAttributes(123456789),
                new DefaultFakeAttributes(999999999)
        );

        final String json = MAPPER.writeValueAsString(document);

        final String expectedJson = ContentLoader.loadContentFromClasspath("fake-attributes-batch-document-with-numeric-id.json");
        assertThatJson(json).isEqualTo(expectedJson);
    }

    private static ObjectMapper buildMapper() {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new Jdk8Module());
        mapper.registerModule(new FakeJsonApiModule());
        return mapper;
    }

}
