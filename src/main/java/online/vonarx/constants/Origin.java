package online.vonarx.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Origin {
	FROM_THE_ASHES("From The Ashes"),
	ADVENTURE_MODE_UPDATE("Adventure Mode Update"),
	LETO_S_LAB_UPDATE("Leto's Lab Update"),
	HARDCORE_UPDATE("Hardcore Update"),
	SWAMPS_OF_CORSUS_DLC("Swamps of Corsus DLC"),
	SUBJECT_2923_DLC("Subject 2923 DLC"),
	PREORDER_BONUS("Preorder Bonus"),
	UNKNOWN("Unknown");

	@Getter private final String displayName;
}
