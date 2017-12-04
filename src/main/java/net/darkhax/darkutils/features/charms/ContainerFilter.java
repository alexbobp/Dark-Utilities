package net.darkhax.darkutils.features.charms;

import net.darkhax.bookshelf.inventory.SlotFake;
import net.darkhax.bookshelf.item.ItemInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerFilter extends Container {

    public ContainerFilter (InventoryPlayer playerInv, ItemInventory inventory) {

        for (int invIndex = 0; invIndex < 5; invIndex++) {
            this.addSlotToContainer(new SlotFake(inventory, invIndex, 44 + invIndex * 18, 20));
        }

        for (int playerInvX = 0; playerInvX < 3; ++playerInvX) {
            for (int playerInvY = 0; playerInvY < 9; ++playerInvY) {
                this.addSlotToContainer(new Slot(playerInv, playerInvY + playerInvX * 9 + 9, 8 + playerInvY * 18, playerInvX * 18 + 51));
            }
        }

        for (int hotbarIndex = 0; hotbarIndex < 9; ++hotbarIndex) {
            this.addSlotToContainer(new Slot(playerInv, hotbarIndex, 8 + hotbarIndex * 18, 109));
        }
    }

    @Override
    public boolean canDragIntoSlot (Slot slot) {

        return !(slot instanceof SlotFake);
    }

    @Override
    public boolean canInteractWith (EntityPlayer player) {

        return true;
    }

    @Override
    public ItemStack transferStackInSlot (EntityPlayer player, int index) {

        final Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack() && !slot.getStack().isEmpty()) {

            for (int fakeSlotID = 0; fakeSlotID < 5; fakeSlotID++) {

                final Slot fakeSlot = this.getSlot(fakeSlotID);

                // Slot doesn't have an item. Add the copy.
                if (!fakeSlot.getHasStack()) {

                    fakeSlot.putStack(slot.getStack());
                    return ItemStack.EMPTY;
                }
            }
        }

        return ItemStack.EMPTY;
    }
}