package dev.latvian.mods.kubejs.item.custom;

import dev.latvian.mods.kubejs.item.ItemBuilder;
import dev.latvian.mods.kubejs.item.MutableArmorTier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;

import java.util.function.Consumer;

public class ArmorItemBuilder extends ItemBuilder {
	public static class Helmet extends ArmorItemBuilder {
		public Helmet(ResourceLocation i) {
			super(i, EquipmentSlot.HEAD);
		}
	}

	public static class Chestplate extends ArmorItemBuilder {
		public Chestplate(ResourceLocation i) {
			super(i, EquipmentSlot.CHEST);
		}

	}

	public static class Leggings extends ArmorItemBuilder {

		public Leggings(ResourceLocation i) {
			super(i, EquipmentSlot.LEGS);
		}
	}

	public static class Boots extends ArmorItemBuilder {
		public Boots(ResourceLocation i) {
			super(i, EquipmentSlot.FEET);
		}

	}

	public final EquipmentSlot equipmentSlot;
	public MutableArmorTier armorTier;

	protected ArmorItemBuilder(ResourceLocation i, EquipmentSlot e) {
		super(i);
		equipmentSlot = e;
		armorTier = new MutableArmorTier(id.toString(), ArmorMaterials.IRON);
		unstackable();
	}

	@Override
	public Item createObject() {
		return new ArmorItem(armorTier, equipmentSlot, createItemProperties());
	}

	public ArmorItemBuilder tier(String t) {
		armorTier = new MutableArmorTier(id.toString(), ARMOR_TIERS.getOrDefault(t, ArmorMaterials.IRON));
		return this;
	}

	public ArmorItemBuilder modifyTier(Consumer<MutableArmorTier> callback) {
		callback.accept(armorTier);
		return this;
	}
}
