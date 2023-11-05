package seedu.staffsnap.model.applicant;

import static java.util.Objects.requireNonNull;
import static seedu.staffsnap.commons.util.AppUtil.checkArgument;

import java.util.List;

import seedu.staffsnap.model.interview.Interview;

/**
 * Represents the score of an applicant.
 */
public class Score {
    public static final String MESSAGE_CONSTRAINTS =
            "Score should have non-negative total score to 1dp, non-negative average score 1dp and non-negative"
                    + " number of ratings";
    private Double totalScore = 0.0;
    private Double averageScore = 0.0;
    private int numberOfRatings = 0;
    /**
     * Constructs a {@code Score}.
     */
    public Score(Score score) {
        requireNonNull(score);
        this.totalScore = score.getTotalScore();
        this.averageScore = score.getAverageScore();
        this.numberOfRatings = score.getNumberOfRatings();
    }

    /**
     * Constructs a {@code Score}.
     */
    public Score(List<Interview> interviews) {
        requireNonNull(interviews);
        for (Interview interview : interviews) {
            updateScoreAfterAdd(interview);
        }
    }

    /**
     * Constructs a {@code Score}.
     */
    public Score(double totalScore, double averageScore, int numberOfRatings) {
        checkArgument(isValidScore(totalScore, averageScore, numberOfRatings), MESSAGE_CONSTRAINTS);
        this.totalScore = totalScore;
        this.averageScore = averageScore;
        this.numberOfRatings = numberOfRatings;
    }

    /**
     * Returns the number of decimals of a given score.
     */
    public static int getNumberOfDecimals(double score) {
        String[] splitter = Double.toString(score).split("\\.");
        return splitter[1].length();
    }

    /**
     * Returns true if a given score is valid.
     */
    public static Boolean isValidScore(double totalScore, double averageScore, int numberOfRatings) {
        return totalScore >= 0.0 && getNumberOfDecimals(totalScore) == 1
                && averageScore >= 0.0 && getNumberOfDecimals(averageScore) == 1
                && numberOfRatings >= 0;
    }

    /**
     * Updates the score of the applicant when a new interview is added.
     *
     * @param interview The interview that was added or updated.
     */
    public void updateScoreAfterAdd(Interview interview) {
        String rating = interview.getRating().value;
        if (!rating.equals("-")) {
            numberOfRatings++;
            totalScore += Double.parseDouble(rating);
        }
        averageScore = Double.parseDouble(String.format("%.1f", totalScore / numberOfRatings));
    }

    /**
     * Updates the score of the applicant when an interview is edited.
     *
     * @param oldInterview The interview before it was edited.
     * @param newInterview The interview after it was edited.
     */
    public void updateScoreAfterEdit(Interview oldInterview, Interview newInterview) {
        String oldRating = oldInterview.getRating().value;
        String newRating = newInterview.getRating().value;

        if (!oldRating.equals("-")) {
            totalScore -= Double.parseDouble(oldRating);
        }
        if (!newRating.equals("-")) {
            totalScore += Double.parseDouble(newRating);
        }
        if (oldRating.equals("-") && !newRating.equals("-")) {
            numberOfRatings++;
        }
        averageScore = Double.parseDouble(String.format("%.1f", totalScore / numberOfRatings));
    }

    /**
     * Updates the score of the applicant when an interview is deleted.
     *
     * @param interview The interview that was deleted.
     */
    public void updateScoreAfterDelete(Interview interview) {
        String rating = interview.getRating().value;
        if (!rating.equals("-")) {
            numberOfRatings--;
            totalScore -= Double.parseDouble(rating);
        }
        averageScore = Double.parseDouble(String.format("%.1f", totalScore / numberOfRatings));
    }

    /**
     * Returns true if the applicant has been rated for an interview.
     *
     * @return true if the applicant has been rated for an interview.
     */
    public boolean hasRating() {
        return numberOfRatings > 0;
    }

    /**
     * Returns the average score of the applicant.
     *
     * @return averageScore The average score of the applicant.
     */
    public Double getAverageScore() {
        if (averageScore.isNaN()) {
            return 0.;
        }
        return averageScore;
    }

    /**
     * Returns the total score of the applicant.
     *
     * @return totalScore The total score of the applicant.
     */
    public Double getTotalScore() {
        return totalScore;
    }

    /**
     * Returns the number of ratings the applicant has.
     *
     * @return numberOfRatings The number of ratings the applicant has.
     */
    public int getNumberOfRatings() {
        return numberOfRatings;
    }

    @Override
    public String toString() {
        return String.format("%.1f", averageScore);
    }
}
