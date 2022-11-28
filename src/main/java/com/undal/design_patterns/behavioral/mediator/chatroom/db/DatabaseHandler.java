package com.undal.design_patterns.behavioral.mediator.chatroom.db;
import com.undal.design_patterns.behavioral.mediator.chatroom.model.AppUser;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class DatabaseHandler {
    private static Logger logger;
    private final static String DB_URL="jdbc:sqlite:identifier.sqlite";

    public Optional<AppUser> getUser(String id){
        try(Statement stm = getConnection().createStatement()){
            ResultSet rs = stm.executeQuery(SqlQueries.SELECT_FROM_APP_USER_WHERE_USERID);
            Optional<AppUser> user = Optional.empty();
            while(rs.next()){
                user = Optional.of(new AppUser(rs.getString(1), rs.getString(2)));
            }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Optional<AppUser>> getAllUsers(String roomId){
        try(PreparedStatement preparedStatement = getConnection().prepareStatement(SqlQueries.SELECT_USERS_WHERE_ROOMID)){
            preparedStatement.setString(1, roomId);
            ResultSet rs = preparedStatement.executeQuery();
            List<Optional<AppUser>> users = new ArrayList<>();
            while(rs.next()){
               users.add(Optional.of(new AppUser(rs.getString(1), rs.getString(2))));
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteUser(String userid){
        try(Statement stm = getConnection().createStatement()){
            ResultSet rs = stm.executeQuery(SqlQueries.SELECT_FROM_APP_USER_WHERE_USERID);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
    //    private ResultSet getResults(String query){
//        try(Statement stm = getConnection().createStatement()){
//
//            logger.fine(query);
//        }catch (SQLException e){
//            logger.severe(e.getMessage());
//            throw new RuntimeException(e);
//        }
//    }
    private Connection getConnection(){
        Connection connection;
        try{
            connection = DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
