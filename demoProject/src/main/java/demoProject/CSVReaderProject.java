package demoProject;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class CSVReaderProject {

	private static final String CSV_FILE_PATH = "C:\\Users\\HP\\Desktop\\Buyer.csv";

	private static final String CSV_FILE_CUSTOM_SEPARATOR = "C:\\Users\\HP\\Desktop\\Supplier.csv";

	public static void main(String[] args) throws IllegalStateException, IOException, ParseException {

		System.out.println("READ ALL DATA AT ONCE ADN HIDE THE HEADER ALSO \n");
//		readAllDataAtOnce(CSV_FILE_PATH, CSV_FILE_CUSTOM_SEPARATOR);
		readCSV(CSV_FILE_PATH, CSV_FILE_CUSTOM_SEPARATOR);
		System.out.println("---------------------------------------------------------------");

	}

//	public static void readAllDataAtOnce(String file1, String file2) {
//		try {
//			List<List<String>> records1 = new ArrayList<List<String>>();
//			List<List<String>> records2 = new ArrayList<List<String>>();
//
//			// Create an object of filereader class
//			// with CSV file as a parameter.
//
//			FileReader filereader1 = new FileReader(file1);
//			FileReader fileReader2 = new FileReader(file2);
//
//			// create csvReader object
//			// and skip first Line
//
//			com.opencsv.CSVReader csvReader1 = new CSVReaderBuilder(filereader1).withSkipLines(1).build();
//			com.opencsv.CSVReader csvReader2 = new CSVReaderBuilder(fileReader2).withSkipLines(1).build();
//			List<String[]> allData = csvReader1.readAll();
//			List<String[]> allData2 = csvReader2.readAll();
//			
//			// print Data for first
//			for (String[] row : allData) {
//				records1.add(Arrays.asList(row));
//				System.out.println();
//			}
//
//			System.out.println("RECORDS FOR FIRST CSV" + " " + records1);
//
//			// print Data for second
//			for (String[] row : allData2) {
//				records2.add(Arrays.asList(row));
//				System.out.println();
//			}
//
//			System.out.println("RECORDS FOR SECOND CSV" + " " + records2);
//
//			if(records1.size() == records2.size()) {
//			
//			for(int i=0;i<records1.size();i++) {
//				for(int j=0;j<records1.get(i).size();j++) {
//					System.out.println("FIRST DATA" + records1.get(i).get(j));
//					String saveFirstIndexForRec1 = records1.get(i).get(j);
//					String saveFirstIndexRec2 = records2.get(i).get(j);
//					
//					
//					
//				}
//			}
//			
//			}
//		
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	public static void readCSV(String file1, String file2) throws IOException, ParseException {
		FileReader filereader1 = new FileReader(file1);
		FileReader filereader2 = new FileReader(file2);

		List<List<String>> records1 = new ArrayList<List<String>>();
		List<List<String>> records2 = new ArrayList<List<String>>();

		CSVReader reader1 = new CSVReaderBuilder(filereader1).withSkipLines(1).build();
		CSVReader reader2 = new CSVReaderBuilder(filereader2).withSkipLines(1).build();

		// Reading the contents of the csv file
		List<?> list1 = reader1.readAll();
		List<?> list2 = reader2.readAll();

		// Getting the Iterator object
		Iterator<?> it1 = list1.iterator();
		Iterator<?> it2 = list2.iterator();
		while (it1.hasNext()) {
			String[] str = (String[]) it1.next();
			records1.add(Arrays.asList(str));

		}

		while (it2.hasNext()) {
			String[] str = (String[]) it2.next();
			records2.add(Arrays.asList(str));

		}

		for (int i = 0; i < records1.size(); i++) {
			for (int j = 0; j < records1.get(i).size(); j++) {

				Integer numValues = 0;
				Date dateValues;
				String compareStringValues = null;
				Double doubleValues;
				System.out.println("FIRST DATA" + "-" + records1.get(i).get(j));
				
				String regexForInteger = "\\d+";
				String regexForDate = "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$";
				String regexForDouble = "^[\\+\\-]{0,1}[0-9]+[\\.\\,]{1}[0-9]+$";

				if (records1.get(i).get(j).matches(regexForInteger) == true) {
					numValues = Integer.parseInt(records1.get(i).get(j));
					System.out.println("INTEGER VALUE" + "-"+ numValues);
					System.out.println("-------------------------------------------------------------------");
				} else if (records1.get(i).get(j).matches(regexForDate) == true) {
					dateValues = new SimpleDateFormat("dd/MM/yyyy").parse(records1.get(i).get(j));
					System.out.println("DATE VALUES"+ "-"+dateValues);
					System.out.println("-------------------------------------------------------------------");
				} else if (records1.get(i).get(j).matches(regexForDouble)) {
					doubleValues = Double.valueOf(records1.get(i).get(j));
					System.out.println("DOUBLE VALUES"+ "-"+ doubleValues);
					System.out.println("-------------------------------------------------------------------");
				} else {
					compareStringValues = records1.get(i).get(j);
					System.out.println("STRING VALUES"+ "-"+compareStringValues);
					System.out.println("-------------------------------------------------------------------");
				}

			}
		}

	}
}
