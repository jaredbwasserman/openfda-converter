# openFDA Converter

Downloads data from https://api.fda.gov/download.json and converts the data to CSV format.

## References

* [How To Use GUI Designer In IntelliJ IDEA IDE (2023 )](https://www.youtube.com/watch?v=whF_Qm1epQ8)

## TODO

1. Drop down for type (only drug label - should default to this - for now)
2. Drop down for file format (only csv - should default to this - for now)
3. Option box to discard the downloaded files after csv is generated
4. Pick the folder to download the files and put generate file into
    1. File picker directory only
5. Button that says start (verifies the type, format, download/generate location are all populated)
6. Name of generated file is `<TYPE>-<TIMESTAMP>.<FORMAT>`
    1. For example: `drug-label-1702928488.csv`
7. Show progress bar since there are 11 files
    1. For example: `Downloading file 1/11`
    2. And continue progress when it is generating the csv
