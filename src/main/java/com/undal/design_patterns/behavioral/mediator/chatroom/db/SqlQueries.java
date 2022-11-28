package com.undal.design_patterns.behavioral.mediator.chatroom.db;

public class SqlQueries {
    public final static String SELECT_FROM_APP_USER_WHERE_USERID =
            "SELECT * FROM AppUser WHERE userid = ?;";
    public static final String SELECT_USERS_WHERE_ROOMID =
            "select r.roomid, roomName, u.userid, u.username\n" +
                    "from joinedUsers\n" +
                    "    inner join room r on joinedUsers.roomid = r.roomId\n" +
                    "    inner join user u on u.userid = joinedUsers.userid\n" +
                    "where joinedUsers.roomid = ?;";
}
