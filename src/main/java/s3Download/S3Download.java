package s3Download;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class S3Download
{
	InputStream			input		= null;
	Connection			conn		= null;
	static String		consolePath	= "/home/devanshparmar/devansh/CHS/1902/commands/command.sh";
	String				url			= "jdbc:mysql://ezcapc-webdb-production-readrep.cncmk5ndlbjo.us-east-1.rds.amazonaws.com:3306/CAPC_APIGATEWAY";
	String				user		= "read_only";
	String				pwd			= "P@ssw0rd@123";
	static List<String>	commands	= new ArrayList<>();

	public void connectfile() throws SQLException, IOException, ClassNotFoundException
	{

		conn = DriverManager.getConnection(url, user, pwd);
	}

	private void Query(String account) throws SQLException, ClassNotFoundException, IOException
	{

		List<String> acc = new ArrayList<String>();
		Statement stmt = conn.createStatement();

		String q1 = "select dm.service_date,dpd.ocr_request_s3_path, dpd.created_date,dpd.nlp_cdp_xml_result_s3_path, dpd.nlp_pcs_xml_result_s3_path, dpd.document_id,\n" + "dm.is_physician_document, dm.id,dm.account_id, am.account_number, am.id from account_mst am \n"
				+ "join document_mst dm on dm.account_id = am.id \n" + "and dm.is_physician_document = 1\n" + "join document_processing_detail dpd on dpd.document_id = dm.id \n" + "where am.account_number =\"" + account + "\" order by dpd.created_date desc";
		ResultSet rs = stmt.executeQuery(q1);

		while (rs.next())
		{
			String account_number = rs.getString("account_number");
			String cdp = rs.getString("nlp_cdp_xml_result_s3_path");
			String pcs = rs.getString("nlp_pcs_xml_result_s3_path");

			if (acc.contains(account_number))
			{
				continue;
			}
			else
			{
				System.out.println("aws s3 cp s3://ezdi-production-bucket/" + cdp + " CDP/" + account_number + ".xml");
				System.out.println("aws s3 cp s3://ezdi-production-bucket/" + pcs + " PCS/" + account_number + ".xml");
				acc.add(account_number);
			}
		}
	}

	public static void main(String args[]) throws IOException, SQLException, ClassNotFoundException
	{

		String acc = "/home/devanshparmar/git/fetchData/src/main/java/s3Download/account_numbers";
		File file = new File(acc);

		S3Download obj = new S3Download();
		obj.readfile(file);

		//		FileWriter fileWrite=new FileWriter(consolePath);
		//		for(String s:commands) {
		//			fileWrite.write(s);
		//		}

	}

	private void readfile(File file) throws IOException, SQLException, ClassNotFoundException
	{

		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;

		connectfile();
		while ((line = br.readLine()) != null)
		{
			Query(line);
		}

	}
}
