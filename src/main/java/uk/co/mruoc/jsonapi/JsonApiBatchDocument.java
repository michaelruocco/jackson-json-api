package uk.co.mruoc.jsonapi;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Data
public class JsonApiBatchDocument<T> {

    private final Collection<JsonApiDataItem<T>> data;

    public Collection<T> getAttributes() {
        return data.stream()
                .map(JsonApiDataItem::getAttributes)
                .collect(Collectors.toList());
    }

}
