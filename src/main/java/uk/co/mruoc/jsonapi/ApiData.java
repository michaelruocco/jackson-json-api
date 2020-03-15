package uk.co.mruoc.jsonapi;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@EqualsAndHashCode
@Data
public class ApiData<T> {

    private final String type;
    private final T attributes;

}
