package resources;

import Pojo.AddPlace;
import Pojo.Location;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestDataBuild {

        public static AddPlace addPlacePayload() {
            AddPlace p = new AddPlace();
            p.setAccuracy(50);
            p.setAddress("29, side layout, cohen 09");
            p.setLanguage("French-IN");
            p.setPhone_number("(+91) 983 329 3929");
            p.setWebsite("http://google.com");
            p.setName("Frontline house");
            List<String> types = new ArrayList<String>();
            for (String s : Arrays.asList("shoe park", "shop")) {
                types.add(s);
            }

            p.setTypes(types);
            Location l = new Location();
            l.setLat(-38.383494);
            l.setLng(33.427362);

            return p;
        }
    }
