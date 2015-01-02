
package io.sixth.imgur9000.api;

import java.util.List;

public class ImgurResponse{
    private List<ImgurData> data;
    private Number status;
    private boolean success;

    public List<ImgurData> getData(){
        return this.data;
    }
    public Number getStatus(){
        return this.status;
    }
    public boolean isSuccess(){
        return this.success;
    }
}
