package net.bounceme.dur.usenet.controller;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "messages", catalog = "nntp", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Messages.findAll", query = "SELECT m FROM Messages m"),
    @NamedQuery(name = "Messages.findById", query = "SELECT m FROM Messages m WHERE m.id = :id")})
public class Messages implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    @GeneratedValue
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
    private Collection<Comments> commentsCollection;

    public Messages() {
    }

    public Messages(Integer id) {
        this.id = id;
    }

    public Messages(MessageBean mb) {
        newsgroup = mb.getGroup();
        subject = mb.getSubject();
        content = mb.getContent().toString();
        number = Integer.toString(mb.getNumber());
    }
    
    
    public Messages(Integer id, String newsgroup, String subject, String content, String number) {
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
    public Collection<Comments> getCommentsCollection() {
        return commentsCollection;
    }

    public void setCommentsCollection(Collection<Comments> commentsCollection) {
        this.commentsCollection = commentsCollection;
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
        if (!(object instanceof Messages)) {
            return false;
        }
        Messages other = (Messages) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.bounceme.dur.usenet.controller.Messages[ id=" + id + " ]";
    }
    
}
