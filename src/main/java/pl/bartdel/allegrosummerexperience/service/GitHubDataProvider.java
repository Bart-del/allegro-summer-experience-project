package pl.bartdel.allegrosummerexperience.service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Service;

@Service
public class GitHubDataProvider {


    public String getData(String user) throws UnirestException {
        HttpResponse<JsonNode> jsonResponse
                = Unirest.get("https://api.github.com/users/" + user + "/repos")
                .header("accept", "application/json")
                .asJson();
        return jsonResponse.getBody().getArray().toString();

        }

    }
