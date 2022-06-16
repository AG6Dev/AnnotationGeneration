package io.github.ag6dev.annotationgeneration.generation.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ItemModelGen {

    /**
     * The registry name of the item
     */
    String registryName();

    /**
     * Type of model to be generated
     */
    ModelType type();

    /**
     * Location of the texture {@code item/texturename}
     * <br> Starts from the {@code assets/modid} directory  </br>
     */
    String textureLoc() default "";

    enum ModelType {
        ITEM_GENERATED,
        ITEM_HANDHELD,
    }
}

