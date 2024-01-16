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
6. Option for number of lines per sheet
    1. This should default to the maximum amount and be capped between 1 and max inclusive
    2. Need to account for the Excel hard limit on the number of rows
7. Option for number of sheets per workbook
8. Pick the folder to download the files and put generate file into
    1. File picker directory only
9. Button that says start (verifies the type, subtype, fields, format, download/generate location are all populated)
10. Name of generated file is `<TYPE>-<SUBTYPE>-<yyyyMMdd>-<HHmmss>-<PART>-of-<PARTS>.<FORMAT>`
    1. For example: `drug-label-20100416-151517-00000-of-00010.xlsx`
11. Show progress bar since there are 11 files
    1. For example: `Downloading file 1/11`
    2. And continue progress when it is generating the Excel file
12. Make sure to update Maven version to correlate with GitHub release version
13. Make sure to delete ALL intermediate files
    1. Even on failure
14. Lock the interface when it is downloading and processing
15. Open folder showing Excel files at the end
16. Add fields to `OpenFDAAPI`
    1. Need to add everything except drug label
17. Fix NullPointer in `fromEndpointDatasetRaw`
    1. Can reproduce with drug event
18. Fix spacing in generated files to make indentation correct compared to formatter
19. Optimize so that the transformations take place in each thread rather than waiting for the whole set of files to
    download and having single-threaded operation over all files
20. The `openfda` logic does not work for all datasets, for example drug event, need to generalize
21. More sophisticated code generation to avoid manually copying files would be nice
22. Probably need support for writing certain kinds of objects to Excel to avoid any weird `toString` behavior
23. Instead of all the generation stuff, just write a script to parse the searchable fields YAML
    1. For example: https://open.fda.gov/apis/drug/label/searchable-fields/
    2. And need a clever way to parse nested fields (things with `.`) because not all datasets are the same structure
24. Remove existing code for dealing with `openfda` and use searchable fields to come up with a more general approach
    1. Should be able to handle fields containing a `.` and any formats that exist
25. Can parse the searchable fields from the YAML files on the fly instead of checking those files in
    1. Remove the generated package and associated README info
    2. Make the `EndpointDatasetRaw` the regular one and remove the weird parsing logic
    3. Remove fields from `Endpoint` since will parse on the fly
26. Improvements
    1. Add column for the originating file
    2. Make this a tool that can be run since files are updated frequently
    3. Alternative to scraping website automatically is ability to manually feed the label json files and have it spit
       out the spreadsheet
        1. Supply local files rather than needing to download each time useful if site is down or providing different
           settings for the same input
    4. Need to avoid capping Excel worksheet row limit
27. Generalizations
    1. Add drop down for field(s) to split on, for example `openfda.package_ndc`
    2. Add ability to specify specials rules for parsing fields, for example `indications_and_usage` split characters
    3. Custom column ordering
        1. Use https://docs.oracle.com/javase/tutorial/uiswing/dnd/dropmodedemo.html
    4. Skipping rules, like skipping fields without `openfda`
28. Might actually be easier to load all of this into a database
    1. The database tables would be the intermediate representation
    2. Export to Excel, CSV, etc. would be easier since it would just be SQL queries
29. Create functions to pass in for the thread pool (rather than always downloading and unzipping)
    1. Function to download
    2. Function to unzip (this might just happen automatically if needed rather than being a passed in function)
    3. Function to write to relational database
    4. Function to write to Excel (maybe each sheet is handled by a thread?)
30. Make generating the fields a maven compile step rather than a manual test
    1. Update the README appropriately
31. Remove all the `@SuppressWarnings("unchecked")`
32. Gray out everything that is not "drug" and "label" for each dropdown, respectively
33. Still need to pick the endpoint even when giving local files, so it knows how to parse them
34. Fix `WARNING: Secure coding is automatically enabled for restorable state!`
35. Get rid of the `MainForm.form` warnings
36. Why does `inputFilesList` change size sometimes?
