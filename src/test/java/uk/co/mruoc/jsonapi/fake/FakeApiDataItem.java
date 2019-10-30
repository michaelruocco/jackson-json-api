package uk.co.mruoc.jsonapi.fake;

import uk.co.mruoc.jsonapi.ApiDataItem;

public class FakeApiDataItem extends ApiDataItem<FakeAttributes> {

    private static final String TYPE = "fake-attributes-type";

    public FakeApiDataItem(final Object id, final FakeAttributes attributes) {
        super(id,TYPE, attributes);
    }

    public FakeApiDataItem(final FakeAttributes attributes) {
        super(TYPE, attributes);
    }

}
