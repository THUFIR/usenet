package net.bounceme.dur.usenet.model;

import java.io.Serializable;
import javax.mail.Folder;
import javax.persistence.*;

@Entity
@NamedQueries({
    @NamedQuery(name = "Newsgroups.findAll", query = "SELECT n FROM Newsgroups n"),
    @NamedQuery(name = "Newsgroups.findById", query = "SELECT n FROM Newsgroups n WHERE n.id = :id")})
public class Newsgroups implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    //@Column
    @Column(unique = true)
    private String newsgroup;

    public Newsgroups() {
    }

    public Newsgroups(Folder folder) {
        newsgroup = folder.getFullName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Newsgroups)) {
            return false;
        }
        Newsgroups other = (Newsgroups) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return newsgroup;
    }

    public String getNewsgroup() {
        return newsgroup;
    }

    public void setNewsgroup(String newsgroup) {
        this.newsgroup = newsgroup;
    }

}
