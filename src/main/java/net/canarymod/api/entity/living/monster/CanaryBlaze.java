package net.canarymod.api.entity.living.monster;

import net.canarymod.api.entity.EntityType;
import net.minecraft.server.EntityBlaze;

/**
 * Blaze wrapper implementation
 * 
 * @author Jason (darkdiplomat)
 */
public class CanaryBlaze extends CanaryEntityMob implements Blaze {

    /**
     * Constructs a new wrapper for EntityBlaze
     * 
     * @param entity
     *            the EntityBlaze to wrap
     */
    public CanaryBlaze(EntityBlaze entity) {
        super(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityType getEntityType() {
        return EntityType.BLAZE;
    }

    @Override
    public String getFqName() {
        return "Blaze";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isBurning() {
        return getHandle().bT();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setBurning(boolean isBurning) {
        getHandle().a(isBurning);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityBlaze getHandle() {
        return (EntityBlaze) entity;
    }
}
