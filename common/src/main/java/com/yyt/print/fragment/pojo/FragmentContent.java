package com.yyt.print.fragment.pojo;

/**
 * Created by SomeBody on 2016/10/4.
 */
public class FragmentContent {
    private String url;
    private String img;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "FragmentContent{" +
                "url='" + url + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
