package uk.co.mruoc.jsonapi.error;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import uk.co.mruoc.file.content.ContentLoader;
import uk.co.mruoc.jsonapi.fake.FakeApiModuleObjectMapperFactory;
import uk.co.mruoc.jsonapi.fake.error.FakeInternalServerError;
import uk.co.mruoc.jsonapi.fake.error.FakeInternalServerErrorWithMeta;

import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;

class ApiErrorSerializerTest {

    private static final FakeApiModuleObjectMapperFactory FACTORY = new FakeApiModuleObjectMapperFactory();
    private static final ObjectMapper MAPPER = FACTORY.withNoOpIdParser();

    @Test
    void shouldSerializeJsonApiErrorItem() throws JsonProcessingException {
        final ApiError item = new FakeInternalServerError();

        final String json = MAPPER.writeValueAsString(item);

        final String expectedJson = ContentLoader.loadContentFromClasspath("error/fake-internal-server-error-item.json");
        assertThatJson(json).isEqualTo(expectedJson);
    }

    @Test
    void shouldSerializeJsonApiErrorItemWithMetaData() throws JsonProcessingException {
        final ApiError item = new FakeInternalServerErrorWithMeta();

        final String json = MAPPER.writeValueAsString(item);

        final String expectedJson = ContentLoader.loadContentFromClasspath("error/fake-internal-server-error-item-with-meta.json");
        assertThatJson(json).isEqualTo(expectedJson);
    }

}
