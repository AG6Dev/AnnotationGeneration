package com.example.examplemod.generation;

import java.util.Objects;
import java.util.Set;

public class AnnotationGeneration {
    public static AnnotationGeneration INSTANCE = null;
    public final String modid;
    public final Set<Class<?>> classesToSearch;

    public AnnotationGeneration(String modid, Set<Class<?>> classesToSearch) {
        INSTANCE = this;
        this.modid = modid;
        this.classesToSearch = classesToSearch;
    }


    public static AnnotationGeneration getInstance() {
        return Objects.requireNonNull(INSTANCE);
    }
}
