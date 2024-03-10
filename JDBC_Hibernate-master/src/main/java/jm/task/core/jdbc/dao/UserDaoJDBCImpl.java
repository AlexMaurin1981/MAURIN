package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

   Connection connection = Util.getConnection();

    public void createUsersTable()  {


       try (Statement statement = connection.createStatement()){
           statement.execute("CREATE TABLE IF NOT EXISTS users (" +

                   "  id BIGINT NOT NULL AUTO_INCREMENT," +

                   "  name VARCHAR(50)," +

                   "  lastName VARCHAR(50)," +

                   "  age SMALLINT," +

                   "  PRIMARY KEY (id));");

       }catch (SQLException e){
          System.out.println(e +"Table create successful by JDBC");
       }


    }

    public void dropUsersTable() {
       try (Statement statement = connection.createStatement()){

        statement.execute("DROP TABLE IF EXISTS users " );

    } catch (SQLException e) {
      System.out.println(e +"Error dropping users");
       }

    }

    public void saveUser(String name, String lastName, byte age) {
        String save = " INSERT INTO users (name, lastName, age) values (?,?,?)";
      try(  PreparedStatement preparedStatement = connection.prepareStatement(save)){
            preparedStatement.setString(1,name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3,age);
            preparedStatement.executeUpdate();

      }catch (SQLException e){
          System.out.println(e + "Error saving user");
      }

    }

    public void removeUserById(long id) {
        String removeID = " DELETE  FROM users where id=? ";

        try ( PreparedStatement preparedStatement = connection.prepareStatement(removeID )){
            preparedStatement.setLong(1,  id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e + "Error removing users" );


        }

    }

    public List<User> getAllUsers() {
        User user = new User();
        List <User> userList = new ArrayList<>();
        String getAll = "SELECT * FROM users ";

       try ( Statement statement= connection.createStatement();
        ResultSet resultSet = statement.executeQuery(getAll)){
           while (resultSet.next()) {
               user.setName(resultSet.getString("name"));
               user.setLastName(resultSet.getString("lastName"));
               user.setAge(resultSet.getByte("age"));
               userList.add(user);
           }
       }catch ( SQLException e){
           System.out.println(e+ "Error getting users");
       }
        return  userList;
    }

    public void cleanUsersTable() {

       try ( Statement statement = connection.createStatement()) {
            statement.executeUpdate("TRUNCATE TABLE users ");
        } catch (SQLException e){
           System.out.println(e + "Error cleaning table");
       }
    }
}
