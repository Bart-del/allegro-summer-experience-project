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
        return Unirest.get("https://api.github.com/users/" + user + "/repos")
        .header("accept", "application/json")
        .asJson();
    }

    private int countReposStars(JSONArray jsonArray){
        int stars = 0;
        for (int i = 0; i < jsonArray.length(); i++){
            stars = stars + jsonArray.getJSONObject(i).getInt("stargazers_count");
        }
        return stars;
    }

    private JSONObject getReposList(JSONArray jsonArray){
        JSONObject reposList = new JSONObject();
        for (int i = 0; i < jsonArray.length(); i++){
            reposList.put(jsonArray.getJSONObject(i).getString("name"), new JSONObject().put("stars", jsonArray.getJSONObject(i).getInt("stargazers_count")));
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
        JSONArray responseJsonArray = getJSON(user).getBody().getArray();
        return formatDataToJSON(countReposStars(responseJsonArray), getReposList(responseJsonArray));
    }

}
