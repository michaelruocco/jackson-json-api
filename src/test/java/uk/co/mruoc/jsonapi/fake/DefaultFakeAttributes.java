package uk.co.mruoc.jsonapi.fake;

import java.util.UUID;

public class DefaultFakeAttributes extends FakeAttributes {

    public DefaultFakeAttributes() {
        this(UUID.fromString("94e65ed0-1334-4c78-8c8f-bfd12773d041"));
    }

    public DefaultFakeAttributes(final Object id) {
        super(id, "fake-value-1", "fake-value-2");
    }

}
