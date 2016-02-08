To run this compiler:
The source program must have a .txt extension.
Run the main Compiler class.
When asked for the input file, do not include the extension.
The compiler first removes all comments from the source file and writes a file
 out with only the source code not commented.This file has the format
 <fileName>Stripped.txt
The parser then calls the scanner on the stripped file.
The Generator writes to a file <fileName>.asm, and it creates this file
 directly in the Mice folder. The Mice folder contains mini and mice for
 reading from the file the parser output. This is so the intermediate code
 file does not have to be copied to the folder containing mini and mice.
Mini must then be run. When asked for input, the file name is:
 <fileName>.asm
Mini outputs another file that must be run through mice:
 <fileName>.asm.out. Further documentation may be found in the Support folder.
