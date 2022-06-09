package com.example.examplemod.init;

import com.example.examplemod.generation.annotations.LanguageDataKey;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TestInit {
    public static final DeferredRegister<Item> TEST = DeferredRegister.create(ForgeRegistries.ITEMS, "examplemod");

    @LanguageDataKey(key = "item.test", translation = "test item")
    public static final RegistryObject<Item> TEST_ITEM = TEST.register("examplemod", () -> new Item(new Item.Properties()));
}
