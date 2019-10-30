package uk.co.mruoc.jsonapi;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface ApiDocumentMixin<T> {

    @JsonIgnore
    T getAttributes();

}
