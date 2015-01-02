package io.sixth.imgur9000.model;

/**
 * Created by walle on 01/01/15.
 */
public class Imgur {
    private final String API = "https://api.imgur.com/3/";
    private String apiCall;

    public Imgur() {
        apiCall = API;
    }

    public Imgur gallery () {
        apiCall = apiCall.concat("gallery/");
        return this;
    }

    public Imgur reddit (String subreddit) {
        apiCall = apiCall.concat("r/"+subreddit);
        return this;
    }

    public Imgur defaultView() {
        apiCall = apiCall.concat("hot/viral/0.json");
        return this;
    }

    public String getUrl() {
        return this.apiCall;
    }

}
