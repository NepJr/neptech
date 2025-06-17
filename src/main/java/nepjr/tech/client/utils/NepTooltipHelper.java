package nepjr.tech.client.utils;

import static gregtech.client.utils.TooltipHelper.createNewCode;
import static net.minecraft.util.text.TextFormatting.GREEN;
import static net.minecraft.util.text.TextFormatting.WHITE;

import gregtech.client.utils.TooltipHelper.GTFormatCode;

public class NepTooltipHelper 
{
	/** Switches between AQUA and WHITE, changing every 5 ticks */
    public static final GTFormatCode BLINKING_GREEN = createNewCode(5, GREEN, WHITE);
}
