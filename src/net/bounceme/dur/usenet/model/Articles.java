package net.bounceme.dur.usenet.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Header;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.persistence.*;

@Entity
public class Articles implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(Articles.class.getName());
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String subject;

    //@OneToMany(mappedBy="articles")  //a wrapper for Header is needed?
    //private List<Header> headers;
    
    /*
     *     Example 1:

    // In Customer class:

    @ManyToMany
    @JoinTable(name="CUST_PHONES")
    public Set<PhoneNumber> getPhones() { return phones; }

    // In PhoneNumber class:

    @ManyToMany(mappedBy="phones")
    public Set<Customer> getCustomers() { return customers; }
     */
    
       // @ManyToMany
    //@JoinTable(name="ARTICLES_FOOS")
       // private List<Foos> foos;
    //public List<Foos> getPhones() { return phones; }
    private Set<Foos> foos;

    
    public Articles() {
    }

    public Articles(Message message) {
        try {
            subject = message.getSubject();
        } catch (MessagingException ex) {
            Logger.getLogger(Articles.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @ManyToMany(mappedBy="foos")
    public Set<Foos> getFoos() { return foos; }
    
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
        if (!(object instanceof Articles)) {
            return false;
        }
        Articles other = (Articles) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
