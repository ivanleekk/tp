package seedu.staffsnap.model.applicant;

import static java.util.Objects.requireNonNull;
import static seedu.staffsnap.commons.util.AppUtil.checkArgument;

/**
 * Represents a Applicant's position in the applicant book.
 * Guarantees: immutable; is valid as declared in {@link #isValidPosition(String)}
 */
public class Position implements Comparable<Position> {

    public static final String MESSAGE_CONSTRAINTS = "Positions can take any values, should not be blank "
            + "and should not be more than 30 characters";

    /*
     * The first character of the position must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[^\\s].*";

    public final String value;

    /**
     * Constructs an {@code Position}.
     *
     * @param position A valid position.
     */
    public Position(String position) {
        requireNonNull(position);
        checkArgument(isValidPosition(position), MESSAGE_CONSTRAINTS);
        value = position;
    }

    /**
     * Returns true if a given string is a valid email.
     */
    public static boolean isValidPosition(String test) {
        return test.matches(VALIDATION_REGEX) && test.length() <= 30;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Position)) {
            return false;
        }

        Position otherPosition = (Position) other;
        return value.equals(otherPosition.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public int compareTo(Position o) {
        return this.value.compareTo(o.value);
    }
}
