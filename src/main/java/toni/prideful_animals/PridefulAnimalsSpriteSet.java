package toni.prideful_animals;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import org.jetbrains.annotations.NotNull;

//#if MC <= 11802
//$$ import java.util.Random;
//#else
import net.minecraft.util.RandomSource;
//#endif

public class PridefulAnimalsSpriteSet implements SpriteSet
{
    public static ParticleEngine.MutableSpriteSet HeartSprite;

    public PridefulAnimalsSpriteSet(ParticleEngine.MutableSpriteSet spriteSet) {
        super();
        HeartSprite = spriteSet;
    }

    @Override
    public @NotNull TextureAtlasSprite get(int i, int j) {
        if (HeartSprite == null) {
            System.out.println("[Prideful Animals] Heart sprite is null!");
            return null;
        }

        return HeartSprite.sprites.get(i * (HeartSprite.sprites.size() - 1) / j);
    }


    @Override
    //#if MC <= 11802
    //$$ public @NotNull TextureAtlasSprite get(Random randomSource) {
    //#else
    public @NotNull TextureAtlasSprite get(RandomSource randomSource) {
    //#endif
        if (HeartSprite == null) {
            System.out.println("[Prideful Animals] Heart sprite is null!");
            return null;
        }

        var mc = Minecraft.getInstance();
        if (mc.level == null)
            return HeartSprite.sprites.get(randomSource.nextInt(HeartSprite.sprites.size()));

        return HeartSprite.sprites.get((int) (mc.level.getGameTime() % HeartSprite.sprites.size()));
    }
}
