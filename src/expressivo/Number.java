package expressivo;

import java.util.Objects;

/**
 * A Number represents a nonnegative integer or floating-point number.
 * Immutable.
 */
public class Number implements Expression {
    private final double value;

    // Abstraction function:
    //   AF(value) = a numerical constant
    // Rep invariant:
    //   true
    // safety from rep exposure:
    //   value is private and final

    public Number(double value) {
        this.value = value;
        checkRep();
    }

    private void checkRep() {
        // No specific constraints for now
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Number)) return false;
        Number other = (Number) obj;
        return Double.compare(this.value, other.value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
