/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lth.pojos;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "news")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "News.findAll", query = "SELECT n FROM News n"),
    @NamedQuery(name = "News.findById", query = "SELECT n FROM News n WHERE n.id = :id"),
    @NamedQuery(name = "News.findByTitle", query = "SELECT n FROM News n WHERE n.title = :title"),
    @NamedQuery(name = "News.findByContent", query = "SELECT n FROM News n WHERE n.content = :content"),
    @NamedQuery(name = "News.findByQuantityLikes", query = "SELECT n FROM News n WHERE n.quantityLikes = :quantityLikes"),
    @NamedQuery(name = "News.findByQuantityViews", query = "SELECT n FROM News n WHERE n.quantityViews = :quantityViews"),
    @NamedQuery(name = "News.findByPostedDate", query = "SELECT n FROM News n WHERE n.postedDate = :postedDate"),
    @NamedQuery(name = "News.findByUpdatedDate", query = "SELECT n FROM News n WHERE n.updatedDate = :updatedDate")})
public class News implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "content")
    private String content;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity_likes")
    private int quantityLikes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity_views")
    private int quantityViews;
    @Basic(optional = false)
    @NotNull
    @Column(name = "posted_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date postedDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "updated_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private User userId;
    @OneToMany(mappedBy = "newsId")
    private Collection<Reaction> reactionCollection;

    public News() {
        this.id = 0;
    }

    public News(Integer id) {
        this.id = id;
    }

    public News(Integer id, String title, String content, int quantityLikes, int quantityViews, Date postedDate, Date updatedDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.quantityLikes = quantityLikes;
        this.quantityViews = quantityViews;
        this.postedDate = postedDate;
        this.updatedDate = updatedDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getQuantityLikes() {
        return quantityLikes;
    }

    public void setQuantityLikes(int quantityLikes) {
        this.quantityLikes = quantityLikes;
    }

    public int getQuantityViews() {
        return quantityViews;
    }

    public void setQuantityViews(int quantityViews) {
        this.quantityViews = quantityViews;
    }

    public Date getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @XmlTransient
    public Collection<Reaction> getReactionCollection() {
        return reactionCollection;
    }

    public void setReactionCollection(Collection<Reaction> reactionCollection) {
        this.reactionCollection = reactionCollection;
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
        if (!(object instanceof News)) {
            return false;
        }
        News other = (News) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lth.pojos.News[ id=" + id + " ]";
    }
    
}
