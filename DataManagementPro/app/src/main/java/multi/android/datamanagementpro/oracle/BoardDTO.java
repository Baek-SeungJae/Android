package multi.android.datamanagementpro.oracle;
import java.sql.Date;
public class BoardDTO {
    private int boardNum;
    private String id;
    private String title;
    private String contents;
    private Date writeDate;
    private int point;

    public BoardDTO() {
    }

    //insert¿ë
    public BoardDTO(String id, String title, String contents) {
        super();
        this.id = id;
        this.title = title;
        this.contents = contents;
    }

    //select¿ë
    public BoardDTO(int boardNum, String id, String title, String contents, Date writeDate, int point) {
        super();
        this.boardNum = boardNum;
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.writeDate = writeDate;
        this.point = point;
    }

    public String toString() {
        return "BoardDTO [boardNum=" + boardNum + ", id=" + id + ", title=" + title + ", contents=" + contents
                + ", writeDate=" + writeDate + ", point=" + point + "]";
    }

    public int getBoardNum() {
        return boardNum;
    }

    public Date getWriteDate() {
        return writeDate;
    }

    public int getPoint() {
        return point;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    ;
}
