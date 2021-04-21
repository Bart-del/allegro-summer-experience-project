package pl.bartdel.allegrosummerexperience.service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GitHubDataProvider {

    private HttpResponse<JsonNode> getJSON(String user) throws UnirestException {
        HttpResponse<JsonNode> jsonResponse
                = Unirest.get("https://api.github.com/users/" + user + "/repos")
                .header("accept", "application/json")
                .asJson();
        return jsonResponse;
    }

    private int countStars(HttpResponse<JsonNode> repos){
        return 0;
    }

    private ArrayList<String> getReposList(HttpResponse<JsonNode> jsonNodeHttpResponse){
        JSONArray array = jsonNodeHttpResponse.getBody().getArray();
        ArrayList<String> reposList = new ArrayList<>();
        for(int i = 0; i < array.length(); i++){
            reposList.add(array.getJSONObject(i).getString("name"));
        }
        return reposList;
    }

    private String formatDataToJSON(int stars, ArrayList reposList){
        return "placeholder";
    }

    public String getData(String user) throws UnirestException {
        HttpResponse<JsonNode> response = getJSON(user);
        return formatDataToJSON(countStars(response), getReposList(response));

    }

}
