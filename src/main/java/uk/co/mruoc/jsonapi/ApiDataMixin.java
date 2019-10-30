package uk.co.mruoc.jsonapi;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Optional;

public interface ApiDataMixin {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    Optional<Object> getId();

}
