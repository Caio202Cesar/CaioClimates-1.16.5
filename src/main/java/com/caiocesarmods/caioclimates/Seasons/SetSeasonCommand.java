package com.caiocesarmods.caioclimates.Seasons;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.server.ServerWorld;

public class SetSeasonCommand {
    public static void register(CommandDispatcher<CommandSource> dispatcher) {
        dispatcher.register(
                Commands.literal("season")
                        .requires(source -> source.hasPermissionLevel(2)) // OP only
                        .then(Commands.argument("season", StringArgumentType.word())
                                .executes(ctx -> {
                                    String season = StringArgumentType.getString(ctx, "season").toUpperCase();
                                    ServerWorld world = ctx.getSource().getWorld();

                                    long seasonDay;

                                    switch (season) {
                                        case "SPRING":
                                        case "EARLY_SPRING":
                                            seasonDay = 0;
                                            break;
                                        case "MID_SPRING":
                                            seasonDay = 8;
                                            break;
                                        case "LATE_SPRING":
                                            seasonDay = 16;
                                            break;
                                        case "SUMMER":
                                        case "EARLY_SUMMER":
                                            seasonDay = 24;
                                            break;
                                        case "MID_SUMMER":
                                            seasonDay = 32;
                                            break;
                                        case "LATE_SUMMER":
                                            seasonDay = 40;
                                            break;
                                        case "FALL":
                                        case "EARLY_FALL":
                                            seasonDay = 48;
                                            break;
                                        case "MID_FALL":
                                            seasonDay = 56;
                                            break;
                                        case "LATE_FALL":
                                            seasonDay = 64;
                                            break;
                                        case "WINTER":
                                        case "EARLY_WINTER":
                                            seasonDay = 72;
                                            break;
                                        case "MID_WINTER":
                                            seasonDay = 80;
                                            break;
                                        case "LATE_WINTER":
                                            seasonDay = 88;
                                            break;
                                        default:
                                            ctx.getSource().sendErrorMessage(
                                                    new StringTextComponent("Invalid season! Use: (early, mid, late) spring, summer, autumn, winter")
                                            );
                                            return 0;
                                    }

                                    long ticks = seasonDay * 24000L;
                                    world.setDayTime(ticks);

                                    ctx.getSource().sendFeedback(
                                            new StringTextComponent("Season set to " + season),
                                            true
                                    );

                                    return 1;
                                })
                        )
        );
    }
}