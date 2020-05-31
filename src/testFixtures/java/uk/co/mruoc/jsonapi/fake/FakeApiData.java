package uk.co.mruoc.jsonapi.fake;

import uk.co.mruoc.jsonapi.ApiData;

public class FakeApiData extends ApiData<FakeDomainObject> {

    private static final String TYPE = "fake-attributes-type";

    public FakeApiData(final FakeDomainObject attributes) {
        super(TYPE, attributes);
    }

}
