package online.vonarx.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class Save {

	private final List<Actor> storyActors;
	private final List<Actor> adventureActors;
}
