package org.beetl.performance.lab.template;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Boilit
 * @see
 */
public final class StockModel {
	public static int CAPACITY_1 = 1;
	public static int CAPACITY_2 = 2;
	public static int CAPACITY_3 = 3;
	public static int CAPACITY_4 = 4;
	public static int CAPACITY_5 = 5;
	private static int capacity = CAPACITY_2;
	private int id;
	private String code;
	private String name;
	private double price;
	private double range;
	private String amount;
	private double gravity;

	public StockModel(int id, String code, String name, double price,
			double range, String amount, double gravity) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.price = price;
		this.range = range;
		this.amount = amount;
		this.gravity = gravity;
	}

	public final int getId() {
		return id;
	}

	public final String getCode() {
		return code;
	}

	public final String getName() {
		return name;
	}

	public final double getPrice() {
		return price;
	}

	public final double getRange() {
		return range;
	}

	public final String getAmount() {
		return amount;
	}

	public final double getGravity() {
		return gravity;
	}

	public static int getCapacity() {
		return capacity;
	}

	public static void setCapacity(final int capacity) {
		if (capacity <= 0) {
			StockModel.capacity = 1;
			return;
		}
		StockModel.capacity = capacity;
	}

	public static List<StockModel> dummyItems() {
		List<StockModel> items = new ArrayList<StockModel>();
		if (StockModel.capacity >= CAPACITY_1) {
			items.add(new StockModel(1, "600663", "Company 01", 20.55, 10.01,
					"2.13 HM", 24.29));
			items.add(new StockModel(2, "600822", "Company 02", 14.69, 10.04,
					"1.56 HM", 36.79));
			items.add(new StockModel(3, "600831", "Company 03", 8.69, 10.00,
					"1.18 HM", 34.68));
			items.add(new StockModel(4, "600037", "Company 04", 8.47, 10.00,
					"1.17 HM", 28.43));
			items.add(new StockModel(5, "600880", "Company 05", 25.66, 6.78,
					"1.05 HM", 11.20));
			items.add(new StockModel(6, "600827", "Company 06", 9.37, 9.98,
					"9310 HM", 23.32));
			items.add(new StockModel(7, "000917", "Company 07", 17.03, 4.80,
					"8312 HM", 8.16));
			items.add(new StockModel(8, "603128", "Company 08", 16.56, 10.03,
					"7505 HM", 10.62));
			items.add(new StockModel(9, "002315", "Company 09", 52.61, 9.99,
					"6486 HM", 24.82));
			items.add(new StockModel(10, "600633", "Company 10", 45.74, 10.00,
					"6307 HM", 19.18));
		}
		if (StockModel.capacity >= CAPACITY_2) {
			items.add(new StockModel(11, "601888", "Company 11", 40.98, 8.04,
					"5556 HM", 15.46));
			items.add(new StockModel(12, "600650", "Company 12", 12.80, 7.74,
					"5516 HM", 17.27));
			items.add(new StockModel(13, "002277", "Company 13", 12.78, 6.95,
					"5285 HM", 15.03));
			items.add(new StockModel(14, "002405", "Company 14", 13.85, 3.20,
					"5027 HM", 14.95));
			items.add(new StockModel(15, "002185", "Company 15", 9.71, 3.96,
					"5019 HM", 27.46));
			items.add(new StockModel(16, "600637", "Company 16", 42.22, 5.60,
					"4962 HM", 8.30));
			items.add(new StockModel(17, "000538", "Company 17", 105.00, -1.39,
					"4942 HM", 9.45));
			items.add(new StockModel(18, "002317", "Company 18", 23.49, 7.65,
					"4566 HM", 22.23));
			items.add(new StockModel(19, "000839", "Company 19", 7.28, 6.28,
					"4475 HM", 22.06));
			items.add(new StockModel(20, "000419", "Company 20", 6.79, 8.29,
					"4330 HM", 19.83));
		}
		if (StockModel.capacity >= CAPACITY_3) {
			items.add(new StockModel(21, "000665", "Company 21", 13.61, 10.02,
					"4079 HM", 15.89));
			items.add(new StockModel(22, "002161", "Company 22", 9.47, 3.61,
					"3960 HM", 10.37));
			items.add(new StockModel(23, "002027", "Company 23", 7.98, 5.70,
					"3712 HM", 8.07));
			items.add(new StockModel(24, "600202", "Company 24", 6.43, 0.94,
					"3561 HM", 22.97));
			items.add(new StockModel(25, "600535", "Company 25", 43.83, 2.62,
					"3511 HM", 8.96));
			items.add(new StockModel(26, "000909", "Company 26", 7.03, 4.93,
					"3478 HM", 25.66));
			items.add(new StockModel(27, "300294", "Company 27", 43.78, 10.00,
					"3388 HM", 24.13));
			items.add(new StockModel(28, "600406", "Company 28", 16.16, 0.31,
					"3336 HM", 13.49));
			items.add(new StockModel(29, "600867", "Company 29", 17.03, 2.96,
					"3151 HM", 19.05));
			items.add(new StockModel(30, "300347", "Company 30", 58.38, 7.22,
					"3088 HM", 15.83));
		}
		if (StockModel.capacity >= CAPACITY_4) {
			items.add(new StockModel(31, "000156", "Company 31", 27.93, 5.08,
					"2955 HM", 15.05));
			items.add(new StockModel(32, "300330", "Company 32", 16.73, 9.99,
					"2879 HM", 18.10));
			items.add(new StockModel(33, "600415", "Company 33", 7.15, 2.88,
					"2819 HM", 4.50));
			items.add(new StockModel(34, "002238", "Company 34", 13.78, 6.82,
					"2741 HM", 18.38));
			items.add(new StockModel(35, "600832", "Company 35", 8.04, 4.69,
					"2683 HM", 5.07));
			items.add(new StockModel(36, "002428", "Company 36", 13.36, 0.23,
					"2652 HM", 21.64));
			items.add(new StockModel(37, "002223", "Company 37", 21.28, 5.03,
					"2617 HM", 16.86));
			items.add(new StockModel(38, "000058", "Company 38", 5.00, 2.88,
					"2610 HM", 20.96));
			items.add(new StockModel(39, "300246", "Company 39", 20.13, 10.00,
					"2440 HM", 21.23));
			items.add(new StockModel(40, "300038", "Company 40", 17.77, 10.03,
					"2375 HM", 20.79));
		}
		if (StockModel.capacity >= CAPACITY_5) {
			items.add(new StockModel(41, "601928", "Company 41", 13.07, 2.91,
					"2345 HM", 4.04));
			items.add(new StockModel(42, "601933", "Company 42", 13.42, 1.05,
					"2287 HM", 16.35));
			items.add(new StockModel(43, "002648", "Company 43", 28.09, 3.73,
					"2286 HM", 11.63));
			items.add(new StockModel(44, "600551", "Company 44", 14.19, 6.37,
					"2256 HM", 14.40));
			items.add(new StockModel(45, "300232", "Company 45", 16.28, 10.00,
					"2245 HM", 25.83));
			items.add(new StockModel(46, "002007", "Company 46", 27.20, 2.41,
					"2238 HM", 9.04));
			items.add(new StockModel(47, "000548", "Company 47", 6.36, 9.66,
					"2213 HM", 16.48));
			items.add(new StockModel(48, "300274", "Company 48", 27.30, 9.20,
					"2155 HM", 22.31));
			items.add(new StockModel(49, "300045", "Company 49", 15.71, 6.65,
					"2106 HM", 13.81));
			items.add(new StockModel(50, "300247", "Company 50", 11.15, 9.96,
					"2083 HM", 13.87));
		}
		for (int i = 0; i < capacity - CAPACITY_5; i++) {
			items.add(new StockModel(51, "601929", "Company 51", 13.07, 2.91,
					"2345 HM", 4.04));
			items.add(new StockModel(52, "601934", "Company 52", 13.42, 1.05,
					"2287 HM", 16.35));
			items.add(new StockModel(53, "002649", "Company 53", 28.09, 3.73,
					"2286 HM", 11.63));
			items.add(new StockModel(54, "600552", "Company 54", 14.19, 6.37,
					"2256 HM", 14.40));
			items.add(new StockModel(55, "300233", "Company 55", 16.28, 10.00,
					"2245 HM", 25.83));
			items.add(new StockModel(56, "002008", "Company 56", 27.20, 2.41,
					"2238 HM", 9.04));
			items.add(new StockModel(57, "000549", "Company 57", 6.36, 9.66,
					"2213 HM", 16.48));
			items.add(new StockModel(58, "300275", "Company 58", 27.30, 9.20,
					"2155 HM", 22.31));
			items.add(new StockModel(59, "300046", "Company 59", 15.71, 6.65,
					"2106 HM", 13.81));
			items.add(new StockModel(60, "300248", "Company 60", 11.15, 9.96,
					"2083 HM", 13.87));
		}
		return items;
	}
}
