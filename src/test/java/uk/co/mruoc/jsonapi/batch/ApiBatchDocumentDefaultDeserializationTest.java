package uk.co.mruoc.jsonapi.batch;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import uk.co.mruoc.file.content.ContentLoader;
import uk.co.mruoc.jsonapi.ApiModule;
import uk.co.mruoc.jsonapi.fake.FakeAttributes;
import uk.co.mruoc.jsonapi.fake.MyApiBatchDocument;
import uk.co.mruoc.jsonapi.fake.MyApiBatchDocumentWithId;
import uk.co.mruoc.jsonapi.fake.MyApiDataWithId;

import java.io.IOException;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class ApiBatchDocumentDefaultDeserializationTest {

    @Test
    void shouldDeserializeJsonApiBatchDocumentWithoutCustomDeserializer() throws IOException {
        final ObjectMapper mapper = buildMapper();
        final String json = ContentLoader.loadContentFromClasspath("fake-attributes-batch-document-without-id.json");

        final MyApiBatchDocument document = mapper.readValue(json, MyApiBatchDocument.class);

        assertThat(document).isEqualTo(new MyApiBatchDocument(
                buildFakeAttributes(),
                buildFakeAttributes()
        ));
    }

    @Test
    void shouldDeserializeJsonApiBatchDocumentWithUuidId() throws IOException {
        final ObjectMapper mapper = buildMapper();
        final String json = ContentLoader.loadContentFromClasspath("fake-attributes-batch-document-with-uuid-id.json");

        final MyApiBatchDocumentWithId document = mapper.readValue(json, MyApiBatchDocumentWithId.class);

        assertThat(document).isEqualTo(new MyApiBatchDocumentWithId(Arrays.asList(
                new MyApiDataWithId("94e65ed0-1334-4c78-8c8f-bfd12773d041", buildFakeAttributes()),
                new MyApiDataWithId("3909018e-35d1-4196-9141-13a966005a67", buildFakeAttributes())
        )));
    }

    @Test
    void shouldDeserializeJsonApiBatchDocumentWithStringId() throws IOException {
        final ObjectMapper mapper = buildMapper();
        final String json = ContentLoader.loadContentFromClasspath("fake-attributes-batch-document-with-string-id.json");

        final MyApiBatchDocumentWithId document = mapper.readValue(json, MyApiBatchDocumentWithId.class);

        assertThat(document).isEqualTo(new MyApiBatchDocumentWithId(Arrays.asList(
                new MyApiDataWithId("my-id-1", buildFakeAttributes()),
                new MyApiDataWithId("my-id-2", buildFakeAttributes())
        )));
    }

    @Test
    void shouldDeserializeJsonApiBatchDocumentWithNumericId() throws IOException {
        final ObjectMapper mapper = buildMapper();
        final String json = ContentLoader.loadContentFromClasspath("fake-attributes-batch-document-with-numeric-id.json");

        final MyApiBatchDocumentWithId document = mapper.readValue(json, MyApiBatchDocumentWithId.class);

        assertThat(document).isEqualTo(new MyApiBatchDocumentWithId(Arrays.asList(
                new MyApiDataWithId(123456789, buildFakeAttributes()),
                new MyApiDataWithId(999999999, buildFakeAttributes())
        )));
    }

    private static ObjectMapper buildMapper() {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new ApiModule());
        return mapper;
    }

    private static FakeAttributes buildFakeAttributes() {
        final FakeAttributes attributes = new FakeAttributes();
        attributes.setValue1("fake-value-1");
        attributes.setValue2("fake-value-2");
        return attributes;
    }

}
