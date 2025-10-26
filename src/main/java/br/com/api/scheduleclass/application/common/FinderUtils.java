package br.com.api.scheduleclass.application.common;

import java.util.Optional;
import java.util.function.Function;

public class FinderUtils {

    private FinderUtils() {}

    public static <T, ID, E extends RuntimeException> T findOrThrow(
            Function<ID, Optional<T>> findFunction,
            Function<ID, E> exceptionSupplier,
            ID id
    ) {
        return findFunction.apply(id)
                .orElseThrow(() -> exceptionSupplier.apply(id));
    }
}