package pl.bartdel.allegrosummerexperience.service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;


@Service
public class GitHubDataProvider {

    private HttpResponse<JsonNode> getJSON(String user) throws UnirestException {
        HttpResponse<JsonNode> jsonResponse
                = Unirest.get("https://api.github.com/users/" + user + "/repos")
                .header("accept", "application/json")
                .asJson();
        return jsonResponse;
    }

    private int countStars(HttpResponse<JsonNode> jsonNodeHttpResponse){
        int stars = 0;
        JSONArray array = jsonNodeHttpResponse.getBody().getArray();
        for(int i = 0; i < array.length(); i++){
            stars = stars + array.getJSONObject(i).getInt("stargazers_count");
        }
        return stars;
    }

    private JSONObject getReposList(HttpResponse<JsonNode> jsonNodeHttpResponse){
        JSONArray array = jsonNodeHttpResponse.getBody().getArray();
        JSONObject reposList = new JSONObject();
        for(int i = 0; i < array.length(); i++){
            reposList.put(array.getJSONObject(i).getString("name"), new JSONObject().put("stars", array.getJSONObject(i).getInt("stargazers_count")));
        }
        return reposList;
    }

    private String formatDataToJSON(int stars, JSONObject reposList){
        JSONObject jsonBuilder = new JSONObject();

        jsonBuilder.put("repositories",reposList);
        jsonBuilder.put("sum_of_all_stars",stars);
        return jsonBuilder.toString();
    }

    public String getData(String user) throws UnirestException {
        HttpResponse<JsonNode> response = getJSON(user);
        return formatDataToJSON(countStars(response), getReposList(response));

    }

}
