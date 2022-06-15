package com.example.examplemod.generation;

import com.example.examplemod.generation.provider.AnnotationBlockModelProvider;
import com.example.examplemod.generation.provider.AnnotationItemModelProvider;
import com.example.examplemod.generation.provider.AnnotationLanguageProvider;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class GenerationEvents {
    @SubscribeEvent
    public static void gatherDataEvent(final GatherDataEvent event) {
        final var existingFileHelper = event.getExistingFileHelper();
        final var generator = event.getGenerator();

        generator.addProvider(new AnnotationLanguageProvider(generator, "en_us"));
        generator.addProvider(new AnnotationItemModelProvider(generator, existingFileHelper));
        generator.addProvider(new AnnotationBlockModelProvider(generator, existingFileHelper));
    }
}
