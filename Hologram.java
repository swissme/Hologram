import com.orbixmc.library.core.chat.*;
import lombok.*;
import org.bukkit.*;
import org.bukkit.entity.*;

import java.util.*;

/**
 * @author Swiss (swiss@swissdev.com)
 */

@Data
public class Hologram {

    @Getter
    private static HashMap<UUID, Hologram> holograms = new HashMap<>();

    @Getter
    private static double lineSeparation = 0.3;

    private UUID id;
    private List<String> hologramLines;
    private Location location;
    private List<ArmorStand> armorStands;

    public Hologram(UUID id, Location location) {
        this.id = id;
        this.location = location;
        this.armorStands = new ArrayList<>();
        this.hologramLines = new ArrayList<>();
    }

    public void addLine(String line) {
        ArmorStand armorStand = (ArmorStand) this.location.getWorld().spawnEntity(location.add(0, (this.hologramLines.size() + 1) * lineSeparation, 0), EntityType.ARMOR_STAND);
        armorStand.setVisible(false);
        armorStand.setSmall(true);
        armorStand.setMarker(true);
        armorStand.setCustomNameVisible(true);
        armorStand.setCustomName(CC.translate(line));
        this.armorStands.add(armorStand);
    }

    public void delete() {
        for (ArmorStand armorStand : this.armorStands) {
            armorStand.remove();
        }
    }

}
