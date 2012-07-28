package net.bounceme.dur.usenet.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import net.bounceme.dur.usenet.controller.MessageBean;

@Entity
@Table(name = "flat", catalog = "nntp", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Flat.findAll", query = "SELECT f FROM Flat f"),
    @NamedQuery(name = "Flat.findById", query = "SELECT f FROM Flat f WHERE f.id = :id"),
    @NamedQuery(name = "Flat.findByNumber", query = "SELECT f FROM Flat f WHERE f.number = :number"),
    @NamedQuery(name = "Flat.findByPosted", query = "SELECT f FROM Flat f WHERE f.posted = :posted"),
    @NamedQuery(name = "Flat.findByStamp", query = "SELECT f FROM Flat f WHERE f.stamp = :stamp")})
public class Flat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Lob
    @Column(name = "newsgroup", nullable = false, length = 65535)
    private String newsgroup;
    @Basic(optional = false)
    @Lob
    @Column(name = "subject", nullable = false, length = 65535)
    private String subject;
    @Basic(optional = false)
    @Lob
    @Column(name = "content", nullable = false, length = 65535)
    private String content;
    @Basic(optional = false)
    @Column(name = "number", nullable = false)
    private int number;
    @Basic(optional = false)
    @Column(name = "posted", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date posted;
    @Basic(optional = false)
    @Column(name = "stamp", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date stamp;
    @Basic(optional = false)
    @Lob
    @Column(name = "comment", nullable = false, length = 65535)
    private String comment;

    public Flat() {
    }

    /*
     * mysql> describe flat;
+-----------+---------+------+-----+---------+----------------+
| Field     | Type    | Null | Key | Default | Extra          |
+-----------+---------+------+-----+---------+----------------+
| id        | int(11) | NO   | PRI | NULL    | auto_increment |
| newsgroup | text    | NO   |     | NULL    |                |
| subject   | text    | NO   |     | NULL    |                |
| content   | text    | NO   |     | NULL    |                |
| number    | int(11) | NO   |     | NULL    |                |
| posted    | date    | NO   |     | NULL    |                |
| stamp     | date    | NO   |     | NULL    |                |
| comment   | text    | NO   |     | NULL    |                |
+-----------+---------+------+-----+---------+----------------+
8 rows in set (0.00 sec)


     */
    public Flat(MessageBean mb) {
        newsgroup = mb.getGroup();
        subject = mb.getSubject();
        content = mb.getContent().toString();
        number = mb.getNumber();
        posted = mb.getSent();
        stamp = new Date();
        comment = "dummy comment";
    }

    public Flat(Integer id) {
        this.id = id;
    }

    public Flat(Integer id, String newsgroup, String subject, String content, int number, Date posted, Date stamp, String comment) {
        this.id = id;
        this.newsgroup = newsgroup;
        this.subject = subject;
        this.content = content;
        this.number = number;
        this.posted = posted;
        this.stamp = stamp;
        this.comment = comment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNewsgroup() {
        return newsgroup;
    }

    public void setNewsgroup(String newsgroup) {
        this.newsgroup = newsgroup;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getPosted() {
        return posted;
    }

    public void setPosted(Date posted) {
        this.posted = posted;
    }

    public Date getStamp() {
        return stamp;
    }

    public void setStamp(Date stamp) {
        this.stamp = stamp;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
        if (!(object instanceof Flat)) {
            return false;
        }
        Flat other = (Flat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.bounceme.dur.usenet.model.Flat[ id=" + id + " ]";
    }
}
