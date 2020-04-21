package fileUploadDownload;

import java.io.File;

import org.junit.Test;

import junit.framework.Assert;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.*;

public class DownloadRest {
	
	@Test
	public void Test001()
	{
		String Path = System.getProperty("user.dir")+File.separator+"geckodriver-v0.26.0-win64 (2).zip";
		File inputfile=new File(Path);
		int expectedSize = (int) inputfile.length();
		
		System.out.println(expectedSize);
		//System.out.println(Path);
		
		byte[] actualSize = given()
		.when()
		.get("https://github.com/mozilla/geckodriver/releases/download/v0.26.0/geckodriver-v0.26.0-win64.zip")
		.then()
		.extract()
		.asByteArray();
		
		System.out.println(actualSize.length);
		
		//Assert.assertEquals(expectedSize, actualSize.length);
		
		assertThat(expectedSize,equalTo(actualSize.length) );
	}

}
