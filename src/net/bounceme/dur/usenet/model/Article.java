package net.bounceme.dur.usenet.model;

import java.io.Serializable;
import java.util.logging.Logger;
import javax.mail.Folder;
import javax.mail.Message;
import javax.persistence.*;
import net.bounceme.dur.usenet.driver.FetchBean;

@Entity
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(Article.class.getName());
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private int messageNumber;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Newsgroup newsgroup;

    public Article() {
    }

    public Article(Message message, Folder folder) {
        messageNumber = message.getMessageNumber();
        EntityManagerFactory emf;
        EntityManager em;
        emf = Persistence.createEntityManagerFactory("USENETPU");
        em = emf.createEntityManager();
        String ng = folder.getFullName();
        Query query = em.createQuery("SELECT n FROM Newsgroup n WHERE n.newsgroup = :ng", Newsgroup.class);
        query.setParameter(ng, newsgroup);//newsgroup object
        Newsgroup result = (Newsgroup) query.getSingleResult();
        LOG.info(result.toString());
        newsgroup = (result == null) ? new Newsgroup(folder) : result;
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
        return "\nmessageNumber\t" + messageNumber;
    }

    public int getMessageNumber() {
        return messageNumber;
    }

    public void setMessageNumber(int messageNumber) {
        this.messageNumber = messageNumber;
    }
}
