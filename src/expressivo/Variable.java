package expressivo;

import java.util.Objects;

/**
 * A Variable represents a case-sensitive string identifier.
 * Immutable.
 */
public class Variable implements Expression {
    private final String name;

    // Abstraction function:
    //   AF(name) = a variable with the name `name`
    // Rep invariant:
    //   name is nonempty and consists of only letters
    // safety from rep exposure:
    //   name is private and final

    public Variable(String name) {
        this.name = name;
        checkRep();
    }

    private void checkRep() {
        assert name.matches("[a-zA-Z]+");
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Variable)) return false;
        Variable other = (Variable) obj;
        return this.name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
