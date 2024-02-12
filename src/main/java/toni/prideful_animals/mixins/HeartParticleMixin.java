package toni.prideful_animals.mixins;

import toni.prideful_animals.PridefulAnimalsSpriteSet;
import net.minecraft.client.particle.HeartParticle;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.client.particle.SpriteSet;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HeartParticle.Provider.class)
public class HeartParticleMixin
{
    @Final
    @Shadow
    @Mutable
    private SpriteSet sprite;

    @Inject(at = @At("RETURN"), method = "<init>(Lnet/minecraft/client/particle/SpriteSet;)V")
    public void setSpriteSet(SpriteSet spriteSet, CallbackInfo ci)
    {
        this.sprite = new PridefulAnimalsSpriteSet((ParticleEngine.MutableSpriteSet) this.sprite);
    }
}