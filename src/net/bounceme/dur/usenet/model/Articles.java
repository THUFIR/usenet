/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.bounceme.dur.usenet.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import net.bounceme.dur.usenet.controller.MessageBean;

/**
 *
 * @author thufir
 */
@Entity
@Table(name = "articles", catalog = "nntp", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Articles.findAll", query = "SELECT a FROM Articles a"),
    @NamedQuery(name = "Articles.findById", query = "SELECT a FROM Articles a WHERE a.id = :id"),
    @NamedQuery(name = "Articles.findByNumber", query = "SELECT a FROM Articles a WHERE a.number = :number"),
    @NamedQuery(name = "Articles.findBySent", query = "SELECT a FROM Articles a WHERE a.sent = :sent")})
public class Articles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Lob
    @Column(name = "content", nullable = false, length = 2147483647)
    private String content;
    @Basic(optional = false)
    @Lob
    @Column(name = "header_id_string", nullable = false, length = 2147483647)
    private String headerIdString;
    @Basic(optional = false)
    @Column(name = "number", nullable = false)
    private int number;
    @Basic(optional = false)
    @Column(name = "sent", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date sent;
    @Basic(optional = false)
    @Lob
    @Column(name = "subject", nullable = false, length = 2147483647)
    private String subject;

    public Articles() {
    }

    public Articles(MessageBean messageBean) {
        subject = messageBean.getSubject();
        content = messageBean.getContent();
        sent = messageBean.getSent();
        number = messageBean.getNumber();
        headerIdString = "dummy";
    }

    public Articles(Integer id) {
        this.id = id;
    }

    public Articles(Integer id, String content, String headerIdString, int number, Date sent, String subject) {
        this.id = id;
        this.content = content;
        this.headerIdString = headerIdString;
        this.number = number;
        this.sent = sent;
        this.subject = subject;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHeaderIdString() {
        return headerIdString;
    }

    public void setHeaderIdString(String headerIdString) {
        this.headerIdString = headerIdString;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getSent() {
        return sent;
    }

    public void setSent(Date sent) {
        this.sent = sent;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
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
        return "net.bounceme.dur.usenet.model.Articles[ id=" + id + " ]";
    }
}
