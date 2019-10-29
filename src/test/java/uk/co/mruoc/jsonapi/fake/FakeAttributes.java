package uk.co.mruoc.jsonapi.fake;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class FakeAttributes {

    private final UUID id;
    private final String value1;
    private final String value2;

}
