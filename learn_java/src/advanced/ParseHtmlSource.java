package advanced;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class ParseHtmlSource {
	
	public static void main (String[] args){
		
		String content = "<p>An <a href='http://example.com/'><b>example</b></a> link.</p>. <p>An <a href='http://example.com/'><b>example</b></a> link.</p>. <p>An <a href='http://example.com/'><b>example</b></a> link.</p>. <p>An <a href='http://example.com/'><b>example</b></a> link.</p>";
	    Document doc = Jsoup.parse(content);
	    Elements links = doc.select("a[href]"); // a with href
	    System.out.println(links.size());
	    System.out.println(links);
	    
	    String content1 = "<p>An <a href='http://example.com/'><b>example</b></a> link.</p>. <p>An <a href='http://example.com/'><b>example</b></a> link.</p>. <p>An <a href='http://example.com/'><b>example</b></a> link.</p>. <p>An <a href='http://example.com/'><b>example</b></a> link.</p>";
	    Document doc1 = Jsoup.parse(content1);
	    Elements links1 = doc1.select("<b>"); // a with href
	    System.out.println(links1.size());
	    System.out.println(links1);
		
	}

}
