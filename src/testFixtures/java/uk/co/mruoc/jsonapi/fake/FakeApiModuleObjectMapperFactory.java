package uk.co.mruoc.jsonapi.fake;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.UUID;
import java.util.function.Function;

public class FakeApiModuleObjectMapperFactory {

    public ObjectMapper withNoOpIdParser() {
        return build(new NoOpIdParser());
    }

    public ObjectMapper withUuidIdParser() {
        return build(new UuidIdParser());
    }

    public ObjectMapper withStringIdParser() {
        return build(new StringIdParser());
    }

    public ObjectMapper withNumericIdParser() {
        return build(new LongIdParser());
    }

    public ObjectMapper build(final Function<String, Object> idParser) {
        return new ObjectMapper().registerModule(new FakeApiModule(idParser));
    }

    private static class NoOpIdParser implements Function<String, Object> {

        @Override
        public Object apply(final String value) {
            return new Object();
        }

    }

    private static class StringIdParser implements Function<String, Object> {

        @Override
        public Object apply(final String value) {
            return value;
        }

    }

    private static class UuidIdParser implements Function<String, Object> {

        @Override
        public Object apply(final String value) {
            return UUID.fromString(value);
        }

    }

    private static class LongIdParser implements Function<String, Object> {

        @Override
        public Object apply(final String value) {
            return Long.parseLong(value);
        }

    }

}
