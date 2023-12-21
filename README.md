# openFDA Converter

Downloads data from the [openFDA API](https://api.fda.gov/download.json) and converts the data to various formats.

## References

* [Download a File From an URL in Java](https://www.baeldung.com/java-download-file)
* [Downloading Multiple Files Parallelly or Asynchronously in Java](https://stackoverflow.com/questions/33075208/downloading-multiple-files-parallelly-or-asynchronously-in-java)
* [How to extract specific file in a zip file in java](https://stackoverflow.com/questions/32179094/how-to-extract-specific-file-in-a-zip-file-in-java)
* [Intro to the Jackson ObjectMapper](https://www.baeldung.com/jackson-object-mapper-tutorial)
* [How To Use GUI Designer In IntelliJ IDEA IDE (2023 )](https://www.youtube.com/watch?v=whF_Qm1epQ8)

## TODO

1. Drop down for type (e.g. drug)
2. Drop down for subtype (e.g. label)
3. Drop down with multiselect for fields
    1. Every field selected by default
    2. Fields are internally mapped from type/subtype to field list
    3. Field names flat but keep dots to represent nesting
4. Drop down for file format (only xlsx - should default to this - for now)
5. Option box to discard the downloaded files after Excel file is generated
    1. This should be on by default
6. Option for number of lines per file
    1. This should default to the maximum amount and be capped between 1 and max inclusive
7. Pick the folder to download the files and put generate file into
    1. File picker directory only
8. Button that says start (verifies the type, subtype, fields, format, download/generate location are all populated)
9. Name of generated file is `<TYPE>-<SUBTYPE>-<yyyyMMdd>-<HHmmss>-<PART>-of-<PARTS>.<FORMAT>`
    1. For example: `drug-label-20100416-151517-0000-of-0010.xlsx`
10. Show progress bar since there are 11 files
    1. For example: `Downloading file 1/11`
    2. And continue progress when it is generating the Excel file
11. Make sure to update Maven version to correlate with GitHub release version
12. Make a script checked in separately that can be used to one-off generate the list of fields
    1. Could be some test(s) to verify the constants are correct
13. Make sure to delete ALL intermediate files
    1. Even on failure
14. Need to account for the Excel hard limit on the number of rows
15. Lock the interface when it is downloading and processing
16. Open folder showing Excel files at the end
17. Add `excel` package for writing Excel files
