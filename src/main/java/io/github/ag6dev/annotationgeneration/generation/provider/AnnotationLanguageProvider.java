package io.github.ag6dev.annotationgeneration.generation.provider;

import io.github.ag6dev.annotationgeneration.generation.AnnotationGeneration;
import io.github.ag6dev.annotationgeneration.generation.annotations.LanguageDataKey;
import io.github.ag6dev.annotationgeneration.util.AnnotationUtil;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class AnnotationLanguageProvider extends LanguageProvider {
    public AnnotationLanguageProvider(DataGenerator gen, String locale) {
        super(gen, AnnotationGeneration.getInstance().modid, locale);
    }

    @Override
    protected void addTranslations() {
        final var fieldsWithAnno = AnnotationUtil.getFieldsInClassesWithAnnotation(AnnotationGeneration.getInstance().classesToSearch, LanguageDataKey.class);

        fieldsWithAnno.forEach(field -> {
            final var fieldAnnotation = field.getAnnotation(LanguageDataKey.class);
            add(fieldAnnotation.key(), fieldAnnotation.translation());
        });
    }
}
