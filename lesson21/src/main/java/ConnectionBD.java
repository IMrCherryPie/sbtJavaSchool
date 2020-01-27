import java.sql.*;
import java.util.Objects;

public class ConnectionBD {

    public static void main(String[] args) throws SQLException {

//        Statement statement = getStatement();
//        createTables(statement);
//        addRecordToStudents("Efim","Alexandrovich");
//        showRecord("Students");
//        showRecordForName("Students", "name", "Efim");
    }

    private static void addRecordToStudents(String name_, String lastName) throws SQLException {

        Objects.requireNonNull(getStatement()).executeUpdate("insert into Students(name,lastname) values('" + name_ + "','" + lastName + "')");

    }

    private static void addRecordToLessons(String lectureTitle, String date) throws SQLException {

        Objects.requireNonNull(getStatement()).executeUpdate("insert into Lessons(lecture_title,date_) values('" + lectureTitle + "','" + date + "')");

    }

    private static void addRecordToStudentsVisit(String studentID_, String lessonID_) throws SQLException {

        Objects.requireNonNull(getStatement()).executeUpdate("insert into user(studentID,lessonID) values('" + studentID_ + "','" + lessonID_ + "')");

    }

    private static void showRecord(String nameTable) throws SQLException {

        ResultSet result = Objects.requireNonNull(getStatement()).executeQuery("select * from "+nameTable+"");
        while (result.next()){
            System.out.println(result.getString(2) +"       "+ result.getString(3));
        }

    }

    private static void showRecordForName(String nameTable, String nameCollomn, String value) throws SQLException {

        String str = "select * from "+nameTable+" where "+nameCollomn+" = '"+value+"' ";
        ResultSet result = Objects.requireNonNull(getStatement()).executeQuery(str);
        while (result.next()){
            System.out.println(result.getString(2) +"       "+ result.getString(3));
        }

    }

    private static Statement getStatement() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "SA", "");
        return conn.createStatement();
    }

    private static void createTables(Statement statement) throws SQLException {
        statement.execute("create table Students (id integer primary key auto_increment, name varchar(15) NOT NULL, lastName varchar(15) NOT NULL);");
        statement.execute("create table  Lessons (id integer primary key auto_increment, Lecture_title varchar(25) not null, date_ date not null);");
        statement.execute("create table  StudentVisit (id integer primary key auto_increment, StudentId integer not null, LessonId integer not null);");

        statement.execute("alter table StudentVisit add FOREIGN KEY (StudentId) REFERENCES Students(id)");
        statement.execute("alter table StudentVisit add FOREIGN KEY (LessonId) REFERENCES Lessons(id)");
    }

    /*private static void addRecord(String nameTable, String value1, String value2) throws ClassNotFoundException, SQLException {
        Objects.requireNonNull(connectBDUniversity()).executeUpdate("INSERT INTO nameTable values (" + value1 +"," +  value2 + "");
    }*/

    /*private static Statement connectBDUniversity() throws ClassNotFoundException {
        String instanceName = "DESKTOP-JENO8RR";
        String databaseName = "University";
        String userName = "sa";
        String pass = "";
        String connectionUrl = "jdbc:sqlserver://%1$s;databaseName=%2$s;user=%3$s;password=%4$s;";
        String connectionString = String.format(connectionUrl, instanceName, databaseName, userName, pass);
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (Connection con = DriverManager.getConnection(connectionString); Statement statement = con.createStatement()) {
            // Подключение к базе данных
            System.out.println("Successfully");
            return statement;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }*/

}
