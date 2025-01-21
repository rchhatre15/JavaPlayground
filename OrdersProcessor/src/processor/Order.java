package processor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Order implements Runnable {
	private String itemName, baseName, resultName;
	private int numOrder;
	private Map<String, Double> items;
	private Map<String, Integer> totalCounts;
	// Map<String, Integer> data;

	public Order(String itemName, int numOrder, String baseName, String resultName, Map<String, Double> items,
			Map<String, Integer> totalCounts) {
		this.itemName = itemName;
		this.numOrder = numOrder;
		this.baseName = baseName;
		this.resultName = resultName;
		this.items = items;
		this.totalCounts = totalCounts;
	}

	@Override
	public void run() {
		String value = "";
		try {
			synchronized (items) {
				synchronized (totalCounts) {

					double total = 0;
					Map<String, Integer> data = readOrder(baseName, "" + numOrder);
					System.out.println("Reading order for client with id: " + numOrder);
					value += "----- Order details for client with Id: " + numOrder + " -----\n";
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

						value += "Order Total: " + NumberFormat.getCurrencyInstance().format(total) + "\n";
						System.out.println("focused up>>" + value);
					}

					value += "***** Summary of all orders *****\n";

					double netTotal = 0;
					for (Map.Entry<String, Integer> entry : totalCounts.entrySet()) {
						String key = entry.getKey();
						Integer val = entry.getValue();
						value += "Summary - Item's name: " + key + ", Cost per item: "
								+ NumberFormat.getCurrencyInstance().format(items.get(key)) + ", Number sold: " + val
								+ ", Item's Total: " + NumberFormat.getCurrencyInstance().format(items.get(key) * val)
								+ "\n";
						netTotal += items.get(key) * val;
					}
					value += "Summary Grand Total: " + NumberFormat.getCurrencyInstance().format(netTotal);

					// System.out.println(value);

					writeFile(resultName, value);
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}

	}

	public static void writeFile(String fileName, String content) throws IOException {
		// FileWriter file = new
		// FileWriter("/home/ro/eclipse-workspace/OrdersProcessor/" + fileName);

		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
		// System.out.println(fileName);
		writer.write(content);
		writer.close();
	}

	private void readItems(String fileName) throws FileNotFoundException {
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

	private Map<String, Integer> readOrder(String baseFile, String id) throws FileNotFoundException {
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

}
