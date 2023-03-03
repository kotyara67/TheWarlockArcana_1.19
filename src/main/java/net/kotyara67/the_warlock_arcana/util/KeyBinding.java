package net.kotyara67.the_warlock_arcana.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class KeyBinding {
    public static final String KEY_CATEGORY = "key.category.the_warlock_arcana";
    public static final String KEY_ELEMENT_SLOT1 = "key.the_warlock_arcana.element_slot1";

    public static final KeyMapping ELEMENT_SLOT1 = new KeyMapping(KEY_ELEMENT_SLOT1, KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_Z,KEY_CATEGORY);

}
