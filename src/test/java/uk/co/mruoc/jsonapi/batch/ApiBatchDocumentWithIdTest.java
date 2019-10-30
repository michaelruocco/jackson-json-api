package uk.co.mruoc.jsonapi.batch;

import org.junit.jupiter.api.Test;
import uk.co.mruoc.jsonapi.ApiDataWithId;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class ApiBatchDocumentWithIdTest {

    private static final String ID = "fake-id";
    private static final String TYPE = "fake-type";
    private static final String ATTRIBUTES = "fake-attributes";

    private final ApiBatchDocumentWithId<Object> item = new ApiBatchDocumentWithId<>(Collections.singleton(new ApiDataWithId<>(ID, TYPE, ATTRIBUTES)));

    @Test
    void shouldReturnAttributes() {
        assertThat(item.getAttributes()).containsExactly(ATTRIBUTES);
    }

}
