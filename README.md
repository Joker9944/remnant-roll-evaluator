# Remnant roll evaluator

Basic Java based command line tool to evaluate rolled encounters in a save game from Remnant: From the Ashes.

## Description

Extracts game actors from a given save, maps then against dictionaries to gain meaningful names and groups the results for easier reading.

## Getting Started

### Installing

* Download executable from the releases page

### Executing program

* Open a commandline window in the folder where the executable is located (Shift + Right click in File Explorer -> "Open PowerShell window here")
* Run the executable with the file switch and the location to the save game, the save game is usually located under {userhome}\AppData\Remnant\Saved\SaveGames\
```
.\remnant-roll-evaludator.exe --file C:\Users\Joker9944\AppData\Remnant\Saved\SaveGames\save_0.sav
```
* For more information run the executable with the help switch
```
.\remnant-roll-evaludator.exe --help
```

## Help

If you run into problem please open a new issue on the Issues page.

## Author

* Felix von Arx

## Version History

* 0.1.0
    * Initial Beta Release

## License

This project is licensed under the MIT License - see the LICENSE.md file for details

## Acknowledgments

* [Remnant: From the Ashes Wiki](https://remnantfromtheashes.wiki.fextralife.com/Remnant+From+The+Ashes+Wiki)
* [Steam thread with original idea](https://steamcommunity.com/app/617290/discussions/0/1636416951459505629/)
* [Ultimate Remnant Convenience Guide](https://docs.google.com/spreadsheets/d/1VzmDx0ZXQWN5N_9_zP0gEqToyuB9ZjlxgZOEGdiuA6A/edit?usp=sharing)
* [World Analyzer](https://hzla.github.io/Remnant-World-Analyzer/)
