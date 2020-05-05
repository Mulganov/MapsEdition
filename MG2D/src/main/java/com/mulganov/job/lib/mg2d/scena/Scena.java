package com.mulganov.job.lib.mg2d.scena;

import android.content.Context;

import com.mulganov.job.lib.mg2d.graph.Graph;

import java.util.ArrayList;
import java.util.HashMap;

public class Scena {
    private HashMap<String, Graph> map = new HashMap<>();

    private Context context;

    public Scena(Context context){
        this.context = context;
    }

    public void add(Graph graph){
        if (map.containsKey(graph.getKey())){
            System.out.println("[ERROR] -> [Scena] -> [add] -> графика с таким ключов уже существует -> key: " + graph.getKey());
            assert map.containsKey(graph.getKey());
        }
        graph.setIndex(map.size());
        map.put(graph.getKey(), graph);
    }

    public void delete(Graph graph){
        map.remove(graph.getKey());
    }


    public Graph get(int index){
        for (String key: map.keySet()){
            Graph graph = map.get(key);
            if (graph.getIndex() == index){
                return graph;
            }
        }
        return null;
    }

    public Graph get(String key){
        return map.get(key);
    }
}
