package multi.android.jasoseolanalysis;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.List;

import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.KomoranResult;
import kr.co.shineware.nlp.komoran.model.Token;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;
    ProgressFragment pf = new ProgressFragment();
    ResultFragment rf = new ResultFragment();
    MainFragment mf = new MainFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        Komoran komoran = new Komoran(DEFAULT_MODEL.LIGHT);
        String strToAnalyze = "대한민국은 민주공화국이다.";
        KomoranResult analyzeResultList = komoran.analyze(strToAnalyze);
        //editText.append(analyzeResultList.getPlainText()+"\n");
        List<Token> tokenList = analyzeResultList.getTokenList();
        for (Token token : tokenList) {
            //editText.append(token.getBeginIndex()+","+token.getEndIndex()+" "+token.getMorph()+" "+token.getPos()+"\n");
            textView.append(token.getMorph()+" "+token.getPos()+'\n');
        }
        */
    }

    public void sendBtn(View v){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction;
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment,rf);
        transaction.commit();
    }
}
