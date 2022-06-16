package io.github.ag6dev.annotationgeneration.generation.provider;

import io.github.ag6dev.annotationgeneration.generation.AnnotationGeneration;
import io.github.ag6dev.annotationgeneration.generation.annotations.BlockModelGen;
import io.github.ag6dev.annotationgeneration.util.AnnotationUtil;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class AnnotationBlockModelProvider extends BlockModelProvider {
    public AnnotationBlockModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, AnnotationGeneration.getInstance().modid, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        final var fieldsAnnotated = AnnotationUtil.getFieldsInClassesWithAnnotation(AnnotationGeneration.getInstance().classesToSearch, BlockModelGen.class);

        fieldsAnnotated.forEach(field -> {
            final var fieldAnno = field.getAnnotation(BlockModelGen.class);

            switch (fieldAnno.modelType()) {
                case CUBE_SINGLE_TEXTURE -> cubeAll(fieldAnno.registryName(), modLoc(fieldAnno.texLoc()[0]));
                case STAIRS -> stairs(fieldAnno.registryName(), modLoc(fieldAnno.texLoc()[0]), modLoc(fieldAnno.texLoc()[1]), modLoc(fieldAnno.texLoc()[2]));
            }
        });
    }
}
