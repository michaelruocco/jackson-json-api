package uk.co.mruoc.jsonapi.batch;

import org.junit.jupiter.api.Test;
import uk.co.mruoc.jsonapi.ApiDataWithId;

import static org.assertj.core.api.Assertions.assertThat;

class ApiBatchDocumentWithIdTest {

    private static final String TYPE = "fake-type";

    private static final String ID_1 = "fake-id-1";
    private static final String ATTRIBUTES_1 = "fake-attributes-1";

    @Test
    void shouldReturnAttributes() {
        final ApiBatchDocumentWithId<String, Object> document = toDocument(toData(ID_1, ATTRIBUTES_1));

        assertThat(document.getAttributes()).containsExactly(ATTRIBUTES_1);
    }

    @Test
    void shouldReturnId() {
        final ApiBatchDocumentWithId<String, Object> document = toDocument(toData(ID_1, ATTRIBUTES_1));

        assertThat(document.getIds()).containsExactly(ID_1);
    }

    @Test
    void shouldGetDataByIndex() {
        final ApiDataWithId<String, Object> data1 = toData(ID_1, ATTRIBUTES_1);
        final ApiDataWithId<String, Object> data2 = toData("ID_2", "attributes-2");

        final ApiBatchDocumentWithId<String, Object> document = toDocument(data1, data2);

        assertThat(document.getDataByIndex(1)).contains(data2);
    }

    @Test
    void shouldReturnEmptyOptionalIfIndexDoesNotExist() {
        final ApiBatchDocumentWithId<String, Object> document = toDocument();

        assertThat(document.getDataByIndex(0)).isEmpty();
    }

    @Test
    void shouldGetDataById() {
        final ApiDataWithId<String, Object> data1 = toData(ID_1, ATTRIBUTES_1);
        final ApiDataWithId<String, Object> data2 = toData("ID_2", "attributes-2");

        final ApiBatchDocumentWithId<String, Object> document = toDocument(data1, data2);

        assertThat(document.getDataById(data2.getId())).contains(data2);
    }

    @Test
    void shouldReturnEmptyOptionalIfIdDoesNotExist() {
        final ApiBatchDocumentWithId<String, Object> document = toDocument();

        assertThat(document.getDataById("id")).isEmpty();
    }

    private static ApiDataWithId<String, Object> toData(final String id, final Object attributes) {
        return new ApiDataWithId<>(id, TYPE, attributes);
    }

    @SafeVarargs
    private static ApiBatchDocumentWithId<String, Object> toDocument(final ApiDataWithId<String, Object>... items) {
        return new ApiBatchDocumentWithId<>(items);
    }

}
