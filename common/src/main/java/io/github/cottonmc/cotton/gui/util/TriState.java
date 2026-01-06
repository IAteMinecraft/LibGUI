package io.github.cottonmc.cotton.gui.util;

import com.mojang.serialization.Codec;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

import net.minecraft.util.StringIdentifiable;

import org.jetbrains.annotations.Nullable;

public enum TriState implements StringIdentifiable {
    FALSE("false"),
    DEFAULT("default"),
    TRUE("true");

    public static final com.mojang.serialization.Codec<TriState> CODEC = StringIdentifiable.createCodec(TriState::values);
    private final String name;

    public static TriState of(boolean bool) {
        return bool ? TRUE : FALSE;
    }

    public static TriState of(@Nullable Boolean bool) {
        return bool == null ? DEFAULT : of(bool);
    }

    public boolean get() {
        return this == TRUE;
    }

    public @Nullable Boolean getBoxed() {
        return this == DEFAULT ? null : this.get();
    }

    public boolean orElse(boolean value) {
        return this == DEFAULT ? value : this.get();
    }

    public boolean orElseGet(BooleanSupplier supplier) {
        return this == DEFAULT ? supplier.getAsBoolean() : this.get();
    }

    public <T> Optional<T> map(BooleanFunction<@Nullable ? extends T> mapper) {
        Objects.requireNonNull(mapper, "Mapper function cannot be null");
        return this == DEFAULT ? Optional.empty() : Optional.ofNullable(mapper.apply(this.get()));
    }

    public <X extends Throwable> boolean orElseThrow(Supplier<X> exceptionSupplier) throws Throwable {
        if (this != DEFAULT) {
            return this.get();
        } else {
            throw (Throwable) exceptionSupplier.get();
        }
    }

    public static TriState fromSystemProperty(String property) {
        String value = System.getProperty(property);
        if (value != null) {
            return Boolean.parseBoolean(value) ? TRUE : FALSE;
        } else {
            return DEFAULT;
        }
    }

    public String asString() {
        return this.name;
    }

    private TriState(String name) {
        this.name = name;
    }
}
