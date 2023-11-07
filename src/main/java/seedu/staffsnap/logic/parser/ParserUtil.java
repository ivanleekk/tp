package seedu.staffsnap.logic.parser;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import seedu.staffsnap.commons.core.index.Index;
import seedu.staffsnap.commons.util.StringUtil;
import seedu.staffsnap.logic.commands.FilterCommand;
import seedu.staffsnap.logic.commands.ImportCommand;
import seedu.staffsnap.logic.parser.exceptions.ParseException;
import seedu.staffsnap.model.applicant.Applicant;
import seedu.staffsnap.model.applicant.CsvApplicant;
import seedu.staffsnap.model.applicant.Descriptor;
import seedu.staffsnap.model.applicant.Email;
import seedu.staffsnap.model.applicant.Name;
import seedu.staffsnap.model.applicant.Phone;
import seedu.staffsnap.model.applicant.Position;
import seedu.staffsnap.model.applicant.Score;
import seedu.staffsnap.model.applicant.Status;
import seedu.staffsnap.model.interview.Interview;
import seedu.staffsnap.model.interview.Rating;

/**
 * Contains utility methods used for parsing strings in the various *Parser classes.
 */
public class ParserUtil {

    public static final String MESSAGE_INVALID_INDEX = "Index is not a non-zero unsigned integer.";

    /**
     * Parses {@code oneBasedIndex} into an {@code Index} and returns it. Leading and trailing whitespaces will be
     * trimmed.
     * @throws ParseException if the specified index is invalid (not non-zero unsigned integer).
     */
    public static Index parseIndex(String oneBasedIndex) throws ParseException {
        String trimmedIndex = oneBasedIndex.trim();
        if (!StringUtil.isNonZeroUnsignedInteger(trimmedIndex)) {
            throw new ParseException(MESSAGE_INVALID_INDEX);
        }
        return Index.fromOneBased(Integer.parseInt(trimmedIndex));
    }

    /**
     * Capitalizes the first letter of each word.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @return the new content with the first letter of each word capitalized.
     */
    public static String standardizeCapitalization(String content) {
        String[] tokens = content.split(" ");
        StringBuilder newContent = new StringBuilder();
        for (String token : tokens) {
            if (token.isEmpty()) {
                continue;
            }
            char capLetter = Character.toUpperCase(token.charAt(0));
            newContent.append(" ");
            newContent.append(capLetter);
            newContent.append(token.substring(1).toLowerCase());
        }
        return newContent.toString().trim();
    }

    /**
     * Parses a {@code String name} into a {@code Name}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code name} is invalid.
     */
    public static Name parseName(String name) throws ParseException {
        requireNonNull(name);
        String trimmedName = name.trim();
        if (!Name.isValidName(trimmedName)) {
            throw new ParseException(Name.MESSAGE_CONSTRAINTS);
        }
        trimmedName = standardizeCapitalization(trimmedName);
        return new Name(trimmedName);
    }

    /**
     * Parses a {@code String phone} into a {@code Phone}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code phone} is invalid.
     */
    public static Phone parsePhone(String phone) throws ParseException {
        requireNonNull(phone);
        String trimmedPhone = phone.trim();
        if (!Phone.isValidPhone(trimmedPhone)) {
            throw new ParseException(Phone.MESSAGE_CONSTRAINTS);
        }
        return new Phone(trimmedPhone);
    }

    /**
     * Parses a {@code String position} into an {@code Position}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code position} is invalid.
     */
    public static Position parsePosition(String position) throws ParseException {
        requireNonNull(position);
        String trimmedPosition = position.trim();
        if (!Position.isValidPosition(trimmedPosition)) {
            throw new ParseException(Position.MESSAGE_CONSTRAINTS);
        }
        trimmedPosition = standardizeCapitalization(trimmedPosition);
        return new Position(trimmedPosition);
    }

    /**
     * Parses a {@code String email} into an {@code Email}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code email} is invalid.
     */
    public static Email parseEmail(String email) throws ParseException {
        requireNonNull(email);
        String trimmedEmail = email.trim();
        if (!Email.isValidEmail(trimmedEmail)) {
            throw new ParseException(Email.MESSAGE_CONSTRAINTS);
        }
        return new Email(trimmedEmail.toLowerCase());
    }

    /**
     * Parses a {@code String email} into an {@code Email}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code email} is invalid.
     */
    public static String parseEmailAsString(String email) throws ParseException {
        requireNonNull(email);
        String trimmedEmail = email.trim();
        return trimmedEmail.toLowerCase();
    }

    /**
     * Parses a {@code String type} and {@code String rating} into a {@code Interview}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code interview} is invalid.
     */
    public static Interview parseInterview(String type, String rating) throws ParseException {
        requireNonNull(type, rating);
        String trimmedType = type.trim();
        String trimmedRating = rating.trim();
        Rating ratingValue = new Rating(trimmedRating);
        if (!Interview.isValidType(trimmedType)) {
            throw new ParseException(Interview.MESSAGE_CONSTRAINTS);
        }
        if (!Rating.isValidRating(trimmedRating)) {
            throw new ParseException(Rating.MESSAGE_CONSTRAINTS);
        }
        return new Interview(trimmedType, ratingValue);
    }

    /**
     * Parses {@code Collection<String> interviews} into a {@code List<Interview>}.
     */
    public static List<Interview> parseInterviews(Collection<String> interviews) throws ParseException {
        requireNonNull(interviews);
        final List<Interview> interviewList = new ArrayList<>();
        for (String interviewType : interviews) {
            interviewList.add(parseInterview(interviewType, "-"));
        }
        return interviewList;
    }

    /**
     * Parses a {@code String descriptor} into a {@code Name}.
     * Leading and trailing whitespaces will be trimmed.
     * Case-insensitive
     *
     * @throws ParseException if the given {@code descriptor} is invalid.
     */
    public static Descriptor parseDescriptor(String descriptor) throws ParseException {
        requireNonNull(descriptor);
        String trimmedDescriptor = descriptor.trim();
        Descriptor result = Descriptor.findByName(trimmedDescriptor);
        if (result == null) {
            throw new ParseException(Descriptor.MESSAGE_CONSTRAINTS);
        }
        return result;
    }

    /**
     * Parses a {@code String type} into a {@code String}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code type} is invalid.
     */
    public static String parseType(String type) throws ParseException {
        requireNonNull(type);
        String trimmedType = type.trim();
        if (!Interview.isValidType(trimmedType)) {
            throw new ParseException(Interview.MESSAGE_CONSTRAINTS);
        }
        return trimmedType.toLowerCase();
    }

    /**
     * Parses a {@code String rating} into a {@code Rating}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code rating} is invalid.
     */
    public static Rating parseRating(String rating) throws ParseException {
        requireNonNull(rating);
        String trimmedRating = rating.trim();
        Double ratingValue;
        try {
            ratingValue = Double.parseDouble(trimmedRating);
        } catch (NumberFormatException e) {
            throw new ParseException(Rating.MESSAGE_CONSTRAINTS);
        }
        String ratingString = String.format("%.1f", ratingValue);
        if (!Rating.isValidRating(ratingString)) {
            throw new ParseException(Rating.MESSAGE_CONSTRAINTS);
        }
        return new Rating(ratingString);
    }

    /**
     * Checks if all prefixes are present in the given {@code ArgumentMultimap}.
     *
     * @param argumentMultimap
     * @param prefixes
     * @return true if all prefixes are present, false otherwise
     */
    public static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }

    /**
     * Parses a {@code String status} into a {@code Status}.
     *
     * @param status String representation of Status
     * @return Status if successful, or null if no matching status is found.
     */
    public static Status parseStatus(String status) {
        requireNonNull(status);
        return Status.findByName(status);
    }

    /**
     * Parses a {@code String score} into a {@code Double}.
     *
     * @param score String representation of score
     * @return Double score which is the average rating of all interviews
     * @throws ParseException if a NumberFormatException is caught
     */
    public static Double parseScore(String score) throws ParseException {
        requireNonNull(score);
        Double result;
        try {
            result = Double.parseDouble(score);
            if (result < 0 || result > 10) {
                throw new NumberFormatException("Score out of range");
            }
        } catch (NumberFormatException e) {
            throw new ParseException(FilterCommand.MESSAGE_SCORE_PARSE_FAILURE);
        }
        return result;
    }

    /**
     * Parses a {@code String fileName} into a {@code String}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code fileName} is invalid.
     */
    public static String parseFileName(String fileName) throws ParseException {
        requireNonNull(fileName);
        String trimmedFileName = fileName.trim();
        if (!trimmedFileName.matches(ImportCommand.FILENAME_VALIDATION_REGEX)) {
            throw new ParseException(ImportCommand.MESSAGE_INVALID_FILENAME);
        }

        return trimmedFileName;
    }

    /**
     * Parses a {@code CsvApplicant csvApplicant} into a {@code Applicant}.
     * Interviews and status will be given default values.
     *
     * @throws ParseException if the given {@code csvApplicant} is invalid.
     */
    public static Applicant parseApplicantFromCsv(CsvApplicant csvApplicant) throws ParseException {
        Name name = ParserUtil.parseName(csvApplicant.getName());
        Phone phone = ParserUtil.parsePhone(csvApplicant.getPhone());
        Email email = ParserUtil.parseEmail(csvApplicant.getEmail());
        Position position = ParserUtil.parsePosition(csvApplicant.getPosition());
        List<Interview> interviewList = new ArrayList<>();
        Status status = Status.UNDECIDED;
        Score score = new Score(interviewList);

        return new Applicant(name, phone, email, position, interviewList, status, score);
    }
}
