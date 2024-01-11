package main.java;

import java.io.File;

public class Main {
	public static void main(String[] args) {
		System.out.println(process_arguments(args));
	}

	private static String process_arguments(String[] args) {
		TextFileHelper helper = new TextFileHelper();
		if (args == null) {
			return ("No arguments provided");
		} else {
			if (args[0].equals("help")) {
				return ("process_file <input file path> <output file path> <number of lines to read at a time> \n"
						+ "process_directory <input directory path> <output directory path> "
						+ "<number of lines to read at a time>");

			} else if (args[0].equals("process_file")) {
				if (args.length == 4) {
					helper.generate_output_document(args[1], args[2], Integer.valueOf(args[3]));
					return ("File Output Generated");
				} else {
					return ("Incorrect number of arguments for this command. Run the 'help' command if confused.");
				}
			} else if (args[0].equals("process_directory")) {
				if (args.length == 5) {
					File directory = new File(args[1]);
					if (directory.exists() && directory.isDirectory()) {
						File[] files = directory.listFiles();
						if (files != null && files.length > 0) {
							for (File file : files) {
								String fileName = file.getName().toString();
								String[] parts = fileName.split("\\.");
								String newfileName = parts[0].concat(args[4]).concat(".").concat(parts[1]);
								helper.generate_output_document(file.getAbsolutePath(), args[2].concat(newfileName),
										Integer.valueOf(args[3]));
							}
							return ("Directory Output Generated");
						} else {
							return ("No files found in the directory.");
						}
					} else {
						return ("The specified path is not a directory or does not exist.");
					}
				} else {
					return ("Incorrect number of arguments for this command. Run the 'help' command if confused.");
				}
			} else {
				return ("This is not a valid command. please run the 'help' command if confused");
			}
		}
	}
}
