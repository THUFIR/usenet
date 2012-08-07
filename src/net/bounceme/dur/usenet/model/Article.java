package net.bounceme.dur.usenet.model;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.logging.Logger;
import javax.mail.Header;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.persistence.*;

@Entity
@Table(name = "articles")
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;
    //private Usenet u = Usenet.INSTANCE;
    private static final Logger LOG = Logger.getLogger(Article.class.getName());
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String messageId;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Newsgroup newsgroup;

    public Article() {
    }

    public Article(Message message, Newsgroup newsgroup) throws MessagingException {
        this.newsgroup = newsgroup;
        Header headerId = null;
        Enumeration e = message.getAllHeaders();
        while (e.hasMoreElements()) {
            Header header = (Header) e.nextElement();
            if ("Message-ID".equals(header.getName())) {
                headerId = header;
            }
            LOG.fine(header.getName());
        }
        messageId = headerId.getValue();
        LOG.info(messageId);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Article)) {
            return false;
        }
        Article other = (Article) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "\nmessageId\t" + getMessageId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public Newsgroup getNewsgroup() {
        return newsgroup;
    }

    public void setNewsgroup(Newsgroup newsgroup) {
        this.newsgroup = newsgroup;
    }
}