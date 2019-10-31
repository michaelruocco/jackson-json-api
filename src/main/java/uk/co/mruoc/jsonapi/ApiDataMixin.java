package uk.co.mruoc.jsonapi;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "type", "attributes" })
public interface ApiDataMixin<T> {

    @JsonIgnore
    T getAttributes();

}
