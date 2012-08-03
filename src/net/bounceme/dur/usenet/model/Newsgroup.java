package net.bounceme.dur.usenet.model;

import java.io.Serializable;
import java.util.List;
import javax.mail.Folder;
import javax.persistence.*;

@Entity
public class Newsgroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String newsgroup;
    @OneToOne(cascade = CascadeType.PERSIST)
    private  Article article;

    public Newsgroup() {
    }

    public Newsgroup(Folder folder) {
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
        return newsgroup;
    }
}
