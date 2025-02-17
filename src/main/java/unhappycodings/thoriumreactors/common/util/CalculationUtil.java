package unhappycodings.thoriumreactors.common.util;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayList;
import java.util.List;

public class CalculationUtil {

    public static List<BlockPos> getBlockPositions(BlockPos loc1, BlockPos loc2, Level level) {
        List<BlockPos> blocks = new ArrayList<>();
        int x1 = loc1.getX();
        int y1 = loc1.getY();
        int z1 = loc1.getZ();
        int x2 = loc2.getX();
        int y2 = loc2.getY();
        int z2 = loc2.getZ();
        int xMin, yMin, zMin;
        int xMax, yMax, zMax;
        int x, y, z;
        if (x1 > x2) {
            xMin = x2;
            xMax = x1;
        } else {
            xMin = x1;
            xMax = x2;
        }
        if (y1 > y2) {
            yMin = y2;
            yMax = y1;
        } else {
            yMin = y1;
            yMax = y2;
        }
        if (z1 > z2) {
            zMin = z2;
            zMax = z1;
        } else {
            zMin = z1;
            zMax = z2;
        }

        for (y = yMax; y >= yMin; y--) {
            for (x = xMin; x <= xMax; x++) {
                for (z = zMin; z <= zMax; z++) {
                    blocks.add(new BlockPos(x, y, z));
                }
            }
        }
        return blocks;
    }

    public static List<BlockState> getBlockStates(BlockPos loc1, BlockPos loc2, Level level) {
        List<BlockPos> posList = getBlockPositions(loc1, loc2, level);
        List<BlockState> stateList = new ArrayList<>();
        for (BlockPos pos : posList)
            stateList.add(level.getBlockState(pos));
        return stateList;
    }

    public static List<Block> getBlocks(BlockPos loc1, BlockPos loc2, Level level) {
        List<BlockPos> posList = getBlockPositions(loc1, loc2, level);
        List<Block> blockList = new ArrayList<>();
        for (BlockPos pos : posList)
            blockList.add(level.getBlockState(pos).getBlock());
        return blockList;
    }

}
