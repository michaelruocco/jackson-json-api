package uk.co.mruoc.jsonapi.batch;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Collection;

public interface ApiBatchDocumentMixin<T> {

    @JsonIgnore
    Collection<T> getAttributes();

}
