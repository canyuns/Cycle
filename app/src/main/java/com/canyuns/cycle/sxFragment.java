package com.canyuns.cycle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class sxFragment extends ListFragment{
	private ListView listView;
	private SimpleAdapter simpleAdapter;
    private ImageView  imgA;
    private TextView txtA;

    @Override  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);
    }

    @Override  
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  
            Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_details, container, false);

        listView = (ListView) v.findViewById(android.R.id.list);
        imgA =(ImageView) getActivity().findViewById(R.id.animal);
        txtA = (TextView) getActivity().findViewById(R.id.cn_word);
        
        List<Map<String, Object>> items = new ArrayList<>();
        for (int i = 0; i < routeStrings.TITLES_sx.length; i++) {
            Map<String, Object> item = new HashMap<>();
            item.put("image", routeStrings.ICONS_sx[i]);
            item.put("text", routeStrings.TITLES_sx[i]);
            items.add(item);
        }
        
        simpleAdapter = new SimpleAdapter(getActivity(), items, R.layout.route_list,
                new String[]{"image", "text"}, new int[]{R.id.animal, R.id.cn_word});
        listView.setAdapter(simpleAdapter);

        return v;  
    }  
      
    @Override  
    public void onListItemClick(ListView l, View v, int position, long id) {
        showDetails(position);
    }  	
    
    /**
     * Helper function to show the details of a selected item, either by
     * displaying a fragment in-place in the current UI, or starting a
     * whole new activity in which it is displayed.
     */
    void showDetails(int index) {
            Intent intent = new Intent();
            intent.setClass(getActivity(), DetailsActivity.class);
            intent.putExtra("index", index+routeStrings.TITLES.length);
            startActivity(intent);
    }
}