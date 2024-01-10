package main.java;
import java.io.File;

public class Main {
	public static void main(String[] args) {
		TextFileHelper helper = new TextFileHelper();
		if (args.length == 0) {
			System.out.println("No arguments provided");
		} else {
			if (args[0].equals("help")) {
				System.out.println("process_file <input file path> <output file path> <number of lines to read at a time>");
				System.out.println("process_directory <input directory path> <output directory path> <number of lines to read at a time> "
						+ "<string to add to end of each file name");
			} else if (args[0].equals("process_file")) {
				if (args.length == 4) {
					helper.generate_output_document(args[1], args[2], Integer.valueOf(args[3]));
				} else {
					System.out.println("Incorrect number of arguments for this command. Run the 'help' command if confused.");
				}
			} else if (args[0].equals("process_directory")) {
				if (args.length == 5) {
				File directory = new File(args[1]);
				if (directory.exists() && directory.isDirectory()) {
		            File[] files = directory.listFiles(); 
		            if (files != null) {
		                for (File file : files) {
		                	String fileName = file.getName().toString();
		                	String[] parts = fileName.split("\\.");
		                	String newfileName = parts[0].concat(args[4]).concat(".").concat(parts[1]);
		                	helper.generate_output_document(file.getAbsolutePath(), args[2].concat(newfileName), Integer.valueOf(args[3]));
		                }
		            } else {
		                System.out.println("No files found in the directory.");
		            }
		        } else {
		            System.out.println("The specified path is not a directory or does not exist.");
		        }
		    } else {
		    	System.out.println("Incorrect number of arguments for this command. Run the 'help' command if confused.");
		    }
			}
		}
	}
}
