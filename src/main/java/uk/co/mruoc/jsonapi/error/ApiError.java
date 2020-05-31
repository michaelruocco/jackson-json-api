package uk.co.mruoc.jsonapi.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class ApiError {

    private final UUID id;
    private final String status;
    private final String title;
    private final String detail;
    private final Map<String, Object> meta;

}
