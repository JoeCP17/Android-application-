package com.example.memopay_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity3 extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    TextView txt1, txt2, txt3, txt4, txt5, txt6;
    LinearLayout cont1, cont2, cont3, cont4, cont5;
    Space sp1;
    TabLayout tabs;

    private TextView tvDate;
    private GridAdapter gridAdapter;
    private ArrayList<String> dayList;
    private GridView gridView;
    private Calendar mCal;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        Toast toast = Toast.makeText(getApplicationContext(),"",Toast.LENGTH_LONG);

        switch(item.getItemId()){
            case R.id.menu1:
                Intent intent1 = new Intent(getApplicationContext(), MainActivity6.class);
                startActivity(intent1);
                break;
            case R.id.menu2:
                Intent intent2 = new Intent(getApplicationContext(), MainActivity4.class);
                startActivity(intent2);
                break;
            case R.id.menu3:
                Intent intent3 = new Intent(getApplicationContext(), MainActivity7.class);
                startActivity(intent3);
                break;
        }
        return super .onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        bottomNavigationView = findViewById(R.id.bottom1);
        tvDate = (TextView)findViewById(R.id.tv_date);
        gridView = (GridView)findViewById(R.id.gridview);

        long now = System.currentTimeMillis();
        final Date date = new Date(now);

        final SimpleDateFormat curYearFormat = new SimpleDateFormat("yyyy", Locale.KOREA);
        final SimpleDateFormat curMonthFormat = new SimpleDateFormat("MM", Locale.KOREA);
        final SimpleDateFormat curDayFormat = new SimpleDateFormat("dd", Locale.KOREA);

        tvDate.setText(curYearFormat.format(date) + "/" + curMonthFormat.format(date));

        dayList = new ArrayList<String>();
        dayList.add("일");
        dayList.add("월");
        dayList.add("화");
        dayList.add("수");
        dayList.add("목");
        dayList.add("금");
        dayList.add("토");
        mCal = Calendar.getInstance();

        mCal.set(Integer.parseInt(curYearFormat.format(date)), Integer.parseInt(curMonthFormat.format(date)) - 1, 1);
        int dayNum = mCal.get(Calendar.DAY_OF_WEEK);

        for (int i = 1; i < dayNum; i++) {
            dayList.add("");
        }
        setCalendarDate(mCal.get(Calendar.MONTH) + 1);

        gridAdapter = new GridAdapter(getApplicationContext(), dayList);
        gridView.setAdapter(gridAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent1 = new Intent(getApplicationContext(), MainActivity5.class);
                startActivity(intent1);
            }
        });

        TextView mon=(TextView)findViewById(R.id.mon);
        TextView heaven=(TextView)findViewById(R.id.heaven);
        TextView in=(TextView)findViewById(R.id.in);

        mon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri= Uri.parse("https://m.albamon.com/?la_gc=CM1B39228515478&la_src=sa&la_cnfg=2591701&gclid=Cj0KCQjwzYGGBhCTARIsAHdMTQzjg_ZCO-6gd40FmQt78Co9YK4EfPbn0ymqG0dH07FcYJsrd6joX-oaAhgoEALw_wcB");
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });

        heaven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri= Uri.parse("http://m.alba.co.kr/Main.asp?utm_source=google&utm_medium=paidsearch&utm_campaign=brand&utm_content=mobile_cpc&utm_term=%EC%95%8C%EB%B0%94%EC%B2%9C%EA%B5%AD&gclid=Cj0KCQjwzYGGBhCTARIsAHdMTQz52DRE9tdI0H8lmtNIL1yYwkIOINq8H0ksrzyAgW0m2xd9pHws5qYaAktTEALw_wcB");
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });

        in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri= Uri.parse("https://m.saramin.co.kr/");
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });

        cont4 = findViewById(R.id.container4);
        cont5 = findViewById(R.id.container5);

        tabs = findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("급여"));
        tabs.addTab(tabs.newTab().setText("일정"));
        tabs.addTab(tabs.newTab().setText("급여+일정"));

        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();

                if (position == 0) {
                    cont4.setVisibility(View.VISIBLE);
                    cont5.setVisibility(View.GONE);
                } else if (position == 1) {
                    cont4.setVisibility(View.GONE);
                    cont5.setVisibility(View.VISIBLE);
                } else if (position == 2) {
                    cont4.setVisibility(View.VISIBLE);
                    cont5.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        txt1 = findViewById(R.id.Text1);
        txt2 = findViewById(R.id.Text2);
        txt3 = findViewById(R.id.Text3);
        txt4 = findViewById(R.id.Text4);
        txt5 = findViewById(R.id.Text5);
        txt6 = findViewById(R.id.Text6);

        txt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent1);
            }
        });

        cont1 = findViewById(R.id.container1);
        cont2 = findViewById(R.id.container2);
        cont3 = findViewById(R.id.container3);
        sp1 = findViewById(R.id.space1);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.tab1:
                        cont1.setVisibility(View.VISIBLE);
                        cont2.setVisibility(View.INVISIBLE);
                        cont3.setVisibility(View.INVISIBLE);
                        sp1.setVisibility(View.INVISIBLE);
                        break;
                    case R.id.tab2:
                        cont1.setVisibility(View.INVISIBLE);
                        cont2.setVisibility(View.VISIBLE);
                        cont3.setVisibility(View.INVISIBLE);
                        sp1.setVisibility(View.VISIBLE);
                        break;
                    case R.id.tab3:
                        cont1.setVisibility(View.INVISIBLE);
                        cont2.setVisibility(View.INVISIBLE);
                        cont3.setVisibility(View.VISIBLE);
                        sp1.setVisibility(View.VISIBLE);
                        break;
                }
                return true;
            }
        });

    }
    private void setCalendarDate(int month) {
        mCal.set(Calendar.MONTH, month - 1);

        for (int i = 0; i < mCal.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
            dayList.add("" + (i + 1));
        }

    }
    private class GridAdapter extends BaseAdapter {

        private final List<String> list;

        private final LayoutInflater inflater;


        public GridAdapter(Context context, List<String> list) {
            this.list = list;
            this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public String getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder = null;

            if (convertView == null) {
                convertView = inflater.inflate(R.layout.cal, parent, false);
                holder = new ViewHolder();

                holder.tvItemGridView = (TextView)convertView.findViewById(R.id.tv_item_gridview);

                convertView.setTag(holder);
            } else {
                holder = (ViewHolder)convertView.getTag();
            }
            holder.tvItemGridView.setText("" + getItem(position));


            mCal = Calendar.getInstance();

            Integer today = mCal.get(Calendar.DAY_OF_MONTH);
            String sToday = String.valueOf(today);
            if (sToday.equals(getItem(position))) {
                holder.tvItemGridView.setTextColor(getResources().getColor(R.color.black));
            }
            return convertView;
        }
    }

    private class ViewHolder {
        TextView tvItemGridView;
    }
}