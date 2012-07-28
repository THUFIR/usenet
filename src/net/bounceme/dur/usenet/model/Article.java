package net.bounceme.dur.usenet.model;

//article has the wrong structure.
//newsgroup should be a foreign key
//there needs to be some mechanism for unique messages
//message id!


//hmm, can I push to the master?


import java.io.Serializable;
import java.util.Collection;
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
    @NamedQuery(name = "Articles.findByNumber", query = "SELECT a FROM Article a WHERE a.number = :number")})
public class Article implements Serializable {

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
    @Column(name = "number", nullable = false)
    private int number;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "messageId")
    private Collection<Comment> commentsCollection;

    public Article() {
    }

    public Article(MessageBean messageBean) {
        newsgroup = messageBean.getGroup();
        subject = messageBean.getSubject();
        content = messageBean.getContent();
        number = messageBean.getNumber();
    }

    public Article(Integer id) {
        this.id = id;
    }

    public Article(Integer id, String newsgroup, String subject, String content, int number) {
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @XmlTransient
    public Collection<Comment> getCommentsCollection() {
        return commentsCollection;
    }

    public void setCommentsCollection(Collection<Comment> commentsCollection) {
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
