package pl.bartdel.allegrosummerexperience.api;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.bartdel.allegrosummerexperience.service.GitHubDataProvider;

@RestController
@RequestMapping(value="/api/", produces = { MediaType.APPLICATION_JSON_VALUE })
public class GitHubDataController {

    GitHubDataProvider gitHubDataProvider = new GitHubDataProvider();

    @GetMapping(value="/github_data")
    @ResponseBody
    public String getUserData(@RequestParam(value = "user") String user) throws UnirestException {
        return gitHubDataProvider.getData(user);
    }
}
