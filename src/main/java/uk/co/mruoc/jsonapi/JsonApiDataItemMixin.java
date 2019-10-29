package uk.co.mruoc.jsonapi;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Optional;

public interface JsonApiDataItemMixin {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    Optional<Object> getId();

}
