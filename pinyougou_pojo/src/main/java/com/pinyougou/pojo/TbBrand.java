package com.pinyougou.pojo;

import java.io.Serializable;

public class TbBrand implements Serializable {
    private Long id;
    private String name;
    private String firstChar;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TbBrand{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", firstChar='").append(firstChar).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstChar() {
        return firstChar;
    }

    public void setFirstChar(String firstChar) {
        this.firstChar = firstChar;
    }
}
