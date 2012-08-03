package net.bounceme.dur.usenet.model;

import java.io.Serializable;
import java.util.List;
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
        TypedQuery<Newsgroup> query = em.createQuery("SELECT n FROM Newsgroup n WHERE n.newsgroup = :foo", Newsgroup.class);
        query.setParameter("foo", ng);
        List<Newsgroup> results = query.getResultList();
        LOG.fine("got result " + results.size());
        for (Newsgroup n : results) {
            LOG.info(n.toString());
        }
        //newsgroup = (result.size() > 0) ? new Newsgroup(folder) : new Newsgroup(folder);  // result.get(1);
        if (results.size() > 0) {
            newsgroup = results.get(0);
            LOG.fine("using result " + results.get(0).toString());
        } else {
            newsgroup = new Newsgroup(folder);
            LOG.fine("new " + folder.getFullName());
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
        return "\nmessageNumber\t" + messageNumber;
    }

    public int getMessageNumber() {
        return messageNumber;
    }

    public void setMessageNumber(int messageNumber) {
        this.messageNumber = messageNumber;
    }
}
