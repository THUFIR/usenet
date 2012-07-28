package net.bounceme.dur.usenet.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import net.bounceme.dur.usenet.controller.MessageBean;

@Entity
@Table(name = "articles", catalog = "nntp", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Articles.findAll", query = "SELECT a FROM Article a"),
    @NamedQuery(name = "Articles.findById", query = "SELECT a FROM Article a WHERE a.id = :id"),
    @NamedQuery(name = "Articles.findByNumber", query = "SELECT a FROM Article a WHERE a.number = :number"),
    @NamedQuery(name = "Articles.findBySent", query = "SELECT a FROM Article a WHERE a.sent = :sent")})
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Lob
    @Column(name = "subject", nullable = false, length = 65535)
    private String subject;
    @Basic(optional = false)
    @Lob
    @Column(name = "content", nullable = false, length = 65535)
    private String content;
    @Basic(optional = false)
    @Column(name = "number", nullable = false)
    private int number;
    @Basic(optional = false)
    @Column(name = "sent", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date sent;
    @Basic(optional = false)
    @Lob
    @Column(name = "header_id_string", nullable = false, length = 65535)
    private String headerIdString;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "newsgroupId")
    private Collection<NewsgroupsArticles> newsgroupsArticlesCollection;

    public Article() {
    }

    public Article(MessageBean messageBean) {
        subject = messageBean.getSubject();
        content = messageBean.getContent();
        sent = messageBean.getSent();
        number = messageBean.getNumber();
        headerIdString = "dummy";
    }

    public Article(Integer id) {
        this.id = id;
    }

    public Article(Integer id, String subject, String content, int number, Date sent, String headerIdString) {
        this.id = id;
        this.subject = subject;
        this.content = content;
        this.number = number;
        this.sent = sent;
        this.headerIdString = headerIdString;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getSent() {
        return sent;
    }

    public void setSent(Date sent) {
        this.sent = sent;
    }

    public String getHeaderIdString() {
        return headerIdString;
    }

    public void setHeaderIdString(String headerIdString) {
        this.headerIdString = headerIdString;
    }

    @XmlTransient
    public Collection<NewsgroupsArticles> getNewsgroupsArticlesCollection() {
        return newsgroupsArticlesCollection;
    }

    public void setNewsgroupsArticlesCollection(Collection<NewsgroupsArticles> newsgroupsArticlesCollection) {
        this.newsgroupsArticlesCollection = newsgroupsArticlesCollection;
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
        if (!(object instanceof Article)) {
            return false;
        }
        Article other = (Article) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.bounceme.dur.usenet.model.Articles[ id=" + id + " ]";
    }
}
