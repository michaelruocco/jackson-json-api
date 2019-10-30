package uk.co.mruoc.jsonapi.fake;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FakeDomainObject {

    private final Object id;
    private final String value1;
    private final String value2;

}
