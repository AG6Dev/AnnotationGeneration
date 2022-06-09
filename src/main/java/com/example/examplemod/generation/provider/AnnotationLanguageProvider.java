package com.example.examplemod.generation.provider;

import com.example.examplemod.generation.AnnotationGeneration;
import com.example.examplemod.generation.annotations.LanguageDataKey;
import com.example.examplemod.util.AnnotationUtil;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;
import org.slf4j.LoggerFactory;

public class AnnotationLanguageProvider extends LanguageProvider {
    public AnnotationLanguageProvider(DataGenerator gen, String locale) {
        super(gen, AnnotationGeneration.getInstance().modid, locale);
    }

    @Override
    protected void addTranslations() {
        LoggerFactory.getLogger(AnnotationGeneration.getInstance().modid).debug("Starting language data generation for modid {}", AnnotationGeneration.getInstance().modid);

        final var fieldsWithAnno = AnnotationUtil.getFieldsInClassesWithAnnotation(AnnotationGeneration.getInstance().classesToSearch, LanguageDataKey.class);

        fieldsWithAnno.forEach((aClass, fields) -> fields.forEach(field -> {
            final var fieldAnnotation = field.getAnnotation(LanguageDataKey.class);
            add(fieldAnnotation.key(), fieldAnnotation.translation());
        }));
    }
}
