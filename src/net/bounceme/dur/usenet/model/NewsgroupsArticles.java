/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.bounceme.dur.usenet.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thufir
 */
@Entity
@Table(name = "newsgroups_articles", catalog = "nntp", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NewsgroupsArticles.findAll", query = "SELECT n FROM NewsgroupsArticles n"),
    @NamedQuery(name = "NewsgroupsArticles.findById", query = "SELECT n FROM NewsgroupsArticles n WHERE n.id = :id"),
    @NamedQuery(name = "NewsgroupsArticles.findByArticleId", query = "SELECT n FROM NewsgroupsArticles n WHERE n.articleId = :articleId")})
public class NewsgroupsArticles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "article_id", nullable = false)
    private int articleId;
    @JoinColumn(name = "newsgroup_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Articles newsgroupId;

    public NewsgroupsArticles() {
    }

    public NewsgroupsArticles(Integer id) {
        this.id = id;
    }

    public NewsgroupsArticles(Integer id, int articleId) {
        this.id = id;
        this.articleId = articleId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public Articles getNewsgroupId() {
        return newsgroupId;
    }

    public void setNewsgroupId(Articles newsgroupId) {
        this.newsgroupId = newsgroupId;
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
        if (!(object instanceof NewsgroupsArticles)) {
            return false;
        }
        NewsgroupsArticles other = (NewsgroupsArticles) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.bounceme.dur.usenet.model.NewsgroupsArticles[ id=" + id + " ]";
    }
    
}
