package dev.latvian.kubejs.item.forge;

import net.minecraft.item.ItemStack;

public class ContainerInventoryImpl
{
	public static boolean areCapsCompatible(ItemStack a, ItemStack b)
	{
		return a.areCapsCompatible(b);
	}
}
