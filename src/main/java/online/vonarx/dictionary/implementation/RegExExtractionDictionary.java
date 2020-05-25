package online.vonarx.dictionary.implementation;

import com.google.common.collect.ImmutableList;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import online.vonarx.dictionary.Dictionary;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExExtractionDictionary implements Dictionary<String, String> {

	private final List<Pattern> patterns;

	private RegExExtractionDictionary(final List<Pattern> patterns) {
		this.patterns = patterns;
	}

	@Override
	public Optional<String> lookup(final String name) {
		return patterns.stream()
			.map(pattern -> pattern.matcher(name))
			.filter(Matcher::matches)
			.map(matcher -> matcher.group(1))
			.findFirst();
	}

	public static RegExExtractionDictionaryBuilder builder() {
		return new RegExExtractionDictionaryBuilder();
	}

	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	public static class RegExExtractionDictionaryBuilder {

		private final ImmutableList.Builder<Pattern> patternsBuilder = ImmutableList.builder();

		public RegExExtractionDictionaryBuilder add(final String pattern) {
			patternsBuilder.add(Pattern.compile(pattern));
			return this;
		}

		public RegExExtractionDictionary build() {
			return new RegExExtractionDictionary(patternsBuilder.build());
		}
	}
}
