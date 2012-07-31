package net.bounceme.dur.usenet.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.logging.Logger;
import javax.mail.Header;
import javax.persistence.*;

@Entity
public class HeaderField implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(HeaderField.class.getName());
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToMany(mappedBy = "headerField")
    private Collection<Article> Articles = new ArrayList<>();

    public HeaderField() {
    }

    public HeaderField(Enumeration e) {
        while (e.hasMoreElements()) {
            Header h = (Header) e.nextElement();
            LOG.fine(h.getName());
        }
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
        if (!(object instanceof HeaderField)) {
            return false;
        }
        HeaderField other = (HeaderField) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.bounceme.dur.usenet.model.HeaderField[ id=" + id + " ]";
    }
}
