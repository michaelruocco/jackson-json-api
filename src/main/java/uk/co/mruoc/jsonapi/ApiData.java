package uk.co.mruoc.jsonapi;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Data
public class ApiData<T> {

    private final String type;
    private final T attributes;

}
