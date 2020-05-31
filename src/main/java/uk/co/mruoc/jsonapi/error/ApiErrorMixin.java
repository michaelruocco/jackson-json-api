package uk.co.mruoc.jsonapi.error;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Map;

public interface ApiErrorMixin {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    Map<String, Object> getMeta();

}
