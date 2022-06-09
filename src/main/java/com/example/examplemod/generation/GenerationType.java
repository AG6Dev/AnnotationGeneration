package com.example.examplemod.generation;

import com.example.examplemod.generation.annotations.LanguageDataKey;

public enum GenerationType {
    TRANSLATIONS(LanguageDataKey.class);
    //ITEM_MODELS,
    //LOOT_TABLES,
    //BLOCK_MODELS

    public final Class<?> annotationClass;

    GenerationType(Class<?> annotationClass) {
        this.annotationClass = annotationClass;
    }
}
