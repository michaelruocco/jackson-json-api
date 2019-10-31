package uk.co.mruoc.jsonapi;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "id", "type", "attributes" })
public interface ApiDataWithIdMixin<T> {

    // intentionally blank

}
