package com.example.examplemod.generation.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface BlockModelGen {
    String registryName();

    /**
     * A list of texture locations so all sides can be textures
     */
    String[] texLoc();

    ModelType modelType();

    boolean generateBlockItemModels() default false;

    enum ModelType {
        CUBE_SINGLE_TEXTURE,
        STAIRS,
        SLAB
    }
}
