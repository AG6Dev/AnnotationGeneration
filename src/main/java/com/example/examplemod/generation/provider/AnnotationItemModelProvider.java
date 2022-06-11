package com.example.examplemod.generation.provider;

import com.example.examplemod.generation.AnnotationGeneration;
import com.example.examplemod.generation.annotations.ItemModelGen;
import com.example.examplemod.util.AnnotationUtil;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class AnnotationItemModelProvider extends ItemModelProvider {
    public AnnotationItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, AnnotationGeneration.getInstance().modid, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        AnnotationGeneration.LOGGER.debug("Starting item model generation for modid {}", AnnotationGeneration.getInstance().modid);

        final var fields = AnnotationUtil.getFieldsInClassesWithAnnotation(AnnotationGeneration.getInstance().classesToSearch, ItemModelGen.class);
        fields.forEach(field -> {
            final var fieldAnno = field.getAnnotation(ItemModelGen.class);

            switch (fieldAnno.type()) {
                case ITEM_GENERATED -> singleTexture(fieldAnno.registryName(), mcLoc("item/generated"), "layer0", modLoc(fieldAnno.textureLoc()));
                case ITEM_HANDHELD -> singleTexture(fieldAnno.registryName(), mcLoc("item/handheld"), "layer0", modLoc(fieldAnno.textureLoc()));
            }
        });
    }

    ;
}

