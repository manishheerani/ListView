package com.example.manish.listexample;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.manish.listexample.model.Member;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<Member> list;
    Context context;
    MyAdapter adapter;
    ListView mList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getString(R.string.main_screen_name));

        context = this;
        mList =(ListView) findViewById(R.id.member_list);
        list = getMemberData();

        adapter = new MyAdapter(this,list);
        mList.setAdapter(adapter);
    }
    private ArrayList<Member> getMemberData()
    {
        ArrayList<Member> temp_list = new ArrayList<>();
        for(int i=0;i<10;i++)
        {
            Member temp_member = new Member("Laxman","24","Male",null,"9999888823");
            temp_list.add(temp_member);
        }
        return temp_list;
    }

    public class MyAdapter extends BaseAdapter {
        private LayoutInflater inflater;
        private Activity activity;
        private List<Member> memberList;
        public MyAdapter(Activity activity, List<Member> forumTopicsList) {

            this.activity = activity;
            this.memberList = forumTopicsList;
        }

        @Override
        public int getCount() {

            return memberList.size();
        }

        @Override
        public Object getItem(int position) {

            return memberList.get(position);
        }

        @Override
        public long getItemId(int position) {

            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (inflater == null)
                inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            ViewMemberHolder v=new ViewMemberHolder();
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.member_list_item, parent, false);
                v.member_name = (TextView) convertView.findViewById(R.id.member_name);
                v.member_image = (ImageView) convertView.findViewById(R.id.member_image);
                v.member_moblie_number = (TextView) convertView.findViewById(R.id.member_number);
                convertView.setTag(v);

            }
            else
            {
                v=(ViewMemberHolder)convertView.getTag();
            }
            final Member member = memberList.get(position);
            v.member_name.setText(member.getName());
            v.member_moblie_number.setText(member.getContact_number());
            return convertView;
        }
    }
    class ViewMemberHolder{
        TextView member_name;
        ImageView member_image;
        TextView member_moblie_number;
    }
}
