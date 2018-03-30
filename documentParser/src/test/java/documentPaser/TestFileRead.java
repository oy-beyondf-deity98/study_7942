package documentPaser;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;
import net.deity.documentPaser.parser.Word;
import net.deity.documentPaser.parser.WordParser;

public class TestFileRead extends TestCase {

	@Test
	public void testWordDic() throws IOException{
		String path="/Users/deity/Documents/document";
		
		WordParser paser = new WordParser();
		List<Word> list = paser.paserDir(path);
		
		System.out.println(list.size());
	}
}
