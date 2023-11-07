package seedu.staffsnap.model.applicant;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

import seedu.staffsnap.commons.util.StringUtil;
import seedu.staffsnap.commons.util.ToStringBuilder;
import seedu.staffsnap.model.interview.Interview;


/**
 * Custom predicate to be used to filter applicants
 */
public class CustomFilterPredicate implements Predicate<Applicant> {

    // Identity fields
    private final Name name;
    private final Phone phone;
    // Data fields
    private final String email;
    private final Position position;
    private final List<Interview> interviews;
    private final Status status;
    private final Double lessThanScore;
    private final Double greaterThanScore;

    /**
     * Constructor for CustomFilterPredicate
     *
     * @param name       Name of applicant
     * @param phone      Phone number of applicant
     * @param email      Email address of applicant
     * @param position   Position applied for by applicant
     * @param interviews Interviews applicant has to go through
     */
    public CustomFilterPredicate(Name name, Phone phone, String email, Position position, List<Interview> interviews,
                                 Status status, Double lessThanScore, Double greaterThanScore) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.position = position;
        this.interviews = interviews;
        this.status = status;
        this.lessThanScore = lessThanScore;
        this.greaterThanScore = greaterThanScore;
    }

    /**
     * @param applicant the applicant to be tested.
     * @return true if applicant matches all specified fields in the predicate
     */
    @Override
    public boolean test(Applicant applicant) {
        if (this.name != null) {
            if (!StringUtil.containsStringIgnoreCase(applicant.getName().toString(), this.name.toString())) {
                return false;
            }
        }
        if (this.phone != null) {
            if (!StringUtil.containsWordIgnoreCase(applicant.getPhone().toString(), this.phone.toString())) {
                return false;
            }
        }
        if (this.email != null) {
            if (!StringUtil.containsWordIgnoreCase(applicant.getEmail().toString(), this.email)) {
                return false;
            }
        }
        if (this.position != null) {
            if (!StringUtil.containsStringIgnoreCase(applicant.getPosition().toString(), this.position.toString())) {
                return false;
            }
        }
        if (this.status != null) {
            if (applicant.getStatus() != this.status) {
                return false;
            }
        }
        if (this.lessThanScore != null) {
            if (applicant.getScore().getAverageScore() > this.lessThanScore) {
                return false;
            }
        }
        if (this.greaterThanScore != null) {
            if (applicant.getScore().getAverageScore() < this.greaterThanScore) {
                return false;
            }
        }
        return true;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("name", name)
                .add("phone", phone)
                .add("email", email)
                .add("position", position)
                .add("interviews", interviews)
                .add("status", status).toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CustomFilterPredicate that = (CustomFilterPredicate) o;
        return Objects.equals(name, that.name) && Objects.equals(phone, that.phone) && Objects.equals(email,
                that.email) && Objects.equals(position, that.position) && Objects.equals(interviews, that.interviews)
                && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phone, email, position, interviews);
    }
}
