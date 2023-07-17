package com.xiafish.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserComment {
    private Integer userCommentId;
    private Integer buyerId;
    private Integer sellerId;
    private String userCommentContent;

    @Override
    public String toString() {
        return "UserComment{" +
                "userCommentId=" + userCommentId +
                ", buyerId=" + buyerId +
                ", sellerId=" + sellerId +
                ", userCommentContent='" + userCommentContent + '\'' +
                '}';
    }

    public Integer getUserCommentId() {
        return userCommentId;
    }

    public void setUserCommentId(Integer userCommentId) {
        this.userCommentId = userCommentId;
    }

    public Integer getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Integer buyerId) {
        this.buyerId = buyerId;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public String getUserCommentContent() {
        return userCommentContent;
    }

    public void setUserCommentContent(String userCommentContent) {
        this.userCommentContent = userCommentContent;
    }
}
