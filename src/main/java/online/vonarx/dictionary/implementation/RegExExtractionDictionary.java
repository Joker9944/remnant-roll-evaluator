package online.vonarx.dictionary.implementation;

import online.vonarx.dictionary.Dictionary;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class RegExExtractionDictionary implements Dictionary<String, String> {

	private final List<Pattern> patterns;

	public RegExExtractionDictionary(final String... patterns) {
		this.patterns = Stream.of(patterns)
			.map(Pattern::compile)
			.collect(toList());
	}

	@Override
	public Optional<String> lookup(final String name) {
		return patterns.stream()
			.map(pattern -> pattern.matcher(name))
			.filter(Matcher::matches)
			.map(matcher -> matcher.group(1))
			.findFirst();
	}
}
