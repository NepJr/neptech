package nepjr.tech;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import exnihilocreatio.ExNihiloCreatio;
import gregtech.GTInternalTags;
import nepjr.tech.exnihilo.GTModule;
import nepjr.tech.items.NepMetaItems;
import nepjr.tech.proxy.CommonProxy;
import nepjr.tech.registries.NepMetaTileEntities;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = NepTags.MODID,
	 version = NepTags.VERSION, 
	 name = NepTags.MODNAME, 
	 acceptedMinecraftVersions = "[1.12.2]", 
	 dependencies = GTInternalTags.DEP_VERSION_STRING)
public class NepTech {

    public static final Logger LOGGER = LogManager.getLogger(NepTags.MODID);
    
    @SidedProxy(modId = NepTags.MODID, clientSide = "nepjr.tech.proxy.ClientProxy", serverSide = "nepjr.tech.proxy.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) 
    {
    	// Ex Nihilo support
    	ExNihiloCreatio.loadedModules.add(new GTModule());

    	// Items n stuff
    	NepMetaItems.init();
    	
    	// Machines
    	NepMetaTileEntities.register();
    	
    	// Proxy
    	proxy.preLoad();
    }
    
    @NotNull
    public static ResourceLocation nepId(@NotNull String path) 
    {
        return new ResourceLocation(NepTags.MODID, path);
    }
}
