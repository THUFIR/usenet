package net.bounceme.dur.usenet.swing;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import net.bounceme.dur.usenet.swing.model.MessageBean;

@Entity
@Table(name = "NOTES", catalog = "nntp", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notes.findAll", query = "SELECT n FROM Notes n"),
    @NamedQuery(name = "Notes.findById", query = "SELECT n FROM Notes n WHERE n.id = :id"),
    @NamedQuery(name = "Notes.findByMessageId", query = "SELECT n FROM Notes n WHERE n.messageId = :messageId"),
    @NamedQuery(name = "Notes.findByNewsGroupId", query = "SELECT n FROM Notes n WHERE n.newsGroupId = :newsGroupId"),
    @NamedQuery(name = "Notes.findByStamp", query = "SELECT n FROM Notes n WHERE n.stamp = :stamp")})
public class Notes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "MESSAGE_ID", nullable = false)
    private int messageId;
    @Basic(optional = false)
    @Lob
    @Column(name = "NEWS_GROUP", nullable = false, length = 2147483647)
    private String newsGroup;
    @Basic(optional = false)
    @Column(name = "NEWS_GROUP_ID", nullable = false)
    private long newsGroupId;
    @Lob
    @Column(name = "NOTE", length = 2147483647)
    private String note;
    @Basic(optional = false)
    @Column(name = "STAMP", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date stamp;

    public Notes() {
        stamp = new Date();
    }

    public Notes(MessageBean messageBean) {
        messageId = messageBean.getId();
        newsGroup = messageBean.getGroup();
        note = messageBean.getNote();
        stamp = new Date();
    }

    public Notes(Long id) {
        this.id = id;
        stamp = new Date();
    }

    public Notes(Long id, int messageId, String newsGroup, long newsGroupId, Date stamp) {
        this.id = id;
        this.messageId = messageId;
        this.newsGroup = newsGroup;
        this.newsGroupId = newsGroupId;
        this.stamp = stamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public long getNewsGroupId() {
        return newsGroupId;
    }

    public void setNewsGroupId(long newsGroupId) {
        this.newsGroupId = newsGroupId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getStamp() {
        return stamp;
    }

    public void setStamp(Date stamp) {
        this.stamp = stamp;
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
