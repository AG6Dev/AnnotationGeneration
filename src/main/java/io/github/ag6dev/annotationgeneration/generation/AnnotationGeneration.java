package io.github.ag6dev.annotationgeneration.generation;

import java.util.Objects;
import java.util.Set;

public class AnnotationGeneration {
    private static AnnotationGeneration INSTANCE = null;
    public final String modid;
    public final Set<Class<?>> classesToSearch;

    public AnnotationGeneration(String modid, Set<Class<?>> classesToSearch) {
        INSTANCE = this;
        this.modid = modid;
        this.classesToSearch = classesToSearch;
    }

    public AnnotationGeneration(String modid, Class<?>... classes) {
        this(modid, Set.of(classes));
    }


    public static AnnotationGeneration getInstance() {
        return Objects.requireNonNull(INSTANCE);
    }
}
