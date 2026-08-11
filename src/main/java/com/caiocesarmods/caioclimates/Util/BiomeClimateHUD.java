package com.caiocesarmods.caioclimates.Util;

import com.caiocesarmods.caioclimates.Climate.ClimateDomain;
import com.caiocesarmods.caioclimates.Climate.ClimateDomainRegistry;
import com.caiocesarmods.caioclimates.Seasons.Season;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class BiomeClimateHUD {

    @SubscribeEvent
    public static void onRenderGameOverlay(RenderGameOverlayEvent.Text event) {
        Minecraft mc = Minecraft.getInstance();
        ClientPlayerEntity player = mc.player;

        if (player == null) return;

        World world = player.world;
        long dayTime = world.getDayTime();
        BlockPos pos = player.getPosition();

        String season = Season.getSeason(dayTime);
        ClimateDomain climate = ClimateDomainRegistry.get(world, pos);

        int lineHeight = 10;
        int margin = 40;

        int screenHeight = mc.getMainWindow().getScaledHeight();

        // Two lines, starting from the bottom.
        int y = screenHeight - margin - (lineHeight * 2);

        drawText(mc, event, "Global Season: " + season, 10, y);
        y += lineHeight;

        drawText(mc, event, "Biome Climate: " + climate, 10, y);
    }

    private static void drawText(Minecraft mc, RenderGameOverlayEvent.Text event, String text, int x, int y) {
        mc.fontRenderer.drawString(
                event.getMatrixStack(),
                text,
                x,
                y,
                0xFFFFFF
        );
    }
}
