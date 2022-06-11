package com.example.examplemod.generation.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ItemModelGen {

    /**
     *  To be written as {@code modid:registryname}
     */
    String registryName();

    /**
     *  Type of model to be generated
     */
    ModelType type();

    /**<p> Location of the texture {@code item/texturename} </p>
     *  Starts from the {@code assets/modid} directory
     */
    String textureLoc() default "";

    enum ModelType {
        ITEM_GENERATED,
        ITEM_HANDHELD,
        BLOCK_ITEM_MODEL
    }
}

