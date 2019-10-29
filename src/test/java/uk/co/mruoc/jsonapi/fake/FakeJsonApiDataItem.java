package uk.co.mruoc.jsonapi.fake;

import uk.co.mruoc.jsonapi.JsonApiDataItem;

public class FakeJsonApiDataItem extends JsonApiDataItem<FakeAttributes> {

    private static final String TYPE = "fake-attributes-type";

    public FakeJsonApiDataItem(final Object id, final FakeAttributes attributes) {
        super(id,TYPE, attributes);
    }

    public FakeJsonApiDataItem(final FakeAttributes attributes) {
        super(TYPE, attributes);
    }

}
