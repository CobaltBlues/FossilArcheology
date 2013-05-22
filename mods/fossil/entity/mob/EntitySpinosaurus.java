package mods.fossil.entity.mob;

import cpw.mods.fml.common.FMLCommonHandler;
import java.util.ArrayList;
import java.util.Random;

import mods.fossil.Fossil;
import mods.fossil.fossilAI.DinoAIAttackOnCollide;
import mods.fossil.fossilAI.DinoAIAvoidEntityWhenYoung;
import mods.fossil.fossilAI.DinoAIControlledByPlayer;
import mods.fossil.fossilAI.DinoAIEat;
import mods.fossil.fossilAI.DinoAIFishing;
import mods.fossil.fossilAI.DinoAIFollowOwner;
import mods.fossil.fossilAI.DinoAIGrowup;
import mods.fossil.fossilAI.DinoAIStarvation;
import mods.fossil.fossilAI.DinoAITargetNonTamedExceptSelfClass;
import mods.fossil.fossilAI.DinoAIWander;
import mods.fossil.fossilEnums.EnumDinoFoodItem;
import mods.fossil.fossilEnums.EnumDinoFoodMob;
import mods.fossil.fossilEnums.EnumDinoType;
import mods.fossil.fossilEnums.EnumOrderType;
import mods.fossil.fossilEnums.EnumSituation;
import mods.fossil.guiBlocks.GuiPedia;
import net.minecraft.block.Block;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntitySpinosaurus extends EntityDinosaur
{
    public final int Areas = 15;
    //public final float HuntLimit = (float)this.getHungerLimit() * 0.8F;
    private boolean looksWithInterest;
    /*private float field_25048_b;
    private float field_25054_c;
    private boolean field_25052_g;*/
    public boolean Screaming = false;
    public boolean isAngry = false;
    public int SkillTick = 0;
    //public int WeakToDeath = 0;
    public int TooNearMessageTick = 0;
    public boolean SneakScream = false;
    //private final BlockBreakingRule blockBreakingBehavior;
    

    public EntitySpinosaurus(World var1)
    {
        super(var1);
        //this.blockBreakingBehavior = new BlockBreakingRule(this.worldObj, this, 5.0F);
        this.SelfType = EnumDinoType.Spinosaurus;
        this.looksWithInterest = false;
        //this.texture = "/fossil/textures/TRex.png";
        //this.setSize(2.5F, 2.5F);
        //this.moveSpeed = 0.3F;
        this.health = 10;
        this.experienceValue=20;
        
        this.Width0=0.5F;
        this.WidthInc=0.3F;
        this.Length0=0.5F;
        this.LengthInc=0.3F;
        this.Height0=0.5F;
        this.HeightInc=0.3F;
        this.BaseattackStrength=4;
        //this.AttackStrengthIncrease=;
        //this.BreedingTime=;
        this.BaseSpeed=0.22F;
        this.SpeedIncrease=0.021F;
        this.MaxAge=23;
        //this.BaseHealth=;
        this.HealthIncrease=5;
        //this.AdultAge=;
        //this.AgingTicks=;
        this.MaxHunger=550;
        //this.Hungrylevel=;
        this.updateSize();
        
        FoodItemList.addItem(EnumDinoFoodItem.PorkRaw);
        FoodItemList.addItem(EnumDinoFoodItem.BeefRaw);
        FoodItemList.addItem(EnumDinoFoodItem.ChickenRaw);
        FoodItemList.addItem(EnumDinoFoodItem.Triceratops);
        FoodItemList.addItem(EnumDinoFoodItem.Stegosaur);
        FoodItemList.addItem(EnumDinoFoodItem.Dilophosaurus);
        FoodItemList.addItem(EnumDinoFoodItem.Plesiosaur);
        FoodItemList.addItem(EnumDinoFoodItem.Pterosaur);
        FoodItemList.addItem(EnumDinoFoodItem.Brachiosaur);
        FoodItemList.addItem(EnumDinoFoodItem.Velociraptor);
        
        FoodMobList.addMob(EnumDinoFoodMob.Pig);
        FoodMobList.addMob(EnumDinoFoodMob.Cow);
        FoodMobList.addMob(EnumDinoFoodMob.Chicken);
        FoodMobList.addMob(EnumDinoFoodMob.Triceratops);
        FoodMobList.addMob(EnumDinoFoodMob.Stegosaurus);
        FoodMobList.addMob(EnumDinoFoodMob.Dilophosaurus);
        FoodMobList.addMob(EnumDinoFoodMob.Plesiosaur);
        FoodMobList.addMob(EnumDinoFoodMob.Pterosaur);
        FoodMobList.addMob(EnumDinoFoodMob.Brachiosaurus);
        FoodMobList.addMob(EnumDinoFoodMob.Velociraptor);
        
        this.tasks.addTask(0, new EntityAISwimming(this)); 
        this.tasks.addTask(3, new DinoAIAttackOnCollide(this, true));
        this.tasks.addTask(4, new DinoAIFollowOwner(this, 5.0F, 2.0F));
        this.tasks.addTask(6, new DinoAIWander(this));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new DinoAIFishing(this, /*this.HuntLimit,*/ 1));
        this.tasks.addTask(6, new DinoAIEat(this, 24));
        this.tasks.addTask(9, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new DinoAITargetNonTamedExceptSelfClass(this, EntityLiving.class, 16.0F, 50, false));

    }

    /**
     * Returns true if the newer Entity AI code should be run
     */
    public boolean isAIEnabled()
    {
        return this.riddenByEntity == null && !this.isWeak();
    }

    /**
     * returns if this entity triggers Block.onEntityWalking on the blocks they walk on. used for spiders and wolves to
     * prevent them from trampling crops
     */
    protected boolean canTriggerWalking()
    {
        return false;
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    /*public void writeEntityToNBT(NBTTagCompound var1)
    {
        super.writeEntityToNBT(var1);
        //var1.setBoolean("Angry", this.isSelfAngry());
        //var1.setBoolean("Sitting", this.isSelfSitting());
        //var1.setInteger("WeakToDeath", this.WeakToDeath);
    }*/

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    /*public void readEntityFromNBT(NBTTagCompound var1)
    {
        super.readEntityFromNBT(var1);
        //this.setSelfAngry(var1.getBoolean("Angry"));
        //this.setSelfSitting(var1.getBoolean("Sitting"));
        //this.InitSize();
        //this.WeakToDeath = var1.getInteger("WeakToDeath");
    }*/

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return this.worldObj.getClosestPlayerToEntity(this, 8.0D) != null ? "TRex_Living" : null;
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "TRex_hit";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "TRex_Death";
    }

    protected void updateEntityActionState() {}

    /**
     * Checks if the entity's current position is a valid location to spawn this entity.
     */
    public boolean getCanSpawnHere()
    {
        return this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).size() == 0 && !this.worldObj.isAnyLiquid(this.boundingBox);
    }

    /**
     * Checks if this entity is inside water (if inWater field is true as a result of handleWaterMovement() returning
     * true)
     */
    public boolean isInWater()
    {
        return this.onGround ? false : super.isInWater();
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        super.onUpdate();
//        this.blockBreakingBehavior.execute();
       if(this.isAdult() && Fossil.FossilOptions.Dino_Block_Breaking)
        	BlockInteractive();
         
        if (this.health > 0)
        {
            /*this.field_25054_c = this.field_25048_b;

            if (this.looksWithInterest)
            {
                this.field_25048_b += (1.0F - this.field_25048_b) * 0.4F;
            }
            else
            {
                this.field_25048_b += (0.0F - this.field_25048_b) * 0.4F;
            }*/

            if (this.looksWithInterest)
            {
                this.numTicksToChaseTarget = 10;
            }
        }
    }

    /**
     * Applies a velocity to each of the entities pushing them away from each other. Args: entity
     */
    public void applyEntityCollision(Entity var1)
    {
        if (var1 instanceof EntityLiving && !(var1 instanceof EntityPlayer) && this.getHunger() < this.MaxHunger / 2 && this.onGround && this.getDinoAge() > 3)
        {
            ((EntityLiving)var1).attackEntityFrom(DamageSource.causeMobDamage(this), 10);
        }
    }

    /*public boolean getSelfShaking()
    {
        return false;
    }

    public float getInterestedAngle(float var1)
    {
        return (this.field_25054_c + (this.field_25048_b - this.field_25054_c) * var1) * 0.15F * (float)Math.PI;
    }*/

    public float getEyeHeight()
    {
        return this.height * 0.8F;
    }

    /**
     * The speed it takes to move the entityliving's rotationPitch through the faceEntity method. This is only currently
     * use in wolves.
     */
    public int getVerticalFaceSpeed()
    {
        return this.isSitting() ? 20 : super.getVerticalFaceSpeed();
    }

    private void handleScream()
    {
        EntityLiving var1 = this.getAttackTarget();

        if (var1 == null)
        {
            this.Screaming = false;
        }
        else
        {
            double var2 = this.getDistanceSqToEntity(var1);

            if (var2 <= (double)(this.width * 4.0F * this.width * 4.0F))
            {
                this.Screaming = true;
            }
            else
            {
                this.Screaming = false;
            }
        }
    }

    /**
     * Disables a mob's ability to move on its own while true.
     */
    protected boolean isMovementCeased()
    {
        return this.isSitting();// || this.field_25052_g;
    }

    /**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(DamageSource var1, int var2)
    {
        if (var1.getEntity() == this)
        {
            return false;
        }
        else
        {
            Entity var3 = var1.getEntity();

            if (var1.damageType.equals("arrow") && this.getDinoAge() >= 3)
            {
                return false;
            }
            else if (var2 < 6 && var3 != null && this.getDinoAge() >= 3)
            {
                return false;
            }
            else if (var2 == 20 && var3 == null)
            {
                return super.attackEntityFrom(var1, 200);
            }
            else
            {
                this.setTarget((EntityLiving)var3);
                return super.attackEntityFrom(var1, var2);
            }
        }
    }

    /**
     * Deals damage to the entity. If its a EntityPlayer then will take damage from the armor first and then health
     * second with the reduced value. Args: damageAmount
     */
    protected void damageEntity(DamageSource var1, int var2)
    {
        var2 = this.applyArmorCalculations(var1, var2);
        var2 = this.applyPotionDamageCalculations(var1, var2);
        this.prevHealth=this.health;
        this.health -= var2;
    }

    public boolean isAngry()
    {
        return true;

    }
 
    /**
     * Finds the closest player within 16 blocks to attack, or null if this Entity isn't interested in attacking
     * (Animals, Spiders at day, peaceful PigZombies).
     */
    protected Entity findPlayerToAttack()
    {
        return this.isAngry() ? super.findPlayerToAttack() : null;
    }

    /**
     * Basic mob attack. Default to touch of death in EntityCreature. Overridden by each mob to define their attack.
     */
    protected void attackEntity(Entity var1, float var2)
    {
        this.faceEntity(var1, 30.0F, 30.0F);
        
        if (!this.hasPath())
        {
            this.setPathToEntity(this.worldObj.getPathEntityToEntity(this, this.getEntityToAttack(), var2, true, false, true, false));
        }

        if ((double)var2 > (double)this.width * 1.6D)
        {
            if (this.onGround)
            {
                double var3 = var1.posX - this.posX;
                double var5 = var1.posZ - this.posZ;
                float var7 = MathHelper.sqrt_double(var3 * var3 + var5 * var5);
                this.motionX = var3 / (double)var7 * 0.5D * 0.800000011920929D + this.motionX * 0.20000000298023224D;
                this.motionZ = var5 / (double)var7 * 0.5D * 0.800000011920929D + this.motionZ * 0.20000000298023224D;

                if (this.getDinoAge() <= 3)
                {
                    this.motionY = 0.4000000059604645D;
                }

                if (var2 < 5.0F && !this.Screaming)
                {
                    if (this.getDinoAge() >= 3)
                    {
                        this.worldObj.playSoundAtEntity(this, "TRex_scream", this.getSoundVolume() * 2.0F, 1.0F);
                    }

                    this.Screaming = true;
                }
            }
        }
        else
        {
            var1.attackEntityFrom(DamageSource.causeMobDamage(this), this.getAttackStrength());
        }
    }

    /**
     * This method gets called when the entity kills another one.
     */
    public void onKillEntity(EntityLiving var1)
    {
        super.onKillEntity(var1);

        if (this.getDinoAge() >= 3)
        {
            this.worldObj.playSoundAtEntity(this, "TRex_scream", this.getSoundVolume() * 2.0F, 1.0F);
        }
    }

    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
    public boolean interact(EntityPlayer var1)
    {
        ItemStack var2 = var1.inventory.getCurrentItem();

        if (var2 != null)
        {
        	if (var2.itemID == Fossil.gem.itemID)
            {
        		if (this.isWeak() && !this.isTamed())
                {
        			if(Fossil.FossilOptions.Heal_Dinos)
        				this.heal(200);
                    this.increaseHunger(500);
                    --var2.stackSize;
                    if (var2.stackSize <= 0)
        	        {
        	        	var1.inventory.setInventorySlotContents(var1.inventory.currentItem, (ItemStack)null);
        	        }
                    return true;
                }
             }
        	/*
        	if (var2.itemID == Fossil.whip.itemID && this.isTamed() && this.SelfType.isRideable() && this.isAdult() && !this.worldObj.isRemote && this.riddenByEntity == null)
            {
                if (var1.username.equalsIgnoreCase(this.getOwnerName()))
		        {
		            var1.rotationYaw = this.rotationYaw;
		            var1.mountEntity(this);
		            this.setPathToEntity((PathEntity)null);
		            this.renderYawOffset = this.rotationYaw;
		        }
                return true;
            }
            */
        	/*
        	if(var2.itemID == Fossil.chickenEss.itemID)
        		return true;
        		*/
         }
        else 
        {
        	if (this.isTamed() && this.SelfType.isRideable() && this.isAdult() && !this.worldObj.isRemote && (this.riddenByEntity == null || this.riddenByEntity == var1))
        	{
	        	if (var1.username.equalsIgnoreCase(this.getOwnerName()))
		        {
		            var1.rotationYaw = this.rotationYaw;
		            var1.mountEntity(this);
		            this.setPathToEntity((PathEntity)null);
		            this.renderYawOffset = this.rotationYaw;
		        }
	        	return true;
        	}
        }
        return super.interact(var1);
    }

    public boolean CheckSpace()
    {
        return !this.isEntityInsideOpaqueBlock();
    }

    public void updateRiderPosition()
    {
        if (this.riddenByEntity != null)
        	this.riddenByEntity.setPosition(this.posX, this.posY + (double)this.getDinoHeight() * 1.5D, this.posZ);
    }

    private void Flee(Entity var1, int var2)
    {
        int var3 = (new Random()).nextInt(var2) + 1;
        int var4 = (int)Math.round(Math.sqrt(Math.pow((double)var2, 2.0D) - Math.pow((double)var3, 2.0D)));
        boolean var5 = false;
        int var6 = 0;
        boolean var7 = false;
        boolean var8 = false;
        boolean var9 = true;
        boolean var10 = true;
        boolean var11 = true;
        float var12 = -99999.0F;
        int var14;

        if (var1.posX <= this.posX)
        {
            var14 = (int)Math.round(this.posX) + var3;
        }
        else
        {
            var14 = (int)Math.round(this.posX) - var3;
        }

        int var15;

        if (var1.posZ <= this.posZ)
        {
            var15 = (int)Math.round(this.posZ) + var4;
        }
        else
        {
            var15 = (int)Math.round(this.posZ) - var4;
        }

        for (int var13 = 128; var13 > 0; --var13)
        {
            if (!this.worldObj.isAirBlock(var14, var13, var15))
            {
                var6 = var13;
                break;
            }
        }

        this.setTamed(false);
        this.setOwner("");
        this.setPathToEntity(this.worldObj.getEntityPathToXYZ(this, var14, var6, var15, (float)var2, true, false, true, false));
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void onLivingUpdate()
    {
        if (!this.isWeak())
            this.handleScream();
        
        
        super.onLivingUpdate();
    }

    /**
     * Returns the texture's file path as a String.
     */
    public String getTexture()
    {
        if(this.isModelized())
        	return super.getTexture();
        return "/mods/fossil/textures/mob/Spinosaurus_Adult.png";
    }

    /**
     * Causes this entity to do an upwards motion (jumping).
     */
    protected void jump()
    {
        if (!this.isInWater())
        {
            if (this.riddenByEntity != null)
            {
                this.motionY += 0.6299999803304672D;
            }
            else
            {
                super.jump();
            }
        }
        else if (!this.onGround || !this.inWater)
        {
            this.motionY -= 0.1D;
        }
    }

    public boolean isWeak()
    {
 //       return this.getHealth() < 8 && this.getDinoAge()>8 && !this.isTamed();
    	return false;
    }

    /*private void HandleWeak()
    {
        if (!this.worldObj.isRemote)
        {
            if (this.texture != "/fossil/textures/TRexWeak.png")
            {
                this.texture = "/fossil/textures/TRexWeak.png";
            }

            ++this.WeakToDeath;

            if (this.WeakToDeath >= 200)
            {
                this.attackEntityFrom(DamageSource.generic, 10);
            }
            else
            {
                this.setTarget((Entity)null);
                this.setPathToEntity((PathEntity)null);
                this.setAngry(false);
            }
        }
    }*/
    public void ShowPedia(GuiPedia p0)
    {
    	super.ShowPedia(p0);
    	p0.PrintItemXY(Fossil.dnaSpinosaurus, 120, 7);

    		
    }

    public EntitySpinosaurus spawnBabyAnimal(EntityAgeable var1)
    {
        return new EntitySpinosaurus(this.worldObj);
    }

    /**
     * This method returns a value to be applied directly to entity speed, this factor is less than 1 when a slowdown
     * potion effect is applied, more than 1 when a haste potion effect is applied and 2 for fleeing entities.
     */
    public float getSpeedModifier()
    {
        float var1 = 1.0F;

        if (this.getDinoAge() < 3)
        {
            var1 = super.getSpeedModifier();

            if (this.fleeingTick > 0)
            {
                var1 *= 3.0F;
            }
        }
        else if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayerSP)
        {
            EntityPlayerSP var2 = (EntityPlayerSP)this.riddenByEntity;

            if (var2.movementInput.sneak)
            {
                var1 = 5.0F;
            }
        }

        return var1;
    }
    public int BlockInteractive()
    {
    	int destroyed=0;
        for (int var1 = (int)Math.round(this.boundingBox.minX) - 1; var1 <= (int)Math.round(this.boundingBox.maxX) + 1; ++var1)
        {
            for (int var2 = (int)Math.round(this.boundingBox.minY); var2 <= (int)Math.round(this.boundingBox.maxY); ++var2)
            {
                for (int var3 = (int)Math.round(this.boundingBox.minZ) - 1; var3 <= (int)Math.round(this.boundingBox.maxZ) + 1; ++var3)
                {
                    if (!this.worldObj.isAirBlock(var1, var2, var3))
                    {
                        int var4 = this.worldObj.getBlockId(var1, var2, var3);

                        if (!this.inWater)
                        {
                            if ((double)Block.blocksList[var4].getBlockHardness(this.worldObj, (int)this.posX, (int)this.posY, (int)this.posZ) < 5.0D)
                            {
                                if ((new Random()).nextInt(10) < 2)
                                {
                                    Block.blocksList[var4].dropBlockAsItem(this.worldObj, var1, var2, var3, 1, 0);
                                }

                                this.worldObj.setBlock(var1, var2, var3, 0);
                                destroyed++;
                                //this.RushTick = 10;
                            }
                        }
                    }
                }
            }
        }
        return destroyed;
    }

    /*public float getGLX()
    {
        return (float)(0.5D + 0.5125D * (double)this.getDinoAge());
    }

    public float getGLY()
    {
        return (float)(0.5D + 0.5125D * (double)this.getDinoAge());
    }*/

    /*public EntityAgeable func_90011_a(EntityAgeable var1)
    {
        return this.spawnBabyAnimal(var1);
    }*/

	@Override
	public EntityAgeable createChild(EntityAgeable var1) 
	{
		return null;
	}
}
