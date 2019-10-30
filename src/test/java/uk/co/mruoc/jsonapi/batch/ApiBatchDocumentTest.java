package uk.co.mruoc.jsonapi.batch;

import org.junit.jupiter.api.Test;
import uk.co.mruoc.jsonapi.ApiData;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class ApiBatchDocumentTest {

    private static final String TYPE = "fake-type";
    private static final String ATTRIBUTES = "fake-attributes";

    private final ApiBatchDocument<Object> item = new ApiBatchDocument<>(Collections.singleton(new ApiData<>(TYPE, ATTRIBUTES)));

    @Test
    void shouldReturnAttributes() {
        assertThat(item.getAttributes()).containsExactly(ATTRIBUTES);
    }

}
