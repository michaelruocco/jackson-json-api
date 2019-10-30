package uk.co.mruoc.jsonapi.error;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

class FakeInternalServerErrorWithMeta extends InternalServerError {

    private static final UUID ID = UUID.fromString("74a8a129-a96b-4979-98c1-90d864dd47a4");
    private static final String DETAIL = "faked detail message";
    private static final Map<String, Object> META = buildMeta();

    FakeInternalServerErrorWithMeta() {
        super(ID, DETAIL, META);
    }

    private static Map<String, Object> buildMeta() {
        final Map<String, Object> meta = new HashMap<>();
        meta.put("string-value", "my-value-1");
        meta.put("numeric-value", 999);
        return meta;
    }

}
