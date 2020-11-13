package dev.latvian.kubejs.block;

import dev.latvian.kubejs.entity.EntityJS;
import dev.latvian.kubejs.item.ItemStackJS;
import dev.latvian.kubejs.player.PlayerEventJS;
import dev.latvian.kubejs.world.BlockContainerJS;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.Nullable;

/**
 * @author LatvianModder
 */
public class BlockLeftClickEventJS extends PlayerEventJS
{
	public final Player player;
	public final InteractionHand hand;
	public final BlockPos pos;
	public final Direction direction;

	public BlockLeftClickEventJS(Player player, InteractionHand hand, BlockPos pos, Direction direction)
	{
		this.player = player;
		this.hand = hand;
		this.pos = pos;
		this.direction = direction;
	}

	@Override
	public boolean canCancel()
	{
		return true;
	}

	@Override
	public EntityJS getEntity()
	{
		return entityOf(player);
	}

	public BlockContainerJS getBlock()
	{
		return new BlockContainerJS(player.level, pos);
	}

	public ItemStackJS getItem()
	{
		return ItemStackJS.of(player.getItemInHand(hand));
	}

	@Nullable
	public Direction getFacing()
	{
		return direction;
	}
}