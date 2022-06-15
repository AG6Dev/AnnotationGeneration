package com.example.examplemod;

import com.example.examplemod.generation.AnnotationGeneration;
import com.example.examplemod.init.TestInit;
import com.mojang.logging.LogUtils;
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
