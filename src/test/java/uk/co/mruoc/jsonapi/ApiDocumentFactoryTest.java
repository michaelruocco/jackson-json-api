package uk.co.mruoc.jsonapi;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class ApiDocumentFactoryTest {

    @Test
    void shouldExtractTypeNode() {
        final JsonNode dataNode = mock(JsonNode.class);
        final JsonNode typeNode = mock(JsonNode.class);
        given(dataNode.get("type")).willReturn(typeNode);

        final JsonNode result = ApiDocumentFactory.extractTypeNode(dataNode);

        assertThat(result).isEqualTo(typeNode);
    }

}
