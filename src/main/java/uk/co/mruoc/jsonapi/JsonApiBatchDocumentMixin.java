package uk.co.mruoc.jsonapi;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Collection;

public interface JsonApiBatchDocumentMixin<T> {

    @JsonIgnore
    Collection<T> getAttributes();

}
