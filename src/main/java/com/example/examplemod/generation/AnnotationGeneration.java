package com.example.examplemod.generation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;
import java.util.Set;

public class AnnotationGeneration {
    private static AnnotationGeneration INSTANCE = null;
    public final String modid;
    public final Set<Class<?>> classesToSearch;

    public static final Logger LOGGER = LoggerFactory.getLogger(getInstance().modid);

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
