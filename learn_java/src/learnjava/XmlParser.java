package learnjava;

//import java.io.InputStream;

//
//import com.cmates.selenium.framework.page.WebObj;
//import com.cmates.selenium.framework.utils.Logger;
//
//public class XmlParser {
//
//	public static WebObj webobj;
//	static boolean flag =false;
//	static void createXmlFile(String Account){
//
//		String data =new String();
//
//
//
//
//
//		webobj = new WebObj("10.103.15.20",4444,"*chrome","http://www.discovernetwork.com/");
//		//localhost 10.103.15.18
//
//		webobj.start();
//		webobj.windowMaximize();
//		webobj.setTimeout(webobj.globalProps.timeOut);
//		webobj.deleteAllVisibleCookies();
//		Logger.info("All Visible cookies deleted");
//
//		webobj.open("http://bsi-vgs.prod.untd.com:8868/bsi.untd?type=RETRIEVE&member_id="+Account+"&trancd=ASUM");
//		data = webobj.getLocation();
//		System.out.println("URL of the file:"+data);
//
//		try {
//	URL url = new URL(data);
//	BufferedReader input =  new BufferedReader(new InputStreamReader(url.openStream()));
//
//	String str=new String();
//	BufferedWriter out = new BufferedWriter(new FileWriter("f://temp//ASUM.xml"));
//	while((str=input.readLine())!=null)
//	{
//		out.write(str);
//	}
//	out.close();
//	} catch (Exception e)
//	{e.printStackTrace();}
//	webobj.close();
//
//}
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//
//		System.out.println("#####################################################");
//		String Account = "sudheer.nl@netzero.net";
//
//		XmlParser.createXmlFile(Account);
//		System.out.println("#####################################################");
//
//	}
//
//}
