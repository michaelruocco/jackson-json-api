package uk.co.mruoc.jsonapi.error;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BadRequestErrorItemTest {

    private static final String TITLE = "My Title";
    private static final String DETAIL = "my detail";
    private static final int STATUS = 400;

    private final ApiError item = new BadRequestError(TITLE, DETAIL);

    @Test
    void shouldGenerateRandomIdIfNotProvided() {
        assertThat(item.getId()).isNotNull();
    }

    @Test
    void shouldReturnStatus() {
        assertThat(item.getStatus()).isEqualTo(STATUS);
    }

    @Test
    void shouldReturnDefaultTitleIfNotProvided() {
        final ApiError noTitleItem = new BadRequestError(DETAIL);

        assertThat(noTitleItem.getTitle()).isEqualTo("Bad Request");
    }

}
