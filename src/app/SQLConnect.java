package app;
import java.sql.*;
import java.util.*;
import java.util.logging.*;

public class SQLConnect {
    public Connection conn;
    public Statement stmt;
    public ResultSet rs;
    
    public SQLConnect(){
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:chinook.db");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
    }
    /**
     * Method to issue SQL SELECT query
     * @param columnsArray The columns, for which we want data
     * @param table The table, from which we want data
     * @return Dynamic array with data from the query
     */
    public ArrayList<String> select(String[] columnsArray, String table){
        ArrayList data = new ArrayList<String>();
        String columns = String.join(", ", columnsArray);
        String sql = "SELECT " + columns + " FROM " + table;

        try{
            System.out.println(sql);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                String row = "";
                for (int i = 0; i < columnsArray.length; i++) {
                    row = row + rs.getString(columnsArray[i])+"---";
                }
                row=row.substring(0, row.length()-3);
                data.add(row);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return data;
    }
    /**
     * Method to issue SQL SELECT WHERE query
     * @param columnsArray The columns, for which we want data
     * @param table The table, from which we want data
     * @param whereColumn For which columns to search for
     * @param whereValue Which values to search for
     * @return Dynamic array with data from the query
     */
    public ArrayList<String> selectWhere(String[] columnsArray, String table, String whereColumn, String whereValue){
        ArrayList data = new ArrayList<String>();
        String columns = String.join(", ", columnsArray);
        String sql = "SELECT " + columns + " FROM " + table 
                + " WHERE " + whereColumn + " LIKE '" + whereValue+"'";

        try{
            System.out.println(sql);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                String row = "";
                for (int i = 0; i < columnsArray.length; i++) {
                    row = row + rs.getString(columnsArray[i])+"---";
                }
                row=row.substring(0, row.length()-3);
                data.add(row);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return data;
    }
    /**
     * Method to issue SQL SELECT WHERE query
     * @param columnsArray The columns, for which we want data
     * @param table The table, from which we want data
     * @param whereColumns For which columns to search for
     * @param whereValues Which values to search for
     * @return Dynamic array with data from the query
     */
    public ArrayList<String> selectWhereOr(String[] columnsArray, String table, String[] whereColumns, String[] whereValues){
        ArrayList data = new ArrayList<String>();
        String columns = String.join(", ", columnsArray);
        
        String sql = "SELECT " + columns + " FROM " + table + " WHERE ";
        
        for (int i = 0; i < whereColumns.length; i++) {
            sql=sql+whereColumns[i]+" LIKE '" + whereValues[i]+"' OR ";
        }
        sql=sql.substring(0,sql.length()-4);
        try{
            System.out.println(sql);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                String row = "";
                for (int i = 0; i < columnsArray.length; i++) {
                    row = row + rs.getString(columnsArray[i])+"---";
                }
                row=row.substring(0, row.length()-3);
                data.add(row);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return data;
    }
    
    /**
     * Method to issue SQL SELECT WHERE query
     * @param columnsArray The columns, from which we want data
     * @param table The table, from which we want data
     * @param whereCols In which columns to search for
     * @param whereValues Which values to search for
     * @return Dynamic array with data from the query
     */
    public ArrayList<String> selectWhereAnd(String[] columnsArray, String table, String[] whereCols, String[] whereValues){
        ArrayList data = new ArrayList<String>();
        String columns = String.join(", ",columnsArray);

        String sql = "SELECT " + columns + " FROM " + table + " WHERE ";
        
        for(int i=0; i<whereCols.length; i++){
            sql = sql + whereCols[i] + " LIKE '" + whereValues[i] + "' AND ";
        }
        sql = sql.substring(0,sql.length()-5);
        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            System.out.println(sql);
            while(rs.next()){
                String row="";
                for (int i = 0; i < columnsArray.length; i++) {
                    row+=rs.getString(columnsArray[i])+"---";
                }
                row=row.substring(0, row.length()-3);
               data.add(row);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return data;
    }
    
    public ArrayList<String> selectOrderBy(String[] columnsArray, String table){
        ArrayList data = new ArrayList<String>();
        
        String columns = String.join(", ",columnsArray);

        String sql = "SELECT " + columns + " FROM " + table;
        
        System.out.println(sql);
        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while(rs.next()){
                String row = "";
                for (int i = 0; i < columnsArray.length; i++) {
                    row = row + rs.getString(columnsArray[i]) + "---";
                    
                }
                row = row.substring(0, row.length()-3);
                System.out.println(row);
                data.add(row);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return data;
    }
    
    public ArrayList<String> selectGroupBy(String[] columnsArray, String table, String GroupCol){
        ArrayList<String> data = new ArrayList<String>();
        
        String columns = String.join(", ",columnsArray);

        String sql = "SELECT " + columns + " FROM " + table + " GROUP BY " + GroupCol;

        System.out.println(sql);
        
        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while(rs.next()){
                String row = "";
                for (int i = 0; i < columnsArray.length; i++) {
                    row = row + rs.getString(columnsArray[i]) + "---";
                    
                }
                row = row.substring(0, row.length()-3);
                data.add(row);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return data;
    }
    
     /**
     * Method to issue INSERT query
     * @param table In which table to add values
     * @param columnsArray In which columns to add values
     * @param valuesArray Which values to add
     */
    public void insert(String table, String[] columnsArray, String[] valuesArray){
        String columns = String.join(", ", columnsArray);
        String values = String.join("', '", valuesArray);
        String sql = "Insert into " + table + " ("+columns+") values ('"+values+"')";

        System.out.println(sql);
        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * Method to issue UPDATE query
     * @param table In which table to change data
     * @param columnsArray For which columns the data will be affected
     * @param valuesArray Which values will be changed
     * @param whereCol For which column to search for a match
     * @param whereVal What match to search for
     */
    public void update(String table, String[] columnsArray, String[] valuesArray, String whereCol, String whereVal){
        String sql = "update "+ table + " set ";
        for (int i = 0; i < columnsArray.length; i++) {
            sql=sql+columnsArray[i]+" = '"+valuesArray[i]+"', ";
        }
        sql=sql.substring(0, sql.length()-2);
        sql = sql + " WHERE "+ whereCol + " = '"+whereVal+"'";
        System.out.println(sql);
        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(String table, String whereCol, String whereValue){
        String sql = "DELETE FROM " + table + " WHERE "+
                whereCol + " LIKE '"+whereValue+"'";
        try{
            System.out.println(sql);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * Closes database connection
     */
    public void close(){
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Throwable ex) {
            Logger.getLogger(SQLConnect.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
