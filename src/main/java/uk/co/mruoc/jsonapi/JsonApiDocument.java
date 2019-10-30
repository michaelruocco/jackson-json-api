package uk.co.mruoc.jsonapi;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class JsonApiDocument<T> {

    private final JsonApiDataItem<T> data;

    public T getAttributes() {
        return data.getAttributes();
    }

}
