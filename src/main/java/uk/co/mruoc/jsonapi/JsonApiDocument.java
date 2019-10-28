package uk.co.mruoc.jsonapi;


import java.util.Optional;

public class JsonApiDocument<T> {

    private final JsonApiDataItem<T> data;

    public JsonApiDocument(final JsonApiDataItem<T> data) {
        this.data = data;
    }

    public Optional<String> getId() {
        return data.getId();
    }

    public String getType() {
        return data.getType();
    }

    public T getAttributes() {
        return data.getAttributes();
    }

}
