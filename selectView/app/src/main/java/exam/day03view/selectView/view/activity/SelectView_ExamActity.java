package exam.day03view.selectView.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import exam.day03view.selectView.R;
import exam.day03view.selectView.view.adapter2.ActorItem;
import exam.day03view.selectView.view.adapter2.ExamAdapter;

public class SelectView_ExamActity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_view__exam_actity);
        ListView listview = findViewById(R.id.exam_listView);
        ActorItem actorItem;
        ArrayList<ActorItem> actorlist = new ArrayList<ActorItem>();
        actorItem = new ActorItem(R.drawable.ansoccer,"안정환","2020/04/06","멋져");
        actorlist.add(actorItem);
        actorItem = new ActorItem(R.drawable.chasoccer,"차범근","2020/04/06","아들~~");
        actorlist.add(actorItem);
        actorItem = new ActorItem(R.drawable.jjangkim,"김어준","2020/04/06","찐");
        actorlist.add(actorItem);
        actorItem = new ActorItem(R.drawable.kbr,"김범룡","2020/04/06","진짜가수");
        actorlist.add(actorItem);
        actorItem = new ActorItem(R.drawable.android,"김서연","2020/04/06","이뻐");
        actorlist.add(actorItem);
        actorItem = new ActorItem(R.drawable.kimdong,"이민호","2020/04/06","멋져");
        actorlist.add(actorItem);
        actorItem = new ActorItem(R.drawable.leemin,"이민호","2020/04/06","멋져");
        actorlist.add(actorItem);
        actorItem = new ActorItem(R.drawable.parksoccer,"박지성","2020/04/06","멋져");
        actorlist.add(actorItem);
        actorItem = new ActorItem(R.drawable.ansoccer,"안정환","2020/04/06","멋져");
        actorlist.add(actorItem);
        actorItem = new ActorItem(R.drawable.chasoccer,"차범근","2020/04/06","아들~~");
        actorlist.add(actorItem);
        actorItem = new ActorItem(R.drawable.jjangkim,"김어준","2020/04/06","찐");
        actorlist.add(actorItem);
        actorItem = new ActorItem(R.drawable.kbr,"김범룡","2020/04/06","진짜가수");
        actorlist.add(actorItem);
        actorItem = new ActorItem(R.drawable.android,"김서연","2020/04/06","이뻐");
        actorlist.add(actorItem);
        actorItem = new ActorItem(R.drawable.kimdong,"이민호","2020/04/06","멋져");
        actorlist.add(actorItem);
        actorItem = new ActorItem(R.drawable.leemin,"이민호","2020/04/06","멋져");
        actorlist.add(actorItem);
        actorItem = new ActorItem(R.drawable.parksoccer,"박지성","2020/04/06","멋져");
        actorlist.add(actorItem);

        ExamAdapter adapter = new ExamAdapter(this, R.layout.exam_custrow, actorlist);

        listview.setAdapter(adapter);
    }
}
