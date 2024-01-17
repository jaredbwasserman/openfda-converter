# openFDA Converter

Downloads data from the [openFDA API](https://api.fda.gov/download.json) and converts the data to various formats.

## Generating Fields

1. Supply the absolute path for `com.jaredbwasserman.openfda.model.generated` as the value of
   the `FIELDS_GENERATOR_OUTPUT_PATH` environment variable
2. Go to `com.jaredbwasserman.openfda.generate.EndpointDatasetFieldsGeneratorTest`
3. Run `testGenerateFieldsForAllEndpoints`
4. Format the generated files in the `com.jaredbwasserman.openfda.model.generated` package

## References

* [Download a File From an URL in Java](https://www.baeldung.com/java-download-file)
* [Downloading Multiple Files Parallelly or Asynchronously in Java](https://stackoverflow.com/questions/33075208/downloading-multiple-files-parallelly-or-asynchronously-in-java)
* [List .zip directories without extracting](https://stackoverflow.com/questions/11468163/list-zip-directories-without-extracting)
* [How to extract specific file in a zip file in java](https://stackoverflow.com/questions/32179094/how-to-extract-specific-file-in-a-zip-file-in-java)
* [Intro to the Jackson ObjectMapper](https://www.baeldung.com/jackson-object-mapper-tutorial)
* [Parsing YAML with SnakeYAML](https://www.baeldung.com/java-snake-yaml)
* [Adding items to a JComboBox](https://stackoverflow.com/questions/17887927/adding-items-to-a-jcombobox)
* [Add String to JList exactly where they're dropped, not at the bottom](https://stackoverflow.com/questions/15531783/add-string-to-jlist-exactly-where-theyre-dropped-not-at-the-bottom)
* [Make JList Values Unselectable](https://stackoverflow.com/questions/17863780/make-jlist-values-unselectable)
* [Prevent Swing GUI locking up during a background task](https://stackoverflow.com/questions/940913/prevent-swing-gui-locking-up-during-a-background-task)
* [Progress Bar Java](https://stackoverflow.com/questions/15199091/progress-bar-java)

## TODO

1. Option for number of lines per sheet
    1. This should default to the maximum amount and be capped between 1 and max inclusive
    2. Need to account for the Excel hard limit on the number of rows
2. Option for number of sheets per workbook
3. Name of generated file is `<TYPE>-<SUBTYPE>-<yyyyMMdd>-<HHmmss>-<PART>-of-<PARTS>.<FORMAT>`
    1. For example: `drug-label-20100416-151517-00000-of-00010.xlsx`
4. Make sure to delete ALL intermediate files
    1. Even on failure
5. Optimize so that the transformations take place in each thread rather than waiting for the whole set of files to
   download and having single-threaded operation over all files
6. Create functions to pass in for the thread pool (rather than always downloading and unzipping)
    1. Function to download
    2. Function to unzip (this might just happen automatically if needed rather than being a passed in function)
    3. Function to write to relational database
    4. Function to write to Excel (maybe each sheet is handled by a thread?)
7. Test on all endpoints
8. Probably need support for writing certain kinds of objects to Excel to avoid any weird `toString` behavior
9. Might actually be easier to load all of this into a database
    1. The database tables would be the intermediate representation
    2. Export to Excel, CSV, etc. would be easier since it would just be SQL queries
10. Add column whose value is the originating openfda data file
11. Add support for more file types than just `xlsx`.
12. Add skipping rules, like skipping fields without `openfda`
13. Make generating the fields a maven compile step rather than a manual test
    1. Update the README appropriately
14. Remove all the `@SuppressWarnings("unchecked")`
15. Fix `WARNING: Secure coding is automatically enabled for restorable state!`
16. Why do `inputFilesList` and `outputDirectoryList` change size sometimes?
17. Error dialog if there is an Exception while processing
    1. May involve rethrowing things so the processing thread can handle them
18. Make sure to update Maven version to correlate with GitHub release version
