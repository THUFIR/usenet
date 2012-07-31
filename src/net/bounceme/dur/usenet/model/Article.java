package net.bounceme.dur.usenet.model;

import java.io.Serializable;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Header;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.persistence.*;

@Entity
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(Article.class.getName());
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String subject;
    @OneToMany(mappedBy = "article", cascade = CascadeType.PERSIST)
    private List<HeaderField> headerFields = new ArrayList<>();

    public Article() {
    }

    public Article(Message message) {
        try {
            subject = message.getSubject();
            Enumeration e = message.getAllHeaders();
            while (e.hasMoreElements()) {
                Header header = (Header) e.nextElement();
                @SuppressWarnings("unchecked")
                SimpleEntry nameValue = new SimpleEntry(header.getName(), header.getValue());
                HeaderField headerField = new HeaderField(nameValue);
                headerFields.add(headerField);
                LOG.info(toString());
            }
        } catch (MessagingException ex) {
            Logger.getLogger(Article.class.getName()).log(Level.SEVERE, null, ex);
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
        return subject+ "\n" + headerFields;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
