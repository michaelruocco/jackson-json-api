package uk.co.mruoc.jsonapi.error;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ApiErrorDocumentTest {

    private final ApiError error = new FakeInternalServerError();
    private final ApiErrorDocument document = new ApiSingleErrorDocument(error);

    @Test
    void shouldReturnStatusFromError() {
        assertThat(document.getStatus()).isEqualTo(error.getStatus());
    }

}