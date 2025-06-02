package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

public class Config_data {
	public Properties pro;
	public void config_reader() throws Exception {

		String path="/Users/yashvantandure/eclipse-workspace/Framework_setup_T2D2/Config_prop/Config.properties";
		File fi=new File(path);
		FileInputStream fis=new FileInputStream(fi);
		 pro=new Properties();
		pro.load(fis);
	}
public String get_baseurl() {
	return pro.getProperty("base_url");
}
}
