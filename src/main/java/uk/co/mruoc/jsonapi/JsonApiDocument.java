package uk.co.mruoc.jsonapi;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class JsonApiDocument<T> {

    private final JsonApiDataItem<T> data;

    public T getAttributes() {
        return data.getAttributes();
    }

}
