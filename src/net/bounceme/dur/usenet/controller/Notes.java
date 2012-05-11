package net.bounceme.dur.usenet.controller;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "notes", catalog = "nntp", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notes.findAll", query = "SELECT n FROM Notes n"),
    @NamedQuery(name = "Notes.findById", query = "SELECT n FROM Notes n WHERE n.id = :id"),
    @NamedQuery(name = "Notes.findByGroupId", query = "SELECT n FROM Notes n WHERE n.groupId = :groupId"),
    @NamedQuery(name = "Notes.findByStamp", query = "SELECT n FROM Notes n WHERE n.stamp = :stamp"),
    @NamedQuery(name = "Notes.findByMessageId", query = "SELECT n FROM Notes n WHERE n.messageId = :messageId")})
public class Notes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "GROUP_ID", nullable = false)
    private int groupId;
    @Basic(optional = false)
    @Column(name = "STAMP", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date stamp;
    @Lob
    @Column(name = "NOTE", length = 65535)
    private String note;
    @Basic(optional = false)
    @Column(name = "MESSAGE_ID", nullable = false)
    private int messageId;
    @Basic(optional = false)
    @Lob
    @Column(name = "NEWS_GROUP", nullable = false, length = 65535)
    private String newsGroup;

    public Notes() {
        stamp = new Date();
    }

    public Notes(Long id) {
        this.id = id;
        stamp = new Date();
    }

    public Notes(Long id, int groupId, Date stamp, int messageId, String newsGroup) {
        this.id = id;
        this.groupId = groupId;
        this.stamp = stamp;
        this.messageId = messageId;
        this.newsGroup = newsGroup;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public Date getStamp() {
        return stamp;
    }

    public void setStamp(Date stamp) {
        this.stamp = stamp;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getNewsGroup() {
        return newsGroup;
    }

    public void setNewsGroup(String newsGroup) {
        this.newsGroup = newsGroup;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notes)) {
            return false;
        }
        Notes other = (Notes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.bounceme.dur.usenet.controller.Notes[ id=" + id + " ]";
    }
}
