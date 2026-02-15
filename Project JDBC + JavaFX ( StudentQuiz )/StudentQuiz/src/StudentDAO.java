import java.sql.*;

public class StudentDAO {

    public static boolean validateStudent(String id) throws Exception {

        Connection con = DBConnection.getConnection();

        PreparedStatement ps =
            con.prepareStatement(
            "SELECT * FROM student WHERE student_id=?");

        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();

        return rs.next();
    }
}
