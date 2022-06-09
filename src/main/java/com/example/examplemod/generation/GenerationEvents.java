package com.example.examplemod.generation;

import com.example.examplemod.generation.provider.AnnotationLanguageProvider;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import org.slf4j.LoggerFactory;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class GenerationEvents {
    @SubscribeEvent
    public static void gatherDataEvent(final GatherDataEvent event) {
        final var existingFileHelper = event.getExistingFileHelper();
        final var generator = event.getGenerator();

        LoggerFactory.getLogger(AnnotationGeneration.class).debug("Starting Data Generation for mod: {}", AnnotationGeneration.getInstance().modid);

        generator.addProvider(new AnnotationLanguageProvider(generator, "en_us"));
    }
 }
