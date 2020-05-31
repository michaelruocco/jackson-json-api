package uk.co.mruoc.jsonapi.fake;

import java.util.UUID;

public class FakeDomainObjectMother {

    public static FakeDomainObject nullId() {
        return build(null);
    }

    public static FakeDomainObject uuidId1() {
        return build(UUID.fromString("94e65ed0-1334-4c78-8c8f-bfd12773d041"));
    }

    public static FakeDomainObject uuidId2() {
        return build(UUID.fromString("3909018e-35d1-4196-9141-13a966005a67"));
    }

    public static FakeDomainObject stringId1() {
        return FakeDomainObjectMother.build("my-id-1");
    }

    public static FakeDomainObject stringId2() {
        return FakeDomainObjectMother.build("my-id-2");
    }

    public static FakeDomainObject numericId1() {
        return build(123456789L);
    }

    public static FakeDomainObject numericId2() {
        return build(999999999L);
    }

    public static FakeDomainObject build(final Object id) {
        return FakeDomainObject.builder()
                .id(id)
                .value1("fake-value-1")
                .value2("fake-value-2")
                .build();
    }

}
