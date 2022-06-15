package com.example.examplemod.generation.provider;

import com.example.examplemod.generation.AnnotationGeneration;
import com.example.examplemod.generation.annotations.BlockModelGen;
import com.example.examplemod.util.AnnotationUtil;
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

            if (fieldAnno.generateBlockItemModels())
                withExistingParent(modid + ":" + fieldAnno.registryName(), modLoc("block/" + fieldAnno.registryName()));


        });
    }
}
