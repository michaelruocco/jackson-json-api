package uk.co.mruoc.jsonapi;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class ApiDocument<T> {

    private final ApiData<T> data;

    public T getAttributes() {
        return data.getAttributes();
    }

}
