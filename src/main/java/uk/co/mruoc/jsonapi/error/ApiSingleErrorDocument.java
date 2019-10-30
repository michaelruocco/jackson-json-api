package uk.co.mruoc.jsonapi.error;

import java.util.Collection;
import java.util.Collections;

public class ApiSingleErrorDocument implements ApiErrorDocument {

    private final ApiError error;

    public ApiSingleErrorDocument(final ApiError error) {
        this.error = error;
    }

    @Override
    public Collection<ApiError> getErrors() {
        return Collections.singleton(error);
    }

    @Override
    public int getStatus() {
        return error.getStatus();
    }

}
