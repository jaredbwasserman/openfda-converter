# openFDA Converter

Downloads data from https://api.fda.gov/download.json and converts the data to various formats.

## References

* [How To Use GUI Designer In IntelliJ IDEA IDE (2023 )](https://www.youtube.com/watch?v=whF_Qm1epQ8)

## TODO

1. Drop down for type (only drug label - should default to this - for now)
2. Drop down with multiselect for fields
    1. Every field selected by default
    2. Fields are internally mapped from type to field list
    3. Field names flat but keep dots to represent nesting
3. Drop down for file format (only xlsx - should default to this - for now)
4. Option box to discard the downloaded files after Excel file is generated
    1. This should be on by default
5. Pick the folder to download the files and put generate file into
    1. File picker directory only
6. Button that says start (verifies the type, format, download/generate location are all populated)
7. Name of generated file is `<TYPE>-<yyyyMMddHHmmss>.<FORMAT>`
    1. For example: `drug-label-20100416151517.xlsx`
8. Show progress bar since there are 11 files
    1. For example: `Downloading file 1/11`
    2. And continue progress when it is generating the Excel file
9. Make sure to update Maven version to correlate with GitHub release version
10. Make a script checked in separately that can be used to one-off generate the list of fields
