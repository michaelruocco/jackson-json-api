package uk.co.mruoc.jsonapi.error;

import org.junit.jupiter.api.Test;
import uk.co.mruoc.jsonapi.fake.error.FakeBadRequestError;
import uk.co.mruoc.jsonapi.fake.error.FakeInternalServerError;
import uk.co.mruoc.jsonapi.fake.error.FakeNotFoundError;

import static org.assertj.core.api.Assertions.assertThat;

class ApiBatchErrorDocumentTest {

    @Test
    void shouldReturnStatusFromErrorsIfErrorsHaveSameStatus() {
        final ApiError error1 = new FakeInternalServerError();
        final ApiError error2 = new FakeInternalServerError();

        final ApiErrorDocument document = new ApiBatchErrorDocument(error1, error2);

        assertThat(document.getStatus()).isEqualTo(error1.getStatus());
        assertThat(document.getStatus()).isEqualTo(error2.getStatus());
    }

    @Test
    void shouldReturnMultiStatusIfErrorsDoNotHaveSameStatus() {
        final ApiError error1 = new FakeNotFoundError();
        final ApiError error2 = new FakeBadRequestError();

        final ApiErrorDocument document = new ApiBatchErrorDocument(error1, error2);

        assertThat(document.getStatus()).isEqualTo("207");
    }

}
