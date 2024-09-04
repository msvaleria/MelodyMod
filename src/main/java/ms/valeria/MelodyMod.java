package ms.valeria;

import org.lwjgl.input.Keyboard;

import ms.valeria.listeners.PlayerListener;
import ms.valeria.utils.Utils;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = MelodyMod.MODID, version = MelodyMod.VERSION, name = MelodyMod.MOD_NAME, clientSideOnly = true, acceptedMinecraftVersions = "[1.8.9]")
public class MelodyMod     // Constants for Mod metadata
    public static final String MODID = "melodymod";
    public static final String VERSION = "3.5";
    public static final String MOD_NAME = "Melody Mod";

    // Array to store key bindings for the mod
    private KeyBinding[] keyBindings = new KeyBinding[7];

    // Listener for player events
    private PlayerListener playerListener = new PlayerListener(this);

    // Utility class instance
    private Utils utils = new Utils(this);

    // Method called during the initialization phase
    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {

        // Register the playerListener to the event bus
        MinecraftForge.EVENT_BUS.register(playerListener);

        // Define key bindings for different notes
        keyBindings[0] = new KeyBinding("Note 1", Keyboard.KEY_Z, MOD_NAME);
        keyBindings[1] = new KeyBinding("Note 2", Keyboard.KEY_X, MOD_NAME);
        keyBindings[2] = new KeyBinding("Note 3", Keyboard.KEY_C, MOD_NAME);
        keyBindings[3] = new KeyBinding("Note 4", Keyboard.KEY_V, MOD_NAME);
        keyBindings[4] = new KeyBinding("Note 5", Keyboard.KEY_B, MOD_NAME);
        keyBindings[5] = new KeyBinding("Note 6", Keyboard.KEY_N, MOD_NAME);
        keyBindings[6] = new KeyBinding("Note 7", Keyboard.KEY_M, MOD_NAME);

        // Register each key binding with the client registry
        for (int i = 0; i < keyBindings.length; i++) {
            ClientRegistry.registerKeyBinding(keyBindings[i]);
        }
    }

    // Getter for the array of key bindings
    public KeyBinding[] getKeyBindings() {
        return keyBindings;
    }

    // Getter for the utils instance
    public Utils getUtils() {
        return utils;
    }
}
