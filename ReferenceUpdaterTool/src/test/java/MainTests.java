package test.java;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.jupiter.api.Test;
import main.java.Main;

public class MainTests {
	@Test
	void no_arguments_test()
			throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException {
		Method privateMethod = Main.class.getDeclaredMethod("process_arguments", String[].class);
		privateMethod.setAccessible(true);
		String[] args = new String[1];
		String result = (String) privateMethod.invoke(null, args);
		String expected = "No arguments provided";
		assertEquals(result, expected);
	}

	@Test
	void help_test()
			throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException {
		Method privateMethod = Main.class.getDeclaredMethod("process_arguments", String[].class);
		privateMethod.setAccessible(true);
		String[] args = { "help" };
		String result = (String) privateMethod.invoke(null, (Object) args);
		String expected = "process_file <input file path> <output file path> <number of lines to read at a time> \n"
				+ "process_directory <input directory path> <output directory path> <number of lines to read at a time>";
		assertEquals(result, expected);
	}

	@Test
	void process_file_with_wrong_number_of_arguments_test()
			throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException {
		Method privateMethod = Main.class.getDeclaredMethod("process_arguments", String[].class);
		privateMethod.setAccessible(true);
		String[] args = { "process_file", "Fake/Path" };
		String result = (String) privateMethod.invoke(null, (Object) args);
		String expected = "Incorrect number of arguments for this command. Run the 'help' command if confused.";
		assertEquals(result, expected);
	}

	@Test
	void process_file_with_correct_number_of_arguments_test()
			throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException {
		Method privateMethod = Main.class.getDeclaredMethod("process_arguments", String[].class);
		privateMethod.setAccessible(true);
		String[] args = { "process_file", "Fake/Path/input.txt", "Fake/Path/output.txt", "3" };
		String result = (String) privateMethod.invoke(null, (Object) args);
		String expected = "File Output Generated";
		assertEquals(result, expected);
	}

	@Test
	void incorrect_command_test()
			throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException {
		Method privateMethod = Main.class.getDeclaredMethod("process_arguments", String[].class);
		privateMethod.setAccessible(true);
		String[] args = { "process_filesssz", "Fake/Path/input.txt", "Fake/Path/output.txt", "3" };
		String result = (String) privateMethod.invoke(null, (Object) args);
		String expected = "This is not a valid command. please run the 'help' command if confused";
		assertEquals(result, expected);
	}

	@Test
	void process_directory_with_incorrect_number_of_arguments_test()
			throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException {
		Method privateMethod = Main.class.getDeclaredMethod("process_arguments", String[].class);
		privateMethod.setAccessible(true);
		String[] args = { "process_directory", "Fake/Path/input/", "Fake/Path/output/", "3" };
		String result = (String) privateMethod.invoke(null, (Object) args);
		String expected = "Incorrect number of arguments for this command. Run the 'help' command if confused.";
		assertEquals(result, expected);
	}

	@Test
	void process_directory_on_non_existant_directory_test()
			throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException {
		Method privateMethod = Main.class.getDeclaredMethod("process_arguments", String[].class);
		privateMethod.setAccessible(true);
		String[] args = { "process_directory", "Fake/Path/input/", "Fake/Path/output/", "3", "out" };
		String result = (String) privateMethod.invoke(null, (Object) args);
		String expected = "The specified path is not a directory or does not exist.";
		assertEquals(result, expected);
	}

	@Test
	void process_directory_on_empty_directory_test()
			throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException {
		Method privateMethod = Main.class.getDeclaredMethod("process_arguments", String[].class);
		privateMethod.setAccessible(true);
		String[] args = { "process_directory", "src/test/empty_folder/", "Fake/Path/output/", "3", "out" };
		String result = (String) privateMethod.invoke(null, (Object) args);
		String expected = "No files found in the directory.";
		assertEquals(result, expected);
	}

	@Test
	void process_directory_on_full_directory_test()
			throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException {
		Method privateMethod = Main.class.getDeclaredMethod("process_arguments", String[].class);
		privateMethod.setAccessible(true);
		String[] args = { "process_directory", "src/test/full_folder/", "Fake/Path/output/", "3", "out" };
		String result = (String) privateMethod.invoke(null, (Object) args);
		String expected = "Directory Output Generated";
		assertEquals(result, expected);
	}

}
