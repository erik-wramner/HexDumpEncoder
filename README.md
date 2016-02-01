# HexDumpEncoder
This is a drop-in replacement for Sun's internal HexDumpEncoder class. Many projects I've seen have used
<code>sun.misc.HexDumpEncoder</code> and recent Java versions produce warnings that it is an internal
proprietary API that may be removed. What to do? Well, rewrite the code, or use this drop-in. Only
change the package.

This encoder should be 100% compatible. The implementation has not been copied, so performance may be
better or worse, but the output for the public methods should be the same. The unit tests attempt to prove
that this is in fact true.

If you can live with slightly different output there are many alternatives out there, but this free
class can be used in place of Sun's internal class with the same output. That offers a safe migration
path to conservative developers, like me.