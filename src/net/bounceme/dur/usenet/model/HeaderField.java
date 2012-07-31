package net.bounceme.dur.usenet.model;

import java.io.Serializable;
import java.util.AbstractMap.SimpleEntry;
import java.util.logging.Logger;
import javax.persistence.*;

@Entity
public class HeaderField implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(HeaderField.class.getName());
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Article article = new Article();
    @Column
    private String headerName;
    @Column
    private String headerValue;

    public HeaderField() {
    }

    public HeaderField(SimpleEntry nameValue) {
        headerName = nameValue.getKey().toString();
        headerValue = nameValue.getValue().toString();
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
        return "\n\nheaderName\t" + headerName + "\nheaderValue\t" + headerValue;
    }

    public String getHeaderName() {
        return headerName;
    }

    public void setHeaderName(String headerName) {
        this.headerName = headerName;
    }

    public String getHeaderValue() {
        return headerValue;
    }

    public void setHeaderValue(String headerValue) {
        this.headerValue = headerValue;
    }
}
