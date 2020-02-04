package com.github.kyazuki.luckymobsmod;

import mod.lucky.Lucky;
import mod.lucky.drop.func.DropProcessData;
import mod.lucky.drop.func.DropProcessor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

@Mod(LuckyMobsMod.MODID)
@Mod.EventBusSubscriber
public class LuckyMobsMod {
  public static final String MODID = "luckymobsmod";
  public static final Logger LOGGER = LogManager.getLogger(MODID);

  public LuckyMobsMod() {
    LOGGER.debug("LuckyMobsMod Loaded.");
    ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, LuckyMobsModConfig.CLIENT_SPEC);
  }

  @SubscribeEvent
  public static void onKillMobs(LivingDeathEvent event) {
    if (!event.getEntity().world.isRemote()) {
      if (event.getSource().getTrueSource() instanceof PlayerEntity) {
        if (!((PlayerEntity) (event.getSource().getTrueSource())).isCreative() || LuckyMobsModConfig.enable_on_creative) {
          DropProcessor dropProcessor = new DropProcessor();
          DropProcessData dropData = new DropProcessData(event.getEntity().world, event.getSource().getTrueSource(), event.getEntity().getPosition());
          int luck = (new Random()).nextInt(201);
          luck -= 100;
          ((PlayerEntity) (event.getSource().getTrueSource())).sendMessage(new StringTextComponent("Luck: " + luck));
          dropProcessor.processRandomDrop(Lucky.luckyBlock.getDropProcessor().getDrops(), dropData, luck, true);
        }
      }
    }
  }
}
