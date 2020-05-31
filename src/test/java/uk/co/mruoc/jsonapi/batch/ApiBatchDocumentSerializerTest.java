package uk.co.mruoc.jsonapi.batch;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import uk.co.mruoc.file.content.ContentLoader;
import uk.co.mruoc.jsonapi.fake.FakeApiBatchDocument;
import uk.co.mruoc.jsonapi.fake.FakeApiModuleObjectMapperFactory;
import uk.co.mruoc.jsonapi.fake.FakeApiNumericIdBatchDocument;
import uk.co.mruoc.jsonapi.fake.FakeApiStringIdBatchDocument;
import uk.co.mruoc.jsonapi.fake.FakeDomainObjectMother;

import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;

class ApiBatchDocumentSerializerTest {

    private final FakeApiModuleObjectMapperFactory factory = new FakeApiModuleObjectMapperFactory();

    @Test
    void shouldSerializeBatchJsonApiDocumentWithoutId() throws JsonProcessingException {
        final ObjectMapper mapper = factory.withNoOpIdParser();
        final FakeApiBatchDocument document = new FakeApiBatchDocument(
                FakeDomainObjectMother.nullId(),
                FakeDomainObjectMother.nullId()
        );

        final String json = mapper.writeValueAsString(document);

        final String expectedJson = ContentLoader.loadContentFromClasspath("fake-attributes-batch-document-without-id.json");
        assertThatJson(json).isEqualTo(expectedJson);
    }

    @Test
    void shouldSerializeBatchJsonApiDocumentWithUuidId() throws JsonProcessingException {
        final ObjectMapper mapper = factory.withUuidIdParser();
        final FakeApiStringIdBatchDocument document = new FakeApiStringIdBatchDocument(
                FakeDomainObjectMother.uuidId1(),
                FakeDomainObjectMother.uuidId2()
        );

        final String json = mapper.writeValueAsString(document);

        final String expectedJson = ContentLoader.loadContentFromClasspath("fake-attributes-batch-document-with-uuid-id.json");
        assertThatJson(json).isEqualTo(expectedJson);
    }

    @Test
    void shouldSerializeBatchJsonApiDocumentWithStringId() throws JsonProcessingException {
        final ObjectMapper mapper = factory.withStringIdParser();
        final FakeApiStringIdBatchDocument document = new FakeApiStringIdBatchDocument(
                FakeDomainObjectMother.stringId1(),
                FakeDomainObjectMother.stringId2()
        );

        final String json = mapper.writeValueAsString(document);

        final String expectedJson = ContentLoader.loadContentFromClasspath("fake-attributes-batch-document-with-string-id.json");
        assertThatJson(json).isEqualTo(expectedJson);
    }

    @Test
    void shouldSerializeBatchJsonApiDocumentWithNumericId() throws JsonProcessingException {
        final ObjectMapper mapper = factory.withNumericIdParser();
        final FakeApiNumericIdBatchDocument document = new FakeApiNumericIdBatchDocument(
                FakeDomainObjectMother.numericId1(),
                FakeDomainObjectMother.numericId2()
        );

        final String json = mapper.writeValueAsString(document);

        final String expectedJson = ContentLoader.loadContentFromClasspath("fake-attributes-batch-document-with-numeric-id.json");
        assertThatJson(json).isEqualTo(expectedJson);
    }

}
