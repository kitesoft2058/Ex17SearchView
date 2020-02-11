package com.kitesoft.ex17searchview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SearchView searchView; //참조변수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //actionbar메뉴 만드는 작업 메소드..
    //onCreate()실행 후에 자동으로 호출
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar, menu);

        //SearchView를 가지고 있는 MenuItem 얻어오기
        MenuItem item= menu.findItem(R.id.menu_search);
        searchView= (SearchView)item.getActionView();

        //힌트적용하기
        searchView.setQueryHint("input word");

        //소프트키보드의 검색버튼(돋보기모양버튼)을 클릭하는것을
        //듣는 리스너 추가..(검색창에 글씨변경할때 마다)
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(MainActivity.this, query, Toast.LENGTH_LONG).show();

//                searchView.setQuery("",true);//서치뷰 글씨 지우기
//                searchView.setIconified(true);//돋보기 모양으로 바꾸기!
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });



        return super.onCreateOptionsMenu(menu);
    }
}
