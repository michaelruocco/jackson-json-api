package uk.co.mruoc.jsonapi.fake;

import lombok.Getter;
import uk.co.mruoc.jsonapi.ApiDataWithId;

@Getter
public class FakeApiDataWithId extends ApiDataWithId<Object, FakeDomainObject> {

    private static final String TYPE = "fake-attributes-type";

    public FakeApiDataWithId(final FakeDomainObject attributes) {
        super(attributes.getId(), TYPE, attributes);
    }

}
