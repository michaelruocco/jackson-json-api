package uk.co.mruoc.jsonapi;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Data
public class ApiDocumentWithId<I, T> {

    private final ApiDataWithId<I, T> data;

    public T getAttributes() {
        return data.getAttributes();
    }

    public I getId() {
        return data.getId();
    }

}
