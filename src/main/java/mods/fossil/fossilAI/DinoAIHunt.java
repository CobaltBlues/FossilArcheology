package mods.fossil.fossilAI;

import mods.fossil.Fossil;
import mods.fossil.entity.mob.EntityDinosaur;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAITarget;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;


public class DinoAIHunt extends EntityAITarget
{
    private EntityDinosaur dinosaur;
    private DinoAINearestAttackableTargetSorter targetSorter;
    private final Class targetClass;
    
    /**
     * This filter is applied to the Entity search.  Only matching entities will be targetted.  (null -> no
     * restrictions)
     */

    private EntityLivingBase targetEntity;

    public DinoAIHunt(EntityDinosaur dinosaur, Class _class, int par3, boolean par4)
    {
        super(dinosaur, par4);
        this.dinosaur = dinosaur;
        this.targetClass = _class;
        this.targetSorter = new DinoAINearestAttackableTargetSorter(this, this.dinosaur);
    }

    @Override
    public boolean shouldExecute()
    {
        if (this.dinosaur.IsHungry() &&  !this.dinosaur.SelfType.FoodMobList.IsEmpty())
        {
        double d0 = this.getTargetDistance();
        List list = this.dinosaur.worldObj.getEntitiesWithinAABB(EntityLiving.class, this.dinosaur.boundingBox.expand(d0, 4.0D, d0));
        Collections.sort(list, this.targetSorter);
        Iterator iterator = list.iterator();

        while (iterator.hasNext())
        {
            EntityLiving entity = (EntityLiving)iterator.next();

            if (this.dinosaur.SelfType.FoodMobList.CheckMobByClass(entity.getClass()))
            {//It's food
                if(!(entity instanceof EntityDinosaur) || (entity instanceof EntityDinosaur && ((EntityDinosaur) entity).isModelized()==false))
                {//No modelized Dinos for Lunch!
                    this.targetEntity = entity;
                	this.dinosaur.setAttackTarget(entity);
                	Fossil.Log.log(Level.INFO, "typeofTarget: " + this.targetEntity);
                	return true;
                }
            }
            

         //   this.targetEntity = (EntityLivingBase)list.get(0);
        //    return true;
        }
        }
        this.targetEntity = null;
        return false;
    }
    /*
    @Override
    public boolean continueExecuting()
    {

        return (this.dinosaur.IsHungry() || this.dinosaur.IsDeadlyHungry()) && (this.targetEntity != null);
    }
    
    @Override
    public void updateTask()
    {
    	this.dinosaur.setAttackTarget(this.targetEntity);
    }
    */
}
