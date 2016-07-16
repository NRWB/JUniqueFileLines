
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.Set;

/**
 *
 * Outputs a file from memory to disk.
 *
 * @author nick
 */
public class FileOutput {

	private final Path path;
	private final Set<String> lines;

	public FileOutput(final Path p, final Set<String> content) {
		this.path = p;
		this.lines = content;
	}

	/*
	 * Attempts to rename the file by inserting a time stamp in MS.
	 * The time stamp should be inserted after the file name and before the
	 * file extension.
	 * There are many un-handled cases, such as;
	 * - no file extension
	 * - multiple '.' characters
	 * - '.' characters in folder names
	 * etc...
	 */
	private String renameFile() {
		String a = this.path.getFileName().toString();
		String b = "";
		int i = a.lastIndexOf('.');
		if (i > 0)
			b = a.substring(i);
		StringBuilder name = new StringBuilder();
		name.append((i > 0) ? a.substring(0, i) : a);
		name.append("-");
		name.append(System.currentTimeMillis());
		name.append(b);
		return name.toString();
	}

	public void createUniqueContentFile() {
		StringBuilder outPath = new StringBuilder();
		System.out.println(this.path.toAbsolutePath().getParent().toString());
		outPath.append(this.path.toAbsolutePath().getParent().toString());
		outPath.append(File.separator);
		outPath.append(renameFile());
		final String s = outPath.toString();
		final boolean appendTo = true;
		try (FileWriter fw = new FileWriter(s, appendTo); BufferedWriter bw = new BufferedWriter(fw); PrintWriter out = new PrintWriter(bw)) {
			this.lines.forEach((k) -> out.println(k));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
