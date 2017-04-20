package com.example.movierulz.sample;

/**
 * Created by devar on 09-03-2017.
 */

import com.example.movierulz.model.DataItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DataProvider {

    public static List<DataItem> dataItemList;
    public static Map<String, DataItem> dataItemMap;
    static {
        dataItemList = new ArrayList<>();
        dataItemMap = new HashMap<>();

        addItem(new DataItem("1", "Fifty Shades Darker", "How the wounded Christian Grey tries to entice a cautious Ana Steele back into his life",
                "Romantic Drama", "Dekalb", "CarMike", "11.15 , 2.15", "Image1.jpg"));

        addItem(new DataItem("2", "Singham 3", "A sequel to Singam II and the third film in the Singam franchise, it stars Suriya, Shruti Haasan and Anushka Shetty in the lead roles.",
                "Entertainer", "Niles", "Imax", "1:50PM , 4.00PM", "Image2.jpg"));

        addItem(new DataItem("3", "Beauty and Beast", "An adaptation of the Disney fairy tale about a monstrous-looking prince and a young woman who fall in love.",
                "Fantasy", "Dekalb", "CarMike", "4.00PM , 7.00PM", "Image3.jpg"));

        addItem(new DataItem("4", "Logan", " American superhero action thriller film featuring the Marvel Comics character Wolverine, played by Hugh Jackman.",
                "Action", "Dekalb", "CarMike", "11.00AM , 1.50PM", "Image4.jpg"));
        addItem(new DataItem("5","Katamarayudu","A man tries to overcome his violent tendencies but is pushed beyond his limits","Action",
                "Wood Ridge","Wood Ridge Schaumburg","6:20PM , 9.20PM","Image5.jpg"));

    }
    private static void addItem(DataItem item) {
        dataItemList.add(item);
        dataItemMap.put(item.getMovieId(), item);
    }


    }
