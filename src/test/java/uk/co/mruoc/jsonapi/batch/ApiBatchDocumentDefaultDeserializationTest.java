package uk.co.mruoc.jsonapi.batch;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import uk.co.mruoc.file.content.ContentLoader;
import uk.co.mruoc.jsonapi.fake.FakeApiBatchDocument;
import uk.co.mruoc.jsonapi.fake.FakeApiModuleObjectMapperFactory;
import uk.co.mruoc.jsonapi.fake.FakeDomainObjectMother;

import java.io.IOException;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class ApiBatchDocumentDefaultDeserializationTest {

    private final FakeApiModuleObjectMapperFactory factory = new FakeApiModuleObjectMapperFactory();

    @Test
    void shouldDeserializeJsonApiBatchDocumentWithoutCustomDeserializer() throws IOException {
        final ObjectMapper mapper = factory.withNoOpIdParser();
        final String json = ContentLoader.loadContentFromClasspath("fake-attributes-batch-document-without-id.json");

        final FakeApiBatchDocument document = mapper.readValue(json, FakeApiBatchDocument.class);

        assertThat(document).isEqualTo(new FakeApiBatchDocument(
                FakeDomainObjectMother.nullId(),
                FakeDomainObjectMother.nullId()
        ));
    }

    @Test
    void shouldDeserializeJsonApiBatchDocumentWithUuidId() throws IOException {
        final ObjectMapper mapper = factory.withUuidIdParser();
        final String json = ContentLoader.loadContentFromClasspath("fake-attributes-batch-document-with-uuid-id.json");

        final FakeApiBatchDocument document = mapper.readValue(json, FakeApiBatchDocument.class);

        assertThat(document).isEqualTo(new FakeApiBatchDocument(Arrays.asList(
                FakeDomainObjectMother.uuidId1(),
                FakeDomainObjectMother.uuidId2()
        )));
    }

    @Test
    void shouldDeserializeJsonApiBatchDocumentWithStringId() throws IOException {
        final ObjectMapper mapper = factory.withStringIdParser();
        final String json = ContentLoader.loadContentFromClasspath("fake-attributes-batch-document-with-string-id.json");

        final FakeApiBatchDocument document = mapper.readValue(json, FakeApiBatchDocument.class);

        assertThat(document).isEqualTo(new FakeApiBatchDocument(Arrays.asList(
                FakeDomainObjectMother.stringId1(),
                FakeDomainObjectMother.stringId2()
        )));
    }

    @Test
    void shouldDeserializeJsonApiBatchDocumentWithNumericId() throws IOException {
        final ObjectMapper mapper = factory.withNumericIdParser();
        final String json = ContentLoader.loadContentFromClasspath("fake-attributes-batch-document-with-numeric-id.json");

        final FakeApiBatchDocument document = mapper.readValue(json, FakeApiBatchDocument.class);

        assertThat(document).isEqualTo(new FakeApiBatchDocument(Arrays.asList(
                FakeDomainObjectMother.numericId1(),
                FakeDomainObjectMother.numericId2()
        )));
    }

}
