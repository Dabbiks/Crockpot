package dabbiks.crockpot.utils;

import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.WorldEditException;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.extent.clipboard.Clipboard;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormat;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormats;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardReader;
import com.sk89q.worldedit.function.operation.Operation;
import com.sk89q.worldedit.function.operation.Operations;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.math.transform.AffineTransform;
import com.sk89q.worldedit.session.ClipboardHolder;
import com.sk89q.worldedit.world.block.BlockState;
import com.sk89q.worldedit.world.block.BlockType;
import org.bukkit.Location;
import org.bukkit.Material;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public final class WorldeditUtils {

    private WorldeditUtils() {}

    public static void paste(File file, Location location) {
        paste(file, location, 0, null, null);
    }

    public static void paste(File file, Location location, double rotationY) {
        paste(file, location, rotationY, null, null);
    }

    public static void paste(File file, Location location, Material replaceFrom, Material replaceTo) {
        paste(file, location, 0, replaceFrom, replaceTo);
    }

    public static void paste(File file, Location location, double rotationY, Material replaceFrom, Material replaceTo) {
        if (location.getWorld() == null || file == null || !file.exists()) return;

        ClipboardFormat format = ClipboardFormats.findByFile(file);
        if (format == null) return;

        try (ClipboardReader reader = format.getReader(new FileInputStream(file))) {
            Clipboard clipboard = reader.read();

            if (replaceFrom != null && replaceTo != null) {
                BlockType fromType = BukkitAdapter.adapt(replaceFrom.createBlockData()).getBlockType();
                BlockState toState = BukkitAdapter.adapt(replaceTo.createBlockData());

                for (BlockVector3 pt : clipboard.getRegion()) {
                    if (clipboard.getBlock(pt).getBlockType() == fromType) {
                        clipboard.setBlock(pt, toState);
                    }
                }
            }

            try (EditSession editSession = WorldEdit.getInstance().newEditSession(BukkitAdapter.adapt(location.getWorld()))) {
                ClipboardHolder holder = new ClipboardHolder(clipboard);

                if (rotationY != 0) {
                    holder.setTransform(new AffineTransform().rotateY(rotationY));
                }

                Operation operation = holder
                        .createPaste(editSession)
                        .to(BlockVector3.at(location.getX(), location.getY(), location.getZ()))
                        .ignoreAirBlocks(true)
                        .build();

                Operations.complete(operation);
            }
        } catch (IOException | WorldEditException e) {
            e.printStackTrace();
        }
    }
}