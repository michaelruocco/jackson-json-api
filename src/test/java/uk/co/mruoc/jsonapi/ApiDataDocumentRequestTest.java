package uk.co.mruoc.jsonapi;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Test;
import uk.co.mruoc.jsonapi.ApiDataDocumentRequest.ApiDataDocumentRequestBuilder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class ApiDataDocumentRequestTest {

    private final ApiDataDocumentRequestBuilder builder = ApiDataDocumentRequest.builder();

    @Test
    void shouldReturnParser() {
        final JsonParser parser = mock(JsonParser.class);

        final ApiDataDocumentRequest request = builder.parser(parser).build();

        assertThat(request.getParser()).isEqualTo(parser);
    }

    @Test
    void shouldReturnContext() {
        final DeserializationContext context = mock(DeserializationContext.class);

        final ApiDataDocumentRequest request = builder.context(context).build();

        assertThat(request.getContext()).isEqualTo(context);
    }

    @Test
    void shouldReturnRootNode() {
        final JsonNode rootNode = mock(JsonNode.class);

        final ApiDataDocumentRequest request = builder.rootNode(rootNode).build();

        assertThat(request.getRootNode()).isEqualTo(rootNode);
    }

    @Test
    void shouldReturnDataNode() {
        final JsonNode dataNode = mock(JsonNode.class);

        final ApiDataDocumentRequest request = builder.dataNode(dataNode).build();

        assertThat(request.getDataNode()).isEqualTo(dataNode);
    }

}
