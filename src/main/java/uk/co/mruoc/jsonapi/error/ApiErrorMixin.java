package uk.co.mruoc.jsonapi.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.util.Map;

public interface ApiErrorMixin {

    @JsonSerialize(using = ToStringSerializer.class)
    int getStatus();

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    Map<String, Object> getMeta();

}
