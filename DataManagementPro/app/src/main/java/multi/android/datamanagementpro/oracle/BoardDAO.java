package multi.android.datamanagementpro.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDAO {
    BoardDAO() {
    }
    public int insert(BoardDTO board) {
        System.out.println("dto사용메소드:" + board);
        String sql = "insert into tb_board values(board_seq.nextval,?,?,?,sysdate,0)";
        Connection con = null;
        PreparedStatement ptmt = null;
        int result = 0;
        try {
            con = DBUtil.getConnect();
            ptmt = con.prepareStatement(sql);
            ptmt.setString(1, board.getId());
            ptmt.setString(2, board.getTitle());
            ptmt.setString(3, board.getContents());
            result = ptmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("연결 실패" + e.getMessage());
            e.printStackTrace(); // 오류추적
        } finally {
            DBUtil.close(con, ptmt, null);
        }
        return result;
    }

    public int insert(String id, String title, String content) {
        //String sql = "insert into tb_board values(board_seq.nextval,'"+id+"','"+title+"','"+content+"',sysdate,0)";
        String sql = "insert into tb_board values(board_seq.nextval,?,?,?,sysdate,0)";
        Connection con = null;
        PreparedStatement ptmt = null;
        int result = 0;
        try {
            con = DBUtil.getConnect();
            ptmt = con.prepareStatement(sql);
            ptmt.setString(1, id);
            ptmt.setString(2, title);
            ptmt.setString(3, content);
            result = ptmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("연결 실패" + e.getMessage());
            e.printStackTrace(); // 오류추적
        } finally {
            DBUtil.close(con, ptmt, null);
        }
        return result;
    }

    public int update(String id, int num) {
        String sql = "update tb_board set id=? where boardnum=?";
        PreparedStatement ptmt = null;
        Connection con = null;
        int result = 0;
        try {
            con = DBUtil.getConnect();
            ptmt = con.prepareStatement(sql);
            ptmt.setString(1, id);
            ptmt.setInt(2, num);
            result = ptmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(con, ptmt, null);
        }
        return result;
    }

    public int delete(int num) {
        String sql = "delete from tb_board where boardnum=?";
        PreparedStatement ptmt = null;
        Connection con = null;
        int result = 0;
        try {
            con = DBUtil.getConnect();
            ptmt = con.prepareStatement(sql);
            ptmt.setInt(1, num);
            result = ptmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(con, ptmt, null);
        }
        return result;
    }


    public ArrayList<BoardDTO> select() {
        ArrayList<BoardDTO> boardlist = new ArrayList<BoardDTO>(); // 전체 게시글을 담을 Collection
        BoardDTO board = null;    // 조회한 게시글을 담을 객체
        String sql = "select * from tb_board";
        Connection con = null;
        PreparedStatement ptmt = null;
        ResultSet rs = null;
        try {
            con = DBUtil.getConnect();
            ptmt = con.prepareStatement(sql);
            rs = ptmt.executeQuery();
            while (rs.next()) {
                board = new BoardDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getInt(6));
                boardlist.add(board);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(con, ptmt, rs);
        }
        return boardlist;
    }

    public BoardDTO read(int boardnum) {
        BoardDTO board = null;
        String sql = "select * from tb_board where boardNum=?";
        Connection con = null;
        PreparedStatement ptmt = null;
        ResultSet rs = null;
        boolean nullcheck = false;
        try {
            con = DBUtil.getConnect();
            ptmt = con.prepareStatement(sql);
            ptmt.setInt(1, boardnum);
            rs = ptmt.executeQuery();
            while (rs.next()) {
                board = new BoardDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getInt(6));
                nullcheck = true;
            }
            if (!nullcheck) {
                System.out.println("조회된 게시물이 없습니다.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(con, ptmt, rs);
        }
        return board;
    }

    public ArrayList<BoardDTO> findByTitle(String title) {
        ArrayList<BoardDTO> boardlist = new ArrayList<BoardDTO>(); // 전체 게시글을 담을 Collection
        BoardDTO board = null;    // 조회한 게시글을 담을 객체
        // 데이터를 조회하는 작업을 하는 곳이 while문 내부이므로 while에서 객체를 생성
        // while문에서 조회된 레코드로 객체를 생성
        String sql = "select * from tb_board where title like ?";
        Connection con = null;
        PreparedStatement ptmt = null;
        ResultSet rs = null;
        boolean nullcheck = false;
        try {
            con = DBUtil.getConnect();
            ptmt = con.prepareStatement(sql);
            ptmt.setString(1, "%" + title + "%");
            rs = ptmt.executeQuery();
            while (rs.next()) {
                board = new BoardDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getInt(6));
                boardlist.add(board);
                nullcheck = true;
            }
            if (!nullcheck) {
                System.out.println("조회된 게시물이 없습니다.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(con, ptmt, rs);
        }
        return boardlist;
    }
}
