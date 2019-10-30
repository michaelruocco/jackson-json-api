package uk.co.mruoc.jsonapi;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ApiDocumentTest {

    private static final String TYPE = "fake-type";
    private static final String ATTRIBUTES = "fake-attributes";

    private final ApiDocument<Object> item = new ApiDocument<>(new ApiData<>(TYPE, ATTRIBUTES));

    @Test
    void shouldReturnAttributes() {
        assertThat(item.getAttributes()).isEqualTo(ATTRIBUTES);
    }

}
