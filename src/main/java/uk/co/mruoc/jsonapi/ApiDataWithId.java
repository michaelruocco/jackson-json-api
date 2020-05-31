package uk.co.mruoc.jsonapi;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(force = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class ApiDataWithId<I, T> extends ApiData<T> {

    private final I id;

    public ApiDataWithId(final I id, final String type, T attributes) {
        super(type, attributes);
        this.id = id;
    }

    public I getId() {
        return id;
    }

}
