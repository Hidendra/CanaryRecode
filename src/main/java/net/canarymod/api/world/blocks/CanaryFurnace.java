package net.canarymod.api.world.blocks;


import net.canarymod.api.inventory.CanaryItem;
import net.canarymod.api.inventory.Inventory;
import net.canarymod.api.inventory.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.TileEntityFurnace;


public class CanaryFurnace extends CanaryComplexBlock implements Furnace {

    /**
     * Constructs a new wrapper for TileEntityFurnace
     * 
     * @param tileentity
     *            the TileEntityFurnace to be wrapped
     */
    public CanaryFurnace(TileEntityFurnace tileentity) {
        super(tileentity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Inventory getInventory() {
        return getHandle().getInventory();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clearContents() {
        getHandle().clearContents();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CanaryItem decreaseItemStackSize(int itemId, int amount) {
        ItemStack item = getHandle().decreaseItemStackSize(itemId, amount);

        return item != null ? item.getCanaryItem() : null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CanaryItem[] getContents() {
        ItemStack[] oStacks = getHandle().getContents();
        CanaryItem[] items = new CanaryItem[oStacks.length];

        for (int i = 0; i < oStacks.length; i++) {
            items[i] = new CanaryItem(oStacks[i]);
        }

        return items;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getInventoryName() {
        return getHandle().getInventoryName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getInventorySize() {
        return getHandle().getInventorySize();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getInventoryStackLimit() {
        return getHandle().getInventoryStackLimit();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Item getItem(int id) {
        return getHandle().getItem(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Item getItem(int id, int amount) {
        return getHandle().getItem(id, amount);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CanaryItem getSlot(int index) {
        ItemStack item = getHandle().getSlot(index);

        return item != null ? item.getCanaryItem() : null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasItem(int itemId) {
        return getHandle().hasItem(itemId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasItemStack(Item item) {
        return getHandle().hasItemStack(((CanaryItem) item).getHandle());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Item removeItem(Item item) {
        return getHandle().removeItem(item);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Item removeItem(int id) {
        return getHandle().removeItem(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setContents(Item[] items) {
        ItemStack[] oStacks = new ItemStack[items.length];

        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                oStacks[i] = ((CanaryItem) items[i]).getHandle();
            } else {
                oStacks[i] = null;
            }
        }
        getHandle().setContents(oStacks);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setInventoryName(String value) {
        getHandle().setInventoryName(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setSlot(int index, Item value) {
        getHandle().setSlot(index, ((CanaryItem) value).getHandle());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addItem(int itemId, int amount) {
        getHandle().addItem(itemId, amount);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addItem(Item item) {
        getHandle().addItem(item);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getEmptySlot() {
        return getHandle().getEmptySlot();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasItemStack(int itemId, int amount) {
        return getHandle().hasItemStack(itemId, amount);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasItemStack(int itemId, int minAmount, int maxAmount) {
        return getHandle().hasItemStack(itemId, minAmount, maxAmount);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TileEntityFurnace getHandle() {
        return (TileEntityFurnace) tileentity;
    }

}
