package training.problems;

import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.*;

public class Ecom {

	public static final String url = "jdbc:mysql://localhost:3306/eshop";
	public static final String user = "root";
	public static final String pwd = "rootdevansh";

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(url, user, pwd);
		Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

		printMainMenu(statement);
	}

	static void printMainMenu(Statement statement) throws SQLException {

		System.out.println("Hello, This is Eshop. please enter corrosponding input to continue: \n");
		System.out.println("For Login Enter: 1");
		System.out.println("For Registration Enter: 2");
		System.out.println("For Exit Enter: 0");

		mainMenu(statement);
	}

	static void mainMenu(Statement statement) throws SQLException {
		Scanner sc = new Scanner(System.in);

		int input = -1;
		while (input != 0) {
			if (sc.hasNextInt()) {
				input = sc.nextInt();
			} else {
				mainMenu(statement);;
			}
			switch (input) {
			case 1:
				loginMethod(statement);
				break;
			case 2:
				registerMethod(statement);
				break;
			case 0:
				System.out.println("Bye.");
//				System.exit(0);
				break;
			default:
				System.out.println("Incorrect Input.");
				break;
			}

		}
		sc.close();
	}

	static void loginMethod(Statement statement) throws SQLException {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter User Name: ");
		String userIn = sc.next();

		System.out.println("Enter Password: ");
		String pwd = sc.next();

		String selectQuery = String.format("select * from user where userId='%s' and pass='%s'", userIn, pwd);

		ResultSet results = statement.executeQuery(selectQuery);

		if (results.next() != false) {
			System.out.println("Welcome " + userIn);
			showPreviousOrNext(statement, userIn);
		} 
		else
			menuFromLogin(statement);
		sc.close();

	}

	static void menuFromLogin(Statement statement) throws SQLException {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Your user name or password is incorrect.");
		System.out.println("To try again, enter: 1");
		System.out.println("To Register, enter: 2");
		System.out.println("To go back to main menu, enter: 3");
		System.out.println("To quit, enter: 0");
		int input = -1;
		while (input != 0) {
			if (sc.hasNextInt()) {
				input = sc.nextInt();
			} else {
				continue;
			}
			switch (input) {
			case 1:
				loginMethod(statement);
				break;
			case 2:
				registerMethod(statement);
				break;
			case 3:
				printMainMenu(statement);
				break;
			case 0:
				System.out.println("Bye.");
				System.exit(0);
				break;
			default:
				System.out.println("Incorrect Input.");
				break;
			}
		}
		sc.close();
	}
	static void registerMethod(Statement statement) throws SQLException {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a unique userID: ");
		String name = sc.next();

		String selectQuery = String.format("select * from user where userId='%s'", name);
		ResultSet results = statement.executeQuery(selectQuery);

		if (results.next() != false) {
			System.out.println("User already exists");
			registerMethod(statement);
		} else {
			System.out.println("Enter Password");
			String passw = sc.next();
			System.out.println("Enter Phone No.");
			String phoneNo = phoneNoEnter();

			System.out.println("Enter Gender: ");
			System.out.println("Male : 1");
			System.out.println("Female : 2");
			Gender gender = enterGender();

			System.out.println("Enter Address");
			String addr = sc.next();

			String insetQuery = String.format("insert into user values('%s','%s','%s','%s','%s')", name, passw, phoneNo,
					gender, addr);

			if (statement.executeUpdate(insetQuery) != 0) {
				System.out.println("User Registered.");
				showPreviousOrNext(statement, name);
			}

		}
		sc.close();

	}

	static void showPreviousOrNext(Statement statement, String userId) throws SQLException {
		System.out.println("Want to see previous orders? Enter 1");
		System.out.println("Continue Shopping? Enter 2");
		Scanner sc = new Scanner(System.in);
		if(sc.hasNext()) {
			int code = sc.nextInt();
			if (code == 1) {
				showPrevious(statement, userId);
			} else if (code == 2) {
				showProducts(statement, userId);
			} else
				showPreviousOrNext(statement, userId);
		}
		else {
			showPreviousOrNext(statement, userId);
		}
		sc.close();
	}

	static void showPrevious(Statement statement, String userId) throws SQLException {
		String selectQ="select * from cart inner join product using(prodId) where userId='"+userId+"'";
		ResultSet r=statement.executeQuery(selectQ);
		
		while(r.next()) {
			String pName=r.getString("pName");
			int quan=r.getInt("quanity");
			int amt=r.getInt("totalAmount");
			Date d_o_o=r.getDate("D_O_O");
			Date d_o_d=r.getDate("D_O_D");
			
			System.out.println(pName+" "+quan+" "+amt+" "+d_o_o+" "+d_o_d);
		}
		
		showPreviousOrNext(statement, userId);
	}

	static String getProdName(Statement statement, int proId) throws SQLException {
		String proFindName = String.format("select pName from product where prodId='%s'", proId);
		ResultSet reN = statement.executeQuery(proFindName);
		while (reN.next())
			return reN.getString("pName");
		return null;

	}

	static Gender enterGender() {
		Scanner sc = new Scanner(System.in);
		int gen = sc.nextInt();
		Gender gn = null;
		switch (gen) {
		case 1:
			gn = Gender.male;
			sc.close();
			return gn;
		case 2:
			gn = Gender.female;
			sc.close();
			return gn;
		default:
			System.out.println("Enter correct input: ");
			enterGender();
			break;
		}
		sc.close();
		return null;
	}

	enum Gender {
		male, female
	}

	static String phoneNoEnter() {
		Scanner sc = new Scanner(System.in);
		String phoneNo = "";

		if (sc.hasNext("\\d{10}")) {
			phoneNo = sc.next();
		} else {
			System.out.println("Enter Correct Phone No.");
			phoneNoEnter();
		}
		sc.close();
		return phoneNo;
	}

	static void showProducts(Statement statement, String userId) throws SQLException {
		System.out.println("Here are Products: ");
		String selectQuery = String.format("select * from product");
		ResultSet results = statement.executeQuery(selectQuery);
		Scanner sc = new Scanner(System.in);

		try {
			while (results.next()) {
				int id = results.getInt("prodId");
				String name = results.getString("pName");
				String desc = results.getString("pDesc");
				int price = results.getInt("price");
				int quan = results.getInt("quantity");

				System.out.println("Name: " + name + " Desc: " + desc + " Price: " + price + " Quantity: " + quan
						+ "\tcode: " + id + "\n");
			}

			System.out.println("Enter code to buy product: ");
			int code = enterProductCode();
			enterIntoCart(code, statement, userId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		sc.close();
	}

	static int enterProductCode() {
		Scanner sc = new Scanner(System.in);
		int code = sc.nextInt();
		if (code >= 1 || code <= 5) {
			sc.close();
			return code;
		} else
			enterProductCode();
		sc.close();
		return 0;
	}

	static void enterIntoCart(int prodId, Statement statement, String userId) throws SQLException {
		int quanEntered = quantity();
		String selectQuery = String.format("select * from product where prodId='%d'", prodId);
		ResultSet results = statement.executeQuery(selectQuery);
		int quantity = -1, price = -1;

		if (results.next() != false) {
			quantity = results.getInt("quantity");
			price = results.getInt("price");
		}

		if (quantity == 0) {
			System.out.println("Sorry, we have run out of that product! ");
			showProducts(statement, userId);

		} else if (quanEntered <= quantity) {
			int billNo = 1;
			LocalDate date_ord = LocalDate.now();
			LocalDate date_deliv = date_ord.plusDays(7);

			String selectFromCart = "select * from cart";
			ResultSet cart = statement.executeQuery(selectFromCart);

			cart.afterLast();
			while (cart.previous()) {
				billNo = cart.getInt("billNo") + 1;
			}
			String insertQuery = String.format("insert into cart values('%d','%d','%s','%d','%d,'%s','%s')", billNo, prodId,
					userId, quanEntered,quanEntered*price, date_ord, date_deliv);
			String updateQuery = String.format("update product set quantity='%d' where prodId='%d'",
					quantity - quanEntered, prodId);

			if (statement.executeUpdate(insertQuery) != 0 && statement.executeUpdate(updateQuery) != 0)
				System.out.printf("Order placed successfully. Expect delivery on %s", date_deliv);
			System.out.printf("Order Price is %d", quanEntered*price);

		} else {
			System.out.println("Sorry, we don't have the entered quantity,"
					+ " please enter quantity lesser than or equal to shown in products list.");
			enterIntoCart(prodId, statement, userId);
		}
		toContinue(statement, userId);
	}

	static int quantity() {
		System.out.println("Enter Quantity you want to buy: ");
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()) {
			int q = sc.nextInt();
			if (q > 0) {
				sc.close();
				return q;
			} else {
				quantity();
			}
		}
		else
			quantity();
		sc.close();
		return 0;
	}

	static void toContinue(Statement statement, String userId) throws SQLException {
		System.out.println("Want to Order? Enter 1");
		System.out.println("To Quit, Enter 2");
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()) {
			int out = sc.nextInt();
			if (out == 1) {
				showProducts(statement, userId);
			} else if (out == 2) {
				System.exit(0);
			} else {
				System.out.println("Enter Valid input!");
				toContinue(statement, userId);
			}
		}
		else
			toContinue(statement, userId);
		sc.close();
	}
}
