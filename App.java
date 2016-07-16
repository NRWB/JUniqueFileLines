
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App {

	public static void main(String[] args) throws IOException {

		if (args.length != 1) {
			printUsage();
			System.exit(-1); // Runtime.getRuntime().exit(-1);
		}

		long startTime = System.currentTimeMillis();

		final Path target = Paths.get(args[0]);
		FileContent fc = new FileContent(target);

		FileOutput fp = new FileOutput(target, fc.getUniqueLines());
		fp.createUniqueContentFile();

		long endTime = System.currentTimeMillis();
		long elapsedTime = (endTime - startTime);
		System.out.println("Time elapsed = " + elapsedTime + " MS, or " + (elapsedTime / 1000) + " seconds.");
	}

	public static void printUsage() {
		System.out.println("default usage: java App \"/location/to/file\"");
		System.out.println("for further information, see README.md");
	}
}
