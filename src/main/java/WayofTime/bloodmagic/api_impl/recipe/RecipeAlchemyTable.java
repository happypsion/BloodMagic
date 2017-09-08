package WayofTime.bloodmagic.api_impl.recipe;

import com.google.common.base.Preconditions;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;

public class RecipeAlchemyTable {

    @Nonnull
    private final NonNullList<Ingredient> input;
    @Nonnull
    private final ItemStack output;
    @Nonnegative
    private final int syphon;
    @Nonnegative
    private final int ticks;
    @Nonnegative
    private final int minimumTier;

    public RecipeAlchemyTable(@Nonnull NonNullList<Ingredient> input, @Nonnull ItemStack output, int syphon, int ticks, int minimumTier) {
        Preconditions.checkNotNull(input, "input cannot be null.");
        Preconditions.checkNotNull(output, "output cannot be null.");
        Preconditions.checkArgument(syphon >= 0, "syphon cannot be negative.");
        Preconditions.checkArgument(ticks >= 0, "ticks cannot be negative.");
        Preconditions.checkArgument(minimumTier >= 0, "minimumTier cannot be negative.");

        this.input = input;
        this.output = output;
        this.syphon = syphon;
        this.ticks = ticks;
        this.minimumTier = minimumTier;
    }

    @Nonnull
    public final NonNullList<Ingredient> getInput() {
        return input;
    }

    @Nonnull
    public final ItemStack getOutput() {
        return output;
    }

    public final int getSyphon() {
        return syphon;
    }

    public final int getTicks() {
        return ticks;
    }

    public final int getMinimumTier() {
        return minimumTier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RecipeAlchemyTable)) return false;

        RecipeAlchemyTable that = (RecipeAlchemyTable) o;

        if (syphon != that.syphon) return false;
        if (ticks != that.ticks) return false;
        if (minimumTier != that.minimumTier) return false;
        if (!IngredientTester.compareIngredients(input, that.input)) return false;
        return ItemStack.areItemStacksEqualUsingNBTShareTag(output, that.output);
    }

    @Override
    public int hashCode() {
        int result = input.hashCode();
        result = 31 * result + output.hashCode();
        result = 31 * result + syphon;
        result = 31 * result + ticks;
        result = 31 * result + minimumTier;
        return result;
    }
}
