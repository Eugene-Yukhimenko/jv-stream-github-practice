package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && "Ukrainian".equals(candidate.getNationality())
                && hasLivedInUkraineFor10Years(candidate.getPeriodsInUkr());
    }

    private boolean hasLivedInUkraineFor10Years(String period) {
        if (period == null || !period.matches("\\d{4}-\\d{4}")) {
            return false;
        }
        String[] parts = period.split("-");
        try {
            int fromYear = Integer.parseInt(parts[0]);
            int toYear = Integer.parseInt(parts[1]);
            return (toYear - fromYear) >= 10;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
