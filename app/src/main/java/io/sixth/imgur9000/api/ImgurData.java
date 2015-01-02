
package io.sixth.imgur9000.api;

import java.util.List;

public class ImgurData {
    private Number account_id;
    private String account_url;
    private Number comment_count;
    private String cover;
    private Number cover_height;
    private Number cover_width;
    private Number datetime;
    private String description;
    private Number downs;
    private boolean favorite;
    private String id;
    private Number images_count;
    private boolean is_album;
    private String layout;
    private String link;
    private boolean nsfw;
    private String privacy;
    private Number score;
    private String section;
    private String title;
    private Number ups;
    private Number views;
    private String vote;

    public Number getAccount_id(){
        return this.account_id;
    }
    public void setAccount_id(Number account_id){
        this.account_id = account_id;
    }
    public String getAccount_url(){
        return this.account_url;
    }
    public void setAccount_url(String account_url){
        this.account_url = account_url;
    }
    public Number getComment_count(){
        return this.comment_count;
    }
    public void setComment_count(Number comment_count){
        this.comment_count = comment_count;
    }
    public String getCover(){
        return this.cover;
    }
    public void setCover(String cover){
        this.cover = cover;
    }
    public Number getCover_height(){
        return this.cover_height;
    }
    public void setCover_height(Number cover_height){
        this.cover_height = cover_height;
    }
    public Number getCover_width(){
        return this.cover_width;
    }
    public void setCover_width(Number cover_width){
        this.cover_width = cover_width;
    }
    public Number getDatetime(){
        return this.datetime;
    }
    public void setDatetime(Number datetime){
        this.datetime = datetime;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public Number getDowns(){
        return this.downs;
    }
    public void setDowns(Number downs){
        this.downs = downs;
    }
    public boolean getFavorite(){
        return this.favorite;
    }
    public void setFavorite(boolean favorite){
        this.favorite = favorite;
    }
    public String getId(){
        return this.id;
    }
    public void setId(String id){
        this.id = id;
    }
    public Number getImages_count(){
        return this.images_count;
    }
    public void setImages_count(Number images_count){
        this.images_count = images_count;
    }
    public boolean isAlbum(){
        return this.is_album;
    }
    public void setAlbum(boolean is_album){
        this.is_album = is_album;
    }
    public String getLayout(){
        return this.layout;
    }
    public void setLayout(String layout){
        this.layout = layout;
    }
    public String getLink(){
        return this.link;
    }
    public void setLink(String link){
        this.link = link;
    }
    public boolean getNsfw(){
        return this.nsfw;
    }
    public void setNsfw(boolean nsfw){
        this.nsfw = nsfw;
    }
    public String getPrivacy(){
        return this.privacy;
    }
    public void setPrivacy(String privacy){
        this.privacy = privacy;
    }
    public Number getScore(){
        return this.score;
    }
    public void setScore(Number score){
        this.score = score;
    }
    public String getSection(){
        return this.section;
    }
    public void setSection(String section){
        this.section = section;
    }
    public String getTitle(){
        return this.title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public Number getUps(){
        return this.ups;
    }
    public void setUps(Number ups){
        this.ups = ups;
    }
    public Number getViews(){
        return this.views;
    }
    public void setViews(Number views){
        this.views = views;
    }
    public String getVote(){
        return this.vote;
    }
    public void setVote(String vote){
        this.vote = vote;
    }
}
