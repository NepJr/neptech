package nepjr.tech.proxy;

import javax.annotation.Nonnull;

import gregtech.api.event.HighTierEvent;
import gregtech.api.unification.material.event.MaterialEvent;
import nepjr.tech.NepTags;
import nepjr.tech.items.NepMetaItems;
import nepjr.tech.materials.NepMaterials;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid = NepTags.MODID)
public class CommonProxy 
{
	public void preLoad()
	{
		
	}
	
	@SubscribeEvent
	public static void registerItems(@Nonnull RegistryEvent.Register<Item> event)
	{
		NepMetaItems.initSub();
	}
	
	@SubscribeEvent(priority = EventPriority.HIGH)
	public static void registerMaterials(MaterialEvent event)
	{
		NepMaterials.init();
	}
	
	@SubscribeEvent
	public static void HighTier(HighTierEvent event)
	{
		event.enableHighTier();
	}
	
	public boolean serverSide()
	{
		return true;
	}
}
