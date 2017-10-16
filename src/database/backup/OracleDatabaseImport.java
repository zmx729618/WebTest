package database.backup;

import java.io.IOException;

public class OracleDatabaseImport {
	
	/** 
     * 向Oracle数据库中导入已备份的数据库文件 
     *  
     * @author：Gaohuanjie 
     * @param userName 进入数据库所需要的用户名 
     * @param password 进入数据库所需要的密码 
     * @param SID 用户所在的SID 
     * @param fromUserName 导入的数据文件原来的用户 
     * @param filePath 不包含扩展名的数据库备份文件路径 
     * @return 返回true表示导入成功，返回false表示导入失败 
     */  
    public static boolean importDatabase(String userName, String password, String SID, String fromUserName, String filePath)throws InterruptedException {  
        String toUserName = userName;  
        try {  
            Process process = Runtime.getRuntime().exec("imp " + userName + "/" + password + "@" + SID  + " fromuser=" + fromUserName + " touser=" + toUserName + " file=" + filePath + ".dmp");  
            if (process.waitFor() == 0) {// 0 表示线程正常终止。   
                return true;  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return false;  
    }  
  
    public static void main(String[] args) throws InterruptedException {  
        if (importDatabase("sys", "0729", "orcl", "sys", "D:\\oracledb")) {  
            System.out.println("数据库成功导入！！！");  
        } else {  
            System.out.println("数据库导入失败！！！");  
        }  
    }  


}
