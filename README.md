# JUniqueFileLines
Take input file and process to output file, yielding only unique lines.

## About
Takes one input file, processing the file in memory, and outputting the file with line-unique-ness.

## Example Usage
java App "/location/to/file"

## Result
Attempts (given appropriate FileSystem/security permissions) to output a result file to the same location of the input source file. The output file is also named the same, with the exception of a trailing timestamp (in MS) after the file name, before the file extension.
