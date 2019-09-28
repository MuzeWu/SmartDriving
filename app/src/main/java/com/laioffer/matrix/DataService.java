package com.laioffer.matrix;

import java.util.ArrayList;
import java.util.List;

public class DataService {
    public static List<Event> getEventData(int n) {
        List<Event> eventData = new ArrayList<Event>();
        for (int i = 0; i < n; ++i) {
            eventData.add(
                    new Event("Event" + i, "1184 W valley Blvd, CA 90101",
                            "This is a huge event"));
        }
        return eventData;
    }

}
