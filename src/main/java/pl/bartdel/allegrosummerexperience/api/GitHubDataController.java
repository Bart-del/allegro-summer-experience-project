package pl.bartdel.allegrosummerexperience.api;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.bartdel.allegrosummerexperience.service.GitHubDataProvider;

@RestController
@RequestMapping("/api/")
public class GitHubDataController {

    GitHubDataProvider gitHubDataProvider = new GitHubDataProvider();

    @GetMapping(value="/githubdata")
    @ResponseBody
    public String getUserData(@RequestParam(value = "user") String user) throws UnirestException {
        return gitHubDataProvider.getData(user);
    }
}
