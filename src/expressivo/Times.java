package expressivo;

import java.util.Objects;

/**
 * A Times represents a multiplication of two Expressions.
 * Immutable.
 */
public class Times implements Expression {
    private final Expression left;
    private final Expression right;

 // abstraction function:  
//  af(left, right) = the expression left * right  
//rep invariant:  
//  left and right are non-null  
//safety from rep exposure:  
//  all fields are private and final, no mutable fields are returned  


    public Times(Expression left, Expression right) {
        this.left = left;
        this.right = right;
        checkRep();
    }

    private void checkRep() {
        assert left != null && right != null;
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " * " + right.toString() + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Times)) return false;
        Times other = (Times) obj;
        return this.left.equals(other.left) && this.right.equals(other.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
