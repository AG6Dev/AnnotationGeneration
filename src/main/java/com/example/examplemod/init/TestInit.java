package com.example.examplemod.init;

import com.example.examplemod.generation.annotations.BlockModelGen;
import com.example.examplemod.generation.annotations.ItemModelGen;
import com.example.examplemod.generation.annotations.LanguageDataKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TestInit {
    public static final DeferredRegister<Item> TEST = DeferredRegister.create(ForgeRegistries.ITEMS, "examplemod");
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "examplemod");

    @ItemModelGen(registryName = "examplemod:examplemod", type = ItemModelGen.ModelType.ITEM_GENERATED, textureLoc = "item/test")
    @LanguageDataKey(key = "item.examplemod.examplemod", translation = "test item")
    public static final RegistryObject<Item> TEST_ITEM = TEST.register("examplemod", () -> new Item(new Item.Properties()));

    @BlockModelGen(registryName = "exampleblock", modelType = BlockModelGen.ModelType.CUBE_SINGLE_TEXTURE, texLoc = {"item/test"})
    public static final RegistryObject<Block> TEST_BLOCK = BLOCKS.register("exampleblock", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
}
