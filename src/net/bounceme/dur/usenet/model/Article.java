package net.bounceme.dur.usenet.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Folder;
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
    private String newsgroup;
    @Column
    private int messageNumber;
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date posted;
    @Column
    private String subject;
    @OneToMany(mappedBy = "article", cascade = CascadeType.PERSIST)
    private List<HeaderField> headerFields = new ArrayList<>();

    public Article() {
    }

    public Article(Message message,Folder folder) {
        try {
            newsgroup = folder.getFullName();
            messageNumber = message.getMessageNumber();
            posted = message.getSentDate();
            subject = message.getSubject();
        } catch (Exception ex) {
            Logger.getLogger(Article.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
                /*try {
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
            }*/

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
        return id + "\n" + getHeaderFields();
    }

    public int getMessageNumber() {
        return messageNumber;
    }

    public void setMessageNumber(int messageNumber) {
        this.messageNumber = messageNumber;
    }

    public Date getPosted() {
        return posted;
    }

    public void setPosted(Date posted) {
        this.posted = posted;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public List<HeaderField> getHeaderFields() {
        return headerFields;
    }

    public void setHeaderFields(List<HeaderField> headerFields) {
        this.headerFields = headerFields;
    }

    public String getNewsgroup() {
        return newsgroup;
    }

    public void setNewsgroup(String newsgroup) {
        this.newsgroup = newsgroup;
    }
}
