package mods.fossil.items.forge;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSword;

public class ForgeSword extends ItemSword
{
    String TextureFileName;
    public ForgeSword(int par1, EnumToolMaterial par2EnumToolMaterial, String TextureFileName0)
    {
        super(par1, par2EnumToolMaterial);
        this.TextureFileName = TextureFileName0;
    }

    @Override
    public void registerIcons(IconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon("fossil:" + TextureFileName);
    }
}
