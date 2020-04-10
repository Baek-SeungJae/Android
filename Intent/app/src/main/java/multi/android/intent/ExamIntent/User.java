package multi.android.intent.ExamIntent;

import android.os.Parcel;
import android.os.Parcelable;

//안드로이드에서 인텐트에 객체를 공유하고 싶은 경우
public class User implements Parcelable {
    String name;
    String telNum;
    public User(Parcel in){
        name = in.readString();
        telNum = in.readString();
    }
    //안드로이드 OS가 객체를 복원할 때 Creator 타입의 변수 CREATOR를 찾아서 CREATOR의 createFromParcel를 호출한 후 변환되는 값을 이용해서 사용
    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    //객체를 인텐트에 담을 때 자동으로 호추되는 메소드
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(telNum);
    }
}
