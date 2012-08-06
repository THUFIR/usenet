package net.bounceme.dur.usenet.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;
import javax.mail.Folder;
import javax.persistence.*;
import net.bounceme.dur.usenet.controller.Page;

@Entity
@Table(name = "newsgroups")
public class Newsgroup implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(Newsgroup.class.getName());
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column //@Unique @UniqueConstraint interface..?
    private String newsgroup;
    @OneToMany(mappedBy = "newsgroup", cascade = CascadeType.PERSIST)
    private Set<Article> articles = new HashSet<>();

    public Newsgroup() {
        //should not create a newsgroup without a Folder
    }

    public Newsgroup(Folder folder) {
        newsgroup = folder.getFullName();
        LOG.fine(newsgroup);
    }
    public Newsgroup(Page page) {
        newsgroup = page.getFolderFullName();
        LOG.fine(newsgroup);
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
        return getNewsgroup();
    }

    public String getNewsgroup() {
        return newsgroup;
    }

    public void setNewsgroup(String newsgroup) {
        this.newsgroup = newsgroup;
    }
}