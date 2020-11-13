package dev.latvian.kubejs.item.forge;

import dev.latvian.kubejs.item.ItemStackJS;
import dev.latvian.kubejs.player.PlayerJS;
import dev.latvian.kubejs.world.BlockContainerJS;
import me.shedaniel.architectury.registry.ToolType;

import javax.annotation.Nullable;

public class ItemStackJSImpl
{
	public static int _getHarvestLevel(ItemStackJS stack, ToolType tool, @Nullable PlayerJS<?> player, @Nullable BlockContainerJS block)
	{
		return stack.getItem().getHarvestLevel(stack.getItemStack(), net.minecraftforge.common.ToolType.get(tool.forgeName), player == null ? null : player.minecraftPlayer, block == null ? null : block.getBlockState());
	}
}
