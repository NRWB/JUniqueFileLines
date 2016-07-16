
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * Reads a file into memory. Retains only unique lines.
 *
 * @author nick
 */
public class FileContent {

	private final Path path;

	public FileContent(final Path p) {
		this.path = p;
	}

	/*
	 * reads file
	 */
	public Set<String> getUniqueLines() throws IOException {

		List<String> lines = Files.readAllLines(this.path, StandardCharsets.UTF_8);
		Set<String> unique = new HashSet<String>();
		unique.addAll(lines);

		// debug
		if (unique.size() != lines.size()) {
			int linesRemoved = 0;
			int uSize = unique.size();
			int lSize = lines.size();
			if (uSize > lSize)
				linesRemoved = uSize - lSize;
			else
				linesRemoved = lSize - uSize;
			System.out.println("removed duplicates (" + linesRemoved + ")");
		} else
			System.out.println("no duplicates found");

		return unique;
	}
}