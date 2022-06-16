package io.github.ag6dev.annotationgeneration.generation.provider;

import io.github.ag6dev.annotationgeneration.generation.AnnotationGeneration;
import io.github.ag6dev.annotationgeneration.generation.annotations.BlockModelGen;
import io.github.ag6dev.annotationgeneration.generation.annotations.ItemModelGen;
import io.github.ag6dev.annotationgeneration.util.AnnotationUtil;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class AnnotationItemModelProvider extends ItemModelProvider {
    public AnnotationItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, AnnotationGeneration.getInstance().modid, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        final var itemFields = AnnotationUtil.getFieldsInClassesWithAnnotation(AnnotationGeneration.getInstance().classesToSearch, ItemModelGen.class);
        final var blockFields = AnnotationUtil.getFieldsInClassesWithAnnotation(AnnotationGeneration.getInstance().classesToSearch, BlockModelGen.class);
        itemFields.forEach(field -> {
            final var fieldAnno = field.getAnnotation(ItemModelGen.class);

            switch (fieldAnno.type()) {
                case ITEM_GENERATED -> singleTexture(modLoc(fieldAnno.registryName()).toString(), mcLoc("item/generated"), "layer0", modLoc(fieldAnno.textureLoc()));
                case ITEM_HANDHELD -> singleTexture(modLoc(fieldAnno.registryName()).toString(), mcLoc("item/handheld"), "layer0", modLoc(fieldAnno.textureLoc()));
            }
        });

        blockFields.forEach(field -> {
            final var fieldAnno = field.getAnnotation(BlockModelGen.class);
            if (fieldAnno.generateBlockItemModels())
                withExistingParent(fieldAnno.registryName(), modLoc(fieldAnno.registryName()));
        });
    }
}

