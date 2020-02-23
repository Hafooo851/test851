package DataProviderFactory;

public class dataproviderfactory {

	public static ConfigDataProvider getCofig()
	{
		//refrence back to what class you 
	ConfigDataProvider config=new ConfigDataProvider();// everytime use an object it should be return 
	return config;
	
	 }
	public static ExcelDataProvider getExcel()
	{
		
		ExcelDataProvider excel=new ExcelDataProvider();
		return excel;
		
	}
	}
