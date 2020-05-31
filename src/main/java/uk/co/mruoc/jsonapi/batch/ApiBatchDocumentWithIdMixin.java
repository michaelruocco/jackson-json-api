package uk.co.mruoc.jsonapi.batch;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Collection;

public interface ApiBatchDocumentWithIdMixin<I, T> extends ApiBatchDocumentMixin<T> {

    @JsonIgnore
    Collection<I> getIds();

}
