package uk.co.mruoc.jsonapi;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Data
public class ApiDocumentWithId<T> {

    private final ApiDataWithId<T> data;

    public T getAttributes() {
        return data.getAttributes();
    }

}
