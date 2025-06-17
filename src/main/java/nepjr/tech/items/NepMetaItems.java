package nepjr.tech.items;

import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.items.metaitem.StandardMetaItem;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.stack.ItemMaterialInfo;
import gregtech.api.unification.stack.MaterialStack;

import static gregtech.api.GTValues.M;

public class NepMetaItems 
{
	private static StandardMetaItem nepItems;
	
	// Voltage Coils
	public static MetaItem<?>.MetaValueItem VOLTAGE_COIL_UHV;
	public static MetaItem<?>.MetaValueItem VOLTAGE_COIL_UEV;
	public static MetaItem<?>.MetaValueItem VOLTAGE_COIL_UIV;
	public static MetaItem<?>.MetaValueItem VOLTAGE_COIL_UXV;
	public static MetaItem<?>.MetaValueItem VOLTAGE_COIL_OpV;
	public static MetaItem<?>.MetaValueItem VOLTAGE_COIL_MAX;
	
	public static void init()
	{
		nepItems = new StandardMetaItem();
		nepItems.setRegistryName("nep_items");
	}
	
	public static void initSub()
	{
		initItems();
	}
	
	private static void initItems()
	{
		// Voltage Coils: ID 0 - 5
        VOLTAGE_COIL_UHV = nepItems.addItem(0, "voltage_coil.uhv").setMaterialInfo(new ItemMaterialInfo(new MaterialStack(Materials.Neutronium, M * 2), new MaterialStack(Materials.Naquadria, M / 2)));
        VOLTAGE_COIL_UEV = nepItems.addItem(1, "voltage_coil.uev").setMaterialInfo(new ItemMaterialInfo(new MaterialStack(Materials.Neutronium, M * 2), new MaterialStack(Materials.Naquadria, M / 2)));
        VOLTAGE_COIL_UIV = nepItems.addItem(2, "voltage_coil.uiv").setMaterialInfo(new ItemMaterialInfo(new MaterialStack(Materials.Neutronium, M * 2), new MaterialStack(Materials.Naquadria, M / 2)));
        VOLTAGE_COIL_UXV = nepItems.addItem(3, "voltage_coil.uxv").setMaterialInfo(new ItemMaterialInfo(new MaterialStack(Materials.Neutronium, M * 2), new MaterialStack(Materials.Naquadria, M / 2)));
        VOLTAGE_COIL_OpV = nepItems.addItem(4, "voltage_coil.opv").setMaterialInfo(new ItemMaterialInfo(new MaterialStack(Materials.Neutronium, M * 2), new MaterialStack(Materials.Naquadria, M / 2)));
        VOLTAGE_COIL_MAX = nepItems.addItem(5, "voltage_coil.max").setMaterialInfo(new ItemMaterialInfo(new MaterialStack(Materials.Neutronium, M * 2), new MaterialStack(Materials.Naquadria, M / 2)));

	}
}
