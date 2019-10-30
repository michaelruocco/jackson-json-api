package uk.co.mruoc.jsonapi.error;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ApiBatchErrorDocumentTest {

    @Test
    void shouldReturnStatusFromErrorsIfErrorsHaveSameStatus() {
        final ApiErrorItem error1 = new FakeInternalServerErrorItem();
        final ApiErrorItem error2 = new FakeInternalServerErrorItem();

        final ApiErrorDocument document = new ApiBatchErrorDocument(error1, error2);

        assertThat(document.getStatus()).isEqualTo(error1.getStatus());
        assertThat(document.getStatus()).isEqualTo(error2.getStatus());
    }

    @Test
    void shouldReturnMultiStatusIfErrorsDoNotHaveSameStatus() {
        final ApiErrorItem error1 = new FakeNotFoundErrorItem();
        final ApiErrorItem error2 = new FakeBadRequestErrorItem();

        final ApiErrorDocument document = new ApiBatchErrorDocument(error1, error2);

        final int multiStatus = 207;
        assertThat(document.getStatus()).isEqualTo(multiStatus);
    }

}
