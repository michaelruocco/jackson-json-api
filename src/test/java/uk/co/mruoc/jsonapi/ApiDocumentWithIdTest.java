package uk.co.mruoc.jsonapi;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ApiDocumentWithIdTest {

    private static final String ID = "fake-id";
    private static final String TYPE = "fake-type";
    private static final String ATTRIBUTES = "fake-attributes";


    private final ApiDocumentWithId<Object> item = new ApiDocumentWithId<>(new ApiDataWithId<>(ID, TYPE, ATTRIBUTES));

    @Test
    void shouldReturnAttributes() {
        assertThat(item.getAttributes()).isEqualTo(ATTRIBUTES);
    }

}
