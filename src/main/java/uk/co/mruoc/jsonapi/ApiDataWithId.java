package uk.co.mruoc.jsonapi;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(force = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class ApiDataWithId<T> extends ApiData<T> {

    private final Object id;

    public ApiDataWithId(final Object id, final String type, T attributes) {
        super(type, attributes);
        this.id = id;
    }

}
