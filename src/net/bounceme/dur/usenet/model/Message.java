package net.bounceme.dur.usenet.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import net.bounceme.dur.usenet.controller.MessageBean;

@Entity
@Table(name = "message", catalog = "nntp", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Message.findAll", query = "SELECT m FROM Message m"),
    @NamedQuery(name = "Message.findById", query = "SELECT m FROM Message m WHERE m.id = :id")})
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Lob
    @Column(name = "newsgroup", nullable = false, length = 65535)
    private String newsgroup;
    @Basic(optional = false)
    @Lob
    @Column(name = "subject", nullable = false, length = 65535)
    private String subject;
    @Basic(optional = false)
    @Lob
    @Column(name = "content", nullable = false, length = 65535)
    private String content;
    @Basic(optional = false)
    @Lob
    @Column(name = "number", nullable = false, length = 65535)
    private String number;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "messageId")
    private Collection<Comment> commentCollection;

    public Message() {
    }

    public Message(MessageBean mb) {
        newsgroup = mb.getGroup();
        subject = mb.getSubject();
        content = mb.getContent().toString();
        number = Integer.toString(mb.getNumber());
    }

    public Message(Integer id) {
        this.id = id;
    }

    public Message(Integer id, String newsgroup, String subject, String content, String number) {
        this.id = id;
        this.newsgroup = newsgroup;
        this.subject = subject;
        this.content = content;
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNewsgroup() {
        return newsgroup;
    }

    public void setNewsgroup(String newsgroup) {
        this.newsgroup = newsgroup;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @XmlTransient
    public Collection<Comment> getCommentCollection() {
        return commentCollection;
    }

    public void setCommentCollection(Collection<Comment> commentCollection) {
        this.commentCollection = commentCollection;
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
        if (!(object instanceof Message)) {
            return false;
        }
        Message other = (Message) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.bounceme.dur.usenet.model.Message[ id=" + id + " ]";
    }
}
