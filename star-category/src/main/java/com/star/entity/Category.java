package com.star.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 分类(Category)实体类
 *
 * @author makejava
 * @since 2022-06-01 16:10:38
 */

@JsonInclude(JsonInclude.Include.NON_NULL)//用来指定类上  用来指定json数据中包含哪些数据   只要不为空的
public class Category implements Serializable {
    private static final long serialVersionUID = -42855511870315155L;


    private List<Category> children;
    private Integer id;
    /**
     * 名称
     */
    private String name;

    public List<Category> getChildren() {
        return children;
    }

    public void setChildren(List<Category> children) {
        this.children = children;
    }

    /**
     * 父级分类id
     */
    //不仅适用序列化，还适用反序列化
    @JsonProperty("parent_id")
    private Integer parentId;
    
    private Date createdAt;
    
    private Date updatedAt;
    
    private Date deletedAt;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

}

