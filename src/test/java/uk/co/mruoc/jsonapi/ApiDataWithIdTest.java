package uk.co.mruoc.jsonapi;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ApiDataWithIdTest {

    private static final String ID = "fake-id";
    private static final String TYPE = "fake-type";
    private static final String ATTRIBUTES = "fake-attributes";

    private final ApiDataWithId<String, Object> data = new ApiDataWithId<>(ID, TYPE, ATTRIBUTES);

    @Test
    void shouldReturnId() {
        assertThat(data.getId()).isEqualTo(ID);
    }

    @Test
    void shouldReturnType() {
        assertThat(data.getType()).isEqualTo(TYPE);
    }

    @Test
    void shouldReturnAttributes() {
        assertThat(data.getAttributes()).isEqualTo(ATTRIBUTES);
    }

    @Test
    void shouldPrintValues() {
        assertThat(data.toString()).hasToString("ApiDataWithId(super=ApiData(type=fake-type, attributes=fake-attributes), id=fake-id)");
    }

    @Test
    void shouldTestEquals() {
        EqualsVerifier.forClass(ApiDataWithId.class)
                .withRedefinedSuperclass()
                .suppress(Warning.STRICT_INHERITANCE)
                .verify();
    }

}
