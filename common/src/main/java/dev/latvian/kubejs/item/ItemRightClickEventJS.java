package dev.latvian.kubejs.item;

import dev.latvian.kubejs.entity.EntityJS;
import dev.latvian.kubejs.player.PlayerEventJS;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;

/**
 * @author LatvianModder
 */
public class ItemRightClickEventJS extends PlayerEventJS
{
	public final Player player;
	public final InteractionHand hand;

	public ItemRightClickEventJS(Player player, InteractionHand hand)
	{
		this.player = player;
		this.hand = hand;
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

	public InteractionHand getHand()
	{
		return hand;
	}

	public ItemStackJS getItem()
	{
		return ItemStackJS.of(player.getItemInHand(hand));
	}
}