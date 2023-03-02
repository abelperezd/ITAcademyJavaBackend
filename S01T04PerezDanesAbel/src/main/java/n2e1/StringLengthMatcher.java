package n2e1;

import org.hamcrest.FeatureMatcher;
import org.hamcrest.core.IsEqual;

public class StringLengthMatcher extends FeatureMatcher<String, Integer> {

    public static StringLengthMatcher hasLength(IsEqual<Integer> lengthMatcher) {
        return new StringLengthMatcher(lengthMatcher);
    }
    public StringLengthMatcher(IsEqual<Integer> lengthMatcher) {
        super(lengthMatcher, "a string with length that is", "has length that");
    }

    @Override
    protected Integer featureValueOf(String actual) {
        return actual.length();
    }

}