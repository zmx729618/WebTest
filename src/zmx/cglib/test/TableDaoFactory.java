package zmx.cglib.test;

public class TableDaoFactory {
    private static TableDao tDao = new TableDao();  
    public static TableDao getInstance(){  
        return tDao;  
    } 


}
