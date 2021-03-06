package com.github.kyazuki.luckymobsmod;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.commons.lang3.tuple.Pair;

@Mod.EventBusSubscriber(modid = LuckyMobsMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class LuckyMobsModConfig {
  public static final ClientConfig CLIENT;
  public static final ForgeConfigSpec CLIENT_SPEC;
  static {
    final Pair<ClientConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(ClientConfig::new);
    CLIENT_SPEC = specPair.getRight();
    CLIENT = specPair.getLeft();
  }

  public static boolean enable_on_creative;
  public static boolean luck_show_chat;

  @SubscribeEvent
  public static void onModConfigEvent(final ModConfig.ModConfigEvent configEvent) {
    if (configEvent.getConfig().getSpec() == LuckyMobsModConfig.CLIENT_SPEC) {
      bakeConfig();
    }
  }

  public static void bakeConfig() {
    enable_on_creative = CLIENT.enable_on_creative.get();
    luck_show_chat = CLIENT.luck_show_chat.get();
  }

  public static class ClientConfig {

    public final ForgeConfigSpec.BooleanValue enable_on_creative;
    public final ForgeConfigSpec.BooleanValue luck_show_chat;

    public ClientConfig(ForgeConfigSpec.Builder builder) {
      builder.push("LuckyMobsMod Config");
      enable_on_creative = builder
              .comment("Enable lucky effects on creative.")
              .translation(LuckyMobsMod.MODID + ".config" + "enable_on_creative")
              .define("enable_on_creative", false);
      luck_show_chat = builder
              .comment("Send the luck value to chat.")
              .translation(LuckyMobsMod.MODID + ".config" + "luck_show_chat")
              .define("luck_show_chat", false);
      builder.pop();
    }

  }

}