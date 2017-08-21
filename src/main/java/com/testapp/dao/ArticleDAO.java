package com.concretepage.dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.concretepage.entity.Article;
@Transactional
@Repository
public class ArticleDAO implements com.concretepage.dao.IArticleDAO {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Article getArticleById(int articleId) {
        return entityManager.find(Article.class, articleId)
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<Article> getAllArticles() {
        String hql = "FROM Article as atcl ORDER BY atcl.articleID";
        return (List<Article>) entityManager.createQuery(hql).getResultList();
    }
    @Override
    public void AddArticle(Article article) {
        entityManager.persist(article);
    }
}