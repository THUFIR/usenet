package net.bounceme.dur.usenet.controller;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "comments", catalog = "nntp", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comments.findAll", query = "SELECT c FROM Comments c"),
    @NamedQuery(name = "Comments.findById", query = "SELECT c FROM Comments c WHERE c.id = :id"),
    @NamedQuery(name = "Comments.findByStamp", query = "SELECT c FROM Comments c WHERE c.stamp = :stamp")})
public class Comments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private Integer id;
    @Basic(optional = false)
    @Lob
    @Column(name = "comment", nullable = false, length = 65535)
    private String comment;
    @Basic(optional = false)
    @Column(name = "stamp", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date stamp;
    @JoinColumn(name = "message_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Messages messageId;

    public Comments() {
    }

    public Comments(Integer id) {
        this.id = id;
    }

    public Comments(Integer id, String comment, Date stamp) {
        this.id = id;
        this.comment = comment;
        this.stamp = stamp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getStamp() {
        return stamp;
    }

    public void setStamp(Date stamp) {
        this.stamp = stamp;
    }

    public Messages getMessageId() {
        return messageId;
    }

    public void setMessageId(Messages messageId) {
        this.messageId = messageId;
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
        if (!(object instanceof Comments)) {
            return false;
        }
        Comments other = (Comments) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.bounceme.dur.usenet.controller.Comments[ id=" + id + " ]";
    }
}
