import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
public class DelAnnotation {
	private static String PROJECTPATH = "F:/workspace/ruiqin";
	private static String MODELPATH = PROJECTPATH+"/src/main/java/com/jynine/model/";
	private static String DAOPATH = PROJECTPATH+"/src/main/java/com/jynine/dao/";
	private static String MAPPERPATH =PROJECTPATH+ "/src/main/resources/com/jynine/mybatis/";
	/**
	 * 
	 * @param oldFile
	 * @param newFile
	 * @param className
	 *            ����
	 * @param type
	 *            0:model 1:dao 2:mapper
	 */
	public static void copyFile(File oldFile, File newFile, String className,
			int type) {
		BufferedReader reader = null;
		FileWriter fileWriter = null;
		try {
			reader = new BufferedReader(new FileReader(oldFile));
			fileWriter = new FileWriter(newFile);
			String tempString = null;
			int line = 1;
			boolean tag = true;
			boolean delimport = false;
			boolean examTag = false;
			String examStr = "";
			while ((tempString = reader.readLine()) != null) {
				if (type == 2) {
					if (tempString.contains("<!--")) {
						tag = false;
					}
					if(tempString.contains(className+"Mapper")){
						tempString = tempString.replace(className+"Mapper", className+"Dao");
					}
					if(tempString.contains("Example") && !examTag){
						examTag = true;
						examStr = tempString.substring(tempString.indexOf("<")+1,tempString.indexOf(" ", tempString.indexOf("<")));
					}
					
					if (tag && !examTag) {
						fileWriter.write(tempString + "\n");
					}
					if (tempString.contains("-->")) {
						tag = true;
					}
					if(examStr != null && examStr != ""){
						if(tempString.contains("</"+examStr+">")){
							examTag = false;
						}
					}
					line++;
				} else {
					delimport = false;
					if (tempString.contains("/**")) {
						tag = false;
					}
					if (tag) {
						if (type == 1) {
							if (tempString.indexOf(className + "Mapper") != -1) {
								tempString = tempString.replaceAll(className
										+ "Mapper", className + "Dao");
							}
							if (tempString.indexOf(className + "Example") != -1) {
									delimport = true;
							}
							if(tempString.indexOf("record") != -1){
								tempString = tempString.replaceAll(
										"record",className.substring(0, 1).toLowerCase()
										+ className.substring(1,
												className.length()));
							}
							if (tempString.indexOf("example") != -1) {
								tempString = tempString.replaceAll(
										"example",className.substring(0, 1).toLowerCase()
										+ className.substring(1,
												className.length()));
							}
							if(!delimport){
								fileWriter.write(tempString + "\n");
							}
						}else{							
							fileWriter.write(tempString + "\n");
						}
					}
					if (tempString.contains("*/")) {
						tag = true;
					}
					line++;
				}

			}
			fileWriter.close();
			reader.close();
			oldFile.delete();
		} catch (IOException e) {
			System.out.println("�ļ�ɾ��ʧ�ܣ�"+e.getMessage());
		} finally {
			if (reader != null) {
				try {
					reader.close();
					fileWriter.close();
				} catch (IOException e1) {
					System.out.println("���ر��쳣��"+e1.getMessage());
				}
			}
		}
		
	}
	/**
	 * ɾ������ע��
	 * @param table
	 */
	public static void delAllAnnotation(String table) {
		delModelAnnotation(table);
		delDaoAnnotation(table);
		delXmlAnnotation(table);
		System.out.println("ע������ɹ���");
	}
	/**
	 * ɾ�����е�ע��
	 * @param table
	 */
	public static void delModelAnnotation(String table){
		File oldFile = new File(MODELPATH + table + ".java");
		File newFile = new File(MODELPATH + table + "Temp1.java");
		File tempFile = new File(MODELPATH + table + "Example.java");
		tempFile.delete();
		copyFile(oldFile, newFile, table, 0);
		copyFile(newFile, oldFile, table, 0);
	}
	/**
	 * ɾ��dao�е�ע��
	 * @param table
	 */
	public static void delDaoAnnotation(String table){
		File oldDaoFile = new File(DAOPATH + table + "Mapper.java");
		File newDaoFile = new File(DAOPATH + table + "Dao.java");
		copyFile(oldDaoFile, newDaoFile, table, 1);
	}
	/**
	 * ɾ��xml�е�ע��
	 * @param table
	 */
	public static void delXmlAnnotation(String table){
		File oldMapperFile = new File(MAPPERPATH + table + "Mapper.xml");
		File newMapperFile = new File(MAPPERPATH + table + "MapperTemp1.xml");
		copyFile(oldMapperFile, newMapperFile, table, 2);
		copyFile(newMapperFile, oldMapperFile, table, 2);
	}
	
	public static void main(String[] args) {
			InputStream in =new DelAnnotation().getClass().getClassLoader()
					.getResourceAsStream("classname.properties"); 
			Properties pro = new Properties();
			try {
				pro.load(in);
				String calzzs = pro.getProperty("classname");
				System.out.println("---------->"+calzzs);
				String[] calzzarr = calzzs.split(",");
				for(int i = 0;i<calzzarr.length;i++){
					delAllAnnotation(calzzarr[i]);
				}
			} catch (IOException e) {
				System.out.println("�����ˣ���");
			}
	//	delAllAnnotation("Scene");
	}
}