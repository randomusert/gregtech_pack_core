package io.github.randomusert.mods.gregtech_pack_core.datagen;

import io.github.randomusert.mods.gregtech_pack_core.init.ModItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.PlayerTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementProvider extends AdvancementProvider {
    public ModAdvancementProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, ExistingFileHelper existingFileHelper) {
        super(output, registries, existingFileHelper, List.of(new ModAdvancementGenerator()));
    }

    private static final class ModAdvancementGenerator implements AdvancementProvider.AdvancementGenerator {

        @Override
        public void generate(HolderLookup.Provider provider,
                             Consumer<AdvancementHolder> consumer,
                             ExistingFileHelper existingFileHelper) {

            AdvancementHolder root = Advancement.Builder.advancement()
                    .display(
                            ModItems.MINECRAFTIUM.get(),
                            Component.literal("gregtech pack core"),
                            Component.literal("This advancement tree will show a general progression of this mod"),
                            ResourceLocation.fromNamespaceAndPath("minecraft", "textures/block/stone.png"),
                            AdvancementType.TASK,
                            false,
                            false,
                            false
                    )
                    .addCriterion("tick", PlayerTrigger.TriggerInstance.tick())
                    .save(consumer, "gregtech_pack_core:root");



            Advancement.Builder.advancement()
                    .parent(root)
                    .display(
                            ModItems.SINGULARITY_ALLOY.get(),
                            Component.literal("What have YOU DONE!?"),
                            Component.literal("Obtain Singularity alloy"),
                            null,
                            AdvancementType.CHALLENGE,
                            true,
                            true,
                            false
                    )
                    .rewards(AdvancementRewards.Builder.experience(1000))
                    .addCriterion("obtain_singularity_alloy",
                            InventoryChangeTrigger.TriggerInstance.hasItems(
                                    ModItems.MINECRAFTIUM.get()
                            )
                    )
                    .save(consumer, "gregtech_pack_core:obtain_singularity_alloy");

            Advancement.Builder.advancement()
                    .parent(root)
                    .display(
                            ModItems.MINECRAFTIUM.get(),
                            Component.literal("minecraftium, a key to getting into gregtech"),
                            Component.literal("Obtain minecraftium"),
                            null,
                            AdvancementType.TASK,
                            true,
                            true,
                            false
                    )
                    .rewards(AdvancementRewards.Builder.experience(1000))
                    .addCriterion("obtain_minecraftium",
                            InventoryChangeTrigger.TriggerInstance.hasItems(
                                    ModItems.MINECRAFTIUM.get()
                            )
                    )
                    .save(consumer, "gregtech_pack_core:obtain_minecraftium");

            Advancement.Builder.advancement()
                    .parent(root)
                    .display(
                            ModItems.GREGIUM.get(),
                            Component.literal("gregium the unlock for gregtech"),
                            Component.literal("Obtain gregium"),
                            null,
                            AdvancementType.TASK,
                            true,
                            true,
                            false
                    )
                    .rewards(AdvancementRewards.Builder.experience(1000))
                    .addCriterion("obtain_gregium",
                            InventoryChangeTrigger.TriggerInstance.hasItems(
                                    ModItems.GREGIUM.get()
                            )
                    )
                    .save(consumer, "gregtech_pack_core:obtain_gregium");
        }
    }
}
