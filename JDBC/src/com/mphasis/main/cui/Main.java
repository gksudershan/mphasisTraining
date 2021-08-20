package com.mphasis.main.cui;

import sun.dc.pr.PRError;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            //Register the Driver
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

            //Establish Connection
           connection = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-45GJQ8N:1521:orcl1","hr","hrpass");
            System.out.println("Connected");
            connection.setAutoCommit(false);
            CallableStatement callableStatement = connection.prepareCall("{call USER_INSERT_PROC(?,?,?,?,?)}");
            //Query the database
            //preparedStatement = connection.prepareStatement("SELECT FIRST_NAME,LAST_NAME FROM EMPLOYEES WHERE DEPARTMENT_ID=? ");
            /*preparedStatement = connection.prepareStatement("INSERT INTO USERS VALUES(?,?,?,?,?)");*/
            callableStatement.registerOutParameter(1,Types.INTEGER);
            //callableStatement.setInt(1,5);
            callableStatement.setString(2,"Jack");
            callableStatement.setString(3,"Miller");
            callableStatement.setString(4,"3127");
            callableStatement.setString(5,"A");

            //preparedStatement = connection.prepareStatement("UPDATE USERS SET STATUS=? WHERE ID=?");

            //preparedStatement.setString(1,"D");
            //preparedStatement.setInt(2,2);

            //int rowsEffected = preparedStatement.executeUpdate();
            callableStatement.execute();
            if(resultSet!=null) {
                if (resultSet.next()) {
                    System.out.println(resultSet.getString(1));
                }
            }
            connection.commit();
            //preparedStatement.setString(1,"30");

           //resultSet =  preparedStatement.executeQuery();

            if (resultSet != null) {
                while(resultSet.next()){
                    System.out.println(resultSet.getString(1)+" "+resultSet.getString(2));
                }
            }



        } catch (SQLException throwables) {
            throwables.printStackTrace();
            try{
                if(connection!=null && !connection.isClosed()){
                    connection.rollback();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }

        }finally{
            try {
                if(resultSet!=null && !resultSet.isClosed()){
                    resultSet.close();
                }
                if(preparedStatement!=null && !preparedStatement.isClosed()){
                    preparedStatement.close();
                }
                if(connection!=null && !connection.isClosed()){
                    connection.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }










    }
}
