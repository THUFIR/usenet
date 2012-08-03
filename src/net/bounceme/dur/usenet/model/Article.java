package net.bounceme.dur.usenet.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.mail.Folder;
import javax.mail.Message;
import javax.persistence.*;

@Entity
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private int messageNumber;
    //@OneToMany(mappedBy = "article", cascade = CascadeType.PERSIST)
    //private List<Newsgroup> newsgroups = new ArrayList<>();// = new HashSet<>();
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Newsgroup newsgroup;
    
    public Article() {
    }

    public Article(Message message, Folder folder) {
        messageNumber = message.getMessageNumber();
        newsgroup = new Newsgroup(folder);
        //newsgroups.add(newsgroup);
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
