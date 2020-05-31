package uk.co.mruoc.jsonapi.error;

import java.util.Collection;

public interface ApiErrorDocument {

    Collection<ApiError> getErrors();

    String getStatus();

}
