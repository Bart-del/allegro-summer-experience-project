package pl.bartdel.allegrosummerexperience.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.bartdel.allegrosummerexperience.service.GitHubDataProvider;

@RestController
@RequestMapping(value="/api/", produces = { MediaType.APPLICATION_JSON_VALUE })
public class GitHubDataController {

    private final GitHubDataProvider gitHubDataProvider;

    GitHubDataController(GitHubDataProvider gitHubDataProvider){
        this.gitHubDataProvider = gitHubDataProvider;
    }

    @GetMapping(value="/github_data")
    public ResponseEntity<?> getUserData(@RequestParam(value = "user") String user) {
        try {
            return new ResponseEntity<>(gitHubDataProvider.getData(user), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
