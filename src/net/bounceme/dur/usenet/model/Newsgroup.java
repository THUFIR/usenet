package net.bounceme.dur.usenet.model;

//fixing schema

import java.io.Serializable;
import javax.mail.Folder;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "newsgroups", catalog = "nntp", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Newsgroups.findAll", query = "SELECT n FROM Newsgroup n"),
    @NamedQuery(name = "Newsgroups.findById", query = "SELECT n FROM Newsgroup n WHERE n.id = :id")})
public class Newsgroup implements Serializable {
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

    public Newsgroup() {
    }
    
    public Newsgroup(Folder f){
        newsgroup = f.getFullName();
    }

    public Newsgroup(Integer id) {
        this.id = id;
    }

    public Newsgroup(Integer id, String newsgroup) {
        this.id = id;
        this.newsgroup = newsgroup;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Newsgroup)) {
            return false;
        }
        Newsgroup other = (Newsgroup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.bounceme.dur.usenet.model.Newsgroups[ id=" + id + " ]";
    }
    
}
