import java.io.IOException;
import java.util.NoSuchElementException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Properties;
import java.util.logging.Logger;
import java.util.logging.Level;

public class jPokedex
{
	public static String clearScr = "\033[H\033[2J";
	// Clears the screen.

	public static String[] output = new String[1046];
	// This is my array to hold the output the user defines they want, before storing into a file and printing.

	public static void main(String[] args) throws Exception
	{
		Scanner waitingInput = new Scanner(System.in);

		Logger logger;
		// My variable for the logging of the FileNotFoundException exceptional event.

		switch (args[0]){
			case "--help":
				System.out.println("\nName [AZ | ZA] [OutputFile] \t(Searches by the Pokemon's Name)\n\n\t\tOptional Arguments:");
					System.out.println("\t\tAZ         = Sorts ascending order\n\t\tZA         = Sorts descending order\n");
				System.out.println("\nType1 [AZ | ZA] [OutputFile] \t(Searches by the Pokemon's First Type)\n\n\t\tOptional Arguments:");
					System.out.println("\t\tAZ         = Sorts ascending order\n\t\tZA         = Sorts descending order\n");
				System.out.println("\nType2 [AZ | ZA] [OutputFile] \t(Searches by the Pokemon's Second Type)\n\n\t\tOptional Arguments:");
					System.out.println("\t\tAZ         = Sorts ascending order\n\t\tZA         = Sorts descending order\n");
				System.out.println("\nHeight [AZ | ZA] [OutputFile] \t(Searches by the Pokemon's Height)\n\n\t\tOptional Arguments:");
					System.out.println("\t\tAZ         = Sorts ascending order\n\t\tZA         = Sorts descending order\n");
				System.out.println("\nWeight [AZ | ZA] [OutputFile] \t(Searches by the Pokemon's Weight)\n\n\t\tOptional Arguments:");
					System.out.println("\t\tAZ         = Sorts ascending order\n\t\tZA         = Sorts descending order\n");					System.out.println("\t\tOutputFile = The file for the search's output\n");

				break;

			case "Name": case "--Name": case "name": case "--name":
				ShapeArray(3);
				if (args.length == 2){
					if (args[1].equals("AZ")){
						SortArray(true);
						// This sorts the array in descending order.
					} else if (args[1].equals("ZA")){
						SortArray(false);
						// This sorts the array in ascending order.
					}
				}
			break;

			case "Type1": case "--Type1": case "type1": case "--type1":
				ShapeArray(4);
				if (args.length == 2){
					if (args[1].equals("AZ")){
						SortArray(true);
						// This sorts the array in descending order.
					} else if (args[1].equals("ZA")){
						SortArray(false);
						// This sorts the array in ascending order.
					}
				}
			break;

			case "Type2": case "--Type2": case "type2": case "--type2":
				ShapeArray(5);
				if (args.length == 2){
					if (args[1].equals("AZ")){
						SortArray(true);
						// This sorts the array in descending order.
					} else if (args[1].equals("ZA")){
						SortArray(false);
						// This sorts the array in ascending order.
					}
				}
			break;

			case "Height": case "--Height": case "height": case "--height":
				ShapeArray(14);
				if (args.length == 2){
					if (args[1].equals("AZ")){
						SortArray(true);
						// This sorts the array in descending order.
					} else if (args[1].equals("ZA")){
						SortArray(false);
						// This sorts the array in ascending order.
					}
				}
			break;

			case "Weight": case "--Weight": case "weight": case "--weight":
				ShapeArray(15);
				if (args.length == 2){
					if (args[1].equals("AZ")){
						SortArray(true);
						// This sorts the array in descending order.
					} else if (args[1].equals("ZA")){
						SortArray(false);
						// This sorts the array in ascending order.
					}
				}
			break;

		}
			PrintArray();
	}

	public static void ShapeArray(int columnName) throws IOException {
		String scannerValue = "";
		try {
			File pokeFile = new File("N_P.csv");
			Scanner scanner = new Scanner(pokeFile);
			scanner.useDelimiter("\n");
			int outputPointer = 0;
			// This variable keeps track of the pointer for the output array.
			while(scanner.hasNext()){
				int fieldOn = 1;
				// This variable will keep up with which column the pointer is on scannerValue below.
				scannerValue = scanner.next().toString();

				// This variable holds the string value of scanner.next().
				String columnValueHolder = "";
				for (int i = 0; i < scannerValue.length(); i++){


					if (fieldOn == columnName && !scannerValue.substring(i, i+1).equals(",") && !scannerValue.substring(0,2).equals("ID")){

					// if the current field I am on is the same as the column the user specified, I need to be adding each
					// character to the columnValueHolder variable.
						columnValueHolder = columnValueHolder + scannerValue.substring(i, i+1);

					} else {
					// If the current filed I am on is not the same, I keep counting the commas in the scanner.next()
					// value, to get to that field.
						if (scannerValue.substring(i, i+1).equals(",")){

						// If the char acter in the scanner.next() string is a comma, fieldOn needs to increment.
							fieldOn++;
						}
					}
				}
				output[outputPointer] = columnValueHolder;

				outputPointer++;
			}


		} catch (IOException | NoSuchElementException ex){
			System.out.println(ex.toString());
			throw ex;
		}

	}

	public static void SortArray (boolean ascendingOrder){
		for (int i=0; i < output.length; i++){
			for (int j = 0; j < output.length; j++){
				if (!ascendingOrder){
					if (output[i].compareTo(output[j]) > 0){
						String temp = output[i];
						output[i] = output[j];
						output[j] = temp;
					}
				} else {
					if (output[i].compareTo(output[j]) < 0){
						String temp = output[j];
						output[j] = output[i];
						output[i] = temp;
					}
				}
			}
		}
	}

	public static void PrintArray(){
		System.out.println(clearScr);
		System.out.flush();
		// 2 Lines above invoke the clearScr unicode command above.

		for (int printArray = 0; printArray < output.length; printArray++){
			System.out.println(output[printArray]);
		}

	}
}

