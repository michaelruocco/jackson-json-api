package uk.co.mruoc.jsonapi.fake;

import uk.co.mruoc.jsonapi.ApiData;

public class FakeApiData extends ApiData<FakeAttributes> {

    private static final String TYPE = "fake-attributes-type";

    public FakeApiData(final Object id, final FakeAttributes attributes) {
        super(id,TYPE, attributes);
    }

    public FakeApiData(final FakeAttributes attributes) {
        super(TYPE, attributes);
    }

}
