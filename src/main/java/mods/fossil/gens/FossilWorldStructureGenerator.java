package mods.fossil.gens;

import cpw.mods.fml.common.IWorldGenerator;
import mods.fossil.Fossil;
import net.minecraft.world.World;
import net.minecraft.world.biome.*;
import net.minecraft.world.chunk.IChunkProvider;

import java.util.Random;

public class FossilWorldStructureGenerator implements IWorldGenerator
{
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world,
                         IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {
        switch (world.provider.dimensionId)
        {
            case -1:
                // not currently generating anything in the nether
                // generateNether(world, random, chunkX * 16, chunkZ * 16);
                break;

            case 0:
                // 25% chance of a single structure per chunk; could make a weighted list
                // Recall that a chunk is only 16x16 blocks in area, so this is quite a lot of structures
                generateStructure(world, random, chunkX * 16, chunkZ * 16);
                break;

            default:
                break;
        }
    }

    private final void generateStructure(World world, Random rand, int chunkX, int chunkZ)
    {
        BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(chunkX, chunkZ);
        // Need to create a new instance each time or the generate() methods may overlap themselves and cause a crash
        FossilStructureGenerator gen = new FossilStructureGenerator();

        if ((biome instanceof BiomeGenDesert) || (biome instanceof BiomeGenJungle) || (biome instanceof BiomeGenTaiga) || (biome instanceof BiomeGenPlains)) // then add ||BiomeGenXYZ if you want more.
        {
            if (rand.nextInt(20) == 0) //adjust the number in nextInt(). Higher values == rarer. Default = 20
            {
                Fossil.Console("Generating Academy...");
                int struct; // This will store a random index of the structure to generate
                struct = rand.nextInt(gen.structures.size());
                Fossil.Console("[GEN] Generating " + gen.structures.get(struct).name);
                int x = chunkX + rand.nextInt(16);
                int z = chunkZ + rand.nextInt(16);
                // nice way of getting a height to work from; it returns the topmost
                // non-air block at an x/z position, such as tall grass, dirt or leaves
                int y = world.getHeightValue(x, z);

                // find ground level, ignoring blocks such as grass and water
                while (!world.doesBlockHaveSolidTopSurface(x, y, z) && y > world.provider.getAverageGroundLevel())
                {
                    --y;
                }

                if (!world.doesBlockHaveSolidTopSurface(x, y, z))
                {
                    Fossil.Console("Failed to find suitable surface. Not generating structure. Block id " + world.getBlockId(x, y, z));
                    return;
                }

                int widthX = gen.structures.get(struct).getWidthX();
                int widthZ = gen.structures.get(struct).getWidthZ();
                int height = gen.structures.get(struct).getHeight();
                // Set structure and random facing, then generate; no offset needed here
                gen.setStructure(gen.structures.get(struct));
                gen.setStructureFacing(rand.nextInt(4));
                gen.generate(world, rand, x, y, z);
            }
        }
    }
}
