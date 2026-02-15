import java.sql.*;

public class ScoreDAO {

    public static void saveScore(String id, int marks)
            throws Exception {

        Connection con = DBConnection.getConnection();

        PreparedStatement ps =
            con.prepareStatement(
            "INSERT INTO score(student_id,marks) VALUES(?,?)");

        ps.setString(1, id);
        ps.setInt(2, marks);

        ps.executeUpdate();
    }
}
