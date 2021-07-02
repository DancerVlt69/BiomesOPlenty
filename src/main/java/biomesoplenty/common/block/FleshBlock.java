/*******************************************************************************
 * Copyright 2014-2019, the Biomes O' Plenty Team
 *
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 *
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/
package biomesoplenty.common.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

public class FleshBlock extends Block
{
    public FleshBlock(Block.Properties properties)
    {
        super(properties);
    }

    @Override
    public void stepOn(Level worldIn, BlockPos pos, Entity entityIn)
    {
        entityIn.setDeltaMovement(entityIn.getDeltaMovement().multiply(0.95D, 1.0D, 0.95D));
    }
}
