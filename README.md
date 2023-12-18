# openFDA Converter

Downloads data from https://api.fda.gov/download.json and converts the data to various formats.

## References

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
6. Pick the folder to download the files and put generate file into
    1. File picker directory only
7. Button that says start (verifies the type, subtype, fields, format, download/generate location are all populated)
8. Name of generated file is `<TYPE>-<SUBTYPE>-<yyyyMMdd>-<HHmmss>.<FORMAT>`
    1. For example: `drug-label-20100416-151517.xlsx`
9. Show progress bar since there are 11 files
    1. For example: `Downloading file 1/11`
    2. And continue progress when it is generating the Excel file
10. Make sure to update Maven version to correlate with GitHub release version
11. Make a script checked in separately that can be used to one-off generate the list of fields
    1. Could be some test(s) to verify the constants are correct
