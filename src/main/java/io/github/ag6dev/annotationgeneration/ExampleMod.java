package io.github.ag6dev.annotationgeneration;

import com.mojang.logging.LogUtils;
import io.github.ag6dev.annotationgeneration.generation.AnnotationGeneration;
import io.github.ag6dev.annotationgeneration.init.TestInit;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod("examplemod")
public class ExampleMod {
    public static final Logger LOGGER = LogUtils.getLogger();

    public ExampleMod() {
        AnnotationGeneration gen = new AnnotationGeneration("examplemod", TestInit.class);

        TestInit.TEST.register(FMLJavaModLoadingContext.get().getModEventBus());
        TestInit.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        MinecraftForge.EVENT_BUS.register(this);
    }
}
