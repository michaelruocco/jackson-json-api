package uk.co.mruoc.jsonapi;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface ApiDocumentWithIdMixin<I, T> extends ApiDocumentMixin<T> {

    @JsonIgnore
    I getId();

}
