package pack13_dataProviderInTestNG;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataProvider7 {
    //Getting the data for dataprovider from json file


    @Test(dataProvider = "JSONFileData", dataProviderClass = DataProvider7.class, enabled = false)
    public void printDataFromJson(Object eachActivity) {
        System.out.println(eachActivity);
    }

    @DataProvider(name = "JSONFileData", indices = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    public Object[] getDataFromJSON() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(new File("C:\\Users\\samal\\Downloads\\Activity.json"));
        List activities = mapper.convertValue(jsonNode, new TypeReference<List>() {
        });
        Object[] jsonData = new Object[activities.size()];
        int i = 0;
        for (Object eachActivity : activities) {
            jsonData[i++] = eachActivity;
        }
        return jsonData;
    }


    public List getActivityIdsFromActivityName(String activityName) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Map> activities = objectMapper.convertValue(objectMapper.readTree(new File("C:\\Users\\samal\\Downloads\\Activity.json")), new TypeReference<List>() {
        });
        //Get me the activity ids whose name is 001
        List<Object> activityIds = activities.stream().filter(
                eachActivity -> eachActivity.get("name").equals(activityName)
        ).map(eachFilteredAct -> eachFilteredAct.get("id")).collect(Collectors.toList());
        return activityIds;
    }

    @Test
    public void printActivityIdsFromActivityName() throws IOException {
        System.out.println(getActivityIdsFromActivityName("001"));
    }
}
