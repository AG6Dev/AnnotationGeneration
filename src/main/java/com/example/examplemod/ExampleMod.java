package com.example.examplemod;

import com.example.examplemod.generation.AnnotationGeneration;
import com.example.examplemod.generation.GenerationType;
import com.example.examplemod.init.TestInit;
import com.mojang.logging.LogUtils;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import java.util.Set;
import java.util.stream.Collectors;

@Mod("examplemod")
public class ExampleMod {
    public static final Logger LOGGER = LogUtils.getLogger();

    public ExampleMod() {
        AnnotationGeneration gen = new AnnotationGeneration("examplemod", TestInit.class);

        TestInit.TEST.register(FMLJavaModLoadingContext.get().getModEventBus());
        TestInit.BLOCK.register(FMLJavaModLoadingContext.get().getModEventBus());

        MinecraftForge.EVENT_BUS.register(this);
    }
}
