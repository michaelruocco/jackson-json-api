package uk.co.mruoc.jsonapi.fake;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;

public interface FakeDomainObjectMixin {

    @JsonIgnore
    UUID getId();

}
