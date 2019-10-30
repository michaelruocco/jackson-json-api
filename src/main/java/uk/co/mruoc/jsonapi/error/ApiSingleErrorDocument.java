package uk.co.mruoc.jsonapi.error;

import java.util.Collection;
import java.util.Collections;

public class ApiSingleErrorDocument implements ApiErrorDocument {

    private final ApiErrorItem error;

    public ApiSingleErrorDocument(final ApiErrorItem error) {
        this.error = error;
    }

    @Override
    public Collection<ApiErrorItem> getErrors() {
        return Collections.singleton(error);
    }

    @Override
    public int getStatus() {
        return error.getStatus();
    }

}
