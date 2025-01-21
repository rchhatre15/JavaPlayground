package processor;

import java.io.*;

import java.util.*;

import java.text.*;

public class OrdersProcessor {
	private static Map<String, Double> items;
	private static String itemName, numOrders, baseName, resultName;

	public static void writeFile(String fileName, String content) throws IOException {
		// FileWriter file = new
		// FileWriter("/home/ro/eclipse-workspace/OrdersProcessor/" + fileName);

		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
		// System.out.println(fileName);
		writer.write(content);
		writer.close();
	}

	private static void readItems(String fileName) throws FileNotFoundException {
		File file = new File(fileName);
		Scanner scanner = new Scanner(file);

		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] data = line.split(" ", 2);
			items.put(data[0], Double.parseDouble(data[1]));
		}
		scanner.close();
		return;
	}

	private static Map<String, Integer> readOrder(String baseFile, String id) throws FileNotFoundException {
		Map<String, Integer> orderItems = new TreeMap<String, Integer>();
		File file = new File(baseFile + id + ".txt");
		Scanner scanner = new Scanner(file);

		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] data = line.split(" ", 2);
			if (!data[0].equals("ClientId:")) {
				if (orderItems.containsKey(data[0])) {
					int temp = orderItems.get(data[0]);
					temp++;
					orderItems.put(data[0], temp);
				} else {
					orderItems.put(data[0], 1);
				}
			}
		}
		scanner.close();
		return orderItems;
	}

	public static void main1(String[] args) throws FileNotFoundException {
//		Enter item's data file name: itemsData.txt
//		Enter 'y' for multiple threads, any other character otherwise: n
//		Enter number of orders to process: 1
//		Enter order's base filename: example
//		Enter result's filename: results.txt
//		Reading order for client with id: 1001
//		Processing time (msec): 56
//		Results can be found in the file: results.txt

//		itemsData.txt
//		n
//		3
//		example
//		pubTest1Results.txt
//
//		Scanner scan = new Scanner(System.in);
//
//		System.out.println("Enter item's data file name: ");
//		itemName = scan.nextLine();
//
//		System.out.println("Enter 'y' for multiple threads, any other character otherwise: ");
//		String multipleCheck = scan.nextLine();
//
//		items = new TreeMap<String, Double>();
//
//		if (multipleCheck.equals("y")) {
//			scan.close();
//		} else {
//			System.out.println("Enter number of orders to process: ");
//			numOrders = scan.nextLine();
//
//			System.out.println("Enter order's base filename: ");
//			baseName = scan.nextLine();
//
//			System.out.println("Enter result's filename: ");
//			resultName = scan.nextLine();
//
//			scan.close();
//
//			System.out.println("Reading order for client with id: ");
//
//			readItems(itemName);
//
//			String value = "";
//			Map<String, Integer> totalCounts = new TreeMap<String, Integer>();
//
//			for (int i = 1; i <= Integer.parseInt(numOrders); i++) {
//				Map<String, Integer> data = readOrder(baseName, "" + i);
//				double total = 0;
//				System.out.println("Reading order for client with id: " + (1000 + i));
//				value += "----- Order details for client with Id: " + (1000 + i) + " -----\n";
//				for (Map.Entry<String, Integer> entry : data.entrySet()) {
//					String key = entry.getKey();
//					Integer val = entry.getValue();
//					if (totalCounts.containsKey(key)) {
//						int temp = totalCounts.get(key);
//						temp += val;
//						totalCounts.put(key, temp);
//					} else {
//						totalCounts.put(key, val);
//					}
//					value += "Item's name: " + key + ", Cost per item: "
//							+ NumberFormat.getCurrencyInstance().format(items.get(key)) + ", Quantity: " + val
//							+ ", Cost: " + NumberFormat.getCurrencyInstance().format(items.get(key) * val) + "\n";
//					total += items.get(key) * val;
//				}
//				value += "Order Total: " + NumberFormat.getCurrencyInstance().format(total) + "\n";
//			}
//			value += "***** Summary of all orders *****\n";
//
//			double netTotal = 0;
//			for (Map.Entry<String, Integer> entry : totalCounts.entrySet()) {
//				String key = entry.getKey();
//				Integer val = entry.getValue();
//				value += "Summary - Item's name: " + key + ", Cost per item: "
//						+ NumberFormat.getCurrencyInstance().format(items.get(key)) + ", Number sold: " + val
//						+ ", Item's Total: " + NumberFormat.getCurrencyInstance().format(items.get(key) * val) + "\n";
//				netTotal += items.get(key) * val;
//			}
//			value += "Summary Grand Total: " + NumberFormat.getCurrencyInstance().format(netTotal);
//
//			System.out.println(value);
//			try {
//				writeFile(resultName, value);
//			} catch (Exception e) {
//				e.getMessage();
//			}
//
////			OrdersProcessor obj = new OrdersProcessor();
////			Thread thread = new Thread(obj);
////			thread.start();
//		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(System.in);
		

		System.out.println("Enter item's data file name: ");
		itemName = scan.nextLine();

		System.out.println("Enter 'y' for multiple threads, any other character otherwise: ");
		String multipleCheck = scan.nextLine();

		System.out.println("Enter number of orders to process: ");
		numOrders = scan.nextLine();

		System.out.println("Enter order's base filename: ");
		baseName = scan.nextLine();

		System.out.println("Enter result's filename: ");
		resultName = scan.nextLine();

		long time = System.currentTimeMillis();
		scan.close();
		
		
		items = new TreeMap<String, Double>();
		Map<String, Integer> totalCounts = new TreeMap<String, Integer>();

		if (multipleCheck.equals("y")) {
			Thread[] allThreads = new Thread[Integer.parseInt(numOrders)];

			for (int i = 0; i < allThreads.length; i++) {
				allThreads[i] = new Thread(new Order(itemName, (1000 + i + 1), baseName, resultName, items, totalCounts));
			}

			// Remember we need to start all threads
			for (int i = 0; i < allThreads.length; i++) {
				allThreads[i].start();
			}

			// Waiting for threads to finish
			for (int i = 0; i < allThreads.length; i++) {
				try {
					allThreads[i].join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {

			readItems(itemName);

			String value = "";

			for (int i = 1; i <= Integer.parseInt(numOrders); i++) {
				Map<String, Integer> data = readOrder(baseName, "" + i);
				double total = 0;
				System.out.println("Reading order for client with id: " + (1000 + i));
				value += "----- Order details for client with Id: " + (1000 + i) + " -----\n";
				for (Map.Entry<String, Integer> entry : data.entrySet()) {
					String key = entry.getKey();
					Integer val = entry.getValue();
					if (totalCounts.containsKey(key)) {
						int temp = totalCounts.get(key);
						temp += val;
						totalCounts.put(key, temp);
					} else {
						totalCounts.put(key, val);
					}
					value += "Item's name: " + key + ", Cost per item: "
							+ NumberFormat.getCurrencyInstance().format(items.get(key)) + ", Quantity: " + val
							+ ", Cost: " + NumberFormat.getCurrencyInstance().format(items.get(key) * val) + "\n";
					total += items.get(key) * val;
				}
				value += "Order Total: " + NumberFormat.getCurrencyInstance().format(total) + "\n";
			}
			value += "***** Summary of all orders *****\n";

			double netTotal = 0;
			for (Map.Entry<String, Integer> entry : totalCounts.entrySet()) {
				String key = entry.getKey();
				Integer val = entry.getValue();
				value += "Summary - Item's name: " + key + ", Cost per item: "
						+ NumberFormat.getCurrencyInstance().format(items.get(key)) + ", Number sold: " + val
						+ ", Item's Total: " + NumberFormat.getCurrencyInstance().format(items.get(key) * val) + "\n";
				netTotal += items.get(key) * val;
			}
			value += "Summary Grand Total: " + NumberFormat.getCurrencyInstance().format(netTotal);

			// System.out.println(value);
			try {
				writeFile(resultName, value);
			} catch (Exception e) {
				e.getMessage();
			}
		}

		System.out.println("Processing time (msec): " + (System.currentTimeMillis() - time));
		System.out.println("Results can be found in the file: " + resultName);

	}

}