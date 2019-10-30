package uk.co.mruoc.jsonapi.fake;

import uk.co.mruoc.jsonapi.ApiDataWithId;

public class MyApiDataWithId extends ApiDataWithId<FakeAttributes> {

    public MyApiDataWithId(final Object id, final FakeAttributes attributes) {
        super(id, "fake-attributes-type", attributes);
    }

}
