package ru.tinkoff.edu.java.scrapper.domain.jooq.tables.pojos;

import java.beans.ConstructorProperties;
import java.io.Serializable;

import javax.annotation.processing.Generated;

import org.jetbrains.annotations.NotNull;

@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.17.6"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserLink implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long linkId;
    private Long chatId;

    public UserLink() {}

    public UserLink(UserLink value) {
        this.linkId = value.linkId;
        this.chatId = value.chatId;
    }

    @ConstructorProperties({ "linkId", "chatId" })
    public UserLink(
        @NotNull Long linkId,
        @NotNull Long chatId
    ) {
        this.linkId = linkId;
        this.chatId = chatId;
    }

    @jakarta.validation.constraints.NotNull
    @NotNull
    public Long getLinkId() {
        return this.linkId;
    }

    public void setLinkId(@NotNull Long linkId) {
        this.linkId = linkId;
    }

    @jakarta.validation.constraints.NotNull
    @NotNull
    public Long getChatId() {
        return this.chatId;
    }

    public void setChatId(@NotNull Long chatId) {
        this.chatId = chatId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final UserLink other = (UserLink) obj;
        if (this.linkId == null) {
            if (other.linkId != null)
                return false;
        }
        else if (!this.linkId.equals(other.linkId))
            return false;
        if (this.chatId == null) {
            if (other.chatId != null)
                return false;
        }
        else if (!this.chatId.equals(other.chatId))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.linkId == null) ? 0 : this.linkId.hashCode());
        result = prime * result + ((this.chatId == null) ? 0 : this.chatId.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("UserLink (");

        sb.append(linkId);
        sb.append(", ").append(chatId);

        sb.append(")");
        return sb.toString();
    }
}
